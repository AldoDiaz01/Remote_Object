package E1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente {

    public Cliente() throws RemoteException, MalformedURLException, NotBoundException {
        String respuesta = "S";
        
        while (respuesta.equals("S") || respuesta.equals("s")) {
            
            try {
                InterfaceRemota objetoRemoto = (InterfaceRemota) Naming.lookup("//10.30.7.18/ObjetoRemoto");

                Scanner teclado = new Scanner(System.in);

                try {

                    System.out.println("Menu de opciones:");
                    System.out.println("1.Calculo del area de un circulo");
                    System.out.println("2.Calculo del area de un poligono");
                    System.out.println("3.Calculo de una ecuacion cuadratica");
                    System.out.println("4.Salir");
                    System.out.print("Seleccione una opcion: ");
                    int opcion;
                    opcion = teclado.nextInt();

                    switch (opcion) {
                        case 1:
                            System.out.println("Escogio el area de un circulo... ");
                            System.out.println("Ingrese el radio del circulo: ");
                            double radio = teclado.nextDouble();
                            System.out.println("El resultado es: " + objetoRemoto.AreaCirculo(radio));
                            break;

                        case 2:
                            System.out.println("Escogio el area de un poligono... ");
                            System.out.println("Ingresa el numero de lados: ");
                            int numeroLados = teclado.nextInt();
                            System.out.println("Ingrese la longitud de los lados: ");
                            double perimetro = teclado.nextDouble();
                            System.out.println("Ingrese el apotema: ");
                            double apotema = teclado.nextDouble();
                            System.out.println("El resultado es: " + objetoRemoto.AreaPoligono(numeroLados, perimetro, apotema));
                            break;

                        case 3:
                            System.out.println("Escogio una ecuacion cuadratica... ");
                            System.out.println("Ingrese 'a': ");
                            double a = teclado.nextDouble();
                            System.out.println("Ingrese 'b': ");
                            double b = teclado.nextDouble();
                            System.out.println("Ingrese 'c': ");
                            double c = teclado.nextDouble();
                            int tam = objetoRemoto.EcuacionLineal(a, b, c).length;
                            double[] arreglo;
                            arreglo = objetoRemoto.EcuacionLineal(a, b, c);
                            System.out.println("El resultado es: ");
                            if (arreglo.length == 0) {
                                System.out.println("Error  matematico. No es posible realizarlo, dado que saca una raiz negativa.");
                            } else {
                                for (int i = 0; i < tam; i++) {
                                    System.out.println("x" + i + " = " + arreglo[i]);
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Cerrando...");
                            System.exit(0);
                        default:
                            System.out.println("Opcion invalida, regresando al menu");
                            break;
                    }
                    teclado.nextLine();
                    System.out.println("¿Desea regresar al menu de opciones? S/s = Regresar al menu // Otro = Salir");
                    respuesta = teclado.next();
                } catch (RemoteException e) {
                    System.out.println("Error... Regresando al menu");
                }
            } catch (InputMismatchException d) {
                System.out.println("Dato invalido, por favor ingrese un numero... Regresando al menu");
            }
        }
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        new Cliente();
    }
}
