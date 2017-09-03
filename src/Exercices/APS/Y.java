package Exercices.APS;

import java.io.PrintWriter;
import java.util.Scanner;

/**ak^n + bk^(n-1) + ck^(n-2) +...+ d mod (k-1) -> a + b + c +...+ d mod (k-1)*/
public class Y {

    static String s;
    static int minK = -1, sum, a;

    public static void main(String[] args) {

        getInput();

        getFigureData();

        for(int k=minK; k<=36; k++){

            if(sum % (k-1) == 0){
                print(k);
                return;
            }
        }

        print("No solution.");
    }

    static void getFigureData(){

        for(int i=0; i<s.length(); i++){

            a = toFigure(s.charAt(i));

            sum += a;
            if(a > minK) minK = a;
        }

        minK++;
    }

    static int toFigure(char c){

        String fig = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for(int i=0; i<fig.length(); i++)
            if(fig.charAt(i) == c) return i;

        return -1;
    }

    static void getInput(){

        Scanner scanner = new Scanner(System.in);
        s = scanner.nextLine();
    }

    static void print(int answer){

        PrintWriter pw = new PrintWriter(System.out);
        pw.print(answer);
        pw.flush();
    }

    static void print(String answer){

        PrintWriter pw = new PrintWriter(System.out);
        pw.print(answer);
        pw.flush();
    }
}