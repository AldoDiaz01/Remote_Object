package E1;

import java.rmi.Naming;

/**
 * Servidor para el ejemplo de RMI
 * @author vitom
 */
public class Servidor {
    
    //Crea nueva instancia de servidor RMI
    public Servidor() {
        try {
            //Se indica a rmiregistry donde estan las clases
            System.setProperty("java.rmi.server.codebase", "C:/Users/vitom/Documents/NetBeansProjects/Hipoteca/src/E1"); // Cambie la ruta
            
            InterfaceRemota ir = new ObjetoRemoto();
            
            Naming.rebind("//10.50.2.15/ObjectoRemoto", ir);
            System.out.println("Servicio iniciado...");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Servidor servidor = new Servidor();
    }
}
