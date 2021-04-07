
package jeu_.course_.voiliers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
  Représente la ligne d'arrivée
 */
public class goal extends gameObject{

    public goal(int x, int y, Id id) {
        super(x, y, id);
    }

    @Override
    public void tick() {
       // x += velocityX;
        //y += velocityY; 
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y,10 , 1370);
    }
    
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,10,1370);
    }
    
}
