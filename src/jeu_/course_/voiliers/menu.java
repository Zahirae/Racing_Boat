
package jeu_.course_.voiliers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import jeu_.course_.voiliers.Jeu_Course_Voiliers.STATE;

/*
 continet les page de "wining" et "game Over"
*/
public class menu  {
    private Jeu_Course_Voiliers game;
    private handler handler;
    
    public menu(Jeu_Course_Voiliers game, handler handler){
        this.game = game;
        this.handler = handler;
    }
    
        
    public void tick(){
        handler.tick();
    }
    
    public void render(Graphics g){
        //si le joueur a perdu.  
         if(game.gameState == STATE.gameOver){
            Font ftn1 = new Font("arial",1,50);
            g.setFont(ftn1);
            g.setColor(Color.red);
            g.drawString("Jeu terminé", 480, 230);
             Font ftn2 = new Font("arial",1,30);
            g.setFont(ftn2);
            g.drawString("Vous avez perdu", 505, 300);
        }
         //si le joueur est gagné   
        else if(game.gameState == STATE.wining){
            Font ftn1 = new Font("arial",1,50);
            g.setFont(ftn1);
            g.setColor(Color.white);
            g.drawString("Félicitations", 480, 130);
             Font ftn2 = new Font("arial",1,30);
            g.setFont(ftn2);
            g.drawString("Vous gagnez", 530, 190);
        }
    }
    
}
