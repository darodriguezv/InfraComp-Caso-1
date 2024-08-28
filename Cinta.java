import java.util.ArrayList;

public class Cinta {
    private static Integer capCinta = 1;
    private Integer numProd;
    private ArrayList<Producto> productos = new ArrayList<Producto>();

    public Cinta() {
        this.numProd = 0;
    }

    public Integer getCapCinta() {
        return capCinta;
    }

    public synchronized Integer getNumProd() {
        return numProd;
    }

    public synchronized void transportar(Producto Nproducto) {
        productos.add(Nproducto);
        this.numProd++;
        notify();
    }

    public synchronized Producto sacar() {
        Producto producto = productos.get(0);
        productos.remove(0);
        this.numProd--;
        notify();
        return producto;
    }

    public void getProductosAlmacenados() {
        for (Producto producto : productos) {
            System.out.println(producto.getTipo());
        }
    }
}
