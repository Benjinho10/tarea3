package InterfazEX;
import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import MaquinaEX.Exprendedor.Expendedor;
import MaquinaEX.Productos.Precio_Serie;
/**
 * La clase PanelExpendedor representa la interfaz gráfica del expendedor de productos,
 * donde el usuario puede seleccionar diferentes productos, ver el stock disponible y consumir productos.
 *
 * @author Benjamin
 * @author Joaquin
 *
 */
public class PanelExpendedor extends JPanel {
    private Expendedor expendedor; // Objeto del expendedor
    private int numSerieProductoSeleccionado = -1; // Indica "sin producto seleccionado"
    private Botones botones; // Botones para la selección de productos
    private JButton botonConsumir;
    private JLabel stockCocaCola;
    private JLabel stockSprite;
    private JLabel stockFanta;
    private JLabel stockSuper8;
    private JLabel stockSnickers;
    private PanelComprador panelComprador;

    /**
     * Constructor de la clase PanelExpendedor.
     * Inicializa los componentes gráficos, los botones para seleccionar productos, las etiquetas de stock
     * y configura las acciones de los botones.
     *
     * @param expendedor El expendedor que contiene los productos y gestiona el stock.
     * @param panelComprador El panel del comprador que interactúa con el expendedor.
     */

    public PanelExpendedor(Expendedor expendedor, PanelComprador panelComprador) {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(500, 700));
        this.setBackground(Color.LIGHT_GRAY);
        this.panelComprador = panelComprador;
        this.add(new JLabel("Expendedor"), BorderLayout.NORTH);
        this.expendedor = expendedor; // Recibir el expendedor como parámetro

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 500));

        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/Imagenes/expendedortarea3.png"));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(400, 500, Image.SCALE_SMOOTH);
        JLabel etiquetaImagen = new JLabel(new ImageIcon(imagenEscalada));
        etiquetaImagen.setBounds(50, 80, 400, 500);

        layeredPane.add(etiquetaImagen, Integer.valueOf(0));

        // Crear botones
        botones = new Botones();
        botones.getBotonCocaCola().setBounds(81, 102, 263, 70);
        botones.getBotonSprite().setBounds(81, 177, 263, 72);
        botones.getBotonFanta().setBounds(81, 256, 263, 76);
        botones.getBotonSuper8().setBounds(81, 338, 263, 79);
        botones.getBotonSnickers().setBounds(81, 423, 263, 70);

        botonConsumir = new JButton("");
        botonConsumir.setBounds(100, 520, 227, 50);
        botonConsumir.setEnabled(false);
        botonConsumir.addActionListener(e -> consumirProducto());
        botones.getBotonReinciarStock().setBounds(0,0,500,30);

        stockCocaCola = new JLabel("Stock: " + expendedor.getStock(Precio_Serie.COCACOLA.getNumSerie()));
        stockSprite = new JLabel("Stock: " + expendedor.getStock(Precio_Serie.SPRITE.getNumSerie()));
        stockFanta = new JLabel("Stock: " + expendedor.getStock(Precio_Serie.FANTA.getNumSerie()));
        stockSuper8 = new JLabel("Stock: " + expendedor.getStock(Precio_Serie.SUPER8.getNumSerie()));
        stockSnickers = new JLabel("Stock: " + expendedor.getStock(Precio_Serie.SNICKERS.getNumSerie()));

        // Cambiar valores según la posición deseada
        stockCocaCola.setBounds(0, 102, 100, 20);
        stockSprite.setBounds(0, 177, 100, 20);
        stockFanta.setBounds(0, 256, 100, 20);
        stockSuper8.setBounds(0, 338, 100, 20);
        stockSnickers.setBounds(0, 423, 100, 20);

        // Cambiar el color de las letras
        stockCocaCola.setForeground(Color.BLACK);
        stockSprite.setForeground(Color.BLACK);
        stockFanta.setForeground(Color.BLACK);
        stockSuper8.setForeground(Color.BLACK);
        stockSnickers.setForeground(Color.BLACK);

        // Añadir botones y etiquetas de stock al layeredPane
        layeredPane.add(botones.getBotonCocaCola(), Integer.valueOf(1));
        layeredPane.add(stockCocaCola, Integer.valueOf(1));
        layeredPane.add(botones.getBotonSprite(), Integer.valueOf(1));
        layeredPane.add(stockSprite, Integer.valueOf(1));
        layeredPane.add(botones.getBotonFanta(), Integer.valueOf(1));
        layeredPane.add(stockFanta, Integer.valueOf(1));
        layeredPane.add(botones.getBotonSuper8(), Integer.valueOf(1));
        layeredPane.add(stockSuper8, Integer.valueOf(1));
        layeredPane.add(botones.getBotonSnickers(), Integer.valueOf(1));
        layeredPane.add(stockSnickers, Integer.valueOf(1));
        layeredPane.add(botonConsumir, Integer.valueOf(1));
        layeredPane.add(botones.getBotonReinciarStock(), Integer.valueOf(1));
        this.add(layeredPane, BorderLayout.CENTER);

        // Asignar ActionListeners a los botones de productos
        botones.getBotonCocaCola().addActionListener(e -> seleccionarProducto(Precio_Serie.COCACOLA.getNumSerie()));
        botones.getBotonSprite().addActionListener(e -> seleccionarProducto(Precio_Serie.SPRITE.getNumSerie()));
        botones.getBotonFanta().addActionListener(e -> seleccionarProducto(Precio_Serie.FANTA.getNumSerie()));
        botones.getBotonSuper8().addActionListener(e -> seleccionarProducto(Precio_Serie.SUPER8.getNumSerie()));
        botones.getBotonSnickers().addActionListener(e -> seleccionarProducto(Precio_Serie.SNICKERS.getNumSerie()));
        botones.getBotonReinciarStock().addActionListener(e -> {
            expendedor.reiniciarStock();
            actualizarStock();
        });
    }

    /**
     * Establece el panel del comprador que interactúa con el expendedor.
     *
     * @param panelComprador El panel del comprador.
     */
    public void setPanelComprador(PanelComprador panelComprador) {
        this.panelComprador = panelComprador;
    }

    /**
     * Permite seleccionar un producto basado en su número de serie.
     * Al seleccionar un producto, se muestra un mensaje indicando cuál ha sido seleccionado.
     *
     * @param numSerie El número de serie del producto seleccionado.
     */
    private void seleccionarProducto(int numSerie) {
        this.numSerieProductoSeleccionado = numSerie;
        JOptionPane.showMessageDialog(this, "Producto seleccionado: " + Precio_Serie.values()[numSerie].name());
    }

    /**
     * Actualiza la información del stock de los productos en la interfaz a tiempo real
     * de la compra del producto.
     */
    public void actualizarStock() {
        stockCocaCola.setText("Stock: " + expendedor.getStock(Precio_Serie.COCACOLA.getNumSerie()));
        stockSprite.setText("Stock: " + expendedor.getStock(Precio_Serie.SPRITE.getNumSerie()));
        stockFanta.setText("Stock: " + expendedor.getStock(Precio_Serie.FANTA.getNumSerie()));
        stockSuper8.setText("Stock: " + expendedor.getStock(Precio_Serie.SUPER8.getNumSerie()));
        stockSnickers.setText("Stock: " + expendedor.getStock(Precio_Serie.SNICKERS.getNumSerie()));
    }

    /**
     * Simula el consumo del producto seleccionado. Se desactiva el botón de consumir
     * y se reinicia la selección de producto.
     */
    private void consumirProducto() {
        if (numSerieProductoSeleccionado != -1) {
            JOptionPane.showMessageDialog(this, "Producto consumido");

            botonConsumir.setEnabled(false); // Desactivar el botón tras consumir
            reiniciarSeleccion(); // Desmarcar el producto seleccionado
            habilitarBotones();// Habilitar botones para selección nuevamente
            panelComprador.habilitarBotones2();
            botonConsumir.setIcon(null);
        }
    }
    /**
     * Reinicia la selección del producto.
     */
    public void reiniciarSeleccion() {
        numSerieProductoSeleccionado = -1;
        botonConsumir.setEnabled(false);
    }
    /**
     * Getter que obtiene el número de serie del producto seleccionado.
     *
     * @return El número de serie del producto.
     */
    public int getNumSerieProductoSeleccionado() {
        return numSerieProductoSeleccionado;
    }
    /**
     * Getter que obtiene la instancia del expendedor
     *
     * @return El objeto expendedor
     */
    public Expendedor getExpendedor() {
        return expendedor;
    }
    /**
     * Habilita el boton consumir.
     */
    public void mostrarBotonConsumir() {
        botonConsumir.setEnabled(true);
    }
    /**
     * Actualiza la imagen del botón de consumir según el producto seleccionado.
     *
     * @param numSerieProducto El número de serie del producto seleccionado.
     */
    public void actualizarImagenBotonConsumir(int numSerieProducto) {
        String nombreImagen = "";
        int ancho = 130;
        int alto = 55;
        ImageIcon icono = null;

        switch (numSerieProducto) {
            case 0:
                nombreImagen = "/Imagenes/sprite2.png";
                ancho = 100;
                alto = 90;
                icono = new ImageIcon(getClass().getResource(nombreImagen));
                break;
            case 1:
                nombreImagen = "/Imagenes/coca_cola2.png";
                ancho = 100;
                alto = 90;
                icono = new ImageIcon(getClass().getResource(nombreImagen));
                break;
            case 2:
                nombreImagen = "/Imagenes/fanta2.png";
                ancho = 100;
                alto = 100;
                icono = new ImageIcon(getClass().getResource(nombreImagen));
                break;
            case 3:
                nombreImagen = "/Imagenes/super82.png";
                ancho = 140;
                alto = 60;
                icono = new ImageIcon(getClass().getResource(nombreImagen));
                break;
            case 4:
                nombreImagen = "/Imagenes/snickers2.png";
                ancho = 110;
                alto = 45;
                icono = new ImageIcon(getClass().getResource(nombreImagen));
                break;
        }
        botonConsumir.setIcon(new ImageIcon(icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH)));
    }
    /**
     * Deshabilita todos los botones relacionados con productos y monedas.
     */
    public void deshabilitarBotonesProductos() {
        botones.getBotonCocaCola().setEnabled(false);
        botones.getBotonSprite().setEnabled(false);
        botones.getBotonFanta().setEnabled(false);
        botones.getBotonSuper8().setEnabled(false);
        botones.getBotonSnickers().setEnabled(false);
        botones.getBotonMoneda100().setEnabled(false);
        botones.getBotonMoneda500().setEnabled(false);
        botones.getBotonMoneda1000().setEnabled(false);
        botones.getBotonComprar().setEnabled(false);
    }
    /**
     * Habilita los botones de selección de productos.
     */
    private void habilitarBotones() {
        botones.getBotonCocaCola().setEnabled(true);
        botones.getBotonSprite().setEnabled(true);
        botones.getBotonFanta().setEnabled(true);
        botones.getBotonSuper8().setEnabled(true);
        botones.getBotonSnickers().setEnabled(true);
    }
}


