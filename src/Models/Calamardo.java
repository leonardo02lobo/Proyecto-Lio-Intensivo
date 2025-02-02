
package Models;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calamardo extends personaje{
    private Image imagenNueva;
    private int i = 0;

    public Calamardo(int x, int y, int width, int height, String[] sprites) {
        super(x, y, width, height, sprites);
    }

    public void mover(String[] sprites, int letraCodigo,JLabel label) {
        if(timecharacter != null){
            timecharacter.stop();
            timecharacter = null;
        }
        if(iterador1 == getSprites().length){
            iterador1 = 0;
        }
        timecharacter = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(i == getSprites().length){
                    i = 0;
                }
                imagenNueva = new ImageIcon(getClass().getResource(getSprites()[i])).getImage();
                label.setIcon(new ImageIcon(imagenNueva.getScaledInstance(label.getBounds().width, label.getBounds().height, Image.SCALE_SMOOTH)));
                i++;
            }
        });
        timecharacter.start();
        if(letraCodigo == 0){
            imagenNueva = new ImageIcon(getClass().getResource("../Resource/Personajes/Calamardo/calamardo.png")).getImage();
            label.setIcon(new ImageIcon(imagenNueva.getScaledInstance(label.getBounds().width, label.getBounds().height, Image.SCALE_SMOOTH)));
            detenertimer();
        }
    }
}
