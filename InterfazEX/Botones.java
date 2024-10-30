package InterfazEX;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Botones {
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JButton boton4;

    public Botones() {
        // Inicializar los botones
        boton1 = new JButton("Botón 1");
        boton2 = new JButton("Botón 2");
        boton3 = new JButton("Botón 3");
        boton4 = new JButton("Botón 4");

        // Agregar ActionListeners a cada botón
        addActionListeners();
    }

    private void addActionListeners() {
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(boton1.getText() + " fue presionado.");
            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(boton2.getText() + " fue presionado.");
            }
        });

        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(boton3.getText() + " fue presionado.");
            }
        });

        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(boton4.getText() + " fue presionado.");
            }
        });
    }

    // Métodos para obtener los botones
    public JButton getBoton1() {
        return boton1;
    }

    public JButton getBoton2() {
        return boton2;
    }

    public JButton getBoton3() {
        return boton3;
    }

    public JButton getBoton4() {
        return boton4;
    }
}
