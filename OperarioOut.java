public class OperarioOut extends Thread {
    
    Integer contadorFinal;
    DepositoDist depositoDist;
    Cinta cinta;

    public OperarioOut(DepositoDist NdepositoDist, Cinta Ncinta) {
        contadorFinal = 0;
        this.depositoDist = NdepositoDist;
        this.cinta = Ncinta;
        System.out.println("OperarioOut creado");
    }

    public void run() {
        System.out.println("OperarioOut inicia");
        while (contadorFinal < 3) {
            while (cinta.getNumProd() == 0) {
                Thread.yield();
            }
            Producto producto = cinta.sacar();

            if (producto.getTipo().equals("FIN_A") || producto.getTipo().equals("FIN_B")) {
                contadorFinal++;
            }

            while (depositoDist.getCapDepDist() == depositoDist.getNumDepDist()) {
                Thread.yield();
            }
            depositoDist.guardar(producto);
            //System.out.println("        OperarioOut guarda en bodega producto: " + producto.getTipo());
        }
        System.out.println("OperarioOut termina");
    }
}
