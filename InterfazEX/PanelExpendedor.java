package InterfazEX;

import javax.swing.*;
import java.awt.*;
import MaquinaEX.Exprendedor.Expendedor;
import MaquinaEX.Productos.Precio_Serie;

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
        botonConsumir.setBounds(90, 500, 240, 75);
        botonConsumir.setEnabled(false); // Inicialmente deshabilitado
        botonConsumir.addActionListener(e -> consumirProducto());

        stockCocaCola = new JLabel("Stock: " + expendedor.getStock(Precio_Serie.COCACOLA.getNumSerie()));
        stockSprite = new JLabel("Stock: " + expendedor.getStock(Precio_Serie.SPRITE.getNumSerie()));
        stockFanta = new JLabel("Stock: " + expendedor.getStock(Precio_Serie.FANTA.getNumSerie()));
        stockSuper8 = new JLabel("Stock: " + expendedor.getStock(Precio_Serie.SUPER8.getNumSerie()));
        stockSnickers = new JLabel("Stock: " + expendedor.getStock(Precio_Serie.SNICKERS.getNumSerie()));


        stockCocaCola.setBounds(0, 102, 100, 20); // Cambiar valores según la posición deseada
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
        // Añadir el layeredPane al panel principal
        this.add(layeredPane, BorderLayout.CENTER);

        // Asignar ActionListeners a los botones de productos
        botones.getBotonCocaCola().addActionListener(e -> seleccionarProducto(Precio_Serie.COCACOLA.getNumSerie()));
        botones.getBotonSprite().addActionListener(e -> seleccionarProducto(Precio_Serie.SPRITE.getNumSerie()));
        botones.getBotonFanta().addActionListener(e -> seleccionarProducto(Precio_Serie.FANTA.getNumSerie()));
        botones.getBotonSuper8().addActionListener(e -> seleccionarProducto(Precio_Serie.SUPER8.getNumSerie()));
        botones.getBotonSnickers().addActionListener(e -> seleccionarProducto(Precio_Serie.SNICKERS.getNumSerie()));
    }
    public void setPanelComprador(PanelComprador panelComprador) {
        this.panelComprador = panelComprador;
    }
    // Método para seleccionar un producto
    private void seleccionarProducto(int numSerie) {
        this.numSerieProductoSeleccionado = numSerie;
        JOptionPane.showMessageDialog(this, "Producto seleccionado: " + Precio_Serie.values()[numSerie].name());
        //actualizarImagenBotonConsumir(numSerie);  // Llamada al método para actualizar la imagen
        //botonConsumir.setEnabled(true); // Habilitar el botón consumir una vez que se ha seleccionado un producto
    }


    // Método para actualizar el stock después de una compra
    public void actualizarStock() {
        stockCocaCola.setText("Stock: " + expendedor.getStock(Precio_Serie.COCACOLA.getNumSerie()));
        stockSprite.setText("Stock: " + expendedor.getStock(Precio_Serie.SPRITE.getNumSerie()));
        stockFanta.setText("Stock: " + expendedor.getStock(Precio_Serie.FANTA.getNumSerie()));
        stockSuper8.setText("Stock: " + expendedor.getStock(Precio_Serie.SUPER8.getNumSerie()));
        stockSnickers.setText("Stock: " + expendedor.getStock(Precio_Serie.SNICKERS.getNumSerie()));
    }

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

    // Método para reiniciar la selección de producto
    public void reiniciarSeleccion() {
        numSerieProductoSeleccionado = -1;
        botonConsumir.setEnabled(false); // Deshabilitar el botón
    }
    public int getNumSerieProductoSeleccionado() {
        return numSerieProductoSeleccionado;
    }
    // Método para obtener el expendedor
    public Expendedor getExpendedor() {
        return expendedor;
    }

    public void mostrarBotonConsumir() {
        botonConsumir.setEnabled(true);
    }

    public void actualizarImagenBotonConsumir(int numSerieProducto) {
        String nombreImagen = "";
        switch (numSerieProducto) {
            case 0: nombreImagen = "/Imagenes/sprite2.png"; break;
            case 1: nombreImagen = "/Imagenes/coca_cola2.png"; break;
            case 2: nombreImagen = "/Imagenes/fanta2.png"; break;
            case 3: nombreImagen = "/Imagenes/super82.png"; break;
            case 4: nombreImagen = "/Imagenes/snickers2.png"; break;
        }
        ImageIcon icono = new ImageIcon(getClass().getResource(nombreImagen));
        botonConsumir.setIcon(new ImageIcon(icono.getImage().getScaledInstance(170, 75, Image.SCALE_SMOOTH)));
    }

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

    private void habilitarBotones() {
        botones.getBotonCocaCola().setEnabled(true);
        botones.getBotonSprite().setEnabled(true);
        botones.getBotonFanta().setEnabled(true);
        botones.getBotonSuper8().setEnabled(true);
        botones.getBotonSnickers().setEnabled(true);

    }
}


