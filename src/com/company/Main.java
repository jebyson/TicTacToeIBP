package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Tic Tac Toe game!");
        Scanner input = new Scanner(System.in);
        System.out.println("Input '0' if you would like to start. Input '1' if you would like the CPU to start.");
        int i = input.nextInt();
        if(i == 0) {
            new boardStateUser();
            System.out.println("You will go first!");
            System.out.println("This is the board:");
            boardStateUser.printBoard();
            System.out.println("The top left of the board is (0, 0). The bottom right of the board is (2, 2)");
            boardStateUser.userFirst();
        }
        else if(i == 1) {
            new boardStateCPU();
            System.out.println("The CPU will go first!");
            System.out.println("This is the board:");
            boardStateCPU.printBoard();
            System.out.println("The top left of the board is (0, 0). The bottom right of the board is (2, 2)");
            boardStateCPU.CPUFirst();
        }
        else
            System.out.println("Invalid input. Try again.");
    }
}