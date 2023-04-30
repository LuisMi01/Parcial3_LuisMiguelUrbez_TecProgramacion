package org.example;

public class Main {
    public static void main(String[] args) {
        barco Barco = new barco();
        Barco.addPuerto("A");
        Barco.addPuerto("B");
        Barco.addPuerto("C");
        Barco.addPuerto("D");
        Barco.addPuerto("E");

        Barco.addArista("A", "B", 1);
        Barco.addArista("A", "C", 2);
        Barco.addArista("B", "D", 3);
        Barco.addArista("C", "D", 4);
        Barco.addArista("C", "E", 5);


        Barco.barridoEnProfundidad("A");
        System.out.println(Barco.caminoMasCorto("A", "E"));




    }
}