package MaquinaEX.Monedas;

/**
 * Subclase de Moneda que representa una moneda de 1000 unidades.
 *
 * @author Benjamin
 * @author Joaquin
 */
public class Moneda1000 extends Moneda {
    /**
     * Constructor  que crea una moneda de 1000.
     */
    public Moneda1000() {
        super();
    }
    /**
     * Devuelve el valor de esta moneda, que es 1000 unidades.
     *
     * @return El valor de la moneda (1000).
     */
    @Override
    public int getValor() {
        return 1000;
    }
}

