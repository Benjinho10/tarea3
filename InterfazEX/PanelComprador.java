package InterfazEX;

import javax.swing.*;
import java.awt.*;
import MaquinaEX.Exprendedor.Expendedor;
import MaquinaEX.Productos.Precio_Serie;
import MaquinaEX.Excepciones.PagoIncorrectoException;
import MaquinaEX.Excepciones.NoHayProductoException;
import MaquinaEX.Excepciones.PagoInsuficienteException;
import MaquinaEX.Productos.Producto;

public class PanelComprador extends JPanel {
    private int totalMonedas; // Total de monedas
    private JLabel totalLabel; // Etiqueta para mostrar el total de monedas
    private Expendedor expendedor; // Objeto del expendedor
    private Botones botones; // Botones para la compra
    private PanelExpendedor panelExpendedor; // Referencia al PanelExpendedor

    public PanelComprador(Expendedor expendedor, PanelExpendedor panelExpendedor) {
        this.expendedor = expendedor; // Recibir el expendedor como parámetro
        this.panelExpendedor = panelExpendedor; // Referencia a PanelExpendedor

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Usar BoxLayout para organización vertical
        setBackground(Color.LIGHT_GRAY);

        totalLabel = new JLabel("Total de Monedas: 0");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 18));
        totalLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el total

        // Panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(2, 2, 5, 5)); // 2 filas, 2 columnas
        panelBotones.setBackground(Color.LIGHT_GRAY); // Asegurar que el fondo coincida

        botones = new Botones();
        JButton boton100 = botones.getBotonMoneda100();
        JButton boton500 = botones.getBotonMoneda500();
        JButton boton1000 = botones.getBotonMoneda1000();
        JButton botonComprar = botones.getBotonComprar();

        // Establecer tamaño preferido para los botones
        Dimension size = new Dimension(200, 50); // Ancho de 200 y alto de 50
        boton100.setPreferredSize(size);
        boton500.setPreferredSize(size);
        boton1000.setPreferredSize(size);
        botonComprar.setPreferredSize(size);

        // Agregar los botones al panel
        panelBotones.add(boton100);
        panelBotones.add(boton500);
        panelBotones.add(boton1000);
        panelBotones.add(botonComprar);

        // Agregar elementos al panel
        add(panelBotones);
        add(totalLabel);

        // ActionListener para los botones de moneda
        boton100.addActionListener(e -> agregarMoneda(100));
        boton500.addActionListener(e -> agregarMoneda(500));
        boton1000.addActionListener(e -> agregarMoneda(1000));

        // ActionListener para el botón de compra
        botonComprar.addActionListener(e -> realizarCompra());
    }

    // Método para agregar monedas
    public void agregarMoneda(int valor) {
        totalMonedas += valor; // Incrementar el total de monedas
        actualizarTotal(); // Actualizar la etiqueta
    }

    // Método para actualizar la etiqueta del total
    private void actualizarTotal() {
        totalLabel.setText("Total de Monedas: " + totalMonedas);
    }

    // Método para realizar la compra
    private void realizarCompra() {
        int numSerieProductoSeleccionado = panelExpendedor.getNumSerieProductoSeleccionado();
        String mensaje = "Error en la compra: ";

        // Verificar si se ha seleccionado un producto
        if (numSerieProductoSeleccionado == -1) {
            mensaje += "No se ha seleccionado ningún producto.";
            JOptionPane.showMessageDialog(this, mensaje);
            reiniciar(); // Reiniciar solo las monedas
            return;
        }

        try {
            // Intentar comprar el producto
            Producto productoComprado = expendedor.comprarProducto(totalMonedas, numSerieProductoSeleccionado);
            String mensajeConsumo = productoComprado.consumir();
            int vuelto = totalMonedas - productoComprado.getPrecio().getValor();

            // Mostrar mensaje de compra realizada
            JOptionPane.showMessageDialog(this, "Compra realizada!\n" + mensajeConsumo + "\nVuelto: " + vuelto);
            reiniciar(); // Reiniciar solo las monedas

        } catch (PagoIncorrectoException ex) {
            mensaje += "Monto de pago inválido.";
            JOptionPane.showMessageDialog(this, mensaje);
            reiniciar(); // Reiniciar solo las monedas
        } catch (NoHayProductoException ex) {
            mensaje += "Producto agotado.";
            JOptionPane.showMessageDialog(this, mensaje);
            reiniciar(); // Reiniciar solo las monedas
        } catch (PagoInsuficienteException ex) {
            mensaje += "Pago insuficiente para este producto.";
            JOptionPane.showMessageDialog(this, mensaje);
            reiniciar(); // Reiniciar solo las monedas
        }
    }

    // Método para reiniciar solo las monedas
    public void reiniciar() {
        totalMonedas = 0; // Reiniciar total de monedas
        actualizarTotal(); // Actualizar la etiqueta del total
        panelExpendedor.reiniciarSeleccion();
    }
}




