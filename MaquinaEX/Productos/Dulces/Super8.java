package MaquinaEX.Productos.Dulces;

import MaquinaEX.Productos.Precio_Serie;
/**
 * Subclase que representa un Super8.
 *
 * Extiende la clase Dulce y define el comportamiento
 * de un Super8, implementando el método consumir.
 *
 * @author Benjamin
 * @author Joaquin
 */
public class Super8 extends Dulce {
    /**
     * Constructor que crea un Super8 con un número de serie y precio definidos por un enumerador.
     *
     * @param i Número de serie del Super8.
     */
    public Super8(int i) {
        super(Precio_Serie.SUPER8.getNumSerie(), Precio_Serie.SUPER8);
    }
    /**
     * Devuelve una representación de la acción de consumir un Super8.
     *
     * @return Un String con el nombre "super8".
     */
    @Override
    public String consumir() {
        return "super8";
    }
}
