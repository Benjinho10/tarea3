package InterfazEX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mause extends MouseAdapter {
    private JButton boton;

    public Mause(JButton boton) {
        this.boton = boton;
        this.boton.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(boton.getText() + " fue presionado con Mouse.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        boton.setBackground(Color.YELLOW);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        boton.setBackground(UIManager.getColor("Button.background"));
    }
}

