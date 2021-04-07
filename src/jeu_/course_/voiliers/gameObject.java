
package jeu_.course_.voiliers;

import java.awt.Graphics;
import java.awt.Rectangle;

/*
 Cette classe mère de touts les objets de jeu
 */
public abstract class gameObject {
    protected int x,y;
    protected Id id;
    protected int velocityX, velocityY;
    
    public gameObject(int x, int y, Id id){
        this.x = x;
        this.y = y;
        this.id = id;
    }
    
    public void setX(int x){
        this.x = x;
    }
    public int GetX(){
        return this.x;
    }
     public void setY(int y){
        this.y = y;
    }
    public int GetY(){
        return this.y;
    }
    
     public void setId(Id id){
        this.id = id;
    }
    public Id GetId(){
        return this.id;
    }
    
     public void setVelocityX(int velx){
        this.velocityX = velx;
    }
    public int GetVelocityX(){
        return this.velocityX;
    }
    
     public void setVelocitY(int vely){
        this.velocityY = vely;
    }
    public int GetVelocitY(){
        return this.velocityY;
    }
    
    /******************** les méthodes abstraites***********************/
    //controler le mouvement 
    public abstract void tick();
    //la représentation graphique 
    public abstract void render(Graphics g);
    //Stocker l'emplacement et les dimensions de voilier
    public abstract Rectangle getBounds();
    
}
