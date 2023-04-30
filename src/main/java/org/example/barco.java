package org.example;
import java.util.HashMap;
import java.util.Map;

public class barco {

    private Map<String, Map<String, Integer>> grafo;

    public barco() {
        grafo = new HashMap<>();
    }

    public void addPuerto(String puerto) {
        if (!grafo.containsKey(puerto)) {
            grafo.put(puerto, new HashMap<>());
        }
    }

    public void addArista(String puerto1, String puerto2, int distancia) {
        addPuerto(puerto1);
        addPuerto(puerto2);
        grafo.get(puerto1).put(puerto2, distancia);
        grafo.get(puerto2).put(puerto1, distancia);
    }

    public void barridoEnProfundidad(String puertoInicial) {
        Map<String, Boolean> visitados = new HashMap<>();
        barridoEnProfundidadAux(puertoInicial, visitados);
    }

    private void barridoEnProfundidadAux(String puerto, Map<String, Boolean> visitados) {
        visitados.put(puerto, true);
        System.out.println(puerto);
        for (String vecino : grafo.get(puerto).keySet()) {
            if (!visitados.getOrDefault(vecino, false)) {
                barridoEnProfundidadAux(vecino, visitados);
            }
        }
    }

    public int caminoMasCorto(String origen, String destino) {
        Map<String, Integer> distancias = new HashMap<>();
        for (String puerto : grafo.keySet()) {
            distancias.put(puerto, Integer.MAX_VALUE);
        }
        distancias.put(origen, 0);
        caminoMasCortoAux(origen, distancias);
        return distancias.get(destino);
    }

    private void caminoMasCortoAux(String puerto, Map<String, Integer> distancias) {
        for (String vecino : grafo.get(puerto).keySet()) {
            int distancia = distancias.get(puerto) + grafo.get(puerto).get(vecino);
            if (distancia < distancias.get(vecino)) {
                distancias.put(vecino, distancia);
                caminoMasCortoAux(vecino, distancias);
            }
        }
    }

    public String eliminarPuertoConMasAristas() {
        String puertoConMasAristas = null;
        int maxAristas = 0;
        for (String puerto : grafo.keySet()) {
            int aristas = grafo.get(puerto).size();
            if (aristas > maxAristas) {
                puertoConMasAristas = puerto;
                maxAristas = aristas;
            }
        }
        grafo.remove(puertoConMasAristas);
        for (String puerto : grafo.keySet()) {
            grafo.get(puerto).remove(puertoConMasAristas);
        }
        return puertoConMasAristas;
    }
}



