package View;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Principal extends JPanel {

    public Principal() {
        setLayout(null);
        ColocarFondo();
        CrearBotones();
    }

    private void ColocarFondo() {
        Image img = new ImageIcon(getClass().getResource("../Resource/penguin.png")).getImage();
        fondo.setIcon(new ImageIcon(img.getScaledInstance(App.WITDH, App.HEIGHT, Image.SCALE_SMOOTH)));
        fondo.setBounds(0, 0, App.WITDH, App.HEIGHT);
        fondo.setLayout(null);
        add(fondo);
    }

    private void CrearBotones() {
        CrearLabel(play, App.WITDH - 80, (int) (App.HEIGHT / 1.5), 150, 30, "Play");
        CrearLabel(instrucciones, App.WITDH - 150, (int) (App.HEIGHT / 1.3), 150, 30, "Instrucciones");
    }

    private void CrearLabel(JLabel label, int x, int y, int ancho, int alto, String texto) {
        label.setText(texto);
        label.setBounds(x, y, ancho, alto);
        label.setForeground(Color.red);
        label.setFont(new Font("Arial", Font.ITALIC, 20));
        label.addMouseListener(new MouseAdapter() {

            @SuppressWarnings("unlikely-arg-type")
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.equals(play)) {
                    System.out.println("aaa");
                    App.CrearFrame(new Juego());
                } else if (e.equals(instrucciones)) {
                    App.CrearFrame(new Instrucciones());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setForeground(Color.yellow);
                label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setForeground(Color.red);
            }
        });
        fondo.add(label);
    }

    private JLabel fondo = new JLabel();
    private JLabel play = new JLabel();
    private JLabel instrucciones = new JLabel();
}
