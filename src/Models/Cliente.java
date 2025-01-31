package Models;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cliente extends personaje {

    private JLabel cliente = new JLabel();
    private Image img;
    public boolean ordenLista = false;
    public boolean terminarComida = false;
    private Timer segundosComida, comiendo;

    public Cliente(int x, int y, int width, int height) {
        super(x, y, width, height, null);
        setSprites(new String[]{
            "../Resource/Personajes/Calamardo/calamardo-movimiento1.png",
            "../Resource/Personajes/Calamardo/calamardo-movimiento2.png",
            "../Resource/Personajes/Calamardo/calamardo-movimiento3.png",});
    }

    public void CrearCliente(JLabel panel) {
        img = new ImageIcon(getClass().getResource(getSprites()[1])).getImage();
        cliente.setIcon(new ImageIcon(img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)));
        cliente.setBounds(getX(), getY(), getWidth(), getHeight());
        panel.add(cliente);
    }

    public void MoverCliente(int posicionX, int posicionY) {

        timecharacter = new Timer(100, new ActionListener() {
            int x = cliente.getX();
            int y = cliente.getY();

            @Override
            public void actionPerformed(ActionEvent e) {
                if (x == posicionX && y == posicionY) {
                    cliente.setSize(cliente.getWidth(), cliente.getHeight() + 30);
                    pedirComida();
                    timecharacter.stop();
                    return;
                }
                if (cliente.getBounds().x >= posicionX) {
                    x -= 10;
                } else {
                    x += 10;
                }
                if (cliente.getBounds().y < posicionY) {
                    y += 10;
                }
                cliente.setLocation(x, y);
            }
        });
        timecharacter.start();
    }

    public void MoverClienteEliminar(JLabel Fondoescenario, int posicionX, int posicionY) {
        img = new ImageIcon(getClass().getResource("../Resource/Personajes/Calamardo/calamardo-movimiento2.png")).getImage();
        cliente.setIcon(new ImageIcon(img.getScaledInstance(cliente.getWidth(), cliente.getHeight(), Image.SCALE_SMOOTH)));
        timecharacter = new Timer(100, new ActionListener() {
            int x = cliente.getX();
            int y = cliente.getY();

            @Override
            public void actionPerformed(ActionEvent e) {
                if (x == posicionX && y == posicionY) {
                    timecharacter.stop();
                    Fondoescenario.remove(cliente);
                    return;
                }
                if (cliente.getBounds().x >= posicionX) {
                    x -= 10;
                } else {
                    x += 10;
                }
                if (y != posicionY) {
                    if (cliente.getBounds().y > posicionY) {
                        y -= 10;
                    }
                }
                cliente.setLocation(x, y);
            }
        });
        timecharacter.start();
    }

    public void pedirComida() {
        img = new ImageIcon(getClass().getResource("../Resource/Personajes/Calamardo/calamardo-pensando.png")).getImage();
        cliente.setIcon(new ImageIcon(img.getScaledInstance(cliente.getWidth(), cliente.getHeight(), Image.SCALE_SMOOTH)));
        segundosComida = new Timer(1000, new ActionListener() {
            int segundos = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                segundos++;
                if (segundos == 5) {
                    ordenLista = true;
                    img = new ImageIcon(getClass().getResource("../Resource/Personajes/Calamardo/calamardo-orden.png")).getImage();
                    cliente.setIcon(new ImageIcon(img.getScaledInstance(cliente.getWidth(), cliente.getHeight(), Image.SCALE_SMOOTH)));
                    segundosComida.stop();
                }
            }
        });
        segundosComida.start();
    }

    public void Comer(JLabel comida) {
        if (cliente.getBounds().intersects(comida.getBounds())) {
            Comiendo();
        }
    }

    private void Comiendo() {
        comiendo = new Timer(1000, new ActionListener() {
            int segundos = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                segundos++;
                if (segundos == 5) {
                    terminarComida = true;
                    comiendo.stop();
                }
            }
        });
        comiendo.start();
    }
}
