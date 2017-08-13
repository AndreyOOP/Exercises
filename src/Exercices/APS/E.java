package Exercices.APS;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**3 test cases do not work - time limit exeeded - even if no binarysearch just count++ - time limit*/
public class E {

    static int N, K, count;
    static int[] defect, forCheck;

    public static void main(String[] args) {

        getInput();

        for(int i=0; i<K; i++){

            if(Arrays.binarySearch(defect, forCheck[i]) >= 0)
                count++;
        }

        print(count);
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        defect = new int[N];

        for(int i=0; i<N; i++)
            defect[i] = sc.nextInt();

        K = sc.nextInt();
        forCheck = new int[K];

        for(int i=0; i<K; i++)
            forCheck[i] = sc.nextInt();
    }

    static void print(int value){

        PrintWriter pw = new PrintWriter(System.out);
        pw.println(value);
        pw.flush();
    }
}
