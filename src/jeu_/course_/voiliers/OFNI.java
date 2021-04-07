
package jeu_.course_.voiliers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 Objet Flottant Non Identifié
 */
public class OFNI extends gameObject{

    public OFNI(int x, int y, Id id) {
        super(x, y, id);
        velocityY=5;
    }
// le mouvment de l'objet
    @Override
    public void tick() {
        x += velocityX;
        y += velocityY; 
        if(y<=0|| y>= Jeu_Course_Voiliers.HEIGHT-20) velocityY*=-1;
    }
// la representation graphique de l'objet
    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        if(id == Id.OFNI){
            g.fillRect(x, y,20 , 20);
            
        }
        
       
    }
//Stocker l'emplacement et les dimensions de l'objet
    @Override
    public Rectangle getBounds() {
         Rectangle rec = new Rectangle();
        if(id == Id.OFNI)
            rec = new Rectangle(x,y,20,20);
        return rec;
    }
    
}
