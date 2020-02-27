package E1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObjetoRemoto extends UnicastRemoteObject implements InterfaceRemota {
    public ObjetoRemoto() throws RemoteException {
        super();
    }

    @Override
    public double AreaPoligono(double perimetro, double apotema) throws RemoteException {
        System.out.println("Calculando area de un poligono...");
        return perimetro * apotema / 2;
    }

    @Override
    public double AreaPoligono(int numeroLados, double longitudLado, double apotema) throws RemoteException {
        System.out.println("Calculando area de un poligono...");
        return ((numeroLados * longitudLado) * apotema) / 2;
    }

    @Override
    public double AreaCirculo(double radio) throws RemoteException {
        System.out.println("Calculando area de un area...");
        return Math.PI * Math.pow(radio, 2);
    }

    @Override
    public double[] EcuacionLineal(double a, double b, double c) throws RemoteException {
        System.out.println("Calculando ecuacion lineal...");
        double potencia = Math.pow(b, 2);
        double resto = potencia - (4 * (a * c));

        if (resto <= 0) {
            System.out.println("No se pueden ingresar datos menores a 0");
            System.out.println("Todo meco este vato si o no raza? xdxdxdxdxdxdx");
            return new double[]{};
        } else {
            double raiz = Math.sqrt(resto);

            double preResPos = (-b) + raiz;
            double preResNeg = (-b) - raiz;

            double resPos = preResPos / (2 * a);
            double resNeg = preResNeg / (2 * a);

            double eqPos = (a * Math.pow(resPos, 2)) + (b * resPos) + c;
            double eqNeg = (a * Math.pow(resNeg, 2)) + (b * resNeg) + c;

            return new double[]{resPos, resNeg, eqPos, eqNeg};
        }
    }
}
