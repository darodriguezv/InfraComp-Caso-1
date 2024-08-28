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
        productos.add(Nproducto);
        this.numDepProd++;
        notify();
    }

    public synchronized Producto sacar() {
        Producto producto = productos.get(0);
        productos.remove(0);
        this.numDepProd--;
        notify();
        return producto;
    }

    public void getProductosAlmacenados() {
        for (Producto producto : productos) {
            System.out.println(producto.getTipo());
        }
    }
}
