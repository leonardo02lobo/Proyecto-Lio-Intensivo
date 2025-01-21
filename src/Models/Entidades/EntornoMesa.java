package Models.Entidades;

import javax.swing.*;

public class EntornoMesa extends JLabel{

    public EntornoMesa(){
        add(mesa);
    }

    private Mesa mesa = new Mesa();
}
