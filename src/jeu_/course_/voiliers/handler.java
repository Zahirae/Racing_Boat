
package jeu_.course_.voiliers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.LinkedList;

/**
 Contrôler et manipuler les objets de jeu
 */
public class handler {
    //list qui va contenir tous les objet de jeu
     LinkedList<gameObject> object = new LinkedList<gameObject>();
     
     //Parcourir la liste des objets de jeu est appelé la méthode tick() de chacun
     public void tick(){
         for(int i = 0; i<object.size();i++){
             gameObject tempObject = object.get(i);
             tempObject.tick();
         }
     }
     
     public void render(Graphics g){
        //Parcourir la liste des objets de jeu est appelé la méthode render() de chacun
        for(int i = 0; i<object.size();i++){
             gameObject tempObject = object.get(i);
             tempObject.render(g);
         }
        //aficher les informations concernant le vent, le courant et la hauteur des vaguespour chaque zone de la carte .

        g.setColor(Color.black);
        Font ftn1 = new Font("arial",1,15);
        g.setFont(ftn1);
        g.drawString("direction de vent | ", 520, 20);
        g.drawString("hauteur des vagues: 1m ", 520, 40);
        g.drawString("courant : Dans la direction de vent", 520, 60);
        g.drawString("direction de vent <-- ", 960, 20);
        g.drawString("hauteur des vagues: 2m ", 960, 40);
        g.drawString("courant : Dans la direction de vent", 960, 60);
     }
     // ajouter un objet a la liste
     public void addObject(gameObject gobj){
         this.object.add(gobj);
     }
     //suprimer un objet a la liste
     public void removeObject(gameObject gobj){
         this.object.remove(gobj);
     }
}
