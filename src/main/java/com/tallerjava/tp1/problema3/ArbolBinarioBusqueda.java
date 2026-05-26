package com.tallerjava.tp1.problema3;

public class ArbolBinarioBusqueda {

    public static boolean esArbolBusqueda(Node raiz) {
        return validarArbolBusqueda(raiz, null, null);
    }

    private static boolean validarArbolBusqueda(Node actual, Integer minimo, Integer maximo) {
        // Caso base (llegamos al final de una rama, sin romper la regla del árbol)
        if (actual == null)
            return true;
        // Si se rompe alguna regla en el recorrido, se devuelve false, ya que no sería un Árbol Binario de Búsqueda válido
        if (minimo != null && actual.getData() <= minimo)
            return false;
        if (maximo != null && actual.getData() >= maximo)
            return false;

        // Se recorre recursivamente hacia la izquierda haciendo que el máximo sea el valor del nodo actual
        // y luego a la derecha, haciendo que el mínimo sea el valor del nodo actual
        return validarArbolBusqueda(actual.getLeft(), minimo, actual.getData()) &&
                validarArbolBusqueda(actual.getRight(), actual.getData(), maximo);
    }

}
