
package jeu_.course_.voiliers;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JPanel;


/*
     Point d'entrée de jeu
 */
public class Jeu_Course_Voiliers extends Canvas implements Runnable{

    public static final int WIDTH = 1370, HEIGHT = 725; 
    
    private Thread thread;
    private boolean running = false;
    private handler handler;
    private menu menu;
    private health health;
    public enum STATE{
        game,
        menu,
        gameOver,
        wining
    }
    public STATE gameState = STATE.game; 
    public Jeu_Course_Voiliers(){
        
        handler = new handler();
        menu = new menu(this, handler);
        setFocusable(true); 
        requestFocus();
        this.addKeyListener(new keyInput(handler));
               
        System.out.println("print this"+menu.toString());
       
        // Création de la fenêtre de jeu 
        new window(WIDTH, HEIGHT,"Jeu de Course de Voiliers", this);
        health = new health();
        
        if(gameState == STATE.game){
            handler.addObject(new boatPlayer(10,300,Id.boatPlayer,handler,this));
            //Ajouter des vagues horizontales au jeux
            for(int i =0; i< Jeu_Course_Voiliers.HEIGHT; i+=70){
                handler.addObject(new wave(478,i,Id.horizontalWave));
            }
            //Ajouter des vagues verticales au jeux
            for(int i =1340; i> 880; i-=100){
                handler.addObject(new wave(i,0,Id.verticalWave));
            }

            handler.addObject(new goal(1340,0,Id.goal));
            handler.addObject(new rock(443,0,Id.rock));
            handler.addObject(new rock(880,136,Id.rock));
            handler.addObject(new rock(473,200,Id.smalRock));
            handler.addObject(new OFNI(1200,300,Id.OFNI));
            handler.addObject(new OFNI(270,300,Id.OFNI));
            
            handler.addObject(new boatEnemy(10,200,Id.boatEnemy,handler,this));
            handler.addObject(new boatEnemy(10,470,Id.boatEnemy,handler,this));
             
        }       
    }
    // Démarrer le Thread
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    //Arrêter le Thread
    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Boucle du jeu
    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta+=(now - lastTime)/ns;
            lastTime = now;
            while(delta>=1){
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;
            
            if((System.currentTimeMillis()-timer) > 1000){
                timer += 1000;
             
                frames = 0;
            }
                
        }
        stop();
    }
       
    private void tick(){
        handler.tick();
        health.tick();
    }

    private void render(){
        
        BufferStrategy bs = this.getBufferStrategy();
        if(bs==null){
           this.createBufferStrategy(3);
            return ;
        }
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.blue);
        
        g.fillRect(0, 0, WIDTH, HEIGHT);
        if(gameState == STATE.game){
            handler.render(g);
            health.render(g);
        } 
        if(gameState == STATE.menu || gameState == STATE.gameOver|| gameState == STATE.wining)
           menu.render(g);
        
        g.dispose();
        bs.show();
    }
    
    //Empêcher les objets de sortir de l'écran
    public static int clamp(int val, int min ,int max){
        if(val>= max) 
            return val = max;
        else if(val<= min)
            return val = min;
        else
            return val; 
    }
    
    
    public static void main(String[] args) {
        
        new Jeu_Course_Voiliers();
        
    }
    
}
