package Models.Entidades;

import java.awt.Image;

import javax.swing.*;

public class EntornoMesa extends JLabel{

    public EntornoMesa(){
        Image img = new ImageIcon(getClass().getResource("../../Resource/mesa.png")).getImage();
        setIcon(new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
    }

    private Mesa mesa = new Mesa();
}
