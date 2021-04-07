
package jeu_.course_.voiliers;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;


// Canvas pour créer ma propre zone de dessin
public class window extends Canvas{
    public window(int width, int height, String title, Jeu_Course_Voiliers jeu){
        JFrame frame = new JFrame(title);
        
        frame.setPreferredSize(new Dimension(width,height));
        frame.setMaximumSize(new Dimension(width,height));
        frame.setMinimumSize(new Dimension(width,height));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(jeu);
        frame.setVisible(true);
        jeu.start(); 
        
    }
    
}
