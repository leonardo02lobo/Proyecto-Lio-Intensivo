package View;

import Models.*;
import Models.Entidades.EntornoMesa;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Juego extends JPanel {

    public Juego() {
        setLayout(null);

        CrearPersonaje();
        CrearMesas();
        CrearEscenario();
    }

    private void CrearPersonaje() {
        bob = (bobEsponja) datosPersonaje;
        Image img = new ImageIcon(getClass().getResource(bob.getSprites()[1])).getImage();
        LBobEsponja.setIcon(new ImageIcon(img.getScaledInstance(bob.getWidth(), bob.getHeight(), Image.SCALE_SMOOTH)));
        LBobEsponja.setBounds(bob.getX(), bob.getY(), bob.getWidth(), bob.getHeight());
        add(LBobEsponja);
    }

    private void CrearMesas() {
        for (int i = 0; i < EntornoMesa.length; i++) {
            EntornoMesa[i] = new EntornoMesa();
            EntornoMesa[i].setBounds(EntornoMesa[i].getCoordenadasX()[i], EntornoMesa[i].getCoordenadasY()[i], 100,
                    100);
            add(EntornoMesa[i]);
        }
    }

    private void CrearEscenario() {
        Image img = new ImageIcon(getClass().getResource("../Resource/fondoJuego.png")).getImage();
        escenario.setIcon(new ImageIcon(img.getScaledInstance(App.WITDH, App.HEIGHT, Image.SCALE_SMOOTH)));
        escenario.setBounds(0, 0, App.WITDH, App.HEIGHT);
        escenario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bob.mover(LBobEsponja, e, EntornoMesa);
            }

        });
        escenario.setFocusable(true);
        add(escenario);
    }

    private EntornoMesa[] EntornoMesa = new EntornoMesa[4];
    private JLabel LBobEsponja = new JLabel();
    private JLabel escenario = new JLabel();
    private personaje datosPersonaje = new bobEsponja(400, 450, 100, 100,
            new String[] { "../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento1.png",
                    "../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento2.png",
                    "../Resource/Personajes/Bob-Esponja/bob-esponja-movimiento3.png" });
    private bobEsponja bob;
}
