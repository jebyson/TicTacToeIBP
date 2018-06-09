package com.company;

import java.util.Scanner;

public class boardStateUser {
    private static String[][] board;
    private static Scanner input = new Scanner(System.in);
    private static boolean test = false;
    private static String CPUChar = " X ";
    private static String unchanged = " - ";
    private static int xSpot = -1;
    private static int ySpot = -1;
    private static int cnt = 0;

    boardStateUser() {
        board = new String[3][3];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                board[i][j] = " - ";
    }

    static void userFirst() {
        while (!test) {
            userMove();
            if(testWinUser())
                break;

            if (checkTie()) {
                System.out.println("The game has ended in a tie! Thanks for playing!");
                break;
            }
            System.out.println("The CPU's move:");

            if (board[1][1].equals(unchanged)) {
                xSpot = 1; ySpot = 1;
                winNow();
                if(testWinUser())
                    break;

                if (checkTie()) {
                    System.out.println("The game has ended in a tie! Thanks for playing!");
                    break;
                }
            }
            else if (board[0][0].equals(unchanged)) {
                xSpot = 0; ySpot = 0;
                winNow();
                if(testWinUser())
                    break;

                if (checkTie()) {
                    System.out.println("The game has ended in a tie! Thanks for playing!");
                    break;
                }
            }
            else if (board[0][1].equals(unchanged)) {
                xSpot = 0; ySpot = 1;
                winNow();
                if(testWinUser())
                    break;

                if (checkTie()) {
                    System.out.println("The game has ended in a tie! Thanks for playing!");
                    break;
                }
            }
            else if (board[0][2].equals(unchanged)) {
                xSpot = 0; ySpot = 2;
                winNow();
                if(testWinUser())
                    break;

                if (checkTie()) {
                    System.out.println("The game has ended in a tie! Thanks for playing!");
                    break;
                }
            }
            else if (board[1][0].equals(unchanged)) {
                xSpot = 1; ySpot = 0;
                winNow();
                if(testWinUser())
                    break;

                if (checkTie()) {
                    System.out.println("The game has ended in a tie! Thanks for playing!");
                    break;
                }
            }
            else if (board[2][0].equals(unchanged)) {
                xSpot = 2; ySpot = 0;
                winNow();
                if(testWinUser())
                    break;

                if (checkTie()) {
                    System.out.println("The game has ended in a tie! Thanks for playing!");
                    break;
                }
            }

            else if (board[2][1].equals(unchanged)) {
                xSpot = 2; ySpot = 1;
                winNow();
                if(testWinUser())
                    break;

                if (checkTie()) {
                    System.out.println("The game has ended in a tie! Thanks for playing!");
                    break;
                }
            }
            else if (board[1][2].equals(unchanged)) {
                xSpot = 1; ySpot = 2;
                winNow();
                if(testWinUser())
                    break;

                if (checkTie()) {
                    System.out.println("The game has ended in a tie! Thanks for playing!");
                    break;
                }
            }
            else if (board[2][2].equals(unchanged)) {
                xSpot = 2; ySpot = 2;
                winNow();
                if(testWinUser())
                    break;

                if (checkTie()) {
                    System.out.println("The game has ended in a tie! Thanks for playing!");
                    break;
                }
            }
            if (cnt == 9)
                System.out.println("The game has ended in a tie! Thanks for playing!");
            else if (testWinUser()) {
                System.out.println("The top left of the board is (0, 0). The bottom right of the board is (2, 2)");
                break;
            }
            else printBoard();
        }
    }

    static void printBoard() {
        for (int i = 0; i < boardStateUser.board.length; i++) {
            for (int j = 0; j < boardStateUser.board.length; j++)
                System.out.print(boardStateUser.board[i][j]);
            System.out.println();
        }
    }

    private static void userMove() {
        String userChar = " O "; String CPUChar = " X ";
        System.out.println("Please enter the x (row) coordinate of your move.");
        String xCoordinate = input.nextLine(); xCoordinate = xCoordinate.trim();
        int xPoint = Integer.parseInt(xCoordinate);
        System.out.println("Now enter the y (column) coordinate of your move.");
        String yCoordinate = input.nextLine(); yCoordinate = yCoordinate.trim();
        int yPoint = Integer.parseInt(yCoordinate);

        if (xPoint < 0 || xPoint > 2 || yPoint < 0 || yPoint > 2)
            System.out.println("Invalid move. The CPU receives a free move now!");
        else if (!(board[xPoint][yPoint].equals(userChar) || board[xPoint][yPoint].equals(CPUChar))) {
            board[xPoint][yPoint] = userChar;
            printBoard();
        }
        else
            System.out.println("Invalid move. The CPU receives a free move now!");
    }

    private static boolean testWinUser() {
        boolean a = (board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2])) && (board[0][0].equals(" O ") || board[0][0].equals(" X "));
        boolean b = (board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2])) && (board[1][0].equals(" O ") || board[1][0].equals(" X "));
        boolean c = (board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2])) && (board[2][0].equals(" O ") || board[2][0].equals(" X "));
        boolean d = (board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0])) && (board[0][0].equals(" O ") || board[0][0].equals(" X "));
        boolean e = (board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1])) && (board[0][1].equals(" O ") || board[0][1].equals(" X "));
        boolean f = (board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2])) && (board[0][2].equals(" O ") || board[0][2].equals(" X "));
        boolean g = (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) && (board[0][0].equals(" O ") || board[0][0].equals(" X "));
        boolean h = (board[0][2].equals(board[1][1]) && board[2][0].equals(board[0][2])) && (board[0][2].equals(" O ") || board[0][2].equals(" X "));

        if (a || b || c || d || e || f || g || h) {
            System.out.println("Game over! Thanks for playing!");
            return true;
        }
        else
            return false;
    }

    private static void blockWin() {
        String userChar = " O ";
        if (board[0][0].equals(userChar) && board[0][1].equals(userChar) && board[0][2].equals(unchanged))
            board[0][2] = CPUChar;
        else if (board[0][0].equals(userChar) && board[0][2].equals(userChar) && board[0][1].equals(unchanged))
            board[0][1] = CPUChar;
        else if (board[0][1].equals(userChar) && board[0][2].equals(userChar) && board[0][0].equals(unchanged))
            board[0][0] = CPUChar;
        else if (board[1][0].equals(userChar) && board[1][1].equals(userChar) && board[1][2].equals(unchanged))
            board[1][2] = CPUChar;
        else if (board[1][0].equals(userChar) && board[1][2].equals(userChar) && board[1][1].equals(unchanged))
            board[1][1] = CPUChar;
        else if (board[1][1].equals(userChar) && board[1][2].equals(userChar) && board[1][0].equals(unchanged))
            board[1][0] = CPUChar;
        else if (board[2][0].equals(userChar) && board[2][1].equals(userChar) && board[2][2].equals(unchanged))
            board[2][2] = CPUChar;
        else if (board[2][0].equals(userChar) && board[2][2].equals(userChar) && board[2][1].equals(unchanged))
            board[2][1] = CPUChar;
        else if (board[2][1].equals(userChar) && board[2][2].equals(userChar) && board[2][0].equals(unchanged))
            board[2][0] = CPUChar;
        else if (board[0][0].equals(userChar) && board[1][0].equals(userChar) && board[2][0].equals(unchanged))
            board[2][0] = CPUChar;
        else if (board[0][0].equals(userChar) && board[2][0].equals(userChar) && board[1][0].equals(unchanged))
            board[1][0] = CPUChar;
        else if (board[1][0].equals(userChar) && board[2][0].equals(userChar) && board[0][0].equals(unchanged))
            board[0][0] = CPUChar;
        else if (board[0][1].equals(userChar) && board[1][1].equals(userChar) && board[2][1].equals(unchanged))
            board[2][1] = CPUChar;
        else if (board[0][1].equals(userChar) && board[2][1].equals(userChar) && board[1][1].equals(unchanged))
            board[1][1] = CPUChar;
        else if (board[1][1].equals(userChar) && board[2][1].equals(userChar) && board[0][1].equals(unchanged))
            board[0][1] = CPUChar;
        else if (board[0][2].equals(userChar) && board[1][2].equals(userChar) && board[2][2].equals(unchanged))
            board[2][2] = CPUChar;
        else if (board[0][2].equals(userChar) && board[2][2].equals(userChar) && board[1][2].equals(unchanged))
            board[1][2] = CPUChar;
        else if (board[1][2].equals(userChar) && board[2][2].equals(userChar) && board[0][2].equals(unchanged))
            board[0][2] = CPUChar;
        else if (board[0][0].equals(userChar) && board[1][1].equals(userChar) && board[2][2].equals(unchanged))
            board[2][2] = CPUChar;
        else if (board[0][0].equals(userChar) && board[2][2].equals(userChar) && board[1][1].equals(unchanged))
            board[1][1] = CPUChar;
        else if (board[1][1].equals(userChar) && board[2][2].equals(userChar) && board[0][0].equals(unchanged))
            board[0][0] = CPUChar;
        else if (board[2][0].equals(userChar) && board[1][1].equals(userChar) && board[0][2].equals(unchanged))
            board[0][2] = CPUChar;
        else if (board[2][0].equals(userChar) && board[0][2].equals(userChar) && board[1][1].equals(unchanged))
            board[1][1] = CPUChar;
        else if (board[1][1].equals(userChar) && board[0][2].equals(userChar) && board[2][0].equals(unchanged))
            board[2][0] = CPUChar;
        else
            board[xSpot][ySpot] = CPUChar;
    }

    private static boolean checkTie() {
        cnt = 0;
        for (String[] dummyVar : board)
            for (int b = 0; b < board[0].length; b++)
                if (!(dummyVar[b].equals(unchanged)))
                    cnt++;
        if(cnt == 9)
            return true;
        else
            return false;
    }

    private static void winNow() {
        if (board[0][0].equals(CPUChar) && board[0][1].equals(CPUChar) && board[0][2].equals(unchanged))
            board[0][2] = CPUChar;
        else if (board[0][0].equals(CPUChar) && board[0][2].equals(CPUChar) && board[0][1].equals(unchanged))
            board[0][1] = CPUChar;
        else if (board[0][1].equals(CPUChar) && board[0][2].equals(CPUChar) && board[0][0].equals(unchanged))
            board[0][0] = CPUChar;
        else if (board[1][0].equals(CPUChar) && board[1][1].equals(CPUChar) && board[1][2].equals(unchanged))
            board[1][2] = CPUChar;
        else if (board[1][0].equals(CPUChar) && board[1][2].equals(CPUChar) && board[1][1].equals(unchanged))
            board[1][1] = CPUChar;
        else if (board[1][1].equals(CPUChar) && board[1][2].equals(CPUChar) && board[1][0].equals(unchanged))
            board[1][0] = CPUChar;
        else if (board[2][0].equals(CPUChar) && board[2][1].equals(CPUChar) && board[2][2].equals(unchanged))
            board[2][2] = CPUChar;
        else if (board[2][0].equals(CPUChar) && board[2][2].equals(CPUChar) && board[2][1].equals(unchanged))
            board[2][1] = CPUChar;
        else if (board[2][1].equals(CPUChar) && board[2][2].equals(CPUChar) && board[2][0].equals(unchanged))
            board[2][0] = CPUChar;
        else if (board[0][0].equals(CPUChar) && board[1][0].equals(CPUChar) && board[2][0].equals(unchanged))
            board[2][0] = CPUChar;
        else if (board[0][0].equals(CPUChar) && board[2][0].equals(CPUChar) && board[1][0].equals(unchanged))
            board[1][0] = CPUChar;
        else if (board[1][0].equals(CPUChar) && board[2][0].equals(CPUChar) && board[0][0].equals(unchanged))
            board[0][0] = CPUChar;
        else if (board[0][1].equals(CPUChar) && board[1][1].equals(CPUChar) && board[2][1].equals(unchanged))
            board[2][1] = CPUChar;
        else if (board[0][1].equals(CPUChar) && board[2][1].equals(CPUChar) && board[1][1].equals(unchanged))
            board[1][1] = CPUChar;
        else if (board[1][1].equals(CPUChar) && board[2][1].equals(CPUChar) && board[0][1].equals(unchanged))
            board[0][1] = CPUChar;
        else if (board[0][2].equals(CPUChar) && board[1][2].equals(CPUChar) && board[2][2].equals(unchanged))
            board[2][2] = CPUChar;
        else if (board[0][2].equals(CPUChar) && board[2][2].equals(CPUChar) && board[1][2].equals(unchanged))
            board[1][2] = CPUChar;
        else if (board[1][2].equals(CPUChar) && board[2][2].equals(CPUChar) && board[0][2].equals(unchanged))
            board[0][2] = CPUChar;
        else if (board[0][0].equals(CPUChar) && board[1][1].equals(CPUChar) && board[2][2].equals(unchanged))
            board[2][2] = CPUChar;
        else if (board[0][0].equals(CPUChar) && board[2][2].equals(CPUChar) && board[1][1].equals(unchanged))
            board[1][1] = CPUChar;
        else if (board[1][1].equals(CPUChar) && board[2][2].equals(CPUChar) && board[0][0].equals(unchanged))
            board[0][0] = CPUChar;
        else if (board[2][0].equals(CPUChar) && board[1][1].equals(CPUChar) && board[0][2].equals(unchanged))
            board[0][2] = CPUChar;
        else if (board[2][0].equals(CPUChar) && board[0][2].equals(CPUChar) && board[1][1].equals(unchanged))
            board[1][1] = CPUChar;
        else if (board[1][1].equals(CPUChar) && board[0][2].equals(CPUChar) && board[2][0].equals(unchanged))
            board[2][0] = CPUChar;
        else
            blockWin();
    }
}