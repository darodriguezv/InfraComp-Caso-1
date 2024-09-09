public class Cinta {
    private static Integer capCinta = 1;
    private Integer numProd;
    private Producto[] productoEnCinta = new Producto[1];

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
        productoEnCinta[0] = Nproducto;
        this.numProd++;
    }

    public synchronized Producto sacar() {
        Producto producto = productoEnCinta[0];
        productoEnCinta[0] = null;
        this.numProd--;
        return producto;
    }
}
