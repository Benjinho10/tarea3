package InterfazEX;
import javax.swing.*;
import MaquinaEX.Exprendedor.Expendedor;
/**
 * Ventana es la clase principal que representa la ventana de la interfaz gráfica de la máquina expendedora.
 * Esta clase extiende de JFrame y contiene un PanelPrincipal que organiza la interfaz
 *
 * @author Benjamin
 * @author Joaquin
 */
public class Ventana extends JFrame {

    private PanelPrincipal panelPrincipal;
    /**
     * Constructor de la clase Ventana.
     * Inicializa la ventana con un título, tamaño y configuración del comportamiento al cerrar.
     * Crea una instancia de Expendedor y de PanelPrincipal, y los añade a la ventana.
     */
    public Ventana() {
        super("Máquina Expendedora - Tarea 3");
        this.setSize(915, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Expendedor expendedor = new Expendedor(5);
        panelPrincipal = new PanelPrincipal(expendedor);

        this.add(panelPrincipal);
        this.setVisible(true);
    }
}






