package Exercices.DynamicPrograms;

import java.io.PrintWriter;
import java.util.Scanner;

//to solve via two methods
public class HourseAndP {

    static int pX, pY, hX, hY;
    static boolean[][] board;

    public static void main(String[] args) {

        getInput();

        //for each p position
        //pX; pY;
        isHourseWinOrDraw(1, hX, hY);

        //if win or draw - print answer...

        isHourseWinOrDraw(2, hX, hY);

        board = new boolean[8][8];
        board[hX][hY] = true;

        for(int i=pY; i<8; i++){

            board = getNextBoard();

            if(pX == hX && i == hY) {
                print(-1);
                return;
            }

            if(pX == hX && i == hY-1){
                print(0.5);
                return;
            }
        }

        print(1);
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);

        String x = sc.nextLine();
        String[] xx = x.split(" ");

        String p_str = xx[0];
        String h_str = xx[1];

        String boardH = "abcdefgh";
        String boardV = "12345678";

        pX = getCoord(boardH, p_str.charAt(0));
        pY = getCoord(boardV, p_str.charAt(1));

        hX = getCoord(boardH, h_str.charAt(0));
        hY = getCoord(boardV, h_str.charAt(1));
    }

    static int getCoord(String board, char ch){

        for(int i=0; i<8; i++)
            if( board.charAt(i) == ch) return i;

        return -1;
    }

    static boolean[][] getNextBoard(){

        boolean[][] newBoard = new boolean[8][8];

        for(int i=0; i<8; i++){

            for(int j=0; j<8; j++){

                if(board[i][j]){

                    if(isOnBoard(i-1, j-2)) newBoard[i-1][j-2] = true;
                    if(isOnBoard(i-2, j-1)) newBoard[i-2][j-1] = true;
                    if(isOnBoard(i-1, j+2)) newBoard[i-1][j+2] = true;
                    if(isOnBoard(i-2, j+1)) newBoard[i-2][j+1] = true;
                    if(isOnBoard(i+1, j-2)) newBoard[i+1][j-2] = true;
                    if(isOnBoard(i+2, j-1)) newBoard[i+2][j-1] = true;
                    if(isOnBoard(i+1, j+2)) newBoard[i+1][j+2] = true;
                    if(isOnBoard(i+2, j+1)) newBoard[i+2][j+1] = true;
                }
            }
        }

        return newBoard;
    }

    static boolean isOnBoard(int a, int b){
        return (a>0 && a<8) && (b>0 && b<8);
    }

    static void print(int i){

        PrintWriter pw = new PrintWriter(System.out);
        pw.println(i);
        pw.flush();
    }

    static void print(double i){

        PrintWriter pw = new PrintWriter(System.out);
        pw.println(i);
        pw.flush();
    }

    //or via recursion
    static double isHourseWinOrDraw(int step, int hX, int hY){

        if(step == 0) { //return only on step == 0
            //no more steps, check win conditions
                //if hourse position == p pos - return -1;
        }

        if( isOnBoard(hX-1, hY-2))
            isHourseWinOrDraw(step-1, hX-1, hY-2);
        //...

        return 0.0;
    }
}
