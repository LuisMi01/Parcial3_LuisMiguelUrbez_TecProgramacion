package org.example.Ejercicio8;

public class Arista {

        private String origen;
        private String destino;
        private int distancia;

        public Arista(String origen, String destino, int distancia) {
            this.origen = origen;
            this.destino = destino;
            this.distancia = distancia;
        }

        public String getOrigen() {
            return origen;
        }

        public String getDestino() {
            return destino;
        }

        public int getDistancia() {
            return distancia;
        }
    }

