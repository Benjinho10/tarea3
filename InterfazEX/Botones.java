package InterfazEX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Botones {
    private JButton botonCocaCola;
    private JButton botonSprite;
    private JButton botonFanta;
    private JButton botonSuper8;
    private JButton botonSnickers;

    public Botones() {
        botonCocaCola = new JButton("Botón Coca-Cola");
        botonSprite = new JButton("Botón Sprite");
        botonFanta = new JButton("Botón Fanta");
        botonSuper8 = new JButton("Botón Super8");
        botonSnickers = new JButton("Botón Snickers");

        // Agregar ActionListeners a cada botón
        addActionListeners();
    }

    private void addActionListeners() {
        botonCocaCola.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(botonCocaCola.getText() + " fue presionado.");
            }
        });

        botonSprite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(botonSprite.getText() + " fue presionado.");
            }
        });

        botonFanta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(botonFanta.getText() + " fue presionado.");
            }
        });

        botonSuper8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(botonSuper8.getText() + " fue presionado.");
            }
        });

        botonSnickers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(botonSnickers.getText() + " fue presionado.");
            }
        });
    }

    // Métodos para obtener los botones
    public JButton getBotonCocaCola() {
        return botonCocaCola;
    }

    public JButton getBotonSprite() {
        return botonSprite;
    }

    public JButton getBotonFanta() {
        return botonFanta;
    }

    public JButton getBotonSuper8() {
        return botonSuper8;
    }

    public JButton getBotonSnickers() {
        return botonSnickers;
    }
}
