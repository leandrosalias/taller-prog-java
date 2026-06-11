package com.tallerjava.tp1.problema5;

import java.util.*;

public class LaberintoMagico {

    public static int pasosHastaSalida(char[][] laberinto) {

        // Si el laberinto está vacío retorna -1
        if (laberinto == null || laberinto.length == 0 || laberinto[0].length == 0){
            return -1;
        }

        Map<Character, List<int[]>> portales = new HashMap<>();

        final int F = laberinto.length;
        final int C = laberinto[0].length;

        // Ubicamos la entrada
        int entradaF = -1;
        int entradaC = -1;

        // Buscamos la entrada E del laberinto, y además guardamos los portales existentes (si los hay)
        for(int i = 0; i < F; i++){
           for (int j = 0; j < C; j++){
               char valor = laberinto[i][j];
               if (valor == 'E') {
                    entradaF = i;
                    entradaC = j;
               }else{
                   if(valor >= 'a' && valor <= 'z'){
                       // Esta linea se ejecuta solo cuando encuentra la primera letra del portal
                       portales.putIfAbsent(valor, new ArrayList<>());
                       // Agrega la coordenada del portal encontrado
                       portales.get(valor).add(new int[]{i, j});
                   }
               }
           }
        }

        // Chequeamos el caso de que no tenga una entrada 'E'.
        if (entradaF == -1){
            return -1;
        }

        // Utilizamos el algoritmo BFS como estrategia, ya que este algoritmo evalua el camino mas corto entre una entrada (E) y una salida (S).

        Queue<int[]> cola = new ArrayDeque<>();
        boolean[][] visitados = new boolean[F][C];

        // Direcciones de búsqueda (arriba, abajo, izquierda, derecha)
        final int [] dirFila = {-1,1,0,0};
        final int [] dirCol = {0,0,-1,1};

        // Guardamos el primer estado (empezando desde la posición de la letra 'E')
        cola.add(new int[] {entradaF, entradaC, 0});
        visitados[entradaF][entradaC] = true;

        while (!cola.isEmpty()) {
            int[] actual = cola.poll();
            int fil = actual[0];
            int col = actual[1];
            int pasosActuales = actual[2];

            // Si encontramos la salida, retornamos la cantidad de pasos recorridos hasta el momento
            if (laberinto[fil][col] == 'S') {
                return pasosActuales;
            }

            // Recorremos las celdas adyacentes (arriba, abajo, izquierda, derecha)
            for (int dir = 0; dir < 4; dir++){
                int dirF = fil + dirFila[dir];
                int dirC = col + dirCol[dir];
                // Verificamos los límites del laberinto
                if(dirF >= 0 && dirF < F && dirC >= 0 && dirC < C && !visitados[dirF][dirC] && laberinto[dirF][dirC] != '#'){
                    visitados[dirF][dirC] = true;
                    cola.add(new int[]{dirF,dirC, pasosActuales + 1});
                }
            }

            // Lógica del portal
            char ch = laberinto[fil][col];
            if (ch >= 'a' && ch <= 'z'){
                // Si es un portal que encontramos anteriormente
                if (portales.containsKey(ch)){
                    // Buscamos si la coordenada de salto del portal fue visitada
                    for (int[] coordenadas : portales.get(ch)){
                        int portalFila = coordenadas[0];
                        int portalColumna = coordenadas[1];
                        // Si no fue visitada entonces la marcamos como visitada y actualizamos el nuevo estado con la posición del portal
                        if(!visitados[portalFila][portalColumna]) {
                            visitados[portalFila][portalColumna] = true;
                            cola.add(new int[]{portalFila,portalColumna, pasosActuales + 1});
                        }
                    }
                    // Borramos el portal una vez visitado para no entrar en bucles
                    portales.remove(ch);
                }
            }

        }

        // Cuando se termina de recorrer y no hay ningun camino a ninguna salida, entonces retorna -1.
        return -1;
    }

}
