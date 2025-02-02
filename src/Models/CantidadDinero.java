package Models;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class CantidadDinero extends JLabel{

    public CantidadDinero(){
        setLayout(null);
        setBounds(800,0,400,60);
        setForeground(Color.white);
        setFont(new Font("Arial",Font.BOLD,28));
        setText("Cantidad de Dinero: 0$");
    }
    
    public void setDinero(int dinero) {
        this.dinero += dinero;
        setText("Cantidad de Dinero: "+this.dinero+"$");
    }
    
    private int dinero = 0;
    public boolean OrdenTerminada = false;
}
