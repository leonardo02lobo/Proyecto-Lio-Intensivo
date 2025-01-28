package Models;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Cliente extends personaje {

    public Cliente(int x, int y, int width, int height, String[] sprites) {
        super(x, y, width, height, sprites);
    }

    public JLabel CrearCliente() {
        JLabel cliente = new JLabel();
        Image img = new ImageIcon(getClass().getResource(getSprites()[1])).getImage();
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
}
