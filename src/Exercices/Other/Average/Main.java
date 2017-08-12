package Exercices.Other.Average;

import java.io.*;
import java.util.*;

public class Main {

    private static int a;
    private static int b;
    private static int c;

    public static void main(String[] args) {

        getInput();

        int ans = 0;

        if( (b<a && a<c) || (b>a && a>c))
            ans = a;
        else if ((a<b && b<c) || (a>b && b>c))
            ans = b;
        else if ((a<c && c<b) || (a>c && c>b))
            ans = c;

        printAnswer( ans);
    }

    private static void getInput(){

        Scanner scanner = new Scanner( System.in);

        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
    }

    private static void printAnswer(int ans){

        PrintWriter printWriter = new PrintWriter( System.out);

        printWriter.println(ans);
        printWriter.flush();
    }
}
