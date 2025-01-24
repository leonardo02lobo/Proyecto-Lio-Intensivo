package Models;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class bobEsponja extends personaje {

    public bobEsponja(int x, int y, int width, int height, String[] sprites) {
        super(x, y, width, height, sprites);
    }

    public void mover(JLabel label, MouseEvent ex) {
        timecharacter = new Timer(100, new ActionListener() {
            int x = getX();
            int y = getY();

            @Override
            public void actionPerformed(ActionEvent e) {
                if (iterador1 == getSprites().length) {
                    iterador1 = 0;
                }
                if (x < ex.getX()) {
                    x += 10;
                } else {
                    x -= 10;
                }
                if (y < ex.getY()) {
                    y += 10;
                } else {
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
