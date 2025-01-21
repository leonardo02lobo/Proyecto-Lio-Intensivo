package View;

import Models.*;
import Models.Entidades.EntornoMesa;
import Models.Entidades.Mesa;

import java.awt.*;
import javax.swing.*;

public class Juego extends JPanel{
    
    public Juego(){
        setLayout(null);
        ((bobEsponja)datosPersonaje).mover(LBobEsponja);
        add(LBobEsponja);

         add(new EntornoMesa());
        
        
        Image img = new ImageIcon(getClass().getResource("../Resource/fondoJuego.png")).getImage();
        escenario.setIcon(new ImageIcon(img.getScaledInstance(App.WITDH, App.HEIGHT, Image.SCALE_SMOOTH)));
        escenario.setBounds(0, 0, App.WITDH, App.HEIGHT);
        //add(escenario);
    }
    
    private JLabel LBobEsponja = new JLabel();
    private JLabel escenario = new JLabel();
    private personaje datosPersonaje = new bobEsponja(20, 20, 100, 100, new String[]{"../Resource/bob-esponja1.png",
    "../Resource/bob-esponja2.png","../Resource/bob-esponja3.png"});
}
