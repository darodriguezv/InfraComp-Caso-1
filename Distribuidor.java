public class Distribuidor extends Thread {
    Integer numProductos;
    String tipoProducto;
    DepositoDist depositoDist;
    Integer id;
    Boolean terminar;

    public Distribuidor(String NtipoProducto, DepositoDist NdepositoDist, Integer Nid){
        this.numProductos=0;
        this.tipoProducto=NtipoProducto;
        this.depositoDist=NdepositoDist;
        this.id=Nid;
        this.terminar=false;
        System.out.println("Distribuidor "+id+" creado, tipo de producto: " + tipoProducto);
    }

    public void run() {
        System.out.println("Distribuidor "+id+" inicia");
        while (!terminar) {
            Producto producto = depositoDist.distribuir(tipoProducto);
            if (!(producto == null)) {
                numProductos++;
                if (producto.getTipo().equals("FIN_"+tipoProducto)) {
                    terminar = true;
                }
            }
        }
        System.out.println("Distribuidor "+id+" termina con "+numProductos+" productos de tipo "+tipoProducto);
    }
}