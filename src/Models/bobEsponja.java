package Models;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Models.Entidades.*;

public class bobEsponja extends personaje {
    private int iteradorMesas = 0;

    public bobEsponja(int x, int y, int width, int height, String[] sprites) {
        super(x, y, width, height, sprites);
    }

    public void mover(JLabel label, MouseEvent ex, EntornoMesa[] mesas) {
        timecharacter = new Timer(100, new ActionListener() {
            int x = getX();
            int y = getY();

            @Override
            public void actionPerformed(ActionEvent e) {

                if (iterador1 == getSprites().length) {
                    iterador1 = 0;
                }
                if (iteradorMesas == mesas.length - 1) {
                    iteradorMesas = 0;
                } else {
                    iteradorMesas++;
                }

                if (label.getBounds().intersects(mesas[iteradorMesas].getBounds())) {
                    x -= 20;
                    y += 20;
                    label.setBounds(x, y, getWidth(), getHeight());
                    detenertimer();
                }
                if (x < ex.getX()) {
                    if(x == 1080){
                        detenertimer();
                    }
                    x += 10;
                } else {
                    if(x == 0){
                        detenertimer();
                    }
                    x -= 10;
                }
                System.out.println(x);
                if (y < ex.getY()) {
                    if(y == 650){
                        detenertimer();
                    }
                    y += 10;
                } else {
                    if (y == 400) {
                        detenertimer();
                    }
                    y -= 10;
                }

                if (Math.abs(x - ex.getX()) < 10 && Math.abs(y - ex.getY()) < 10) {
                    detenertimer();
                    setX(x);
                    setY(y);
                }

                Image img = new ImageIcon(getClass().getResource(getSprites()[iterador1])).getImage();
                label.setIcon(new ImageIcon(img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)));
                label.setBounds(x, y, getWidth(), getHeight());
                iterador1++;

            }
        });
        timecharacter.start();
    }
}
