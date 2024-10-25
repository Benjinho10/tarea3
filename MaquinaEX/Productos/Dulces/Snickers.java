package MaquinaEX.Productos.Dulces;

import MaquinaEX.Productos.Precio_Serie;
/**
 * Subclase que representa un Snickers.
 *
 * Extiende la clase Dulce y define el comportamiento
 * de un Snickers, implementando el método consumir.
 *
 * @author Benjamin
 * @author Joaquin
 */
public class Snickers extends Dulce {
    /**
     * Constructor que crea un Snickers con un número de serie y precio definidos por un enumerador.
     *
     * @param i Número de serie del Snickers.
     */
    public Snickers(int i) {
        super(Precio_Serie.SNICKERS.getNumSerie(), Precio_Serie.SNICKERS);
    }
    /**
     * Devuelve una representación de la acción de consumir un Snickers.
     *
     * @return Un String con el nombre "snickers".
     */
    @Override
    public String consumir() {
        return "snickers";
    }
}
