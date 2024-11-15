package ui;

import java.util.Scanner;
import model.Controladora;

public class Executable {

    private Scanner reader;
    private Controladora cont;
    private static boolean flag;

    private Executable() {
        reader = new Scanner(System.in);
        cont = new Controladora();
    }

    public void run(boolean flag) {

        flag = false;

        while (!flag) {

            System.out.println("\n\nBienvenido al menu:\n");
            System.out.println("Opciones:\n" + "1. Imprimir tablero \n" + "2. Jugada de la maquina \n"
                    + "3. Jugada de humano \n" + "4. Verificar ganador \n" + "5. Salir del programa \n");

            int option = reader.nextInt();
            reader.nextLine();

            switch (option) {
                case 1:
                    imprimirTablero();
                    break;
                case 2:
                    jugadaMaquina();
                    break;
                case 3:
                    jugadaHumano();
                    break;
                case 4:
                    validarGanador();
                    break;
                case 5:
                    flag = true;
                    System.exit(0);
                    break;
                default:
                    System.out.print("Por favor ingrese una opcion valida");
                    continue;
            }

        }

    }

    public static void main(String[] args) {
        Executable mainApp = new Executable();
        mainApp.run(flag);
    }

    private void imprimirTablero() {
        System.out.println(cont.obtenerTableroComoString());
    }

    private void jugadaMaquina() {
        cont.jugadaAleatoria();
        System.out.println("La maquina ha realizado su jugada.");
        imprimirTablero();
    }

    private void jugadaHumano() {
        System.out.println("Ingrese las coordenadas de donde desea hacer su jugada:");
        System.out.print("Fila: ");
        int i = reader.nextInt();
        reader.nextLine();
        System.out.print("Columna: ");
        int j = reader.nextInt();
        reader.nextLine();

        if (cont.jugadaHumano(i,j) == " ") {
            imprimirTablero();
        } else {
            System.out.println(cont.jugadaHumano(i, j));
        }
    }

    private void validarGanador() {
        System.out.println(cont.verificarGanador());

        if (cont.verificarGanador().equals("O")) {
            System.out.println("Has ganado! :D");
        } else if (cont.verificarGanador().equals("X")) {
            System.out.println("Ha ganado la maquina! D:");
        }
    }
}