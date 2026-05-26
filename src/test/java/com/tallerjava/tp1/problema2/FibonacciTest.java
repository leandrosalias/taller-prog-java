package com.tallerjava.tp1.problema2;

import junit.framework.TestCase;

import java.math.BigInteger;

public class FibonacciTest extends TestCase {

    public void testFibonacciCasoCeroUno(){
        assertEquals(1,Fibonacci.getFibonacci(0));
        assertEquals(1,Fibonacci.getFibonacci(1));
    }

    public void testFibonacciCasoDiez(){
        assertEquals(89,Fibonacci.getFibonacci(10));
    }

    public void testFibonacciCasoNoventa(){
        assertEquals(4660046610375530309L,Fibonacci.getFibonacci(90));
    }

    public void testExcepcionLongitudMinimaInvalida() {
        try {
            Fibonacci.getFibonacci(-1);
            fail("El código no lanzó la excepción.");

        } catch (IllegalArgumentException e) {
            assertEquals("n debe ser mayor o igual a 0 y menor igual a 90.", e.getMessage());
        }
    }

    public void testFibonacciCien(){
        BigInteger esperado = new BigInteger("573147844013817084101");
        assertEquals(esperado, Fibonacci.getFibonacciMasGrande(100));
    }

    public void testFibonacciMil(){
        BigInteger esperado = new BigInteger("70330367711422815821835254877183549770181269836358732742604905087154537118196933579742249494562611733487750449241765991088186363265450223647106012053374121273867339111198139373125598767690091902245245323403501");
        assertEquals(esperado, Fibonacci.getFibonacciMasGrande(1000));
    }

}
