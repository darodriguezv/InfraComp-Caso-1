public class OperarioIn extends Thread {

    Integer contadorFinal;
    DepositoProd depositoProd;
    Cinta cinta;

    Integer contador = 0;

    public OperarioIn(DepositoProd NdepositoProd, Cinta Ncinta) {
        contadorFinal = 0;
        this.depositoProd = NdepositoProd;
        this.cinta = Ncinta;
        System.out.println("OperarioIn creado");
    }

    public void run() {
        System.out.println("OperarioIn inicia");
        while (contadorFinal < 4) {
            while (depositoProd.getNumDepProd() == 0) {
                Thread.yield();
            }
            Producto producto = depositoProd.sacar();
            //System.out.println("        OperarioIn saca de bodega producto: " + producto.getTipo());
            if (producto.getTipo().equals("FIN_A") || producto.getTipo().equals("FIN_B")) {
                contadorFinal++;
            }

            while (cinta.getCapCinta() == cinta.getNumProd()) {
                Thread.yield();
            }
            cinta.transportar(producto);
            //System.out.println("        OperarioIn transporta producto: " + producto.getTipo());
        }
        System.out.println("OperarioIn termina");
    }
}
