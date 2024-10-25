package MaquinaEX.Productos.Bebidas;

import MaquinaEX.Productos.Precio_Serie;
/**
 * Subclase que representa una CocaCola.
 *
 * Extiende la clase Bebida y define el comportamiento
 * de una CocaCola, implementando el método consumir.
 *
 * @author Benjamin
 * @author Joaquin
 */
public class CocaCola extends Bebida {
    /**
     * Constructor que crea una CocaCola con un número de serie y precio definidos por un enumerador.
     *
     * @param i Número de serie de la CocaCola.
     */
    public CocaCola(int i) {
        super(Precio_Serie.COCACOLA.getNumSerie(), Precio_Serie.COCACOLA);
    }
    /**
     * Devuelve una representación de la acción de consumir una CocaCola.
     *
     * @return Un String con el nombre "cocacola".
     */
    @Override
    public String consumir() {
        return "cocacola";
    }
}

