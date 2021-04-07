
package jeu_.course_.voiliers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class wave extends gameObject{
    private Thread thread;
    public wave(int x, int y, Id id) {
        super(x, y, id);
         if(id== Id.verticalWave)
             this.velocityX = -2;
        if(id== Id.horizontalWave)
            this.velocityY = 1;
       
    }

    @Override
    public void tick() {
        x += velocityX;
        y += velocityY;
         
        if(id== Id.horizontalWave){
             if(y<=0|| y>= Jeu_Course_Voiliers.HEIGHT-20) 
                 this.setY(0);
        } if(id== Id.verticalWave){
            if(x<=895 || x>= Jeu_Course_Voiliers.WIDTH-20) 
                 this.setX(1300);
        }                
    }

    @Override
    public void render(Graphics g) {      
        g.setColor(Color.WHITE);
        if(id== Id.verticalWave){
           g.fillRect(x, y,1, 1300);            
        }else if(id== Id.horizontalWave){
           g.fillRect(x, y,400, 1); 
           
        }
        
        
    }

    @Override
    public Rectangle getBounds() {
        Rectangle rec = new Rectangle();
        if(id== Id.verticalWave)
            rec = new Rectangle(x,y,1,1300); 
        if(id== Id.horizontalWave)
            rec = new Rectangle(x,y,400,1); 
        return rec;
    }

    
     
}
