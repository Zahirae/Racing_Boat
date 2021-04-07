
package jeu_.course_.voiliers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
  Permet de contrôler le voilier par le clavier
 */
public class keyInput extends KeyAdapter{
    
    private handler handler;
    public keyInput(handler handler){
        this.handler = handler;
    }
    @Override
    //détecter qu'une touche est enfoncée
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        for(int i=0; i< handler.object.size();i++){
            gameObject tempObj = handler.object.get(i);
            System.out.print(tempObj);
            if(tempObj.GetId()== Id.boatPlayer){
                // Si le voilier est dans la premiere zone son viteese est normal
                if(tempObj.GetX()>=443 && tempObj.GetX()<= 880){
                    if(KeyEvent.VK_UP==key)
                        tempObj.setVelocitY(-5);
                    if(KeyEvent.VK_DOWN ==key) 
                        tempObj.setVelocitY(6);
                    if(KeyEvent.VK_RIGHT==key) 
                        tempObj.setVelocityX(6);
                    if(KeyEvent.VK_LEFT==key) 
                        tempObj.setVelocityX(-6);                   
                                             
                }
                //Si le voilier est dans la deuxième zone son vitesse est demine face aux vagues
                 if(tempObj.GetX()>=0 && tempObj.GetX()<= 443){
                    if(KeyEvent.VK_UP==key)
                        tempObj.setVelocitY(-6);
                    if(KeyEvent.VK_DOWN==key) 
                        tempObj.setVelocitY(6);
                    if(KeyEvent.VK_RIGHT==key) 
                        tempObj.setVelocityX(6);
                    if(KeyEvent.VK_LEFT==key) 
                        tempObj.setVelocityX(-6);                   
                                             
                }
                //Si le voilier est dans la deuxième zone son vitesse est demine face aux vagues
                 if(tempObj.GetX()>=880 && tempObj.GetX()<= 1370){
                    if(KeyEvent.VK_UP==key)
                        tempObj.setVelocitY(-6);
                    if(KeyEvent.VK_DOWN==key) 
                        tempObj.setVelocitY(6);
                    if(KeyEvent.VK_RIGHT==key) 
                        tempObj.setVelocityX(5);
                    if(KeyEvent.VK_LEFT==key) 
                        tempObj.setVelocityX(-6);                   
                                             
                }
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for(int i=0; i< handler.object.size();i++){
            gameObject tempObj = handler.object.get(i);
            System.out.print(tempObj);
            if(tempObj.GetId()== Id.boatPlayer){
                
               if(KeyEvent.VK_UP==key) 
                   tempObj.setVelocitY(0);
               if(KeyEvent.VK_DOWN==key) 
                   tempObj.setVelocitY(0);
               if(KeyEvent.VK_RIGHT==key) 
                   tempObj.setVelocityX(0);
               if(KeyEvent.VK_LEFT==key) 
                   tempObj.setVelocityX(0);
                   
            }
        }
    }
}
