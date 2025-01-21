package Models;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class bobEsponja extends personaje {

    public bobEsponja(int x, int y, int width, int height, String[] sprites) {
        super(x, y, width, height, sprites);
    }

    public void mover(JLabel label) {
        timecharacter = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(iterador1 == getSprites().length){
                    iterador1 = 0;
                }
                Image img = new ImageIcon(getClass().getResource(getSprites()[iterador1])).getImage();
                label.setIcon(new ImageIcon(img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)));
                label.setBounds(getX(), getY(), getWidth(), getHeight());
                iterador1++;
            }
        });
        timecharacter.start();
    }
}
