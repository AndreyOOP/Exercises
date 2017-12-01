package Exercices.DynamicPrograms;

import java.util.Scanner;

public class BizCh {

    static int N;
    static int[] z;

    public static void main(String[] args) {

        getInput();

        System.out.println( f(0, N-1, 0));
    }

    static int f(int a, int b, int h){

        int leftCut, bottCut = 0, aa, bb;

        if(h >= 5000) return 5001;
        if(a > b)    return 0;


        leftCut = f(a+1, b, h);
        if(z[a+1] > h) leftCut++;

        aa = a;
        while (aa < b){

            aa = getA(aa, b, h);
            bb = getB(aa, b, h);

            bottCut += f(aa, bb, h+1) + 1;

            aa = bb;
        }

        return Math.min(leftCut, bottCut);
    }

    static int getA(int start, int b, int h){

        for(int i=start; i<=b; i++)
            if(h<z[i]) return i;

        return b;
    }

    static int getB(int start, int b, int h){

        for(int i=start; i<=b; i++)
            if(h>=z[i]) return i;

        return b;
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        z = new int[N];

        for(int i=0; i<N; i++)
            z[i] = sc.nextInt();

        sc.close();
    }
}
