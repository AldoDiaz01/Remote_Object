package E1;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class ObjetoRemoto extends UnicastRemoteObject implements InterfaceRemota{
    public ObjetoRemoto() throws RemoteException{
        super();
    }
    @Override
    public double cuotaMensual(double capital, double interes, double plazo){
        System.out.println("Calculando cuota...");
        double plazoMes = plazo /12.00;
        double interesMes = interes / 12.00;
        return (capital * interes) / (100.00 *(1 - (Math.pow(interesMes / 100.00, plazoMes))));
    }

    @Override
    public double triangleArea(double base, double height) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double regularPolygon(double perimeter, double apothem) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double irregularPolygon() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
