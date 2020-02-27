package E1;

import java.rmi.Naming;
import java.util.Scanner;

public class Cliente {

    public Cliente() {
        String respuesta = "N";
        try {
            InterfaceRemota objetoRemoto = (InterfaceRemota) Naming.lookup("//192.168.43.198/ObjetoRemoto");

            Scanner teclado = new Scanner(System.in);
            
            do {
                try {
                    System.out.println("Menu de opciones:");
                    System.out.println("1.Calculo del area de un circulo");
                    System.out.println("2.Calculo del area de un poligono");
                    System.out.println("3.Calculo de una ecuacion cuadratica");
                    System.out.print("Seleccione una opcion: ");
                    int opcion;
                    opcion = teclado.nextInt();

                    switch (opcion) {
                        case 1:
                            System.out.println("Escogio el area de un circulo: ");
                            System.out.println("Ingrese el radio del circulo: ");
                            double radio = teclado.nextDouble();
                            System.out.println("El resultado es: " + objetoRemoto.AreaCirculo(radio));
                            break;

                        case 2:
                            System.out.println("Escogio el area de un poligono: ");
                            System.out.println("Ingresa el numero de lados: ");
                            int numeroLados = teclado.nextInt();
                            System.out.println("Ingrese la longitud de los lados: ");
                            double perimetro = teclado.nextDouble();
                            System.out.println("Ingrese el apotema: ");
                            double apotema = teclado.nextDouble();
                            System.out.println("El resultado es: " + objetoRemoto.AreaPoligono(numeroLados, perimetro, apotema));
                            break;

                        case 3:
                            System.out.println("Escogio una ecuacion cuadratica: ");
                            System.out.println("Ingrese 'a': ");
                            double a = teclado.nextDouble();
                            System.out.println("Ingrese 'b': ");
                            double b = teclado.nextDouble();
                            System.out.println("Ingrese 'c': ");
                            double c = teclado.nextDouble();
                            System.out.println("El resultado: ");
                            int tam = objetoRemoto.EcuacionLineal(a, b, c).length;
                            double[] arreglo;
                            arreglo = objetoRemoto.EcuacionLineal(a, b, c);
                            if (arreglo.length == 0) {
                                System.out.println("Error  matematico. No es posible realizarlo, dado que saca una raiz negativa.");
                            } else {
                                for (int i = 0; i < tam; i++) {
                                    System.out.println(i + " = " + arreglo[i]);
                                }
                            }
                            break;

                        default:
                            System.out.println("Cerrando...");
                            System.exit(0);
                    }
                    teclado.nextLine();
                    System.out.println("¿Desea regresar al menu de opciones? S/N");
                    respuesta = teclado.next();

                } catch (Exception e) {
                    System.out.println("Dato invalido, por favor ingrese un numero");
                }
            } while (respuesta.equals("S") || respuesta.equals("s"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Cliente();
    }
}
