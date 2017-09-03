package Exercices.APS.B;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class B_2 {

    static int N, K;
    static int[] f;
    static LinkedList<Integer> premutations1, premutations2;

    public static void main(String[] args) {

        getInput();

        f = convertToArray(N); //convert N to f[]


        premutations1 = generatePremutations(f); //create 2 arrays with premutations all -> premutations1,2

        swap(f, 0, 1);
        premutations2 = generatePremutations(f);

        if(K % 2 != 0){
            print( findMax(premutations1)); //use prem 1 & get Max
        } else {
            print( findMax(premutations2));//use prem 2 & get Max
        }

        //check for K=0
    }

    static int findMax(LinkedList<Integer> list){

        int max = list.remove();

        for(int i: list)
            if(i > max)
                max = i;

        return max;
    }

    static LinkedList<Integer> generatePremutations(int[] f){

        LinkedList<Integer> premutations = new LinkedList<>();

        int n = f.length;

        for(int i=0; i<n; i++){

            for(int j=i+1; j<n; j++){

                premutations.add( getFigure(f, i, j));
            }
        }

        return premutations;
    }

    static int getFigure(int[] f, int i, int j){

        int figure = 0;
        int pow    = f.length-1;

        int[] temp = new int[f.length];

        for(int l=0; l<f.length; l++)
            temp[l] = f[l];

        swap(temp, i, j);

        int ind = 0;
        for(int k=pow; k>=0; k--)
            figure += temp[ind++]*Math.pow(10, k);


        return figure;
    }

    static void swap(int[] arr, int i, int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int[] convertToArray(int n){

        LinkedList<Integer> stack = new LinkedList<>();

        while (n>0){
            stack.push(n % 10);
            n /= 10;
        }

        int[] f = new int[stack.size()];
        int   i = 0;

        while (!stack.isEmpty())
            f[i++] = stack.pop();

        return f;
    }

    static void getInput(){

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
    }

    static void print(int val){

        PrintWriter pw = new PrintWriter(System.out);
        pw.print(val);
        pw.flush();
    }
}
