package MaquinaEX.Productos;

/**
 * Enumeración que representa el precio y número de serie de diferentes productos.
 *
 * Cada valor enum contiene un precio y un número de serie, los cuales son
 * asignados a diferentes productos del expendedor.
 *
 * @author Benjamin
 * @author Joaquin
 */
public enum Precio_Serie {
    SPRITE(700, 0),
    COCACOLA(800, 1),
    FANTA(700, 2),
    SUPER8(900, 3),
    SNICKERS(1000, 4);

    private int valor;
    private int numSerie;
    /**
     * Constructor para la enumeración Precio_Serie.
     *
     * Asigna el precio y el número de serie correspondientes a cada producto.
     *
     * @param valor El valor del producto.
     * @param numSerie El número de serie del producto.
     */
    Precio_Serie(int valor, int numSerie) {
        this.valor = valor;
        this.numSerie = numSerie;
    }
    /**
     * Devuelve el valor para cada producto.
     *
     * @return El valor del producto.
     */
    public int getValor() {
        return valor;
    }
    /**
     * Devuelve el número de serie para cada producto.
     *
     * @return El número de serie del producto.
     */
    public int getNumSerie() {
        return numSerie;
    }
}