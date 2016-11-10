package ItermidTest1.AiB;

import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    static int n;

    public static void main(String[] args) {

        readInput();

        int x = 2*n - 2;

        printOut(x);
    }

    public static void readInput(){

        Scanner scanner = new Scanner( System.in);

        n = scanner.nextInt();
    }

    public static void printOut(int x){

        PrintWriter printWriter = new PrintWriter( System.out);

        printWriter.print(x);
        printWriter.flush();
    }
}
