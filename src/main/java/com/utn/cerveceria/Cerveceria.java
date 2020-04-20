package com.utn.cerveceria;

public class Cerveceria {

	public static void main(String[] args) {
	
        //Creo el recurso compartido
        BeerHouse bHouse = new BeerHouse(); 
        //Creo un productor
        BeerProducter producter = new BeerProducter(bHouse);    
        //muestro el stock de cervezas creado
        System.out.println("available stock :"+producter.getStock());
        //Creo Consumidor
        BeerConsumer consumer = new BeerConsumer(bHouse);      
        
        //lalmo al medoto run de cada hilo
        producter.start(); 
        consumer.start();
    
                
	}

}


