package View;

import Models.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Juego extends JPanel {

    public Juego() {
        setLayout(null);
        Fondoescenario.setLayout(null);
        Fondoescenario.setBounds(0, 0, App.WITDH, App.HEIGHT);
        add(Fondoescenario);

        CrearEscenario();
        CrearPersonaje();
        Fondoescenario.add(barra);
        Fondoescenario.add(cantidadDinero);
        clientePersonaje = new Cliente(100, 300, 100, 100, Fondoescenario, LBobEsponja, barra, cantidadDinero);
        clientePersonaje.IniciarRecorrido();
        Timer tiempoCliente = new Timer(6000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Cliente.NumeroClientes == 10){
                    JOptionPane.showMessageDialog(null, "Primer Nivel Terminado");
                    App.CerraFrame();
                    App.CrearFrame(new Juego());
                }
                if(MesasLibres()){         
                    clientePersonaje = new Cliente(100, 300, 100, 100, Fondoescenario, LBobEsponja, barra, cantidadDinero);
                    clientePersonaje.IniciarRecorrido();
                    Cliente.NumeroClientes++;
                }
            }
        });
        tiempoCliente.start();
    }
    
    private boolean MesasLibres(){
        boolean band = false;
        for (boolean mesas : Cliente.mesasOcupadas) {
            if(mesas){
                band = true;
            }
        }
        return band;
    }

    private void CrearPersonaje() {
        bob = (bobEsponja) datosPersonaje;
        Image img = new ImageIcon(getClass().getResource(bob.getSprites()[0])).getImage();
        LBobEsponja.setIcon(new ImageIcon(img.getScaledInstance(bob.getWidth(), bob.getHeight(), Image.SCALE_SMOOTH)));
        LBobEsponja.setBounds(bob.getX(), bob.getY(), bob.getWidth(), bob.getHeight());
        LBobEsponja.addKeyListener(new KeyAdapter() {
            int x = bob.getX();
            int y = bob.getY();

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    if (x != 1080) {
                        x += 10;
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    if (x != 0) {
                        x -= 10;
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    if (y != 300) {
                        y -= 10;
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    if (y != 660) {
                        y += 10;
                    }

                }
                bob.mover(null, e.getKeyCode(), LBobEsponja);
                LBobEsponja.setLocation(x, y);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                bob.mover(null, 0, LBobEsponja);
            }

        });
        LBobEsponja.setFocusable(true);
        Fondoescenario.add(LBobEsponja);
    }

    private void CrearEscenario() {
        Image img = new ImageIcon(getClass().getResource("../Resource/fondoJuego.png")).getImage();
        escenario.setIcon(new ImageIcon(img.getScaledInstance(App.WITDH, App.HEIGHT, Image.SCALE_SMOOTH)));
        escenario.setBounds(0, 0, App.WITDH, App.HEIGHT);
        add(escenario);
    }

    private JLabel LBobEsponja = new JLabel();
    private JLabel escenario = new JLabel();
    private personaje datosPersonaje = new bobEsponja(400, 450, 100, 100);
    private bobEsponja bob;
    private int segundos = 0;
    private Cliente clientePersonaje;
    private JLabel Fondoescenario = new JLabel();
    private BarraComida barra = new BarraComida();
    private CantidadDinero cantidadDinero = new CantidadDinero();
}
