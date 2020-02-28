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
                    System.out.println("1.Cálculo del área de un circulo");
                    System.out.println("2.Cálculo del área de un poligono");
                    System.out.println("3.Cálculo de una ecuación cuadrática");
                    System.out.print("Seleccione una opción: ");
                    int opcion;
                    opcion = teclado.nextInt();

                    switch (opcion) {
                        case 1:
                            System.out.println("Escogió el área de un círculo: ");
                            System.out.println("Ingrese el radio del círculo: ");
                            double radio = teclado.nextDouble();
                            System.out.println("El resultado es: " + objetoRemoto.AreaCirculo(radio));
                            break;

                        case 2:
                            System.out.println("Escogió el área de un polígono: ");
                            System.out.println("Ingresa el número de lados: ");
                            int numeroLados = teclado.nextInt();
                            System.out.println("Ingrese la longitud de los lados: ");
                            double perimetro = teclado.nextDouble();
                            System.out.println("Ingrese el apotema: ");
                            double apotema = teclado.nextDouble();
                            System.out.println("El resultado es: " + objetoRemoto.AreaPoligono(numeroLados, perimetro, apotema));
                            break;

                        case 3:
                            System.out.println("Escogió una ecuación cuadrática: ");
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
