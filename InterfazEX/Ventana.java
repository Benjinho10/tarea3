package InterfazEX;

import javax.swing.*;
        import java.awt.*;
        import MaquinaEX.Exprendedor.Expendedor;

public class Ventana extends JFrame {
    private PanelExpendedor panelExpendedor; // Objeto del panel expendedor
    private PanelComprador panelComprador; // Objeto del panel comprador

    public Ventana() {
        super("Máquina Expendedora - Tarea 3");
        this.setSize(915, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creación del Panel Principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Inicializar el expendedor
        Expendedor expendedor = new Expendedor(5); // Asegúrate de tener el constructor adecuado

        // Inicializar PanelExpendedor y PanelComprador
        panelExpendedor = new PanelExpendedor(expendedor);
        panelComprador = new PanelComprador(expendedor, panelExpendedor); // Pasar panelExpendedor a PanelComprador

        // Agregar los paneles al panel principal
        panel.add(panelExpendedor, BorderLayout.WEST);
        panel.add(panelComprador, BorderLayout.EAST);

        this.add(panel);
        this.setVisible(true); // Asegúrate de que la ventana sea visible
    }

    // Método para actualizar el total de monedas
    public void actualizarTotal(int total) {
        panelComprador.agregarMoneda(total); // Asegúrate de que esto llame al método adecuado en PanelComprador
    }

    // Método para reiniciar el comprador
    public void reiniciarComprador() {
        panelComprador.reiniciar();
    }

    // Método para obtener el expendedor
    public Expendedor getExpendedor() {
        return panelExpendedor.getExpendedor();
    }
}





