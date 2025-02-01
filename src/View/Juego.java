package View;

import Models.*;
import Models.Entidades.*;

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
        CrearMesas();
        Fondoescenario.add(barra);
        Ordenes();
        Timer tiempoCliente = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (segundos == 5) {
                    CrearCliente();
                }
                if (segundos == 10) {
                    clientePersonaje.MoverCliente(250, 300);
                }
                if (clientePersonaje.ordenLista) {
                    Fondoescenario.add(orden);
                }
                if (LBobEsponja.getBounds().intersects(clientePersonaje.getBounds())) {
                    orden.setLocation(320, 350);
                    Fondoescenario.add(orden);
                    clientePersonaje.Comer(orden);
                    barra.QuitarComida(orden.getUrlImage());
                }
                if (LBobEsponja.getBounds().intersects(orden.getBounds()) && barra.OrdenAgarrada && clientePersonaje.ordenLista) {
                    barra.AgregarComida(orden.getUrlImage());
                    Fondoescenario.remove(orden);
                    clientePersonaje.ordenLista = false;
                }
                if (clientePersonaje.terminarComida) {
                    Fondoescenario.remove(orden);
                    clientePersonaje.MoverClienteEliminar(Fondoescenario, 100, 300);
                }
                System.out.println(segundos);
                segundos++;
                revalidate();
                repaint();
            }
        });
        tiempoCliente.start();
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
                        if (VerificarColisionMesas()) {
                            x += 10;
                        } else {
                            x -= 20;
                        }
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    if (x != 0) {
                        if (VerificarColisionMesas()) {
                            x -= 10;
                        } else {
                            x += 20;
                        }
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    if (y != 300) {
                        if (VerificarColisionMesas()) {
                            y -= 10;
                        } else {
                            y += 20;
                        }
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    if (y != 660) {
                        if (VerificarColisionMesas()) {
                            y += 10;
                        } else {
                            y -= 20;
                        }
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

    private void CrearMesas() {
//        for (int i = 0; i < EntornoMesa.length; i++) {
//            EntornoMesa[i] = new EntornoMesa();
//            EntornoMesa[i].setBounds(EntornoMesa[i].getCoordenadasX()[i], EntornoMesa[i].getCoordenadasY()[i], 100,100);
//            Fondoescenario.add(EntornoMesa[i]);
//        }
    }

    private void CrearEscenario() {
        Image img = new ImageIcon(getClass().getResource("../Resource/fondoJuego.png")).getImage();
        escenario.setIcon(new ImageIcon(img.getScaledInstance(App.WITDH, App.HEIGHT, Image.SCALE_SMOOTH)));
        escenario.setBounds(0, 0, App.WITDH, App.HEIGHT);
        add(escenario);
    }

    private boolean VerificarColisionMesas() {
        return true;
//        return (!LBobEsponja.getBounds().intersects(EntornoMesa[0].getBounds())
//                && !LBobEsponja.getBounds().intersects(EntornoMesa[1].getBounds())
//                && !LBobEsponja.getBounds().intersects(EntornoMesa[2].getBounds())
//                && !LBobEsponja.getBounds().intersects(EntornoMesa[3].getBounds()));
    }

    private void CrearCliente() {
        clientePersonaje.CrearCliente(Fondoescenario);
    }

    private void Ordenes() {
        orden.setLocation(1000, 690);
    }

    private EntornoMesa[] EntornoMesa = new EntornoMesa[4];
    private JLabel LBobEsponja = new JLabel();
    private JLabel escenario = new JLabel();
    private personaje datosPersonaje = new bobEsponja(400, 450, 100, 100);
    private bobEsponja bob;
    private int segundos = 0;
    private Cliente clientePersonaje = new Cliente(100, 300, 100, 100);
    private JLabel Fondoescenario = new JLabel();
    private Orden orden = new Orden("../Resource/cangreburger.png");
    private BarraComida barra = new BarraComida();
}
