package com.tallerjava.tp1.problema1;

import junit.framework.TestCase;

public class PalabraMasUsadaTest extends TestCase {

    public void testPalabraMasUsada(){
        String resultado = PalabraMasUsada.getPalabraMasUsada("Hola hola HOLA mundo", 3);
        assertEquals("hola",resultado);
    }

    public void testPalabraMasUsadaConAcento(){
        String resultado = PalabraMasUsada.getPalabraMasUsada("Informática UNICEN. Universidad unicen/ UNICEN, facultad de EXACTAS!", 3);
        assertEquals("unicen",resultado);
    }

   public void testPalabraMasUsadaNull(){
        String resultado = PalabraMasUsada.getPalabraMasUsada("test test TEST Test", 6);
        assertNull("test",resultado);
    }

  public void testExcepcionLongitudMinimaInvalida() {
        try {
            PalabraMasUsada.getPalabraMasUsada("Hola mundo", 0);
            fail("El código no lanzó la excepción.");

        } catch (IllegalArgumentException e) {
            assertEquals("La longitud mínima de las palabras debe ser mayor a 0", e.getMessage());
        }
    }

}


