package com.tallerjava.tp1.problema4;

import java.lang.reflect.Array;

public class FotografiaArtistica {
    public static int getCantFotosArtisticas(char[] A, int X, int Y){

        // Estrategia de fuerza bruta
        int n = A.length;
        int cantFotosArtisticas = 0;
        int i = 0;
        // Primero recorremos el arreglo para encontrar un fotografo
        while (i < n) {
            if (A[i] == 'f') {
                int j = 0;
                // Si lo encontramos, buscamos un artista
                while (j < n) {
                    // Calculamos la distancia entre el fotografo y el artista
                    int distFA = Math.abs(i - j);
                    if (A[j] == 'a' && distFA >= X && distFA <= Y) {
                        int k = 0;
                        // Si la distancia esta dentro del rango, buscamos un escenario
                        while (k < n) {
                            int distAE = Math.abs(j - k);
                            if (A[k] == 'e' && distAE >= X && distAE <= Y) {
                                // Verifcamos que la secuencia sea en la misma direccion. (izq y der)
                                boolean mismaDireccion = ((j - i) > 0 && (k - j) > 0) || ((j - i) < 0 && (k - j) < 0);
                                if (mismaDireccion)
                                    // Si es asi, incrementamos la cantidad de fotos artisticas
                                    cantFotosArtisticas++;
                            }
                            k++;
                        }
                    }
                    j++;
                }
            }
            i++;
        }
        return cantFotosArtisticas;
    }
}
