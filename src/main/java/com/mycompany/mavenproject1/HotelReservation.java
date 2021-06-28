package com.mycompany.mavenproject1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class HotelReservation {
    
    private static boolean MainMenu = true;
    private static boolean SubMenu = true;

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Room[] myHotel = new Room[10];
        myHotel[0] = new Room();
        myHotel[1] = new Room();
        myHotel[2] = new Room();
        myHotel[3] = new Room();
        myHotel[4] = new Room();
        myHotel[5] = new Room();
        myHotel[6] = new Room();
        myHotel[7] = new Room();
        myHotel[8] = new Room();
        myHotel[9] = new Room();
        int roomNum = 0;
        initialise(myHotel);
        while (MainMenu) {
            while (SubMenu) {
                System.out.println("Olá e bem-vindo ao nosso programa de hotéis.");
                System.out.println("Selecione uma das opções.");
                System.out.println("____________________________________________");
                System.out.println("A: Reserve um novo quarto.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("E: Exibir salas vazias.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("V: Ver todos os quartos.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("D: Exclua o cliente da sala.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("F: Encontre a sala com o nome do cliente.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("O: Exibir salas.");
                String Selection = input.next();
                Selection = Selection.toUpperCase();
                switch (Selection) {
                    case "A":
                        BookARoom(myHotel, roomNum);
                        break;
                    case "E":
                        CheckIfEmpty(myHotel);
                        break;
                    case "V":
                        ViewAllRooms(myHotel);
                        break;
                    case "D":
                        DeleteCustomerFromRoom(myHotel, roomNum);
                        break;
                    case "F":
                        FindRoomFromCustomerName(myHotel);
                        break;
                    case "O":
                        ViewRoomsOrderedAlphabeticallyByName(myHotel);
                        break;
                    default:
                        System.out.println("Seleção inválida");
                        break;
                }
                System.out.println("Você gostaria de selecionar outra opção 1 == para sim ||  2 == para nao");
                if (input.nextInt() == 1) {
                    SubMenu = true;
                } else {
                    SubMenu = false;
                }
            }
            SubMenu = true;
            System.out.println("Você gostaria de continuar com o programa 1 == para sim ||  2 == para nao");
            if (input.nextInt() == 1) {
                MainMenu = true;
            } else {
                System.out.println("");
                System.exit(0);

            }
        }

    }

    private static void initialise(Room[] myHotel) {
        for (int x = 0; x < myHotel.length; x++) {
            myHotel[x].setName("ninguém");
        }
    }

    private static void CheckIfEmpty(Room[] myHotel) {
        for (int x = 0; x < myHotel.length; x++) {
            if (myHotel[x].getName().equals("ninguém")) {
                System.out.println("sala " + (x + 1) + " está vazia");
            }
        }
    }

    private static void BookARoom(Room[] myHotel, int roomNum) {
        String roomName;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o número do quarto (1-10):");
        roomNum = input.nextInt() - 1;
        System.out.println("Insira o nome da sala " + (roomNum + 1) + " :");
        roomName = input.next();
        myHotel[roomNum].setName(roomName);
    }

    private static void ViewAllRooms(Room[] myHotel) {
        for (int x = 0; x < myHotel.length; x++) {
            System.out.println("sala " + (x + 1) + " Ocupado por " + myHotel[x].getName());
        }
    }

    private static void DeleteCustomerFromRoom(Room[] myHotel, int roomNum) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o número do quarto para excluir (1-10):");
        roomNum = input.nextInt() - 1;
        myHotel[roomNum].setName("ninguém");
        System.out.println("Entrada excluída");
    }

    private static void FindRoomFromCustomerName(Room[] myHotel) {
        Scanner input = new Scanner(System.in);
        String roomName;
        System.out.println("Insira o nome para pesquisar:");
        roomName = input.next();
        int x;
        boolean Checker = false;
        for (x = 0; x < myHotel.length; x++) {
            if (roomName.equals(myHotel[x].getName())) {
                System.out.println("A conta que corresponde a esse nome é o número da conta " + x);
                Checker = true;
            }
        }
        if (Checker == false) {
            System.out.println("Não há salas reservadas com esse nome");
        }
    }    

    private static void ViewRoomsOrderedAlphabeticallyByName(Room[] myHotel) {
        String[] myStrArray = new String[myHotel.length];
        for (int i = 0; i < myHotel.length; i++) {
            myStrArray[i] = myHotel[1].getName();
        }

        Arrays.sort(myStrArray);
        for (int a = 0; a < myStrArray.length; a++) {
            System.out.println(myStrArray[a]);
        }

    }

    public static class Room {

        private String mainName;
        int guestsInRoom;

        public Room() {
            mainName = "k";

        }

        public void setName(String aName) {
            mainName = aName;
        }

        public String getName() {
            return mainName;
        }
    }
    
}
