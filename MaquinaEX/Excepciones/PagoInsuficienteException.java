package MaquinaEX.Excepciones;

/**
 * Excepcion utilizada cuando se ingresa una moneda que no cumple con el valor del producto.
 * Es utilizada para indicar que la cantidad del pago no fue suficiente para un
 * determinado producto.
 *
 * @author Benjamin
 * @author Joaquin
 *
 */

public class PagoInsuficienteException extends Exception{
    /**
     * Constructor que crea la excepcion PagoInsuficienteException.
     *
     * Se llama al constructor de la clase {@code Exception}.
     */
    public PagoInsuficienteException(){
        super();
    }
}
