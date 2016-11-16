package ItermidTest1.Dinners;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**seems this solution become out of memory because of very big fs array*/
public class Dinner {

    //region Variables
    static int f;
    static int s;
    static int b;
    static int k;

    static int[] priceF;
    static int[] priceS;
    static int[] priceB;
    //endregion

    public static void main(String[] args) {

        getInput();

        int[] fs = new int[f*s]; //todo seems this is question is bigger than possible array size

        for(int i=0; i<f; i++){

            for(int j=0; j<s; j++)
                fs[i*s + j] = priceF[i] + priceS[j];
        }

        Arrays.sort(fs);

        int fsb[] = new int[fs.length + priceB.length];

        System.arraycopy(fs    , 0, fsb, 0        , fs.length);
        System.arraycopy(priceB, 0, fsb, fs.length, priceB.length);

        Arrays.sort(fsb);

        printAnswer(fsb);
    }

    public static void getInput(){

        Scanner scanner = new Scanner(System.in);

        f = scanner.nextInt();
        s = scanner.nextInt();
        b = scanner.nextInt();

        priceF = new int[f];
        priceS = new int[s];
        priceB = new int[b];

        for(int i=0; i<f; i++)
            priceF[i] = scanner.nextInt();

        for(int i=0; i<s; i++)
            priceS[i] = scanner.nextInt();

        for(int i=0; i<b; i++)
            priceB[i] = scanner.nextInt();

        k = scanner.nextInt();
    }

    public static void printAnswer(int[] fsb){

        PrintWriter printWriter = new PrintWriter(System.out);

        for(int i=0; i<k; i++)
            printWriter.print(fsb[i] + " ");

        printWriter.flush();
    }

    public static void print(int[] arr){

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static int calculateSize(int f, int s){ //if f or s is 0

        int temp = Math.max(f, s);

        return Math.max(temp, f*s);
    }
}
