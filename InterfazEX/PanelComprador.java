package InterfazEX;
import javax.swing.*;
import java.awt.*;
import MaquinaEX.Exprendedor.Expendedor;
import MaquinaEX.Productos.Precio_Serie;
import MaquinaEX.Excepciones.PagoIncorrectoException;
import MaquinaEX.Excepciones.NoHayProductoException;
import MaquinaEX.Excepciones.PagoInsuficienteException;
import MaquinaEX.Productos.Producto;
/**
 * PanelComprador es un panel que permite al comprador interactuar con un expendedor
 * de productos, agregar monedas, realizar compras y manejar las excepciones relacionadas con el pago.
 *
 * <p>La interfaz gráfica incluye botones para agregar monedas (100, 500, 1000), un botón para realizar la compra,
 * y una etiqueta que muestra el total de monedas disponibles para la compra.
 *
 * @author Benjamin
 * @author Joaquin
 */
public class PanelComprador extends JPanel {
    private int totalMonedas;
    private JLabel totalLabel;
    private Expendedor expendedor;
    private Botones botones;
    private PanelExpendedor panelExpendedor;
    /**
     * Constructor de la clase PanelComprador.
     * Inicializa los componentes de la interfaz y establece las conexiones con el expendedor
     * y el panel expendedor.
     *
     * @param expendedor El expendedor que gestiona las compras de productos
     * @param panelExpendedor El panel del expendedor que muestra los productos
     */
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
    /**
     * Establece el panel expendedor al que se debe hacer referencia en este panel.
     *
     * @param panelExpendedor El panel expendedor que se debe asociar
     */
    public void setPanelExpendedor(PanelExpendedor panelExpendedor) {
        this.panelExpendedor = panelExpendedor;
    }
    /**
     * Agrega una moneda al total de monedas insertadas.
     *
     * @param valor El valor de la moneda a agregar
     */
    public void agregarMoneda(int valor) {
        totalMonedas += valor;
        actualizarTotal();
    }
    /**
     * Actualiza la etiqueta que muestra el total de monedas insertadas.
     */
    private void actualizarTotal() {
        totalLabel.setText("Total de Monedas: " + totalMonedas);
    }
    /**
     * Realiza la compra del producto seleccionado si el pago es correcto.
     * Muestra mensajes de error en caso de fallos como pago insuficiente o producto agotado.
     */
    private void realizarCompra() {
        int numSerieProductoSeleccionado = panelExpendedor.getNumSerieProductoSeleccionado();

        String mensaje = "Error en la compra: ";


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
            reiniciar2();
            panelExpendedor.actualizarImagenBotonConsumir(numSerieProductoSeleccionado);
            panelExpendedor.deshabilitarBotonesProductos();
            deshabilitarBotonesProductos2();
            // Después de una compra exitosa, habilitar el botón de consumir
            panelExpendedor.mostrarBotonConsumir();

            JOptionPane.showMessageDialog(this, "Compra realizada!\n" + mensajeConsumo + "\nVuelto: " + vuelto);

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
    /**
     * Reinicia el total de monedas a cero y actualiza la etiqueta.
     */
    public void reiniciar() {
        totalMonedas = 0; // Reiniciar total de monedas
        actualizarTotal(); // Actualizar la etiqueta del total
        panelExpendedor.reiniciarSeleccion();
    }
    public void reiniciar2(){
        totalMonedas = 0;
        actualizarTotal();
    }
    /**
     * Actualiza el stock de productos en el panel expendedor después de una compra exitosa.
     */
    private void actualizarStockPanelExpendedor() {
        panelExpendedor.actualizarStock();
    }

    public void deshabilitarBotonesProductos2() {
        botones.getBotonMoneda100().setEnabled(false);
        botones.getBotonMoneda500().setEnabled(false);
        botones.getBotonMoneda1000().setEnabled(false);
        botones.getBotonComprar().setEnabled(false);

    }
    public void habilitarBotones2(){
        botones.getBotonMoneda100().setEnabled(true);
        botones.getBotonMoneda500().setEnabled(true);
        botones.getBotonMoneda1000().setEnabled(true);
        botones.getBotonComprar().setEnabled(true);
    }
}





