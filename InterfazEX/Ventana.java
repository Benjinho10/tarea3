package InterfazEX;

import javax.swing.*;
import java.awt.*;

class Ventana extends JFrame {
    public Ventana() {
        super("Mi Ventana en Java");

        // Configurar el tamaño de la ventana
        this.setSize(400, 300);

        // Crear un panel con un layout de tipo BorderLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Crear una instancia de la clase Botones
        Botones botones = new Botones();

        // Crear un panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS)); // Layout vertical

        // Agregar los botones al panel de botones
        panelBotones.add(botones.getBoton1());
        panelBotones.add(botones.getBoton2());
        panelBotones.add(botones.getBoton3());
        panelBotones.add(botones.getBoton4());

        // Agregar el panel de botones al panel principal
        panel.add(panelBotones, BorderLayout.WEST);

        // Agregar el panel principal a la ventana
        this.add(panel);
    }
}

