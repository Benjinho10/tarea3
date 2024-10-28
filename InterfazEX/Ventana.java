package InterfazEX;

import java.awt.*;
import javax.swing.*;

class Ventana extends JFrame {
    public Ventana() {
        super();
        this.setTitle("VENTANA PARA PROBAR");
        this.setLayout(new BorderLayout());

        JPanel panelCentro = new JPanel();
        panelCentro.setBackground(Color.LIGHT_GRAY);
        panelCentro.setLayout(new GridBagLayout());
        JLabel etiqueta = new JLabel("prueba");
        JButton boton = new JButton("ola");

        panelCentro.add(etiqueta);
        panelCentro.add(boton);

        this.add(panelCentro, BorderLayout.CENTER);
        this.setSize(700,900);
        this.setVisible(true);
    }
}