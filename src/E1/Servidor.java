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
            //System.setProperty("java.rmi.server.codebase", "C:/Users/dniel/Documents/IDEA projects/Remote_Object/src/E1/Servidor"); // Cambie la ruta
            System.setProperty("java.rmi.server.hostname","10.30.7.22");

            InterfaceRemota ir = new ObjetoRemoto();

            Naming.rebind("//10.30.7.22/ObjetoRemoto", ir);
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
