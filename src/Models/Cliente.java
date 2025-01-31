package Models;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cliente extends personaje {
    
    private JLabel cliente = new JLabel();
    private Image img;
    private Timer segundosComida;
    
    public Cliente(int x, int y, int width, int height) {
        super(x, y, width, height,null);
        setSprites(new String[]{
            "../Resource/Personajes/Calamardo/calamardo-movimiento1.png",
            "../Resource/Personajes/Calamardo/calamardo-movimiento2.png",
            "../Resource/Personajes/Calamardo/calamardo-movimiento3.png",});
    }

    public JLabel CrearCliente() { 
        img = new ImageIcon(getClass().getResource(getSprites()[1])).getImage();
        cliente.setIcon(new ImageIcon(img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)));
        cliente.setBounds(getX(), getY(), getWidth(), getHeight());
        return cliente;
    }

    public void MoverCliente(JLabel label, int posicionX, int posicionY) {

        timecharacter = new Timer(100, new ActionListener() {
            int x = label.getX();
            int y = label.getY();

            @Override
            public void actionPerformed(ActionEvent e) {
                if (x == posicionX && y == posicionY) {
                    label.setSize(label.getWidth(), label.getHeight()+30);
                    pedirComida(label);
                    timecharacter.stop();
                    return;
                }
                if (label.getBounds().x >= posicionX) {
                    x -= 10;
                } else {
                    x += 10;
                }
                if (label.getBounds().y < posicionY) {
                    y += 10;
                }
                label.setLocation(x, y);
            }
        });
        timecharacter.start();
    }

    public void MoverClienteEliminar(JLabel label, JLabel Fondoescenario, int posicionX, int posicionY) {
        timecharacter = new Timer(100, new ActionListener() {
            int x = label.getX();
            int y = label.getY();

            @Override
            public void actionPerformed(ActionEvent e) {
                if (x == posicionX && y == posicionY) {
                    timecharacter.stop();
                    Fondoescenario.remove(label);
                    return;
                }
                if (label.getBounds().x >= posicionX) {
                    x -= 10;
                } else {
                    x += 10;
                }
                if (label.getBounds().y > posicionY) {
                    y -= 10;
                }
                label.setLocation(x, y);
            }
        });
        timecharacter.start();
    }
    
    public void pedirComida(JLabel label){
        img = new ImageIcon(getClass().getResource("../Resource/Personajes/Calamardo/calamardo-pensando.png")).getImage();
        label.setIcon(new ImageIcon(img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH)));
        segundosComida = new Timer(1000, new ActionListener() {
            int segundos = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("aaa");
                segundos++;
                if(segundos == 5){
                    img = new ImageIcon(getClass().getResource("../Resource/Personajes/Calamardo/calamardo-orden.png")).getImage();
                    label.setIcon(new ImageIcon(img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH)));
                    segundosComida.stop();
                }
            }
        });
        segundosComida.start();
    }
}
