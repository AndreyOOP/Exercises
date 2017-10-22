package Exercices.APS.Calc;

import java.util.Scanner;

public class CR_1 {

    static int N, O, M, W;
    static int[] n, o;

    static int[] cache = new int[100]; //qt
    static int[] exclude = new int[1];

    static int w = 10;
    //for example only + - 1

    public static void main(String[] args) {

        cache[1] = 1; //exclude[1] = true;

        minimum(5, exclude, 0);
    }

    static int minimum(int i, int[] excl, int max){

        if(max==6) return Integer.MAX_VALUE;
        if(cache[i] != 0) return cache[i]; //check cache //check simple solution - start figures -> add they in cache on initialization step

        int[] values = generateValues(i);
        //create values
        int a, b, c;
        a = i-1;
        b = i+1;
        c = (i%10 == 1) ? (i-1)/10 : 0;

        int[] exc = generateExcludeArr(i, excl);


        //todo filter if some out of range

        int min = Integer.MAX_VALUE;
        int temp;

        for(int j=0; j<values.length && values[j] != 0; j++) {

            if ( !isExclude(exc, values[j])) {

                temp = minimum(values[j], exc, max + 1);
                if (min > temp) {
                    min = temp + 2;
                }

                //temp = minimum(valuesEq[j], exc, max + 1);
                if (min > temp) {
                    min = temp + 1;
                }
            }
        }
        cache[i] = min;
        return min;
    }

    static int[] generateValues(int i){

        int sz = 0;
        int[] vals = new int[10];

        if(i-1>0 && i-1<1000)
            vals[sz++] = i-1;

        if(i+1>0 && i+1<1000)
            vals[sz++] = i+1;

        if(i+2>0 && i+2<1000)
            vals[sz++] = i+2;

        if(i-2>0 && i-2<1000)
            vals[sz++] = i-2;

        return vals;
    }

    static int[] generateExcludeArr(int i, int[] excl){

        int[] exc = new int[excl.length+1];
        System.arraycopy(excl,0,exc,0,excl.length);
        exc[excl.length] = i;

        return exc;
    }

    static boolean isExclude(int[] excl, int val){

        for(int i=0; i<excl.length; i++)
            if(excl[i] == val) return true;

        return false;
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); //figures
        O = sc.nextInt(); //operations
        M = sc.nextInt(); //qty of button press

        n = new int[N]; //figures
        for(int i=0; i<N; i++)
            n[i] = sc.nextInt();

        o = new int[O]; //operations
        for(int i=0; i<O; i++)
            o[i] = sc.nextInt();

        W = sc.nextInt(); //required figure
    }
}
