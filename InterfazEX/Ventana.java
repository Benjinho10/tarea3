package InterfazEX;

import javax.swing.*;
import MaquinaEX.Exprendedor.Expendedor;

public class Ventana extends JFrame {

    private PanelPrincipal panelPrincipal;

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






