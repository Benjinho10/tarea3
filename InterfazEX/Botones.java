package InterfazEX;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
/**
 * Clase que representa un panel de botones para una interfaz gráfica.
 * Este panel incluye botones para seleccionar los diferentes productos,
 * para insertar monedas, para consumir un producto y para restablecer el stock de productos.
 * Los botones tienen imágenes asociadas y se agregan a un contenedor con un diseño de cuadrícula.
 *
 * @author Joaquin
 * @author Benjamin
 *
 */
public class Botones extends JPanel {

    private JButton botonCocaCola;
    private JButton botonSprite;
    private JButton botonFanta;
    private JButton botonSuper8;
    private JButton botonSnickers;
    private JButton botonConsumir;
    private JButton botonMoneda100;
    private JButton botonMoneda500;
    private JButton botonMoneda1000;
    private JButton botonComprar;
    private JButton botonReinciarStock;
    /**
     * Constructor que inicializa el panel de botones.
     * Configura el diseño, los botones con imágenes y sus respectivos tamaños.
     * Agrega los botones al panel y asigna los eventos correspondientes.
     */
    public Botones() {
        this.setLayout(new GridLayout(2, 2, 10, 10));
        this.setBackground(Color.WHITE);

        // Creación de botones con imágenes y texto
        botonCocaCola = crearBotonConImagen("/Imagenes/coca_cola.png", "Coca-Cola", 290, 90);
        botonSprite = crearBotonConImagen("/Imagenes/sprite.png", "Sprite", 200, 80);
        botonFanta = crearBotonConImagen("/Imagenes/fanta.png", "Fanta", 260, 93);
        botonSuper8 = crearBotonConImagen("/Imagenes/super8.png", "Super8", 260, 95);
        botonSnickers = crearBotonConImagen("/Imagenes/snickers.png", "Snickers", 260, 90);

        botonConsumir = new JButton("Consumir");
        botonConsumir.setBounds(81, 523, 263, 70);
        botonConsumir.setEnabled(false);

        botonReinciarStock = new JButton("Restocking");

        // Agregar los botones al panel
        this.add(botonConsumir);
        this.add(botonReinciarStock);
        this.add(botonCocaCola);
        this.add(botonSprite);
        this.add(botonFanta);
        this.add(botonSuper8);
        this.add(botonSnickers);

        botonMoneda100 = crearBotonConImagen("/Imagenes/moneda100.png", "100", 100, 100);
        botonMoneda500 = crearBotonConImagen("/Imagenes/moneda500.png", "500", 170, 120);
        botonMoneda1000 = crearBotonConImagen("/Imagenes/moneda1000.png", "1000", 175, 70);
        botonComprar = crearBotonConImagen("/Imagenes/comprar.png", "Comprar", 150, 150);

        agregarListeners();
    }
    /**
     * Método que agrega los escuchadores de eventos de ratón a los botones.
     */
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
        new Mause(botonReinciarStock);

    }
    /**
     * Método privado que crea un botón con una imagen escalada y un texto.
     *
     * @param rutaImagen Ruta del archivo de imagen para el botón.
     * @param texto      Texto que se mostrará debajo de la imagen.
     * @param ancho      El ancho que debe tener la imagen.
     * @param alto       El alto que debe tener la imagen.
     * @return Un botón con la imagen escalada y el texto correspondiente.
     */
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

    public JButton getBotonReinciarStock() {
        return botonReinciarStock;
    }

    public JButton getBotonConsumir() {
        return botonConsumir;
    }
}
