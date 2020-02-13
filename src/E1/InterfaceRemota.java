package E1;
import java.rmi.*;
public interface InterfaceRemota extends Remote{
//Define el contrato que debe seguir el objeto remoto para el paso de parametros al servidor
    public double cuotaMensual(double capital, double interes, double plazo) throws RemoteException;
}
