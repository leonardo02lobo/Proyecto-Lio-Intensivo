
package Models;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Orden extends JLabel{

    public Orden(){
        Image img = new ImageIcon(getClass().getResource("../Resource/cangreburger.png")).getImage();
        setIcon(new ImageIcon(img.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        setSize(50,50);
    }
}
