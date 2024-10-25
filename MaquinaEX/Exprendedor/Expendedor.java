package MaquinaEX.Exprendedor;
import MaquinaEX.Monedas.Moneda;
import MaquinaEX.Monedas.Moneda100;
import MaquinaEX.Productos.Producto;
import MaquinaEX.Deposito.Deposito;
import MaquinaEX.Productos.Precio_Serie;
import MaquinaEX.Productos.Bebidas.CocaCola;
import MaquinaEX.Productos.Bebidas.Sprite;
import MaquinaEX.Productos.Bebidas.Fanta;
import MaquinaEX.Productos.Dulces.Snickers;
import MaquinaEX.Productos.Dulces.Super8;
import MaquinaEX.Excepciones.PagoIncorrectoException;
import MaquinaEX.Excepciones.NoHayProductoException;
import MaquinaEX.Excepciones.PagoInsuficienteException;
import java.util.HashMap;
import java.util.Map;
/**
 * Clase que representa el expendedor de productos.
 *
 * El expendedor contiene un depósito de productos y un depósito de monedas para el vuelto.
 * Permite comprar productos y calcular el vuelto correspondiente.
 *
 * @author Benjamin
 * @author Joaquin
 */
public class Expendedor {
    private Deposito<Producto> depositoProducto;
    private Deposito<Moneda> depositoMonedasVuelto;
    private Map<Integer, Integer> stock;
    /**
     * Constructor que crea el expendedor con una cantidad específica dada de cada producto.
     *
     * @param cantidadPorProducto La cantidad inicial de cada producto en el expendedor.
     */
    public Expendedor(int cantidadPorProducto) {
        depositoProducto = new Deposito<>();
        depositoMonedasVuelto = new Deposito<>();
        stock = new HashMap<>(); // Inicializar el mapa de stock

        // Añadir productos y stock inicial
        for (int i = 0; i < cantidadPorProducto; i++) {
            // Añade CocaCola
            Producto cocaCola = new CocaCola(i);
            depositoProducto.add(cocaCola);
            stock.put(cocaCola.getPrecio().getNumSerie(), cantidadPorProducto);

            // Añade Sprite
            Producto sprite = new Sprite(i);
            depositoProducto.add(sprite);
            stock.put(sprite.getPrecio().getNumSerie(), cantidadPorProducto);

            // Añade Fanta
            Producto fanta = new Fanta(i);
            depositoProducto.add(fanta);
            stock.put(fanta.getPrecio().getNumSerie(), cantidadPorProducto);

            // Añade Super8
            Producto super8 = new Super8(i);
            depositoProducto.add(super8);
            stock.put(super8.getPrecio().getNumSerie(), cantidadPorProducto);

            // Añade Snickers
            Producto snickers = new Snickers(i);
            depositoProducto.add(snickers);
            stock.put(snickers.getPrecio().getNumSerie(), cantidadPorProducto);
        }
    }

    /**
     * Método que permite comprar un producto en el expendedor.
     *
     * @param totalPagado El pago total del comprador.
     * @param numSerie El número de serie del producto que se quiere comprar.
     * @return El producto comprado si la transacción es valida.
     * @throws PagoIncorrectoException Si el monto pagado es incorrecto o la serie del producto es inválida.
     * @throws NoHayProductoException Si no hay stock del producto solicitado.
     * @throws PagoInsuficienteException Si el pago es insuficiente para comprar el producto.
     */
    public Producto comprarProducto(int totalPagado, int numSerie) throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {
        if (totalPagado <= 0 || !esSerieValida(numSerie)) {
            throw new PagoIncorrectoException();
        }

        Producto producto = obtenerProducto(numSerie);
        // Verifica si el producto existe y si aún queda stock disponible.
        if (producto == null || stock.get(numSerie) <= 0) {
            throw new NoHayProductoException();        }
        // Verifica si el pago es suficiente para el precio del producto.
        if (producto.getPrecio().getValor() <= totalPagado) {
            int vuelto = totalPagado - producto.getPrecio().getValor();
            // Mientras el vuelto sea suficiente para devolver monedas de 100, se añaden al depósito de vuelto.
            while (vuelto >= 100) {
                depositoMonedasVuelto.add(new Moneda100());
                vuelto -= 100;
            }

            // Se actualiza el stock del producto
            stock.put(numSerie, stock.get(numSerie) - 1);

            return producto;
        } else {
            throw new PagoInsuficienteException();
        }
    }
    /**
     * Método auxiliar para verificar si un número de serie es válido.
     *
     * @param numSerie El número de serie del producto.
     * @return true si el número de serie es válido, false en caso contrario.
     */
    private boolean esSerieValida(int numSerie) {
        for (Precio_Serie precio : Precio_Serie.values()) {
            if (precio.getNumSerie() == numSerie) {
                return true;
            }
        }
        return false;
    }
    /**
     * Método auxiliar para obtener un producto con un número de serie específico.
     *
     * @param numSerie El número de serie del producto.
     * @return El producto correspondiente si existe o null en caso contrario.
     */
    private Producto obtenerProducto(int numSerie) {
        for (Producto producto : depositoProducto.getItems()) {
            if (producto.getPrecio().getNumSerie() == numSerie) {
                return producto;
            }
        }
        return null;
    }
    /**
     * Método que devuelve una moneda del depósito de vuelto.
     *
     * @return Una moneda del depósito de vuelto o null si no hay monedas.
     */
    public Moneda getVuelto() {
        return depositoMonedasVuelto.get(); // Retornar la moneda del vuelto
    }
}
