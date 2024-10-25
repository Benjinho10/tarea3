package MaquinaEX.Productos.Bebidas;

import MaquinaEX.Productos.Precio_Serie;
/**
 * Subclase que representa una Sprite.
 *
 * Extiende la clase Bebida y define el comportamiento
 * de una Sprite, implementando el método consumir.
 *
 * @author Benjamin
 * @author Joaquin
 */
public class Sprite extends Bebida {
    /**
     * Constructor que crea una Sprite con un número de serie y precio definidos por un enumerador.
     *
     * @param i Número de serie de la Sprite.
     */
    public Sprite(int i) {
        super(Precio_Serie.SPRITE.getNumSerie(), Precio_Serie.SPRITE);
    }
    /**
     * Devuelve una representación de la acción de consumir una Sprite.
     *
     * @return Un String con el nombre "sprite".
     */
    @Override
    public String consumir() {
        return "sprite";
    }
}

