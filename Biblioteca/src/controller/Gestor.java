package controller;

import model.Biblioteca;

import java.util.Scanner;

public class Gestor {
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        int opcion;

        System.out.println("\t\t------BIENVENIDO AL GESTOR DE BIBLIOTECAS------");
        System.out.println("Pulse Enter para empezar");
        scanner.nextLine();
        do {
            System.out.println("¿Qué biblioteca desea gestionar?\n\t1. Biblioteca Municipal\t\t\t2. Biblioteca Universidad\t\t\t3. Salir");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1: {
                    System.out.println("\t-----BIBLIOTECA MUNICIPAL-----");
                    menuSub();
                    break;
                }
                case 2: {
                    System.out.println("---BIBLIOTECA UNIVERSIDAD---");
                    menuSub();
                    break;
                }
                case 3: {
                    System.out.println("¡HASTA PRONTO!");
                    break;
                }

                default:
                    System.out.println("Opción no válida");
            }
        }while (opcion!=3);

    }

    public void menuSub (){
        int opcionSub;
        do {
            System.out.println("\t1. Buscar información sobre un libro\n\t2. Construir un catálogo\n\t3. Consultar catálogo" +
                    "\n\t4. Agregar libro al catálogo\n\t5. Sacar libro del catálogo\n\t6. Salir");

            opcionSub = scanner.nextInt();
            switch (opcionSub) {
                case 1: {

                    break;
                }
                case 2: {

                    break;
                }
                case 3: {

                    break;
                }
                case 4: {

                    break;
                }
                case 5: {

                    break;
                }
                case 6: {

                    break;
                }
                default: {
                    System.out.println("Opción no válida");
                }
            }

        } while (opcionSub != 6);
    }
}
