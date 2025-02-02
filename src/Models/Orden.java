
package Models;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Orden extends JLabel{

    private String urlImage;
    
    public void CrearOrden(String image){ 
        this.urlImage = image;
        Image img = new ImageIcon(getClass().getResource(urlImage)).getImage();
        setIcon(new ImageIcon(img.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        setSize(50,50);
    }

    public String getUrlImage() {
        return urlImage;
    }   
}
