package InterfazEX;

import javax.swing.*;
        import java.awt.*;
        import MaquinaEX.Exprendedor.Expendedor;

public class Ventana extends JFrame {
    private PanelExpendedor panelExpendedor;
    private PanelComprador panelComprador;

    public Ventana() {
        super("Máquina Expendedora - Tarea 3");
        this.setSize(915, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Inicializar el expendedor
        Expendedor expendedor = new Expendedor(5); // Asegúrate de que el constructor sea el adecuado

        // Inicializar PanelExpendedor y PanelComprador sin cruzar referencias
        panelExpendedor = new PanelExpendedor(expendedor, null);
        panelComprador = new PanelComprador(expendedor, null);

        // Ahora establecer referencias cruzadas
        panelExpendedor.setPanelComprador(panelComprador);
        panelComprador.setPanelExpendedor(panelExpendedor);

        // Agregar los paneles al panel principal
        panel.add(panelExpendedor, BorderLayout.WEST);
        panel.add(panelComprador, BorderLayout.EAST);

        this.add(panel);
        this.setVisible(true);
    }

    // Método para actualizar el total de monedas
    public void actualizarTotal(int total) {
        panelComprador.agregarMoneda(total);
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





