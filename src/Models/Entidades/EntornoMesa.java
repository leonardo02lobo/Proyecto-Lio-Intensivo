package Models.Entidades;

import java.awt.Image;

import javax.swing.*;

public class EntornoMesa extends JLabel {

    private int[] CoordenadasX = {200, 300, 700, 800};
    private int[] CoordenadasY = {450, 550, 550, 450};

    public EntornoMesa() {
        Image img = new ImageIcon(getClass().getResource("../../Resource/mesa.png")).getImage();
        setIcon(new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
    }
<<<<<<< HEAD
=======

    public int[] getCoordenadasX() {
        return CoordenadasX;
    }

    public int[] getCoordenadasY() {
        return CoordenadasY;
    }
>>>>>>> ab7797262ab325376057655d951c04576cbe7583
}
