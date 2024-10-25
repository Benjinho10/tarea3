package MaquinaEX.Productos.Bebidas;

import MaquinaEX.Productos.Precio_Serie;
import MaquinaEX.Productos.Producto;
/**
 * Clase abstracta que representa el tipo de producto bebida.
 *
 * Extension de la clase Producto que define el comportamiento de una bebida.
 * Es implementado por las subclases.
 *
 * @author Benjamin
 * @author Joaquin
 */
public abstract class Bebida extends Producto {
    /**
     * Constructor que crea una bebida con su precio y numero de serie.
     *
     * @param numSerie Número de serie de la bebida.
     * @param precio Precio de la bebida.
     */
    public Bebida(int numSerie, Precio_Serie precio) {
        super(numSerie, precio);
    }

    /**
     * Método abstracto que es implementado por las subclases.
     * Define como se consume la bebida.
     *
     * @return Un String que describe el consumo de la bebida.
     */
    @Override
    public abstract String consumir();
}


