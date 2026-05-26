package com.tallerjava.tp1.problema3;

import junit.framework.TestCase;

public class ArbolBinarioBusquedaTest extends TestCase {

    public void testABB_Arbol1() {
        Node raiz = new Node(10);
        raiz.setLeft(new Node(5));
        raiz.setRight(new Node(15));
        assertTrue(ArbolBinarioBusqueda.esArbolBusqueda(raiz));
    }
    /*
                     10
                    /  \
                   5    15
                  / \   / \
                2   12 11  20       */
    public void testABB_Arbol2() {
        Node raiz = new Node(10);
        raiz.setLeft(new Node(5, new Node(2), new Node(12)));
        raiz.setRight(new Node(15, new Node(11), new Node(20)));
        assertFalse(ArbolBinarioBusqueda.esArbolBusqueda(raiz));
    }

    public void testABB_Arbol3() {
        Node raiz = new Node(20, null, new Node(5));
        assertFalse(ArbolBinarioBusqueda.esArbolBusqueda(raiz));
    }

}
