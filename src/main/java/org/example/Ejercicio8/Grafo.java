package org.example.Ejercicio8;
import java.util.*;

public class Grafo {

    private final Map<String, Set<Arista>> mapaVertices;

    public Grafo() {
        mapaVertices = new HashMap<String, Set<Arista>>();
    }

    //Puertos
    public void agregarVertice(String vertice) {
        if (!mapaVertices.containsKey(vertice)) {
            mapaVertices.put(vertice, new HashSet<Arista>());
        }
    }

    //camino a puertos
    public void agregarArista(String origen, String destino, int distancia) {
        agregarVertice(origen);
        agregarVertice(destino);

        Arista arista1 = new Arista(origen, destino, distancia);
        Arista arista2 = new Arista(destino, origen, distancia);

        mapaVertices.get(origen).add(arista1);
        mapaVertices.get(destino).add(arista2);
    }


    //barrido
    public List<String> barridoProfundidad(String inicio) {
        Set<String> visitados = new HashSet<String>();
        List<String> resultado = new ArrayList<String>();
        barridoProfundidadRecursivo(inicio, visitados, resultado);
        return resultado;
    }

    //tipo de barrido
    private void barridoProfundidadRecursivo(String vertice, Set<String> visitados, List<String> resultado) {
        visitados.add(vertice);
        resultado.add(vertice);

        for (Arista arista : mapaVertices.get(vertice)) {
            String destino = arista.getDestino();
            if (!visitados.contains(destino)) {
                barridoProfundidadRecursivo(destino, visitados, resultado);
            }
        }
    }

    //buscar camino mas corto
    public List<String> caminoMasCorto(String origen, String destino) {
        Map<String, Integer> distancia = new HashMap<String, Integer>();
        Map<String, String> padre = new HashMap<String, String>();
        PriorityQueue<String> cola = new PriorityQueue<String>(new ComparadorDistancia(distancia));

        for (String vertice : mapaVertices.keySet()) {
            distancia.put(vertice, Integer.MAX_VALUE);
            padre.put(vertice, null);
        }

        distancia.put(origen, 0);
        cola.add(origen);

        while (!cola.isEmpty()) {
            String actual = cola.poll();

            if (actual.equals(destino)) {
                break;
            }

            for (Arista arista : mapaVertices.get(actual)) {
                String vecino = arista.getDestino();
                int peso = arista.getDistancia();
                int nuevaDistancia = distancia.get(actual) + peso;

                if (nuevaDistancia < distancia.get(vecino)) {
                    distancia.put(vecino, nuevaDistancia);
                    padre.put(vecino, actual);
                    cola.add(vecino);
                }
            }
        }

        List<String> resultado = new ArrayList<String>();
        String actual = destino;
        while (actual != null) {
            resultado.add(0, actual);
            actual = padre.get(actual);
        }

        return resultado;
    }

    //Eliminar el vertice con mas aristas
    public void eliminarVerticeConMasAristas() {
        String verticeConMasAristas = null;
        int maxAristas = -1;

        for (String vertice : mapaVertices.keySet()) {
            int aristas = mapaVertices.get(vertice).size();
            if (aristas > maxAristas) {
                maxAristas = aristas;
                verticeConMasAristas = vertice;
            }
        }

        if (verticeConMasAristas != null) {
            mapaVertices.remove(verticeConMasAristas);
            for (Set<Arista> aristas : mapaVertices.values()) {
                Iterator<Arista> iter = aristas.iterator();
                while (iter.hasNext()) {
                    Arista arista = iter.next();
                    if (arista.getDestino().equals(verticeConMasAristas)) {
                        iter.remove();
                    }
                }
            }
        }
    }

    //Imprimir el grafo completo
    public void imprimirGrafo(){
        System.out.println("Vertices: ");
        for (String vertice : mapaVertices.keySet()) {
            System.out.print(vertice + " ");
        }
        System.out.println("\nAristas: ");
        for (String vertice : mapaVertices.keySet()) {
            for (Arista arista : mapaVertices.get(vertice)) {
                System.out.println(arista.getOrigen() + " -> " + arista.getDestino() + " (" + arista.getDistancia() + ")");
            }
        }
    }
}




