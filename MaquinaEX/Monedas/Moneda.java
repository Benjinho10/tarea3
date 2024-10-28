package MaquinaEX.Monedas;

/**
 * Clase abstracta que representa una moneda.
 *
 * Esta clase el uso simple de una moneda,obteneniendo su valor
 * y comparandola con otras monedas.
 *
 * Implementa la interfaz Comparable para permitir la comparación
 * entre monedas según su valor.
 *
 * @author Benjamin
 * @author Joaquin
 */

public abstract class Moneda implements Comparable<Moneda> {
    /**
     * Constructor para la clase {@code Moneda}
     */
   public Moneda() {}

    /**
     * Método abstracto que se implementa por las subclases para devolver
     * el valor de la moneda.
     *
     * @return El valor de la moneda.
     */
    public abstract int getValor();
    /**
     * Compara esta moneda con otra moneda según su valor.
     *
     * @param o La otra moneda con la que se va a comparar.
     * @return un valor positivo o negativo dependiendo si es mayor o menor o cero si son iguales.
     */
    @Override
    public int compareTo(Moneda o) {
        return Integer.compare(this.getValor(), o.getValor());
    }
}
