package Exercices.ItermidTest1.PreparationToCertif;


import java.util.Scanner;

public class CP2 {

    static int n;
    static int [] a;

    static int[] calculated = new int[15];

    public static void main(String[] args) {

        a = getInput();

        findNextBigger(0, a[0]);
    }

    static int findNextBigger(int pos, int max){

        while (a[pos] <= max)
            if(pos<a.length-1)
                pos++;
            else
                break;

        if(pos < a.length){

            if(a[pos] > max)
                return 1 + findNextBigger(pos, a[pos]);
            else
                return 0;
        } else
            return 0;
    }

    static int sumRec(int pos){

        if(pos>0){

            if( calculated[pos] > 0)
                return calculated[pos];
            else
                return calculated[pos] = sumRec(pos-1) + a[pos];

        } else
            return a[0];
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
