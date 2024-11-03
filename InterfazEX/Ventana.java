package InterfazEX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import MaquinaEX.Exprendedor.Expendedor;
import MaquinaEX.Productos.Producto;
import MaquinaEX.Productos.Precio_Serie;
import MaquinaEX.Excepciones.PagoIncorrectoException;
import MaquinaEX.Excepciones.NoHayProductoException;
import MaquinaEX.Excepciones.PagoInsuficienteException;

class Ventana extends JFrame {
    private int totalMonedas; // Variable para llevar el total de monedas
    private JLabel totalLabel; // Etiqueta para mostrar el total de monedas
    private Expendedor expendedor; // Objeto del expendedor
    private int numSerieProductoSeleccionado = -1; // Indica "sin producto seleccionado"

    public Ventana() {
        super("Máquina Expendedora - Tarea 3");
        this.setSize(915, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creación del Panel Principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Configuración del panel izquierdo
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

        // Agregar ActionListeners a los botones de monedas
        botonMoneda100.addActionListener(e -> agregarMoneda(100));
        botonMoneda500.addActionListener(e -> agregarMoneda(500));
        botonMoneda1000.addActionListener(e -> agregarMoneda(1000));

        // Crear el expendedor
        expendedor = new Expendedor(5); // Cantidad inicial de cada producto

        // Asignar ActionListeners a los botones de productos
        botones.getBotonCocaCola().addActionListener(e -> numSerieProductoSeleccionado = Precio_Serie.COCACOLA.getNumSerie());
        botones.getBotonSprite().addActionListener(e -> numSerieProductoSeleccionado = Precio_Serie.SPRITE.getNumSerie());
        botones.getBotonFanta().addActionListener(e -> numSerieProductoSeleccionado = Precio_Serie.FANTA.getNumSerie());
        botones.getBotonSuper8().addActionListener(e -> numSerieProductoSeleccionado = Precio_Serie.SUPER8.getNumSerie());
        botones.getBotonSnickers().addActionListener(e -> numSerieProductoSeleccionado = Precio_Serie.SNICKERS.getNumSerie());

        // Acción para el botón de compra
        botonComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarCompra(); // Llamar a realizarCompra al presionar el botón
            }
        });

        panelBotonesMonedas.add(botonMoneda100); // Fila 1, Columna 1
        panelBotonesMonedas.add(botonMoneda500); // Fila 1, Columna 2
        panelBotonesMonedas.add(botonMoneda1000); // Fila 2, Columna 1
        panelBotonesMonedas.add(botonComprar); // Fila 2, Columna 2

        panelDerecho.add(panelBotonesMonedas); // Panel de botones de monedas

        JPanel panelTotal = new JPanel();
        panelTotal.setPreferredSize(new Dimension(400, 100)); // Tamaño del panel total
        panelTotal.setBackground(Color.GRAY); // Color de fondo del panel total
        totalLabel = new JLabel("Total de Monedas: 0");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Cambiar fuente del texto
        panelTotal.add(totalLabel);

        panelDerecho.add(panelTotal); // Agregar el panel total

        panel.add(panelIzquierdo, BorderLayout.WEST);
        panel.add(panelDerecho, BorderLayout.EAST);

        this.add(panel);
    }

    // Método para agregar monedas
    private void agregarMoneda(int valor) {
        totalMonedas += valor; // Incrementar el total de monedas
        actualizarTotal(); // Actualizar la etiqueta
    }

    // Método para actualizar la etiqueta del total
    private void actualizarTotal() {
        totalLabel.setText("Total de Monedas: " + totalMonedas);
    }

    // Método para realizar la compra
    private void realizarCompra() {
        if (numSerieProductoSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún producto.");
            return;
        }

        try {
            Producto productoComprado = expendedor.comprarProducto(totalMonedas, numSerieProductoSeleccionado);

            // Mostrar el vuelto y el mensaje de consumo en la interfaz
            String mensajeConsumo = productoComprado.consumir();
            int vuelto = totalMonedas - productoComprado.getPrecio().getValor();

            JOptionPane.showMessageDialog(this, "Compra realizada!\n" + mensajeConsumo + "\nVuelto: " + vuelto);

            // Reiniciar selección y monedas para la próxima compra
            numSerieProductoSeleccionado = -1;
            totalMonedas = 0;
            actualizarTotal();

        } catch (PagoIncorrectoException ex) {
            JOptionPane.showMessageDialog(this, "Monto de pago inválido.");
        } catch (NoHayProductoException ex) {
            JOptionPane.showMessageDialog(this, "Producto agotado.");
        } catch (PagoInsuficienteException ex) {
            JOptionPane.showMessageDialog(this, "Pago insuficiente para este producto.");
        }
    }
}




