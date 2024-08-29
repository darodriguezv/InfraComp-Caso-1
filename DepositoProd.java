import java.util.ArrayList;

public class DepositoProd {
    Integer capDepProd;
    Integer numDepProd;
    ArrayList<Producto> productos;

    public DepositoProd(Integer NcapDepProd) {
        this.capDepProd = NcapDepProd;
        this.numDepProd = 0;
        this.productos = new ArrayList<Producto>();
    }

    public Integer getCapDepProd() {
        return capDepProd;
    }

    public synchronized Integer getNumDepProd() {
        return numDepProd;
    }

    public synchronized void producir(Producto Nproducto) {
        while (capDepProd == numDepProd) {
            try {
                wait();
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
        productos.add(Nproducto);
        this.numDepProd++;
    }

    public synchronized Producto sacar() {
        Producto producto = productos.get(0);
        productos.remove(0);
        this.numDepProd--;
        notifyAll();
        return producto;
    }
}
