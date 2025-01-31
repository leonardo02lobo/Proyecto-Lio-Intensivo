package View;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Principal extends JPanel {

    public Principal() {
        setLayout(null);
        ColocarFondo();
        Imagen();
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

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource().equals(play)) {
                    App.CerraFrame();
                    App.WITDH += 400;
                    App.CrearFrame(new Juego());
                } else if (e.getSource().equals(instrucciones)) {
                    App.CerraFrame();
                    App.CrearFrame(new Instrucciones("Main menu"));
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

    private void Imagen() {
        Image img = new ImageIcon(getClass().getResource("../Resource/bob-slimecafe.png")).getImage();
        bob.setIcon(new ImageIcon(img.getScaledInstance(400, 400, Image.SCALE_SMOOTH)));
        bob.setBounds(30, 800, 400, 400);
        Image img2 = new ImageIcon(getClass().getResource("../Resource/logo.png")).getImage();
        logo.setIcon(new ImageIcon(img2.getScaledInstance(420, 300, Image.SCALE_SMOOTH)));
        logo.setBounds(400, -50, 420, 300);
        animacion = new Timer(1000 / 60, new ActionListener() {
            int y = 800;
            int y1 = -350;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (y1 != -50) {
                    y1 += 10;
                }
                if (y == 400) {
                    animacion.stop();
                    animacion = null;
                }
                y -= 10;
                bob.setLocation(30, y);
                logo.setLocation(400, y1);
            }
        });
        animacion.start();
        fondo.add(bob);
        fondo.add(logo);
    }

    private JLabel fondo = new JLabel();
    private Timer animacion;
    private JLabel bob = new JLabel();
    private JLabel logo = new JLabel();
    private JLabel play = new JLabel();
    private JLabel instrucciones = new JLabel();
}
