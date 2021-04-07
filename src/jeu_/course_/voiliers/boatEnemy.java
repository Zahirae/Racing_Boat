
package jeu_.course_.voiliers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class boatEnemy extends gameObject{
    
    private handler handler;
    private Jeu_Course_Voiliers game;

    public boatEnemy(int x, int y, Id id, handler handler,Jeu_Course_Voiliers game) {
        super(x, y, id);
        this.handler = handler;
        this.game=game;
        
    }

    @Override
    public void tick() {
        x += velocityX;
        y += velocityY;
        velocityX = 3;
        x = Jeu_Course_Voiliers.clamp(x,0,Jeu_Course_Voiliers.WIDTH-40);
        y = Jeu_Course_Voiliers.clamp(y,0,Jeu_Course_Voiliers.HEIGHT-60);
        colision();
    }

    @Override
    public void render(Graphics g) {
     
        g.setColor(Color.PINK);             
        g.fillRect(x, y, 18, 18);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,100,100);
    }
    
     public void colision(){
        
        for (gameObject object : handler.object) {
            if(object.GetId() == Id.rock || object.id == Id.smalRock ||  object.id == Id.OFNI){
                if(getBounds().intersects(object.getBounds()))
                    changeDirection();
            }
            else if(object.GetId() == Id.goal){
                if(getBounds().intersects(object.getBounds()))
                game.gameState = Jeu_Course_Voiliers.STATE.gameOver;
            }
            //else this.setVelocityX(3);
        }
        
    }
     
    public void changeDirection(){
        
        if(this.GetX()>=443 && this.GetX()< 880){
            this.setVelocityX(0);
            this.setVelocitY(-3);
        }
        if(this.GetX()>=0 && this.GetX()<= 443){
            this.setVelocityX(0);
            this.setVelocitY(6);
        }
        if(this.GetX()> 880 && this.GetX()<= 1370){
            this.setVelocityX(3);
            this.setVelocitY(0);
        }
            
    }
    
}
