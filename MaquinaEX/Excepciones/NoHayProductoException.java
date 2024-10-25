package MaquinaEX.Excepciones;

/**
 * Excepcion utilizada al momento de no tener el producto disponible en el expendedor.
 * Se lanza cuando se acabo el producto del expendedor o cuando se escoge una opcion no valida.
 *
 * @author Benjamin
 * @author Joaquin
 *
 */
public class NoHayProductoException extends Exception{
    /**
     * Constructor que crea la excepcion NoHayProductoException.
     *
     * Se llama al constructor de la clase {@code Exception}.
     */
    public NoHayProductoException(){
        super();
    }
}
