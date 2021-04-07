
package jeu_.course_.voiliers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 Représente le mur de pierre
 */
public class rock extends gameObject{

    public rock(int x, int y, Id id) {
        super(x, y, id);
    }

    @Override
    public void tick() {
        x += velocityX;
        y += velocityY; 
        
    }
    
    @Override
    public Rectangle getBounds() {
        Rectangle rec = new Rectangle();
        if(id == Id.rock)
            rec = new Rectangle(x,y,30,560);
        else if (id == Id.smalRock)
            rec = new Rectangle(x,y,280,30); 
        return rec;      
    }

    @Override
    public void render(Graphics g) {
       
            g.setColor(Color.DARK_GRAY);
        if(id == Id.rock)
            g.fillRect(x, y,30 , 560);
        if(id == Id.smalRock)
            g.fillRect(x, y,280 , 30);
    }
    
   
    
}
