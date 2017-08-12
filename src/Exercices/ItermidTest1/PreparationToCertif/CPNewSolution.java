package Exercices.ItermidTest1.PreparationToCertif;

import java.io.PrintWriter;
import java.util.Scanner;

/**Solution is ok. Search in depth - bad idea.*/
public class CPNewSolution {

    static int n;
    static int [] a;

    public static void main(String[] args) {

        a = getInput();

        int[] d = new int[n];

        for(int i=0; i<n; i++){

            d[i] = 1;

            for(int j=0; j<i; j++){

                if(a[j] < a[i])
                    d[i] = Math.max(d[i], d[j]+1);
            }
        }

        print( findMax(d));
    }

    static int findMax(int[] arr){

        int max = -1;

        for(int i=0; i<n; i++)
            max = arr[i]>max ? arr[i] : max;

        return max;
    }

    static void print(int answer){

        PrintWriter printWriter = new PrintWriter(System.out);

        printWriter.println(answer);

        printWriter.flush();
    }

    static int[] getInput(){

        Scanner scanner = new Scanner( System.in);

        n = scanner.nextInt();

        int[] temp = new int[n];

        for(int i=0; i<n; i++)
            temp[i] = scanner.nextInt();

        return temp;
    }

}
