package model;

import java.util.Random;

public class Controladora {

    private String[][] triqui;

    /**
     * Constructor de la clase Controladora para inicializar
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controladora 
     */
    public Controladora() {
        triqui = new String[3][3];
        inicializarTablero();
    }

    /**
     * Inicializa el tablero con valores vacíos.
     */
    private void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                triqui[i][j] = " ";
            }
        }
    }

    /**
     * Devuelve el tablero en formato String.
     */
    public String obtenerTableroComoString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(triqui[i][j]);
                if (j < 2) sb.append("|");
            }
            sb.append("\n");
            if (i < 2) sb.append("-----\n");
        }
        return sb.toString();
    }

    /**
     * Realiza una jugada aleatoria para la máquina.
     */
    public void jugadaAleatoria() {
        Random rand = new Random();
        int i, j;
        do {
            i = rand.nextInt(3);
            j = rand.nextInt(3);
        } while (!triqui[i][j].equals(" "));
        triqui[i][j] = "X";
    }

    public String jugadaHumano(int i, int j) {
        String msg = " ";

        if (triqui[i-1][j-1] == " ") {
            triqui[i-1][j-1] = "O";
        } else {
            msg = "Espacio ocupado";
        }

        return msg;
    }

    public String verificarGanador() {
        String msg = "No hay ganador";
        int counter = 0;
        
        //Revision horizontales
        for (int i = 0; i < triqui.length; i++) {
            counter = 0; 

            for (int j = 0; j < 2; j++) {
                if (triqui[i][j] != " " && triqui[i][j].equals(triqui[i][j+1])) {
                    counter++;
                }

                if (counter == 2) {
                    msg = triqui[i][j];
                }
            }
        }

        //Revision horizontales
        for (int i = 0; i < triqui.length; i++) {
            counter = 0; 

            for (int j = 0; j < 2; j++) {
                if (triqui[j][i] != " " && triqui[j][i].equals(triqui[j+1][i])) {
                    counter++;
                }

                if (counter == 2) {
                    msg = triqui[j][i];
                }
            }
        }

        //Revision diagonales

        if (triqui[0][0] != " " && triqui[1][1] != " " && triqui[2][2] != " " && triqui[0][0].equals(triqui[1][1]) && triqui[0][0].equals(triqui[2][2])) {
            msg = triqui[0][0];
        } else if (triqui[0][2] != " " && triqui[1][1] != " " && triqui[2][0] != " " && triqui[0][2].equals(triqui[1][1]) && triqui[0][2].equals(triqui[2][0])){
            msg = triqui[0][2];
        }

        

        /**
         * for (int i = 0; i < triqui.length; i++) {
            counter = 0; 

            for (int j = 0; i < triqui.length-1; j++) {
                if (triqui[j][i] != " " && triqui[j][i].equals(triqui[j+1][i])) {
                    counter++;
                }

                if (counter == 2) {
                    msg = triqui[j][i];
                }
            }
        }
        */
        
        /**
         * if (triqui[i][i] != " " && triqui[i][i+1] != " " && triqui[i][j].equals(triqui[i][j+1])) {
                if (triqui[i][j+2] != " " && triqui[i][j+1].equals(triqui[i][j+2])) {
                    msg = triqui[i][j+2];
                }
            } else if (triqui[i][j] != " " && triqui[i+1][j] != " " && triqui[i][j].equals(triqui[i+1][j])) {
                if (triqui[i+2][j] != " " && triqui[i+1][j].equals(triqui[i+2][j])) {
                    msg = triqui[i+2][j];
                }
            } else if (triqui[i][j] != " " && triqui[i+1][j+1] != " " && triqui[i][j].equals(triqui[i+1][j+1])) {
                if (triqui[i+2][j+2] != " " && triqui[i+1][j+1].equals(triqui[i+2][j+2])) {
                    msg = triqui[i+2][j];
                }
            }
        */
        

        return msg;
    }
}