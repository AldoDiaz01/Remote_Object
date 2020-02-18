package E1;

import java.rmi.*;
import java.text.*;
import java.util.Scanner;

public class Cliente {

    public Cliente(){
        try{
            
            InterfaceRemota objetoRemoto = (InterfaceRemota)Naming.lookup("//192.168.43.198/ObjetoRemoto");
            
            Scanner teclado = new Scanner(System.in);
            System.out.println("Menu de opciones:");
            System.out.println("1.Area de un circulo");
            System.out.println("2.Area de un poligono regular");
            System.out.println("3.Area de un poligono irregular");
            System.out.print("Seleccione una: ");
            int opcion;
            opcion = teclado.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el radio del circulo: ");
                    double radio = teclado.nextDouble();
                    System.out.println("El resultado es: " + objetoRemoto.AreaCirculo(radio));
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Cliente();
    }
}
