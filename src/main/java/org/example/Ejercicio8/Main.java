package org.example.Ejercicio8;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.addArista("A", "B", 3);
        grafo.addArista("A", "C", 1);
        grafo.addArista("B", "C", 5);
        grafo.addArista("B", "D", 4);
        grafo.addArista("C", "D", 3);
        grafo.addArista("C", "E", 1);

        grafo.barridoEnProfundidad("A");
        System.out.println(grafo.caminoMasCorto("A", "E"));

    }
}
