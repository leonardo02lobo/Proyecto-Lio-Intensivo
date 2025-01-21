package Models.Entidades;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Mesa extends JLabel{
    
    public Mesa() {
        Image img = new ImageIcon(getClass().getResource("../Resource/mesa.png")).getImage();
        setIcon(new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
    }
    
}
