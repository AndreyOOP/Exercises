package ItermidTest1.Tank;

import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    public static int n;

    public static void main(String[] args) {

        //region Initialization
        int a1 = 0;
        int a2 = 0;
        int a3 = 0;

        int bug  = 0;
        int vpad = 0;
        //endregion

        Scanner scanner = new Scanner( System.in);

        n = scanner.nextInt();

        if (n>=1)
            a1 = scanner.nextInt();

        if (n>=2)
            a2 = scanner.nextInt();

        for(int i=2; i<n; i++){

            a3 = scanner.nextInt();

            if( a2>a1 && a2>a3) //if check i>2 here it work faster? ...
                bug++;

            if( a2<a1 && a2<a3)
                vpad++;

            a1 = a2;
            a2 = a3;
        }

        PrintWriter printWriter = new PrintWriter( System.out);
        printWriter.print(bug);
        printWriter.print(" ");
        printWriter.print(vpad);
        printWriter.flush();
    }


}
