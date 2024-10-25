package MaquinaEX.Comprador;
import java.util.List;
import MaquinaEX.Monedas.Moneda;
import MaquinaEX.Productos.Producto;
import MaquinaEX.Excepciones.PagoIncorrectoException;
import MaquinaEX.Excepciones.NoHayProductoException;
import MaquinaEX.Excepciones.PagoInsuficienteException;
import MaquinaEX.Exprendedor.Expendedor;
public class Comprador {private String productoComprado;
    private int vuelto;

    /**
     * Constructor que crea a un comprador y realiza una compra en el expendedor.
     *
     * @param monedas Lista de monedas que el comprador usa para pagar.
     * @param cualProducto Indica el producto que desea comprar.
     * @param exp El expendedor del que se va a comprar el producto.
     * @throws NoHayProductoException Si no hay producto disponible.
     * @throws PagoInsuficienteException Si el pago es menor al precio del producto.
     * @throws PagoIncorrectoException Si la moneda es nula o está vacía.
     */
    public Comprador(List<Moneda> monedas, int cualProducto, Expendedor exp) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        this.productoComprado = null;
        this.vuelto = 0;

        // Valida que haya monedas.
        if (monedas == null || monedas.isEmpty()) {
            throw new PagoIncorrectoException();
        }

        // Calcular el valor total de las monedas
        int totalPagado = 0;
        for (Moneda moneda : monedas) {
            totalPagado += moneda.getValor();
        }
        // Comprar producto en el expendedor
        Producto producto = exp.comprarProducto(totalPagado, cualProducto);
        if (producto != null) {
            this.productoComprado = producto.consumir();
        }
        //Lanza el vuelto
        Moneda moneda;
        while ((moneda = exp.getVuelto()) != null) {
            this.vuelto += moneda.getValor();
        }
    }
    /**
     * Devuelve el vuelto que recibió el comprador después de la compra.
     *
     * @return El vuelto.
     */
    public int cuantoVuelto() {
        return vuelto;
    }

    /**
     * Devuelve el producto que consumió el comprador después de la compra.
     *
     * @return El producto consumido.
     */
    public String queConsumiste() {
        return productoComprado;
    }
}
