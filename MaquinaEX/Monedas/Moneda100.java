package MaquinaEX.Monedas;

/**
 * Subclase de Moneda que representa una moneda de 100 unidades.
 *
 * @author Benjamin
 * @author Joaquin
 */
public class Moneda100 extends Moneda {
    /**
     * Constructor  que crea una moneda de 100.
     */
    public Moneda100() {
        super();
    }
    /**
     * Devuelve el valor de esta moneda, que es 100 unidades.
     *
     * @return El valor de la moneda (100).
     */
    @Override
    public int getValor() {
        return 100;
    }
}

