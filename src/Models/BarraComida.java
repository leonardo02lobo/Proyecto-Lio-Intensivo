package Models;

import java.awt.*;
import javax.swing.*;

public class BarraComida extends JLabel {

    public BarraComida() {
        setLayout(null);
        setBounds(0, 690, 320, 100);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        DibujarEspaciosComida();
    }

    private void DibujarEspaciosComida() {
        int x = 10;
        for (JLabel label : espacios) {
            label = new JLabel();
            label.setBounds(x, 10, 50, 50);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            add(label);
            x += 60;
        }
    }

    public void AgregarComida(String img) {
        if (espacios[posicionComida] == null) {
            espacios[posicionComida] = new JLabel();
            urlComidas[posicionComida] = img;
            Image imagen = new ImageIcon(getClass().getResource(img)).getImage();
            espacios[posicionComida].setIcon(new ImageIcon(imagen.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
            espacios[posicionComida].setBounds(x, 10, 50, 50);
            add(espacios[posicionComida]);
            posicionComida++;
            x += 60;
            OrdenAgarrada = false;
        }
    }

    public void QuitarComida(String img) {
        for (int i = 0; i < urlComidas.length; i++) {
            if(urlComidas[i].equals(img)){
                remove(espacios[i]);
                return;
            }
        }
    }

    private JLabel[] espacios = new JLabel[5];
    private int posicionComida = 0;
    public boolean OrdenAgarrada = true;
    private int x = 10;
    private String[] urlComidas = new String[5];
}
