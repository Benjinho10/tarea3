package MaquinaEX.Deposito;
import java.util.ArrayList;

/**
 * Clase genérica de un depósito de productos.
 *
 * Almacena una lista de elementos de tipo genérico y permite agregar y retirar
 * elementos de ella.
 *
 * @param <T> El tipo de elementos que el depósito almacenará.
 *
 * @author Benjamin
 * @author Joaquin
 */
public class Deposito<T> {

    private ArrayList<T> items;
    /**
     * Devuelve los elementos que tiene el depósito.
     *
     * @return Lista de los elementos almacenados en el depósito.
     */
    public ArrayList<T> getItems(){
        return items;
    }
    /**
     * Constructor que inicializa un depósito vacío.
     */
    public Deposito() {
        items = new ArrayList<>();
    }
    /**
     * Agrega elementos al depósito.
     *
     * @param item El elemento a agregar al depósito.
     */
    public void add(T item) {
        items.add(item);
    }
    /**
     * Obtiene y remueve el primer elemento del depósito.
     *
     * @return El primer elemento almacenado en el depósito o null si está vacío.
     */
    public T get() {
        if (items.size() > 0) {
            return items.remove(0);
        }
        return null;
    }
}