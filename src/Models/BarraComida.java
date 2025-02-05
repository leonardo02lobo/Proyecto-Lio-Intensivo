package Models;

import java.awt.*;
import javax.swing.*;

public class BarraComida extends JLabel {

    public BarraComida() {
        setLayout(null);
        setBounds(0, 690, 70, 100);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        DibujarEspaciosComida();
    }

    private void DibujarEspaciosComida() {
        espacios.setBounds(10, 10, 50, 50);
        add(espacios);
    }

    public void AgregarComida(String img) {
        espacios = new JLabel();
        Image imagen = new ImageIcon(getClass().getResource(img)).getImage();
        espacios.setIcon(new ImageIcon(imagen.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        espacios.setBounds(10, 10, 50, 50);
        add(espacios);
        OrdenAgarrada = false;
    }

    public void QuitarComida(String img) {
        remove(espacios);
        OrdenAgarrada = true;
    }

    private static JLabel espacios = new JLabel();
    public boolean OrdenAgarrada = true;
}
