package com.tallerjava.tp1.problema4;

import junit.framework.TestCase;

public class FotografiaArtisticaTest extends TestCase {

    public void testEjemploTabla1() {
        char[] A = {'a', 'f', 'a', 'e', 'a'};   // "afaea"
        assertEquals(1, FotografiaArtistica.getCantFotosArtisticas(A, 1, 2));
    }

    public void testEjemploTabla2() {
        char[] A = {'a', 'f', 'a', 'e', 'a'};   // "afaea"
        assertEquals(0, FotografiaArtistica.getCantFotosArtisticas(A, 2, 3));
    }

    public void testEjemploTabla3() {
        char[] A = {'.', 'f', 'e', 'a', 'a', 'f', '.', 'e'};   // ".feaaf.e"
        assertEquals(3, FotografiaArtistica.getCantFotosArtisticas(A, 1, 3));
    }

    public void testMultiplicacion() {
        char[] A = {'f', 'f', 'a', 'e', 'e'};   // "ffaee"
        assertEquals(4, FotografiaArtistica.getCantFotosArtisticas(A, 1, 2));
    }

    public void testDireccionInvalida() {
        char[] A = {'f', 'e', 'a'};   // "fea"
        assertEquals(0, FotografiaArtistica.getCantFotosArtisticas(A, 1, 2));
    }
    
}
