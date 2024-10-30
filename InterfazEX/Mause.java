package InterfazEX;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mause {
    public Mause(JButton boton) {
        // Agregar un ActionListener al botón
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción a realizar cuando el botón es presionado
                System.out.println(boton.getText() + " fue presionado.");
            }
        });
    }
}
