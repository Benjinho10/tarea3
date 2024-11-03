package InterfazEX;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Botones extends JPanel {

    private JButton botonCocaCola;
    private JButton botonSprite;
    private JButton botonFanta;
    private JButton botonSuper8;
    private JButton botonSnickers;

    private JButton botonMoneda100;
    private JButton botonMoneda500;
    private JButton botonMoneda1000;
    private JButton botonComprar;

    public Botones() {
        this.setLayout(new GridLayout(2, 2, 10, 10));
        this.setBackground(Color.WHITE);

        botonCocaCola = crearBotonConImagen("/Imagenes/coca_cola.png", "Coca-Cola", 260, 95);
        botonSprite = crearBotonConImagen("/Imagenes/sprite.png", "Sprite", 200, 90);
        botonFanta = crearBotonConImagen("/Imagenes/fanta.png", "Fanta", 260, 90);
        botonSuper8 = crearBotonConImagen("/Imagenes/super8.png", "Super8", 260, 95);
        botonSnickers = crearBotonConImagen("/Imagenes/snickers.png", "Snickers", 260, 95);

        this.add(botonCocaCola);
        this.add(botonSprite);
        this.add(botonFanta);
        this.add(botonSuper8);
        this.add(botonSnickers);

        botonMoneda100 = crearBotonConImagen("/Imagenes/moneda100.png", "100", 50, 50);
        botonMoneda500 = crearBotonConImagen("/Imagenes/moneda500.png", "500", 50, 50);
        botonMoneda1000 = crearBotonConImagen("/Imagenes/moneda1000.png", "1000", 50, 50);
        botonComprar = crearBotonConImagen("/Imagenes/comprar.png", "Comprar", 50, 50);

        agregarListeners();
    }

    private void agregarListeners() {
        new Mause(botonCocaCola);
        new Mause(botonSprite);
        new Mause(botonFanta);
        new Mause(botonSuper8);
        new Mause(botonSnickers);
        new Mause(botonMoneda100);
        new Mause(botonMoneda500);
        new Mause(botonMoneda1000);
        new Mause(botonComprar);
    }

    private JButton crearBotonConImagen(String rutaImagen, String texto, int ancho, int alto) {
        ImageIcon icono = null;
        URL imagenURL = getClass().getResource(rutaImagen);
        if (imagenURL != null) {
            icono = new ImageIcon(imagenURL);
            Image img = icono.getImage();
            Image imgEscalada = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
            icono = new ImageIcon(imgEscalada);
        } else {
            System.err.println("No se pudo encontrar la imagen: " + rutaImagen);
            icono = new ImageIcon();
        }

        JButton boton = new JButton(texto, icono);
        boton.setHorizontalTextPosition(SwingConstants.CENTER);
        boton.setVerticalTextPosition(SwingConstants.BOTTOM);

        return boton;
    }

    // Métodos para obtener los botones
    public JButton getBotonCocaCola() {
        return botonCocaCola;
    }

    public JButton getBotonSprite() {
        return botonSprite;
    }

    public JButton getBotonFanta() {
        return botonFanta;
    }

    public JButton getBotonSuper8() {
        return botonSuper8;
    }

    public JButton getBotonSnickers() {
        return botonSnickers;
    }

    public JButton getBotonMoneda100() {
        return botonMoneda100;
    }

    public JButton getBotonMoneda500() {
        return botonMoneda500;
    }

    public JButton getBotonMoneda1000() {
        return botonMoneda1000;
    }

    public JButton getBotonComprar() {
        return botonComprar;
    }
}
