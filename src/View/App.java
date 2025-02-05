package View;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {
    public static int WITDH = 800, HEIGHT = 800;
    public static JFrame v = null;

    public static void main(String[] args){
        CrearFrame(new Principal());
    }

    public static void CrearFrame(JPanel panel) {
        v = new JFrame();
        v.setDefaultCloseOperation(3);
        v.setSize(App.WITDH, App.HEIGHT);
        v.add(panel);
        v.setResizable(false);
        v.setLocationRelativeTo(null);
        v.setTitle("Krusty Krab");
        v.setVisible(true);
    }

    public static void CerraFrame(){
        if(v != null){
            v.dispose();
        }
    }
}
