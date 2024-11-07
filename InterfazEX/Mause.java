package InterfazEX;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Clase que extiende MouseAdapter para gestionar los eventos del ratón sobre un botón.
 * Esta clase permite cambiar el color del botón cuando el mouse entra o sale,
 * y también imprime un mensaje en consola cuando el botón es presionado.
 *
 *
 * @author Benjamin
 * @author Joaquin
 *
 */
public class Mause extends MouseAdapter {
    private JButton boton;
    /**
     * Constructor de la clase Mouse.
     * Asocia un botón a un escuchador de eventos de ratón.
     *
     * @param boton El botón al que se le asociará el escucha de eventos.
     */
    public Mause(JButton boton) {
        this.boton = boton;
        this.boton.addMouseListener(this);
    }
    /**
     * Método llamado cuando el mouse hace clic sobre el botón.
     * Imprime un mensaje en consola indicando que el botón fue presionado.
     *
     * @param e El evento de mouse que contiene la información sobre el clic.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(boton.getText() + " fue presionado con Mouse.");
    }
    /*
    * Método llamado cuando el mouse entra en el área del botón.
    * Cambia el fondo del botón a color amarillo cuando el mouse entra.
    *
    * @param e El evento de mouse que contiene la información sobre la entrada del mouse.
    */
    @Override
    public void mouseEntered(MouseEvent e) {
        boton.setBackground(Color.YELLOW);
    }
    /**
     * Método llamado cuando el mouse sale del área del botón.
     * Restaura el color de fondo del botón al valor por defecto cuando el mouse sale.
     *
     * @param e El evento de mouse que contiene la información sobre la salida del mouse.
     */
    @Override
    public void mouseExited(MouseEvent e) {
        boton.setBackground(UIManager.getColor("Button.background"));
    }
}

