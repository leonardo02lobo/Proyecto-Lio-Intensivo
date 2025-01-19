package View;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Instrucciones extends JPanel {

    private JPanel instruccion = new JPanel();
    private JPanel botones = new JPanel();
    private JLabel next = new JLabel();
    private JLabel tipoInstruccionLabel = new JLabel();
    private JLabel previous = new JLabel();
    private JLabel imagen = new JLabel();
    private String[] imagenes = {
        "../Resource/instruccion-1.png",
        "../Resource/instruccion-2.png",
        "../Resource/instruccion-3.png",
        "../Resource/instruccion-4.png",
        "../Resource/instruccion-5.png",
        "../Resource/instruccion-6.png",};
    private int i = 0;
    private Image img = null;

    public Instrucciones(String tipoInstruccion) {
        setLayout(new BorderLayout());
        CrearPaneles(instruccion, BorderLayout.CENTER);
        CrearPaneles(botones, BorderLayout.SOUTH);
        CrearLabel(previous, "Previous", 100, 20, 200, 30);
        CrearLabel(tipoInstruccionLabel, tipoInstruccion, (App.WITDH / 2) - 200, 20, 200, 30);
        CrearLabel(next, "next", App.WITDH - 100, 20, 100, 30);
        CrearInstrucciones(instruccion);
    }

    private void CrearInstrucciones(JPanel panel) {
        panel.setLayout(null);
        img = new ImageIcon(getClass().getResource(imagenes[i])).getImage();
        imagen.setIcon(new ImageIcon(img.getScaledInstance(App.WITDH, App.HEIGHT - 100, Image.SCALE_SMOOTH)));
        imagen.setBounds(0, 0, App.WITDH, App.HEIGHT - 100);
        panel.add(imagen);
    }

    private void CrearPaneles(JPanel panel, String direccion) {
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, App.WITDH / 5, 20));
        panel.setBackground(Color.cyan);
        add(panel, direccion);
    }

    private void CrearLabel(JLabel label, String texto, int x, int y, int ancho, int alto) {
        label.setText(texto);
        label.setForeground(Color.red);
        label.setFont(new Font("Arial", Font.ITALIC, 20));
        label.setBounds(x, y, ancho, alto);
        label.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource().equals(tipoInstruccionLabel)) {
                    if (tipoInstruccionLabel.getText().equals("Main menu")) {
                        App.CerraFrame();
                        App.CrearFrame(new Principal());
                        return;
                    }
                }

                if (e.getSource().equals(previous)) {
                    i--;
                    if (i == 0) {
                        previous.setVisible(false);
                    }
                } else {
                    i++;
                }
                if (i > 0) {
                    previous.setVisible(true);
                }
                if (i == imagenes.length - 1) {
                    next.setVisible(false);
                } else {
                    next.setVisible(true);
                }

                img = new ImageIcon(getClass().getResource(imagenes[i])).getImage();
                imagen.setIcon(new ImageIcon(img.getScaledInstance(App.WITDH, App.HEIGHT - 100, Image.SCALE_SMOOTH)));
                botones.revalidate();
                botones.repaint();
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
        botones.add(label);
        if (label == previous) {
            previous.setVisible(false);
        }
    }

}
