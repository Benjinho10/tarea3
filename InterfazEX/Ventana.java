package InterfazEX;

import javax.swing.*;
import java.awt.*;

class Ventana extends JFrame {
    public Ventana() {
        super("Maquina Expendedora - Tarea 3");
        this.setSize(900, 700);

        // Creación del Panel Principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Configuración del panel izquierdo
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BorderLayout());
        panelIzquierdo.add(new JLabel("Expendedor"));
        panelIzquierdo.setPreferredSize(new Dimension(500, 500)); //Tamaño panel izquierdo
        panelIzquierdo.setBackground(Color.LIGHT_GRAY); //Color panel izquierdo

        // Crear un JLayeredPane para apilar la imagen y los botones
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 500)); // Tamaño del área de imagen y botones

        // Imagen de fondo
        ImageIcon iconoOriginal = new ImageIcon("Imagenes/expendedortarea3.png");
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(400, 500, Image.SCALE_SMOOTH); // Ajusta el tamaño
        JLabel etiquetaImagen = new JLabel(new ImageIcon(imagenEscalada));
        etiquetaImagen.setBounds(50, 80, 400, 500); // Posición y tamaño de la imagen

        // Agregar la imagen en el fondo del JLayeredPane (capa más baja)
        layeredPane.add(etiquetaImagen, Integer.valueOf(0));

        // Instanciar los botones y ubicarlos en el layeredPane
        Botones botones = new Botones();
        botones.getBotonCocaCola().setBounds(81, 102, 263, 70); // Posición y tamaño del botón 1
        botones.getBotonSprite().setBounds(81, 177, 263, 72); // Posición y tamaño del botón 2
        botones.getBotonFanta().setBounds(81, 256, 263, 76); // Posición y tamaño del botón 3
        botones.getBotonSuper8().setBounds(81, 338, 263, 79); // Posición y tamaño del botón 4
        botones.getBotonSnickers().setBounds(81, 423, 263, 70); // Posición y tamaño del botón 5
        // Agregar los botones en una capa superior en el JLayeredPane
        layeredPane.add(botones.getBotonCocaCola(), Integer.valueOf(1));
        layeredPane.add(botones.getBotonSprite(), Integer.valueOf(1));
        layeredPane.add(botones.getBotonFanta(), Integer.valueOf(1));
        layeredPane.add(botones.getBotonSuper8(), Integer.valueOf(1));
        layeredPane.add(botones.getBotonSnickers(), Integer.valueOf(1));

        // Agregar el layeredPane al panelIzquierdo
        panelIzquierdo.add(layeredPane, BorderLayout.WEST);

        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new GridLayout(2, 1)); // Divide el panel en 2 filas, 1 columna
        panelDerecho.setPreferredSize(new Dimension(400, 500));

// Crear las dos secciones
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(Color.DARK_GRAY); // Color del panel superior

        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(Color.GRAY); // Color del panel inferior

// Agregar los paneles superior e inferior al panel derecho
        panelDerecho.add(panelSuperior);
        panelDerecho.add(panelInferior);

// Agregar los paneles al BorderLayout
        panel.add(panelIzquierdo, BorderLayout.WEST);
        panel.add(panelDerecho, BorderLayout.EAST);

// Agregar el panel principal a la ventana
        this.add(panel);
    }
}

