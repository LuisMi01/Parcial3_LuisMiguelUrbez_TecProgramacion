package org.example.Ejercicio8;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Grafo {

        private final Map<String, Map<String, Integer>> grafo;

        public Grafo() {
            grafo = new HashMap<>();
        }
        public void nuevoPuerto(){
            Scanner teclado = new Scanner(System.in);
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

    }


