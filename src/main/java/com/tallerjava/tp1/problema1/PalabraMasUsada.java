package com.tallerjava.tp1.problema1;

import java.util.HashMap;
import java.util.Map;

public class PalabraMasUsada {

    /*

    Problema 1: Palabra más usada

    Se desea implementar un sistema que dado un String retorne la palabra más usada.
    Las palabras son divididas por la existencia de espacios o caracteres diferentes a letras entre las mismas.
    Solo se considera como palabra a toda secuencia de caracteres con una longitud mayor o igual a N donde N es un parámetro.
    Finalmente, la igualdad entre las palabras debe ignorar el uso de mayúsculas y minúsculas.

    */

    public static String getPalabraMasUsada(String texto, int longMinima) throws IllegalArgumentException {

        // Para evitar que la longitud mínima de las palabras sea menor a 1
        if (longMinima < 1){
            throw new IllegalArgumentException("La longitud mínima de las palabras debe ser mayor a 0");
        }

        Map<String, Integer> palabrasRepetidas = new HashMap<>();
        String palabra = "";

        // Se recorre el texto completo caracter por caracter
        for (int i = 0; i < texto.length(); i++) {
            char carac = texto.charAt(i);
            // Si el caracter actual es una letra, se normaliza a minuscula para ignorar mayusculas/minusculas.
            if (Character.isLetter(carac)) {
                palabra += Character.toLowerCase(carac);
            } else { // Si no es una letra, o si se superó la longitud mínima, entonces se encontró una palabra candidata a ser la más usada
                if (palabra.length() >= longMinima) {
                    palabrasRepetidas.put(palabra, palabrasRepetidas.getOrDefault(palabra, 0) + 1);
                }
                palabra = ""; // Se reinicia el bufer de palabras
            }
        }

        // Luego de terminar el recorrido de la palabra, se chequea la ultima palabra porque el texto puede no terminar en separador.
        if (palabra.length() >= longMinima) {
            palabrasRepetidas.put(palabra, palabrasRepetidas.getOrDefault(palabra, 0) + 1);
        }

        String palabraMasUsada = null;
        int maximo = 0;
        // Por ultimo recorremos el Map para devolver la palabra con mayor frecuencia.
        for (String pal : palabrasRepetidas.keySet()){
            if (palabrasRepetidas.get(pal) > maximo){
                maximo = palabrasRepetidas.get(pal);
                palabraMasUsada = pal;
            }
        }
        return palabraMasUsada;
    }
}
