import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Integer numProductos = input("Ingrese el número de productos a producir por cada Operario: ");
        Integer capDepProd = input("Ingrese la capacidad del deposito de producción: ");
        Integer capDepDis = input("Ingrese la capacidad del deposito de distribución: ");
        DistribuidorIDs distribuidorIDs = new DistribuidorIDs();

        DepositoProd depositoProd = new DepositoProd(capDepProd);
        DepositoDist depositoDist = new DepositoDist(capDepDis);
        Cinta cinta = new Cinta();

        Productor productor1 = new Productor(numProductos, "A", depositoProd, distribuidorIDs.getID());
        Productor productor2 = new Productor(numProductos, "A", depositoProd, distribuidorIDs.getID());
        Productor productor3 = new Productor(numProductos, "B", depositoProd, distribuidorIDs.getID());
        Productor productor4 = new Productor(numProductos, "B", depositoProd, distribuidorIDs.getID());

        OperarioIn operarioIn = new OperarioIn(depositoProd, cinta);
        OperarioOut operarioOut = new OperarioOut(depositoDist, cinta);

        productor1.start();
        productor2.start();
        productor3.start();
        productor4.start();
        operarioIn.start();
        operarioOut.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // System.out.println(depositoProd.numDepProd);
        // depositoProd.getProductosAlmacenados();



        // System.out.println(cinta.getNumProd());
        // cinta.getProductosAlmacenados();
        
        // System.out.println(depositoDist.numDepDist);
        // depositoDist.getProductosAlmacenados();


    }

    @SuppressWarnings("resource")
    public static Integer input(String texto) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(texto);
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }
}
