
package jeu_.course_.voiliers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import jeu_.course_.voiliers.Jeu_Course_Voiliers.STATE;

/*
Cette classe représente le voilier
 */
public class boatPlayer extends gameObject{
    private handler handler;
    private Jeu_Course_Voiliers game;
    
    public boatPlayer(int x, int y, Id id,handler handler,Jeu_Course_Voiliers game) {
        super(x, y, id);
        this.handler = handler;
        this.game=game;
       
        
    }
    // controler le mouvement le voilier
    @Override
    public void tick() {
        x += velocityX;
        y += velocityY;
        x = Jeu_Course_Voiliers.clamp(x,0,Jeu_Course_Voiliers.WIDTH-40);
        y = Jeu_Course_Voiliers.clamp(y,0,Jeu_Course_Voiliers.HEIGHT-60);
        colision();
}
    //la représentation graphique le voilier
    @Override
    public void render(Graphics g) {
        if(id==Id.boatPlayer)
            g.setColor(Color.white);
        else{
            g.setColor(Color.red);
        }
             
        g.fillRect(x, y, 18, 18);
    }
    
    // Stocker l'emplacement et les dimensions de voilier
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,18,18);
    }
    //Détecter  les colision entre le voilier et les autre objets de jeu
    public void colision(){
        
        for (gameObject object : handler.object) {
            if(object.GetId() == Id.rock || object.id == Id.smalRock || object.id == Id.OFNI || health.health == 0){
                if(getBounds().intersects(object.getBounds()))
                    game.gameState = STATE.gameOver;
            }
            else if(object.GetId() == Id.goal){
                if(getBounds().intersects(object.getBounds()))
                game.gameState = STATE.wining;
            }               
             else if(object.GetId() == Id.horizontalWave || object.GetId() == Id.verticalWave  ){
                 if(getBounds().intersects(object.getBounds()))
                    health.health -= 0.00001;
             }
                
        }
        
    }
    public void Speed(){
        
    }
    
   
}
