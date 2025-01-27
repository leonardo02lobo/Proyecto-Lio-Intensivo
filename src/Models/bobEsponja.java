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

    public void mover(String[] sprites,int letraCodigo) {
        if(timecharacter != null){
            timecharacter.stop();
            timecharacter = null;
        }
        timecharacter = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(letraCodigo == KeyEvent.VK_D){
                    System.out.println("D");
                }
                if(letraCodigo == KeyEvent.VK_A){
                    System.out.println("A");
                }
                if(letraCodigo == KeyEvent.VK_W){
                    System.out.println("W");
                }
                if(letraCodigo == KeyEvent.VK_S){
                    System.out.println("S");
                }
//
//                if (iterador1 == getSprites().length) {
//                    iterador1 = 0;
//                }
//                if (iteradorMesas == mesas.length - 1) {
//                    iteradorMesas = 0;
//                } else {
//                    iteradorMesas++;
//                }
//
//                if (label.getBounds().intersects(mesas[iteradorMesas].getBounds())) {
//                    x -= 20;
//                    y += 20;
//                    label.setBounds(x, y, getWidth(), getHeight());
//                    detenertimer();
//                }
//                if (x < ex.getX()) {
//                    if(x == 1080){
//                        detenertimer();
//                    }
//                    setSprites(new String[] { "../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento-derecha1.png",
//                    "../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento-derecha2.png",
//                    "../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento-derecha3.png" });
//                    x += 10;
//                } else {
//                    if(x == 0){
//                        detenertimer();
//                    }
//                    setSprites(new String[] { "../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento-izquierda1.png",
//                    "../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento-izquierda2.png",
//                    "../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento-izquierda3.png" });
//                    x -= 10;
//                }
//                if (y < ex.getY()) {
//                    if(y == 650){
//                        detenertimer();
//                    }
//                    setSprites(new String[] { "../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento1.png",
//                    "../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento2.png",
//                    "../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento3.png" });
//                    y += 10;
//                } else {
//                    if (y == 400) {
//                        detenertimer();
//                    }
//                    setSprites(new String[] { "../Resource/Personajes/Bob-Esponja/bob-esponja-espalda1.png",
//                    "../Resource/Personajes/Bob-Esponja/bob-esponja-espalda2.png",
//                    "../Resource/Personajes/Bob-Esponja/bob-esponja-espalda3.png" });
//                    y -= 10;
//                }
//
//                if (Math.abs(x - ex.getX()) < 10 && Math.abs(y - ex.getY()) < 10) {
//                    setSprites(new String[] { "../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento1.png",
//                    "../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento2.png",
//                    "../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento3.png" });
//                    detenertimer();
//                    setX(x);
//                    setY(y);
//                }
//
//                Image img = new ImageIcon(getClass().getResource(getSprites()[iterador1])).getImage();
//                label.setIcon(new ImageIcon(img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)));
//                label.setBounds(x, y, getWidth(), getHeight());
//                iterador1++;

            }
        });
        timecharacter.start();
    }
}
