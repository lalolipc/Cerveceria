package com.utn.cerveceria;

//BeerProducter es una subclase de Thread 
public class BeerProducter extends Thread{
 
    //utilizaremos el recurso compartido
BeerHouse bHouse;  
    //maximo 100 cervezas puede producir
int stock=(int)(100*Math.random());
 
    public BeerProducter(BeerHouse bHouse) {
       super();
       
       this.bHouse = bHouse;
    }
        //metodo para retornar la cantidad total q productos:
    public int getStock() {
        return stock;
    }
    
        //sobreescribo el metodo run de la clase Thread 
    public void run() {
        for (int i = 1; i < stock; i++) {
       //vamos agregando cervezas del stock 
                bHouse.producing(i);
              
           
    }
    }
}

