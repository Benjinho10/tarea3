package InterfazEX;

import javax.swing.*;
import java.awt.*;
import MaquinaEX.Exprendedor.Expendedor;

public class PanelPrincipal extends JPanel {

    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal(Expendedor expendedor) {
        exp = new PanelExpendedor(expendedor, null);
        com = new PanelComprador(expendedor, null);

        // Establecer el fondo de PanelPrincipal
        this.setBackground(Color.white);

        // Usar un layout adecuado para agregar y posicionar los paneles
        this.setLayout(new BorderLayout());

        // Agregar PanelExpendedor y PanelComprador al contenedor (PanelPrincipal)
        this.add(exp, BorderLayout.WEST);  // Ajusta la posición según el diseño
        this.add(com, BorderLayout.EAST);  // Ajusta la posición según el diseño

        // Establecer referencias cruzadas después de crear los paneles
        exp.setPanelComprador(com);
        com.setPanelExpendedor(exp);
    }

    // Método para actualizar el total de monedas
    public void actualizarTotal(int total) {
        com.agregarMoneda(total);
    }

    // Método para reiniciar el comprador
    public void reiniciarComprador() {
        com.reiniciar();
    }

    // Método para obtener el expendedor
    public Expendedor getExpendedor() {
        return exp.getExpendedor();
    }
}

