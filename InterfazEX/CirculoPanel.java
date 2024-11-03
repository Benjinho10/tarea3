package InterfazEX;

import javax.swing.*;
import java.awt.*;

class CirculoPanel extends JPanel {
    private int diametro;

    public CirculoPanel(int diametro) {
        this.diametro = diametro;
        this.setPreferredSize(new Dimension(diametro, diametro));
        this.setBackground(Color.BLACK); // Fondo negro para el panel del círculo
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED); // Color del círculo
        g.fillOval(100,100, diametro, diametro); // Dibuja el círculo
    }
}