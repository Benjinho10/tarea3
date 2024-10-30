package InterfazEX;

import javax.swing.JFrame;

public class main {
    public static void main(String[] args) {
        // Crear una instancia de Ventana que contiene los botones
        Ventana ventana = new Ventana();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al cerrar la ventana
        ventana.setVisible(true); // Mostrar la ventana
    }
}
