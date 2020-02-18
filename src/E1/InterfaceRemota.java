package E1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRemota extends Remote {
    //Define el contrato que debe seguir el objeto remoto para el paso de parametros al servidor
    public double cuotaMensual(double capital, double interes, double plazo) throws RemoteException;

    public double regularPolygon(double perimeter, double apothem) throws RemoteException;

    public double irregularPolygon() throws RemoteException;
} 
