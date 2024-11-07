package InterfazEX;
import javax.swing.*;
import java.awt.*;
import MaquinaEX.Exprendedor.Expendedor;
/**
 * PanelPrincipal que organiza y gestiona la interfaz gráfica del sistema de expendedor de productos.
 * Este panel incluye dos subpaneles: un PanelComprador y un PanelExpendedor, que permiten la interacción del comprador
 * con el expendedor de productos y el manejo de las compras.
 *
 * @author Benjamin
 * @author Joaquin
 *
 */
public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;
    /**
     * Constructor de la clase PanelPrincipal.
     * Inicializa los subpaneles de comprador y expendedor, y configura el diseño del panel principal.
     * Establece la relación entre ambos paneles para permitir la interacción mutua.
     *
     * @param expendedor El expendedor que gestiona las compras de productos
     */
    public PanelPrincipal(Expendedor expendedor) {
        exp = new PanelExpendedor(expendedor, null);
        com = new PanelComprador(expendedor, null);

        this.setBackground(Color.white);

        this.setLayout(new BorderLayout());

        this.add(exp, BorderLayout.WEST);
        this.add(com, BorderLayout.EAST);

        exp.setPanelComprador(com);
        com.setPanelExpendedor(exp);
    }
    /**
     * Actualiza el total de monedas en el PanelComprador.
     *
     * @param total El total de monedas a agregar al PanelComprador
     */
    public void actualizarTotal(int total) {
        com.agregarMoneda(total);
    }
    /**
     * Reinicia el estado del PanelComprador, restableciendo el total de monedas a cero.
     */
    public void reiniciarComprador() {
        com.reiniciar();
    }
    /**
     * Obtiene el expendedor asociado a este PanelPrincipal.
     *
     * @return El objeto Expendedor asociado al PanelPrincipal
     */
    public Expendedor getExpendedor() {
        return exp.getExpendedor();
    }
}

