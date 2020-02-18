package E1;
import java.rmi.*;
import java.text.*;

public class Cliente     {
    public Cliente(){
        try{
            InterfaceRemota ir = (InterfaceRemota)Naming.lookup("//192.168.43.225/ObjetoRemoto");
            System.out.println("Capital: $20,000");
            System.out.println("Interes: 6%");
            System.out.println("Plazo: 5 años");
            DecimalFormat df = new DecimalFormat("#.##");
            
            System.out.println("Cuota mensual: "+ df.format(ir.cuotaMensual(20000.00, 6.00, 5.00))+" pesos");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Cliente();
    }
}
