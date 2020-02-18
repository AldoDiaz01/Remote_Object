package E1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRemota extends Remote {

    /**
     * Calcula el area de un poligono regular con base en su perimetro y su apotema.
     * @param perimetro - Perimetro del poligono en formato decimal.
     * @param apotema - Apotema del poligono en formato decimal.
     * @return Area del poligono en formato decimal.
     * @throws RemoteException
     */
    public double AreaPoligono(double perimetro, double apotema) throws RemoteException;

    /**
     * Calcula el area de un circulo con base en su radio.
     * @param radio - Radio del circulo en formato decimal.
     * @return Area del circulo en formato decimal.
     * @throws RemoteException
     */
    public double AreaCirculo(double radio) throws RemoteException;

    /**
     * Resuelve los valores de una ecuación en la forma de ax²+bx+c con base en los valores positivo y negativo,
     * obtenidos mediante la formula general x = -b +- √b² - 4ac/2a, utilizando os valores a, b y c.
     * @param a - Valor de a en formato decimal.
     * @param b - Valor de b en formato decimal.
     * @param c - Valor de c en formato decimal.
     * @return Un arreglo de decimales con la primera posicion siendo el valor positivo y segundo el resultado del valor negativo.
     * @throws RemoteException
     */
    public double[] EcuacionLineal(double a, double b, double c) throws RemoteException;
} 
