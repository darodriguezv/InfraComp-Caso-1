public class Productor extends Thread {
    Integer numProductos;
    String tipoProducto;
    Integer numProducido;
    DepositoProd depositoProd;
    Integer id;

    public Productor(Integer NnumProductos, String NtipoProducto, DepositoProd NdepositoProd, Integer Nid) {
        this.numProductos = NnumProductos;
        this.tipoProducto = NtipoProducto;
        this.numProducido = 0;
        this.depositoProd = NdepositoProd;
        this.id = Nid;
        System.out.println("Productor " + id + " creado meta de " + numProductos + " productos: " + tipoProducto);
    }

    public void run() {
        System.out.println("Productor " + id + " inicia");
        while (numProducido < numProductos) {
            Producto producto = new Producto(tipoProducto);
            depositoProd.producir(producto);
            numProducido++;
            //System.out.println("        Productor " + id + " produce producto: " + producto.getTipo());
        }

        Producto producto = new Producto("FIN_" + tipoProducto);
        depositoProd.producir(producto);
        System.out.println("Productor " + id + " termina");
    }
}
