package MaquinaEX.Productos;

/**
 * Clase abstracta que representa un producto del expendedor.
 *
 * Esta clase abstracta define sus caracteristicas en base al numero de serie y su valor.
 * Es implementada por las subclases de producto.
 *
 * @author Benjamin
 * @author Joaquin
 */
public abstract class Producto {
    private int numSerie;
    private Precio_Serie precio;
    /**
     * Constructor para crear un producto con un número de serie y un precio.
     *
     * @param numSerie El número de serie del producto.
     * @param precio El precio del producto.
     */
    public Producto(int numSerie, Precio_Serie precio) {
        this.numSerie = numSerie;
        this.precio = precio;
    }
    /**
     * Devuelve el número de serie del producto.
     *
     * @return El número de serie del producto.
     */
    public int getSerie() {
        return numSerie;
    }
    /**
     * Devuelve el precio del producto.
     *
     * @return El precio del producto, representado por {@link Precio_Serie}.
     */
    public Precio_Serie getPrecio() {
        return precio;
    }
    /**
     * Método abstracto que es implementado por las subclases para definir
     * cómo se consume el producto.
     *
     * @return String que describe el consumo del producto.
     */
    public abstract String consumir();
}

