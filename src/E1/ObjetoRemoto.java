package E1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObjetoRemoto extends UnicastRemoteObject implements InterfaceRemota {
    public ObjetoRemoto() throws RemoteException {
        super();
    }

    @Override
    public double AreaPoligono(double perimetro, double apotema) throws RemoteException {
        return perimetro * apotema / 2;
    }

    @Override
    public double AreaCirculo(double radio) throws RemoteException {
        return Math.PI * Math.pow(radio, 2);
    }

    @Override
    public double[] EcuacionLineal(double a, double b, double c) throws RemoteException {
        double root = Math.sqrt(Math.pow(b, 2) - 4 * (a * c));
        double res = root / (2 * a);

        double resPos = (-b) + res;
        double resNeg = (-b) - res;

        double eqPos = (a * Math.pow(resPos, 2)) + (b * resPos) + c;
        double eqNeg = (a * Math.pow(resNeg, 2)) + (b * resNeg) + c;

        return new double[]{eqPos, eqNeg};
    }
}
