package Exercices.DynamicPrograms;

import java.util.Scanner;

//try with minus
public class Dim {

    static int n, k;
    static int[] a, b, w;

    public static void main(String[] args) {

        getInput();

//        System.out.println( getAnsw());
        System.out.println( f(n, 0));
    }

    static int f(int n, int v){

        if(n==1) return a[1];

//        if(n == Dim.n) return;
        return Math.max( f(n-1, v-w[n]) + a[n], f(n-1, v));
    }

    static int getAnsw(){

        int[] curr = new int[30000];
        int[] next = new int[30000];

        curr[15000+w[0]] = a[0];

        for (int j=1; j<n; j++) {

            for(int i=0; i<30000; i++){

                if(curr[i] != 0){

                    //next[i] = curr[i];

                    if(i + w[j] >=0 && i + w[j] < 30000)
                        curr[i + w[j]] = Math.max( curr[i] + a[j], curr[i + w[j]] );

//                    if(w[j] != 0)
//                        next[i] = curr[i];
                }

            }
            //curr = next;
            //next = new int[30000];
        }

        if(curr[15000] == 0) return -1;

        return curr[15000];
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        a = new int[n+1];
        b = new int[n+1];
        w = new int[n+1];

        for(int i=1; i<=n; i++)
            a[i] = sc.nextInt();

        for(int i=1; i<=n; i++)
            b[i] = sc.nextInt();

        for(int i=1; i<=n; i++)
            w[i] = a[i] - k*b[i];

        sc.close();
    }
}
