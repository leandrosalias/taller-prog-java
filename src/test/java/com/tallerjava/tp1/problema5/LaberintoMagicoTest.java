package com.tallerjava.tp1.problema5;

import junit.framework.TestCase;

public class LaberintoMagicoTest extends TestCase {

        // Convierte filas de tipo "E.." a la matriz char[][] para no construir la matriz a mano en cada test.
        private char[][] grid(String... filas) {
            char[][] m = new char[filas.length][];
            for (int i = 0; i < filas.length; i++) {
                m[i] = filas[i].replace(" ", "").toCharArray();
            }
            return m;
        }

        public void testEjemplo1CaminoSimple() {
            char[][] mapa = grid(
                    "E..",
                    "...",
                    "..S");
            assertEquals(4, LaberintoMagico.pasosHastaSalida(mapa));
        }

        public void testEjemplo2SinSalidaPorPared() {
            char[][] mapa = grid(
                    "E#.",
                    ".#.",
                    ".#S");
            assertEquals(-1, LaberintoMagico.pasosHastaSalida(mapa));
        }

        public void testEjemplo3DosSalidasTomaLaMasCercana() {
            char[][] mapa = grid(
                    "E.S",
                    "...",
                    "..S");
            assertEquals(2, LaberintoMagico.pasosHastaSalida(mapa));
        }

        public void testEjemplo4PortalesEncadenados() {
            char[][] mapa = grid(
                    "S.b#b",
                    "####a",
                    "..E##",
                    "c##.c",
                    "#a...");
            assertEquals(13, LaberintoMagico.pasosHastaSalida(mapa));
        }

        public void testPortalLejanoNoEstorbaCaminoCorto() {
            assertEquals(2, LaberintoMagico.pasosHastaSalida(grid("E.S....a......a")));
        }

        public void testLaberintoNulo() {
            assertEquals(-1, LaberintoMagico.pasosHastaSalida(null));
        }

        public void testLaberintoVacio() {
            assertEquals(-1, LaberintoMagico.pasosHastaSalida(new char[0][0]));
        }
    }