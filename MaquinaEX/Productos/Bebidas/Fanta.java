package MaquinaEX.Productos.Bebidas;

import MaquinaEX.Productos.Precio_Serie;
/**
 * Subclase que representa una Fanta.
 *
 * Extiende la clase Bebida y define el comportamiento
 * de una Fanta, implementando el método consumir.
 *
 * @author Benjamin
 * @author Joaquin
 */
public class Fanta extends Bebida {
    /**
     * Constructor que crea una Fanta con un número de serie y precio definidos por un enumerador.
     *
     * @param i Número de serie de la Fanta.
     */
    public Fanta(int i) {
        super(Precio_Serie.FANTA.getNumSerie(), Precio_Serie.FANTA);
    }
    /**
     * Devuelve una representación de la acción de consumir una Fanta.
     *
     * @return Un String con el nombre "fanta".
     */
    @Override
    public String consumir() {
        return "fanta";
    }
}

