package com.utn.cerveceria;


public class BeerHouse {
    private int stock;  //cantidad total que producio 
    private boolean available = false;
    
    //El metodo synchronized evita que varios hilos interfieran entre si
    
    public synchronized void producing(int value) {
        //EL patron estandar de synchronized es-> while(condicion) wait()  
        while (available) { //si house tiene cervezas
       
            try {
                wait(); //me quedo esperando
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    //si house esta vacia
           
        System.out.println("Producing beers");
        this.stock = value;//rellenar stock con el valor indicado en parametro
        available = true;// "disponible",es decir ahora si tiene cervezas
        notifyAll();//despierto a todos los hilos
    }

    public synchronized int consuming() {

        while (!available) { //Mientras Bhouse este vacia
            try {
                wait();//espero al productor produzca
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    //pero si house tiene cervezas entonces...
            
        int number = this.stock;//almaceno el numero de cerveza ej: cerveza 3
        available = false;// "no disponible",porque ya consumir lo que habia
        notifyAll();//despierto todos los hilos
        return number;//retorna el Nro de cerbeza consumida
        
    }
    
    
        
   

}
