package Models;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cliente extends personaje {

    private JLabel cliente = new JLabel();
    private Image img;
    public boolean ordenLista = false;
    public boolean terminarComida = false;
    private Timer segundosComida, comiendo;
    private int segundos = 0;
    private JLabel panelJuego;
    private Orden orden = new Orden();
    private JLabel personaje;
    private BarraComida barra;
    private CantidadDinero cantidadDinero;
    private int numeroComida = 0;
    private boolean[] mesasOcupadas = {false,false,false,false,false,false};
    private int[] posicionMesasX ={250,500,700,950,400,720};
    private int[] posicionMesasY ={300,300,300,300,450,450};

    public Cliente(int x, int y, int width, int height, JLabel panelJuego, JLabel personaje, BarraComida barra, CantidadDinero cantidadDinero) {
        super(x, y, width, height, null);
        this.panelJuego = panelJuego;
        this.personaje = personaje;
        this.barra = barra;
        this.cantidadDinero = cantidadDinero;
        Ordenes();
        setSprites(new String[]{"../Resource/Personajes/Calamardo/calamardo.png"});
    }

    private void Ordenes() {
        orden.setLocation(1000, 690);
    }

    public void IniciarRecorrido() {
        Timer tiempoCliente = new Timer(1000, new ActionListener() {
            int numerorandom = PosicionRandom();
            @Override
            public void actionPerformed(ActionEvent e) {
                if (segundos == 5) {
                    CrearCliente();
                }
                if (segundos == 10) {
                    MoverCliente(posicionMesasX[numerorandom], posicionMesasY[numerorandom]);
                }
                if (ordenLista) {
                    orden.CrearOrden("../Resource/comida"+numeroComida+".png");
                    panelJuego.add(orden);
                }
                if (personaje.getBounds().intersects(cliente.getBounds())) {
                    if(numerorandom % 2 == 0){
                        orden.setLocation(posicionMesasX[numerorandom]+70, posicionMesasY[numerorandom]+20);
                    }else{
                        orden.setLocation(posicionMesasX[numerorandom]-40, posicionMesasY[numerorandom]+20);
                    } 
                    panelJuego.add(orden);
                    Comer(orden);
                    barra.QuitarComida(orden.getUrlImage());
                }
                if (personaje.getBounds().intersects(orden.getBounds()) && barra.OrdenAgarrada && ordenLista) {
                    barra.AgregarComida(orden.getUrlImage());
                    panelJuego.remove(orden);
                    ordenLista = false;
                }
                if (terminarComida && !cantidadDinero.OrdenTerminada) {
                    panelJuego.remove(orden);
                    cantidadDinero.setDinero(20);
                    cantidadDinero.OrdenTerminada = true;
                    MoverClienteEliminar(100, 300);
                }
                segundos++;
                panelJuego.revalidate();
                panelJuego.repaint();
            }
        });
        tiempoCliente.start();
    }

    public void CrearCliente() {
        img = new ImageIcon(getClass().getResource(getSprites()[0])).getImage();
        cliente.setIcon(new ImageIcon(img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)));
        cliente.setBounds(getX(), getY(), getWidth(), getHeight());
        panelJuego.add(cliente);
    }

    public void MoverCliente(int posicionX, int posicionY) {

        timecharacter = new Timer(100, new ActionListener() {
            int x = cliente.getX();
            int y = cliente.getY();

            @Override
            public void actionPerformed(ActionEvent e) {
                if (x == posicionX && y == posicionY) {
                    cliente.setSize(cliente.getWidth(), cliente.getHeight() + 30);
                    pedirComida();
                    timecharacter.stop();
                    return;
                }
                if (cliente.getBounds().x >= posicionX) {
                    x -= 10;
                } else {
                    x += 10;
                }
                if (cliente.getBounds().y < posicionY) {
                    y += 10;
                }
                cliente.setLocation(x, y);
            }
        });
        timecharacter.start();
    }

    public void MoverClienteEliminar(int posicionX, int posicionY) {
        img = new ImageIcon(getClass().getResource("../Resource/Personajes/Calamardo/calamardo.png")).getImage();
        cliente.setIcon(new ImageIcon(img.getScaledInstance(cliente.getWidth(), cliente.getHeight(), Image.SCALE_SMOOTH)));
        timecharacter = new Timer(100, new ActionListener() {
            int x = cliente.getX();
            int y = cliente.getY();

            @Override
            public void actionPerformed(ActionEvent e) {
                if (x == posicionX && y == posicionY) {
                    timecharacter.stop();
                    panelJuego.remove(cliente);
                    return;
                }
                if (cliente.getBounds().x >= posicionX) {
                    x -= 10;
                } else {
                    x += 10;
                }
                if (y != posicionY) {
                    if (cliente.getBounds().y > posicionY) {
                        y -= 10;
                    }
                }
                cliente.setLocation(x, y);
            }
        });
        timecharacter.start();
    }

    public void pedirComida() {
        img = new ImageIcon(getClass().getResource("../Resource/Personajes/Calamardo/calamardo-pensando.png")).getImage();
        cliente.setIcon(new ImageIcon(img.getScaledInstance(cliente.getWidth(), cliente.getHeight(), Image.SCALE_SMOOTH)));
        segundosComida = new Timer(1000, new ActionListener() {
            int segundos = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                segundos++;
                if (segundos == 5) {
                    ordenLista = true;
                    numeroComida = NumeroAleatorio();
                    img = new ImageIcon(getClass().getResource("../Resource/Personajes/Calamardo/calamardo-orden"+numeroComida+".png")).getImage();
                    cliente.setIcon(new ImageIcon(img.getScaledInstance(cliente.getWidth(), cliente.getHeight(), Image.SCALE_SMOOTH)));
                    segundosComida.stop();
                }
            }
        });
        segundosComida.start();
    }

    public void Comer(JLabel comida) {
        if (cliente.getBounds().intersects(comida.getBounds())) {
            Comiendo();
        }
    }

    private void Comiendo() {
        comiendo = new Timer(1000, new ActionListener() {
            int segundos = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                segundos++;
                if (segundos == 5) {
                    terminarComida = true;
                    comiendo.stop();
                }
            }
        });
        comiendo.start();
    }

    public Rectangle getBounds() {
        return cliente.getBounds();
    }
    
    public int NumeroAleatorio(){
        return (int) (Math.random() * (2-1+1) + 1);
    }
    public int PosicionRandom(){
        return (int)(Math.random() * (posicionMesasX.length-1+1)+1)-1;
    }
}
