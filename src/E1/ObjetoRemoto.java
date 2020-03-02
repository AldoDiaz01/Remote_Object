package E1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DecimalFormat;

public class ObjetoRemoto extends UnicastRemoteObject implements InterfaceRemota {
    public ObjetoRemoto() throws RemoteException {
        super();
    }

    @Override
    public double AreaPoligono(int numeroLados, double longitudLado, double apotema) throws RemoteException {
        System.out.println("Se calculo el area de un poligono...");
        return ((numeroLados * longitudLado) * apotema) / 2;
    }

    @Override
    public double AreaCirculo(double radio) throws RemoteException {
        System.out.println("Se calculo el area de un circulo...");
        return Math.PI * Math.pow(radio, 2);
    }

    @Override
    public double[] EcuacionLineal(double a, double b, double c) throws RemoteException {
        System.out.println("Se calculo una ecuacion lineal...");
        double potencia = Math.pow(b, 2);
        double resto = potencia - (4 * (a * c));

        if (resto <= 0) {
            System.out.println("No se pueden ingresar datos menores a 0");
            return new double[]{};
        } else {
            double raiz = Math.sqrt(resto);

            double preResPos = (-b) + raiz;
            double preResNeg = (-b) - raiz;

            double x1 = preResPos / (2 * a);
            double x2 = preResNeg / (2 * a);

            DecimalFormat df = new DecimalFormat("#.0000");

            x1 = Double.parseDouble(df.format(x1));
            x2 = Double.parseDouble(df.format(x2));

            double ecX1 = (a * Math.pow(x1, 2)) + (b * x1) + c;
            double ecX2 = (a * Math.pow(x2, 2)) + (b * x2) + c;

            ecX1 = Double.parseDouble(df.format(ecX1));
            ecX2 = Double.parseDouble(df.format(ecX2));

            return new double[]{x1, x2, ecX1, ecX2};
        }
    }
}
