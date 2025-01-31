package Models;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Patricio extends personaje{
    private Image imagenNueva;
    private int i = 0;

    public Patricio(int x, int y, int width, int height, String[] sprites) {
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
        if (letraCodigo == KeyEvent.VK_D) {
            setSprites(new String[] { "../Resource/Personajes/Patricio/patricio-estrella-movimiento-izquierda1.png",
                    "../Resource/Personajes/Patricio/patricio-estrella-movimiento-izquierda2.png",
                    "../Resource/Personajes/Patricio/patricio-estrella-movimiento-izquierda3.png" });
        }
        if (letraCodigo == KeyEvent.VK_A) {
            setSprites(new String[] { "../Resource/Personajes/Patricio/patricio-estrella-movimiento-derecha1.png",
                    "../Resource/Personajes/Patricio/patricio-estrella-movimiento-derecha2.png",
                    "../Resource/Personajes/Patricio/patricio-estrella-movimiento-derecha3.png" });
        }
        if (letraCodigo == KeyEvent.VK_W) {
            setSprites(new String[] { "../Resource/Personajes/Patricio/patricio-estrella-espalda1.png",
                    "../Resource/Personajes/Patricio/patricio-estrella-espalda2.png",
                    "../Resource/Personajes/Patricio/patricio-estrella-espalda3.png" });
        }
        if (letraCodigo == KeyEvent.VK_S) {
            setSprites(new String[] { "../Resource/Personajes/Patricio/patricio-estrella-movimiento1.png",
                    "../Resource/Personajes/Patricio/patricio-estrella-movimiento2.png",
                    "../Resource/Personajes/Patricio/patricio-estrella-movimiento3.png" });
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
            imagenNueva = new ImageIcon(getClass().getResource("../Resource/Personajes/Patricio/patricio-estrella-movimiento2.png")).getImage();
            label.setIcon(new ImageIcon(imagenNueva.getScaledInstance(label.getBounds().width, label.getBounds().height, Image.SCALE_SMOOTH)));
            detenertimer();
        }
    }
}
