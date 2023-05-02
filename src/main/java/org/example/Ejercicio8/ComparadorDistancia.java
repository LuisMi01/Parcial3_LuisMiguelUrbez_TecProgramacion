package org.example.Ejercicio8;

import java.util.Comparator;
import java.util.Map;

public class ComparadorDistancia implements Comparator<String> {
    private Map<String, Integer> distancia;

    public ComparadorDistancia(Map<String, Integer> distancia) {
        this.distancia = distancia;
    }

    @Override
    public int compare(String v1, String v2) {
        return distancia.get(v1) - distancia.get(v2);
    }
}
