

package jeu_.course_.voiliers;

import java.awt.Color;
import java.awt.Graphics;


public class health {
    
    public static float health = 1000000000;
    public void tick(){
        
        health = Jeu_Course_Voiliers.clamp((int) health, 0, 100);
    }
    
    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.green);
        g.fillRect(15, 15, (int) (health*2), 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, (int) (health*2), 32);
    }
    
}
