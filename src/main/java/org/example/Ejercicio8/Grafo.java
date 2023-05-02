package org.example.Ejercicio8;
import java.util.*;

public class Grafo {

    private final Map<String, Set<Arista>> mapaVertices;

    public Grafo() {
        mapaVertices = new HashMap<String, Set<Arista>>();
    }

    //Puertos
    public void agregarVertice(String vertice) {
        System.out.println("Se va a agregar un puerto");
        System.out.println("Ingrese el nombre del puerto: ");
        Scanner teclado = new Scanner(System.in);
        vertice = teclado.nextLine();
        if (!mapaVertices.containsKey(vertice)) {
            mapaVertices.put(vertice, new HashSet<Arista>());
        }
    }

    //camino a puertos
    public void agregarArista() {
        System.out.println("Se va a agregar un camino entre puertos");
        System.out.println("Ingrese el nombre del puerto de origen: ");
        Scanner teclado = new Scanner(System.in);
        String origen = teclado.nextLine();
        System.out.println("Ingrese el nombre del puerto de destino: ");
        String destino = teclado.nextLine();
        System.out.println("Ingrese la distancia entre los puertos: ");
        int distancia = teclado.nextInt();
        agregarVertice(origen);
        agregarVertice(destino);

        Arista arista1 = new Arista(origen, destino, distancia);
        Arista arista2 = new Arista(destino, origen, distancia);

        mapaVertices.get(origen).add(arista1);
        mapaVertices.get(destino).add(arista2);
    }

    //barrido
    public List<String> barridoProfundidad() {
        System.out.println("Se va a realizar un barrido en profundidad, ingrese el puerto de inicio:");
        Scanner teclado = new Scanner(System.in);
        String inicio = teclado.nextLine();
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
    public List<String> caminoMasCorto() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el puerto de origen: ");
        String origen = teclado.nextLine();
        System.out.println("Ingrese el puerto de destino: ");
        String destino = teclado.nextLine();

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
        System.out.println("Se va a eliminar el puerto con mas caminos en el");
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
        System.out.println("Se va a imprimir el grafo completo");
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




