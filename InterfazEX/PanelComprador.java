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

        panelBotones.add(boton100);
        panelBotones.add(boton500);
        panelBotones.add(boton1000);
        panelBotones.add(botonComprar);

        add(panelBotones);
        add(totalLabel);

        // ActionListener para los botones de moneda
        boton100.addActionListener(e -> agregarMoneda(100));
        boton500.addActionListener(e -> agregarMoneda(500));
        boton1000.addActionListener(e -> agregarMoneda(1000));

        // ActionListener para el botón de compra
        botonComprar.addActionListener(e -> realizarCompra());
    }

    public void agregarMoneda(int valor) {
        totalMonedas += valor;
        actualizarTotal();
    }

    private void actualizarTotal() {
        totalLabel.setText("Total de Monedas: " + totalMonedas);
    }

    private void realizarCompra() {
        int numSerieProductoSeleccionado = panelExpendedor.getNumSerieProductoSeleccionado();
        String mensaje = "Error en la compra: ";

        // Verificar si se ha seleccionado un producto
        if (numSerieProductoSeleccionado == -1) {
            mensaje += "No se ha seleccionado ningún producto.\n";
            mensaje += "Dinero devuelto: " + totalMonedas;
            JOptionPane.showMessageDialog(this, mensaje);
            reiniciar(); // Reiniciar solo las monedas
            return;
        }

        try {
            Producto productoComprado = expendedor.comprarProducto(totalMonedas, numSerieProductoSeleccionado);
            String mensajeConsumo = productoComprado.consumir();
            int vuelto = totalMonedas - productoComprado.getPrecio().getValor();

            JOptionPane.showMessageDialog(this, "Compra realizada!\n" + mensajeConsumo + "\nVuelto: " + vuelto);
            reiniciar();
            actualizarStockPanelExpendedor(); // Actualizar el stock después de una compra exitosa

        } catch (PagoIncorrectoException ex) {
            mensaje += "Monto de pago inválido.\n";
            mensaje += "Dinero devuelto: " + totalMonedas;
            JOptionPane.showMessageDialog(this, mensaje);
            reiniciar();
        } catch (NoHayProductoException ex) {
            mensaje += "Producto agotado.\n";
            mensaje += "Dinero devuelto: " + totalMonedas;
            JOptionPane.showMessageDialog(this, mensaje);
            reiniciar();
        } catch (PagoInsuficienteException ex) {
            mensaje += "Pago insuficiente para este producto.\n";
            mensaje += "Dinero devuelto: " + totalMonedas;
            JOptionPane.showMessageDialog(this, mensaje);
            reiniciar();
        }
    }

    public void reiniciar() {
        totalMonedas = 0; // Reiniciar total de monedas
        actualizarTotal(); // Actualizar la etiqueta del total
        panelExpendedor.reiniciarSeleccion();
    }

    // Método para actualizar el stock en el panel expendedor
    private void actualizarStockPanelExpendedor() {
        panelExpendedor.actualizarStock();
    }
}





