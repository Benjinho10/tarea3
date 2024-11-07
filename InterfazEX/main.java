package InterfazEX;
import javax.swing.JFrame;
/**
 * Clase principal que ejecuta la aplicación.
 * Esta clase contiene el método principal que crea y muestra la ventana.
 *
 * @author Benjamin
 * @author Joaquin
 *
 */
public class main {
    /**
     * Método principal que inicia la aplicación.
     * Crea una instancia de la ventana y la hace visible.
     */
    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}