package InterfazEX;

import javax.swing.*;
import java.awt.*;

class Ventana extends JFrame {
    public Ventana() {
        super("Máquina Expendedora - Tarea 3");
        this.setSize(915, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BorderLayout());
        panelIzquierdo.add(new JLabel("Expendedor"), BorderLayout.NORTH);
        panelIzquierdo.setPreferredSize(new Dimension(500, 700));
        panelIzquierdo.setBackground(Color.LIGHT_GRAY);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 500));

        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/Imagenes/expendedortarea3.png"));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(400, 500, Image.SCALE_SMOOTH);
        JLabel etiquetaImagen = new JLabel(new ImageIcon(imagenEscalada));
        etiquetaImagen.setBounds(50, 80, 400, 500);

        layeredPane.add(etiquetaImagen, Integer.valueOf(0));

        Botones botones = new Botones();
        botones.getBotonCocaCola().setBounds(81, 102, 263, 70);
        botones.getBotonSprite().setBounds(81, 177, 263, 72);
        botones.getBotonFanta().setBounds(81, 256, 263, 76);
        botones.getBotonSuper8().setBounds(81, 338, 263, 79);
        botones.getBotonSnickers().setBounds(81, 423, 263, 70);

        layeredPane.add(botones.getBotonCocaCola(), Integer.valueOf(1));
        layeredPane.add(botones.getBotonSprite(), Integer.valueOf(1));
        layeredPane.add(botones.getBotonFanta(), Integer.valueOf(1));
        layeredPane.add(botones.getBotonSuper8(), Integer.valueOf(1));
        layeredPane.add(botones.getBotonSnickers(), Integer.valueOf(1));

        panelIzquierdo.add(layeredPane, BorderLayout.CENTER);

        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new GridLayout(3, 1)); // Dividir en 3 filas

        JPanel panelBotonesMonedas = new JPanel();
        panelBotonesMonedas.setLayout(new GridLayout(2, 2)); // 2 filas y 2 columnas
        panelBotonesMonedas.setPreferredSize(new Dimension(400, 200)); // Tamaño del panel de monedas

        // Botones de monedas
        JButton botonMoneda100 = botones.getBotonMoneda100();
        JButton botonMoneda500 = botones.getBotonMoneda500();
        JButton botonMoneda1000 = botones.getBotonMoneda1000();
        JButton botonComprar = botones.getBotonComprar();

        panelBotonesMonedas.add(botonMoneda100);
        panelBotonesMonedas.add(botonMoneda500);
        panelBotonesMonedas.add(botonMoneda1000);
        panelBotonesMonedas.add(botonComprar);

        panelDerecho.add(panelBotonesMonedas);

        JPanel panelTotal = new JPanel();
        panelTotal.setPreferredSize(new Dimension(400, 100));
        panelTotal.setBackground(Color.GRAY);
        JLabel totalLabel = new JLabel("Total de Monedas: 0");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panelTotal.add(totalLabel);


        panelDerecho.add(panelTotal);


        panel.add(panelIzquierdo, BorderLayout.WEST);
        panel.add(panelDerecho, BorderLayout.EAST);


        this.add(panel);
    }
}


