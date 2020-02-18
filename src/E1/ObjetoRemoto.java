package E1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObjetoRemoto extends UnicastRemoteObject implements InterfaceRemota {
    public ObjetoRemoto() throws RemoteException {
        super();
    }

    @Override
    public double AreaPoligono(double perimeter, double apothem) throws RemoteException {
        return 0;
    }

    @Override
    public double AreaCirculo() throws RemoteException {
        return 0;
    }

    @Override
    public double EcuacionLineal() throws RemoteException {
        return 0;
    }
}
