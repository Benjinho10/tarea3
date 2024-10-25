import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import MaquinaEX.Monedas.Moneda;
import MaquinaEX.Monedas.Moneda100;
import MaquinaEX.Monedas.Moneda1000;
import MaquinaEX.Monedas.Moneda500;
import MaquinaEX.Productos.Precio_Serie;
import MaquinaEX.Excepciones.PagoIncorrectoException;
import MaquinaEX.Excepciones.NoHayProductoException;
import MaquinaEX.Excepciones.PagoInsuficienteException;
import MaquinaEX.Comprador.Comprador;
import MaquinaEX.Exprendedor.Expendedor;
/**
 * Clase principal que contiene el método main para probar el funcionamiento del expendedor de productos.
 *
 * @author Benjamin
 * @author Joaquin
 */
public class Main {
    /**
     * Método principal que ejecuta diferentes ejemplos de compra en el expendedor.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        //Inicializa el expendedor con un valor cualquiera.
        Expendedor exp = new Expendedor(5);

        // Pruebas con distintos escenarios:

        System.out.println("Escenario 1: Monedas nulas ");
        try {
            List<Moneda> monedas0 = null;
            Comprador comprador1 = new Comprador(monedas0, Precio_Serie.FANTA.getNumSerie(), exp);
        } catch (PagoIncorrectoException e) {
            System.out.println("Error: Pago incorrecto. No se pueden usar monedas nulas.");
        } catch (NoHayProductoException e) {
            System.out.println("Error: Producto no disponible.");
        } catch (PagoInsuficienteException e) {
            System.out.println("Error: Pago insuficiente.");
        }


        System.out.println("\nEscenario 2: Pago insuficiente");
        try {

            List<Moneda> monedas1 = new ArrayList<>();
            monedas1.add(new Moneda100()); // 100
            monedas1.add(new Moneda100()); // 200
            Comprador comprador2 = new Comprador(monedas1, Precio_Serie.FANTA.getNumSerie(), exp);
        } catch (PagoIncorrectoException e) {
            System.out.println("Error: Pago incorrecto.");
        } catch (NoHayProductoException e) {
            System.out.println("Error: Producto no disponible.");
        } catch (PagoInsuficienteException e) {
            System.out.println("Error: Pago insuficiente. Se necesita más dinero.");
        }

        System.out.println("\nEscenario 3: Pago exacto");
        try {
            List<Moneda> monedas2 = new ArrayList<>();
            monedas2.add(new Moneda500()); // 500
            monedas2.add(new Moneda100()); // 600
            monedas2.add(new Moneda100()); // 700
            Comprador comprador3 = new Comprador(monedas2, 3, exp);
            System.out.println("Compraste: " + comprador3.queConsumiste());
            System.out.println("Vuelto: " + comprador3.cuantoVuelto());
        } catch (PagoIncorrectoException e) {
            System.out.println("Error: Pago incorrecto.");
        } catch (NoHayProductoException e) {
            System.out.println("Error: Producto no disponible.");
        } catch (PagoInsuficienteException e) {
            System.out.println("Error: Pago insuficiente.");
        }

        System.out.println("\nEscenario 4: Pago con exceso");
        List<Moneda> monedas4 = new ArrayList<>();
        monedas4.add(new Moneda1000()); // 1000
        int n=0;
        while (n<6) {
            try {
                Comprador comprador4 = new Comprador(monedas4, 3, exp);
                System.out.println("Compraste: " + comprador4.queConsumiste());
                System.out.println("Vuelto: " + comprador4.cuantoVuelto());
            } catch (NoHayProductoException e) {
                System.out.println("Error: Producto no disponible.");

            } catch (PagoIncorrectoException e) {
                System.out.println("Error: Pago incorrecto.");

            } catch (PagoInsuficienteException e) {
                System.out.println("Error: Pago insuficiente.");
            }
            n++;
        }

        System.out.println();

        // Crear una lista para almacenar las monedas
        ArrayList<Moneda> monedas = new ArrayList<>();

        // Agregar instancias de monedas a la lista
        monedas.add(new Moneda100());
        monedas.add(new Moneda500());
        monedas.add(new Moneda1000());
        monedas.add(new Moneda100());  // Agregamos otra moneda de 100 para ver cómo se ordena

        // Imprimir monedas antes de la ordenación
        System.out.println("Monedas antes de la ordenación:");
        for (Moneda moneda : monedas) {
            System.out.println("Valor de la moneda: " + moneda.getValor());
        }

        // Ordenar las monedas usando el método compareTo
        Collections.sort(monedas);

        // Imprimir las monedas después de la ordenación
        System.out.println("\nMonedas después de la ordenación:");
        for (Moneda moneda : monedas) {
            System.out.println("Valor de la moneda: " + moneda.getValor());
        }
    }
}