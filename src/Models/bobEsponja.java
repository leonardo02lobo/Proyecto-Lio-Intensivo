package Models;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class bobEsponja extends personaje {
    private Image imagenNueva;
    public int i = 0;
    
    public bobEsponja(int x, int y, int width, int height) {
        super(x, y, width, height, null);
        setSprites(new String[]{"../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento1.png",
                "../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento2.png",
                "../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento3.png"});
    }

    public void mover(String[] sprites, int letraCodigo,JLabel label) {
        if(timecharacter != null){
            timecharacter.stop();
            timecharacter = null;
        }
        if(letraCodigo == KeyEvent.VK_D){
            setSprites(new String[]{"../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento4.png",
                "../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento5.png",
                "../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento6.png"});
        }
        if(letraCodigo == KeyEvent.VK_A){
            setSprites(new String[]{"../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento1.png",
                "../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento2.png",
                "../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento3.png"});
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
            imagenNueva = new ImageIcon(getClass().getResource("../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento1.png")).getImage();
            label.setIcon(new ImageIcon(imagenNueva.getScaledInstance(label.getBounds().width, label.getBounds().height, Image.SCALE_SMOOTH)));
            detenertimer();
        }
    }
}
