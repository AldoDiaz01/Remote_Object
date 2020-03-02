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
            System.setProperty("java.rmi.server.hostname","192.168.43.198");

            InterfaceRemota ir = new ObjetoRemoto();

            Naming.rebind("//192.168.43.198/ObjetoRemoto", ir);
            System.out.println("Servidor iniciado...");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Servidor servidor = new Servidor();
    }
}
