
package Models;

import Models.Entidades.EntornoMesa;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Calamardo extends personaje{
    private int iteradorMesas = 0;

    public Calamardo(int x, int y, int width, int height, String[] sprites) {
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
                    setSprites(new String[] { "../Resource/Personajes/Calamardo/calamardo-movimiento-derecha1.png",
                    "../Resource/Personajes/Calamardo/calamardo-movimiento-derecha2.png",
                    "../Resource/Personajes/Calamardo/calamardo-movimiento-derecha3.png" });
                    x += 10;
                } else {
                    if(x == 0){
                        detenertimer();
                    }
                    setSprites(new String[] { "../Resource/Personajes/Calamardo/calamardo-movimiento-izquierda1.png",
                    "../Resource/Personajes/Calamardo/calamardo-movimiento-izquierda2.png",
                    "../Resource/Personajes/Calamardo/calamardo-movimiento-izquierda3.png" });
                    x -= 10;
                }
                if (y < ex.getY()) {
                    if(y == 650){
                        detenertimer();
                    }
                    setSprites(new String[] { "../Resource/Personajes/Calamardo/calamardo-movimiento1.png",
                    "../Resource/Personajes/Calamardo/calamardo-movimiento2.png",
                    "../Resource/Personajes/Calamardo/calamardo-movimiento3.png" });
                    y += 10;
                } else {
                    if (y == 400) {
                        detenertimer();
                    }
                    setSprites(new String[] { "../Resource/Personajes/Calamardo/calamardo-espalda1.png",
                    "../Resource/Personajes/Calamardo/calamardo-espalda2.png",
                    "../Resource/Personajes/Calamardo/calamardo-espalda3.png" });
                    y -= 10;
                }

                if (Math.abs(x - ex.getX()) < 10 && Math.abs(y - ex.getY()) < 10) {
                    setSprites(new String[] { "../Resource/Personajes/Calamardo/calamardo-movimiento1.png",
                    "../Resource/Personajes/Calamardo/calamardo-movimiento2.png",
                    "../Resource/Personajes/Calamardo/calamardo-movimiento3.png" });
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
