package com.tallerjava.tp1.problema2;

import java.math.BigInteger;

public class Fibonacci {

    public static long getFibonacci(int n) throws IllegalArgumentException {

        // Evitamos que se introduzca un número inválido para nuestro caso
        if (n < 0 || n > 90){
            throw new IllegalArgumentException("n debe ser mayor o igual a 0 y menor igual a 90.");
        }

        // fib(0) = fib(1) = 1
        if (n == 0 || n == 1){
            return 1;
        }

        // fib(n) = fib(n-1) + fib(n-2)
        // Realizamos una solucion iterativa en lugar de recursividad. Para esto usamos las variables anterior y actual para obtener los estados necesarios de la secuencia de fibonacci
        long anterior = 1;
        long actual = 1;
        for (int i = 2; i <= n; i++){
            long siguiente = anterior + actual;
            anterior = actual;
            actual = siguiente;
        }
        return actual;
    }

    public static BigInteger getFibonacciMasGrande(int n) {

        // Para la solucion opcional, eliminamos el control de que sea menor o igual a 90
        if (n < 0){
            throw new IllegalArgumentException("n debe ser mayor o igual a 0.");
        }

        // fib(0) = fib(1) = 1
        // La logica es la misma, pero en vez de usar long usamos el tipo BigInteger para evitar el overflow.
        if (n == 0 || n == 1){
            return BigInteger.ONE;
        }

        // fib(n) = fib(n-1) + fib(n-2)
        BigInteger anterior = BigInteger.ONE;
        BigInteger actual = BigInteger.ONE;
        for (int i = 2; i <= n; i++){
            BigInteger siguiente = anterior.add(actual);
            anterior = actual;
            actual = siguiente;
        }
        return actual;
    }


}
