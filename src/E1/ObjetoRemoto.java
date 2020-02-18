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
    public double EcuacionLineal(double a, double b, double c) throws RemoteException {
        return (-b +- (Math.sqrt(Math.pow(b, 2) - 4 * (a * c))))/ (2 * a);
    }
}
