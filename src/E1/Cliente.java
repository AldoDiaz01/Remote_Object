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
            System.out.println("1.Calculo del area de un circulo");
            System.out.println("2.Calculo del area de un poligono");
            System.out.println("3.Calculo de una ecuacion cuadratica");
            System.out.print("Seleccione una opcion: ");
            int opcion;
            opcion = teclado.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el radio del circulo: ");
                    double radio = teclado.nextDouble();
                    System.out.println("El resultado es: " + objetoRemoto.AreaCirculo(radio));
                    break;
                case 2:
                    System.out.println("Ingrese el perimetro del poligono: ");
                    double perimetro = teclado.nextDouble();
                    System.out.println("Ingrese el apotema: ");
                    double apotema = teclado.nextDouble();
                    System.out.println("El resultado es: " + objetoRemoto.AreaPoligono(perimetro, apotema));
                    break;
                case 3:
                    System.out.println("Ingrese 'a': ");
                    double a = teclado.nextDouble();
                    System.out.println("Ingrese 'b': ");
                    double b = teclado.nextDouble();
                    System.out.println("Ingrese 'c': ");
                    double c = teclado.nextDouble();
                    System.out.println("El resultado: ");
                    int tam = objetoRemoto.EcuacionLineal(a, b, c).length;
                    double [] arreglo;
                    arreglo = objetoRemoto.EcuacionLineal(a, b, c);
                    for(int i = 0; i < tam; i++){
                        System.out.println(arreglo[i]);
                    }
                    break;
                default:
                    System.out.println("Hasta la proximaaaaa...");
                    System.exit(0);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Cliente();
    }
}
