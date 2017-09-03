package Exercices.APS;

import java.io.PrintWriter;
import java.util.Scanner;

public class T {

    static String A, B;

    public static void main(String[] args) {

        getInput();

        print( lenArray(A, B));
    }

    /**OK, max time 0,14*/
    static int lenArray(String a, String b){

        int[][] L = new int[a.length()+1][b.length()+1];

        for(int i=a.length()-1; i>=0; i--){

            for(int j=b.length()-1; j>=0; j--){

                if(a.charAt(i) == b.charAt(j))
                    L[i][j] = 1 + L[i+1][j+1];
                else
                    L[i][j] = Math.max(L[i+1][j], L[i][j+1]);
            }
        }

        return L[0][0];
    }

    /**time limit exceeded*/
    static int len(String a, String b){

        if(a.length()==0 || b.length()==0)
            return 0;

        if(a.charAt(0) == b.charAt(0))
            return 1 + len(a.substring(1, a.length()), b.substring(1, b.length()));

            return Math.max( len( a.substring(1, a.length()), b),
                             len( a, b.substring(1, b.length())) );
    }

    static void print(int val){

        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println(val);
        printWriter.flush();
    }

    static void getInput(){

        Scanner scanner = new Scanner(System.in);

        String temp  = scanner.nextLine();
        int i = temp.indexOf(" ");

        A = temp.substring(0, i);
        B = temp.substring(i+1, temp.length());
    }
}
