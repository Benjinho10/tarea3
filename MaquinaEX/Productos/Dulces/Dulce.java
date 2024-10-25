package MaquinaEX.Productos.Dulces;

import MaquinaEX.Productos.Precio_Serie;
import MaquinaEX.Productos.Producto;
/**
 * Clase abstracta que representa el tipo de producto dulce.
 *
 * Extension de la clase Producto que define el comportamiento de un dulce.
 * Es implementado por las subclases.
 *
 * @author Benjamin
 * @author Joaquin
 */
public abstract class Dulce extends Producto {
    /**
     * Constructor que crea un dulce con su precio y numero de serie.
     *
     * @param numSerie Número de serie del dulce.
     * @param precio Precio del dulce.
     */
    public Dulce(int numSerie, Precio_Serie precio) {
        super(numSerie, precio);
    }
}
