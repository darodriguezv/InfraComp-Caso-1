import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Integer numProductos = input("Ingrese el número de productos a producir por cada Operario: ");
        Integer capDepProd = input("Ingrese la capacidad del deposito de producción: ");
        Integer capDepDis = input("Ingrese la capacidad del deposito de distribución: ");
        asignadorIDs distribuidorIDsProductor = new asignadorIDs();
        asignadorIDs distribuidorIDsDistribuidor = new asignadorIDs();

        DepositoProd depositoProd = new DepositoProd(capDepProd);
        DepositoDist depositoDist = new DepositoDist(capDepDis);
        Cinta cinta = new Cinta();

        Productor productor1 = new Productor(numProductos, "A", depositoProd, distribuidorIDsProductor.getID());
        Productor productor2 = new Productor(numProductos, "A", depositoProd, distribuidorIDsProductor.getID());
        Productor productor3 = new Productor(numProductos, "B", depositoProd, distribuidorIDsProductor.getID());
        Productor productor4 = new Productor(numProductos, "B", depositoProd, distribuidorIDsProductor.getID());

        Distribuidor distribuidor1 = new Distribuidor("A", depositoDist, distribuidorIDsDistribuidor.getID());
        Distribuidor distribuidor2 = new Distribuidor("A", depositoDist, distribuidorIDsDistribuidor.getID());
        Distribuidor distribuidor3 = new Distribuidor("B", depositoDist, distribuidorIDsDistribuidor.getID());
        Distribuidor distribuidor4 = new Distribuidor("B", depositoDist, distribuidorIDsDistribuidor.getID());

        OperarioIn operarioIn = new OperarioIn(depositoProd, cinta);
        OperarioOut operarioOut = new OperarioOut(depositoDist, cinta);

        productor1.start();
        productor2.start();
        productor3.start();
        productor4.start();
        distribuidor1.start();
        distribuidor2.start();
        distribuidor3.start();
        distribuidor4.start();
        operarioIn.start();
        operarioOut.start();
    }

    @SuppressWarnings("resource")
    public static Integer input(String texto) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(texto);
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }
}
