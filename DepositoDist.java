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
        notify();
    }

    public void getProductosAlmacenados() {
        for (Producto producto : productos) {
            System.out.println(producto.getTipo());
        }
    }
}
