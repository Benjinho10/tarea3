package MaquinaEX.Excepciones;

/**
 * Excepcion utilizada cuando se ingresa una moneda no valida en el expendedor.
 * Se ocupa para indicar que el tipo o la cantidad de pago no es valida
 * para la compra.
 *
 * @author Benjamin
 * @author Joaquin
 *
 */

public class PagoIncorrectoException extends Exception{
    /**
     * Constructor que crea la excepcion PagoIncorrectoException.
     *
     * Se llama al constructor de la clase {@code Exception}.
     */
    public PagoIncorrectoException(){
        super();
    }
}
