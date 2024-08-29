import java.util.ArrayList;

public class DepositoDist {
    Integer capDepDist;
    Integer numDepDist;
    ArrayList<Producto> productos;

    public DepositoDist(Integer NcapDepDist) {
        this.capDepDist = NcapDepDist;
        this.numDepDist = 0;
        this.productos = new ArrayList<Producto>();
    }

    public Integer getCapDepDist() {
        return capDepDist;
    }

    public synchronized Integer getNumDepDist() {
        return numDepDist;
    }

    public synchronized void guardar(Producto Nproducto) {
        productos.add(Nproducto);
        this.numDepDist++;
        notifyAll();
    }

    public synchronized Producto distribuir(String tipo) {
        while (numDepDist == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
        boolean hay = false;
        int index = -1;

        for (Producto producto : productos) {
            if (producto.getTipo().equals(tipo) || producto.getTipo().equals("FIN_" + tipo)) {
                hay = true;
                index = productos.indexOf(producto);
                break;
            }
        }
        if (hay) {
            Producto producto = productos.get(index);
            productos.remove(index);
            this.numDepDist--;
            return producto;
        } else {
            return null;
        }
    }
}
