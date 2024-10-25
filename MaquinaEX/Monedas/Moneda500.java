package MaquinaEX.Monedas;

/**
 * Subclase de Moneda que representa una moneda de 500 unidades.
 *
 * @author Benjamin
 * @author Joaquin
 */
public class Moneda500 extends Moneda {
    /**
     * Constructor  que crea una moneda de 500.
     */
    public Moneda500() {
        super();
    }
    /**
     * Devuelve el valor de esta moneda, que es 500 unidades.
     *
     * @return El valor de la moneda (500).
     */
    @Override
    public int getValor() {
        return 500;
    }
}
