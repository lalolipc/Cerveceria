package com.utn.cerveceria;

import java.util.logging.Level;
import java.util.logging.Logger;

//BeerConsumer es una subclase de Thread 

public class BeerConsumer extends Thread{
   
//utilizaremos el recurso compartido
    BeerHouse bHouse;
    
    public BeerConsumer(BeerHouse bHouse) {
        this.bHouse = bHouse;
    }
    
    //al ser subclase de Thread puede sobreescribir Metodo run
    @Override
    public void run() {
        
         while (true) {
               int value=bHouse.consuming();//obtener de a 1 cerveza
               System.out.println("Cosumer got beers number: "+value); 
               
               //dormimos el hilo 1 segundo cada vez que consuma
               
             try {
                 Thread.sleep(1000);
             } catch (InterruptedException ex) {
                 Logger.getLogger(BeerConsumer.class.getName()).log(Level.SEVERE, null, ex);
             }
               
          }
         
        }
    }
    
   


