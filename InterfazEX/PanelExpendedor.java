package InterfazEX;

import javax.swing.*;
import java.awt.*;
import MaquinaEX.Exprendedor.Expendedor;
import MaquinaEX.Productos.Precio_Serie;

public class PanelExpendedor extends JPanel {
    private Expendedor expendedor; // Objeto del expendedor
    private int numSerieProductoSeleccionado = -1; // Indica "sin producto seleccionado"
    private Botones botones; // Botones para la selección de productos

    public PanelExpendedor(Expendedor expendedor) {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(500, 700));
        this.setBackground(Color.LIGHT_GRAY);

        // Añadir título
        this.add(new JLabel("Expendedor"), BorderLayout.NORTH);
        this.expendedor = expendedor; // Recibir el expendedor como parámetro

        // Crear un JLayeredPane para los botones y la imagen
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 500));

        // Configuración de la imagen del expendedor
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

        // Añadir botones al layeredPane
        layeredPane.add(botones.getBotonCocaCola(), Integer.valueOf(1));
        layeredPane.add(botones.getBotonSprite(), Integer.valueOf(1));
        layeredPane.add(botones.getBotonFanta(), Integer.valueOf(1));
        layeredPane.add(botones.getBotonSuper8(), Integer.valueOf(1));
        layeredPane.add(botones.getBotonSnickers(), Integer.valueOf(1));

        // Añadir el layeredPane al panel principal
        this.add(layeredPane, BorderLayout.CENTER);

        // Asignar ActionListeners a los botones de productos
        botones.getBotonCocaCola().addActionListener(e -> seleccionarProducto(Precio_Serie.COCACOLA.getNumSerie()));
        botones.getBotonSprite().addActionListener(e -> seleccionarProducto(Precio_Serie.SPRITE.getNumSerie()));
        botones.getBotonFanta().addActionListener(e -> seleccionarProducto(Precio_Serie.FANTA.getNumSerie()));
        botones.getBotonSuper8().addActionListener(e -> seleccionarProducto(Precio_Serie.SUPER8.getNumSerie()));
        botones.getBotonSnickers().addActionListener(e -> seleccionarProducto(Precio_Serie.SNICKERS.getNumSerie()));
    }

    // Método para seleccionar un producto
    private void seleccionarProducto(int numSerie) {
        this.numSerieProductoSeleccionado = numSerie;
        // Aquí puedes agregar lógica adicional si necesitas dar feedback al usuario
        JOptionPane.showMessageDialog(this, "Producto seleccionado: " + Precio_Serie.values()[numSerie].name());
    }

    // Método para obtener el número de serie del producto seleccionado
    public int getNumSerieProductoSeleccionado() {
        return numSerieProductoSeleccionado;
    }

    // Método para reiniciar la selección de producto
    public void reiniciarSeleccion() {
        numSerieProductoSeleccionado = -1;
    }

    // Método para obtener el expendedor
    public Expendedor getExpendedor() {
        return expendedor;
    }
}