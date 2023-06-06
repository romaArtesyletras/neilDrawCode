package BasicExercises;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 *
 * @author @author Romario - estradaflorezromario@artesyletras.edu.co
 */
public class Ventana extends JFrame {

    public static final long serialVersionUID = 1L;
    
    private Panel panel;

    public Ventana() {
        // Diseño
        setTitle("Neil draw - Romario Estrada");
        setSize(930,940);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setBackground(Color.black);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 1));
        setLocationRelativeTo(null);

        panel = new Panel();

        add(panel);
    }

    public static void main(String[] args){
        // JFrame ventana = new JFrame("Lineas - Circulares - Mariquita");
        // Panel codigo = new Panel();

        // ventana.add(codigo);
        // ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ventana.setBackground(Color.white);
        // ventana.setSize(400, 400);
        // ventana.setLocationRelativeTo(null);
        // ventana.setVisible(true);
        // ventana.setResizable(false);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                new Ventana().setVisible(true);
            }
        });
    } 
}
