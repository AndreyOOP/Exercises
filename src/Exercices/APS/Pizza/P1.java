package Exercices.APS.Pizza;

import java.util.Scanner;

public class P1 {

    static int N, M;
    static int[] m;

    //upd len & upd start pos

    //first not optimized solution when some piece cut
    public static void main(String[] args) {

        getInput();

        Distrib base = initialize();

        for(int i=N; i<M; i++){
            base = update(base, m[i]);
        }

        System.out.println(base.delta);
    }

    static Distrib update(Distrib base, int x){

        Distrib[] distrs = new Distrib[N];

        Distrib temp;

        for(int i=0; i<N-1; i++){

            temp = new Distrib();

            for(int j=0; j<i; j++)
                temp.d[j] = base.d[j];

            temp.d[i] = base.d[i] + base.d[i+1];

            for(int j=i+1; j<N-1; j++)
                temp.d[j] = base.d[j+1];

            temp.d[N-1] = x;

            updateDelta(temp);

            distrs[i] = temp;
        }

        temp = new Distrib();

        for(int j=0; j<N; j++)
            temp.d[j] = base.d[j];

        temp.d[N-1] += x;

        updateDelta(temp);

        distrs[N-1] = temp;


        return getBestOne(distrs);
    }

    static Distrib getBestOne(Distrib[] distribs){

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for(int i=0; i<N; i++){

            if(distribs[i].delta < min) {
                min = distribs[i].delta;
                minIndex = i;

            }
        }

        return distribs[minIndex];
    }

    static void updateDelta(Distrib base){

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){

            if(min > base.d[i]) min = base.d[i];
            if(max < base.d[i]) max = base.d[i];
        }

        base.max = max;
        base.min = min;

        base.delta = max - min;
    }

    static Distrib initialize(){

        Distrib base = new Distrib();

        for(int i=0; i<N; i++)
            base.d[i] = m[i];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){

            if(min > base.d[i]) min = base.d[i];
            if(max < base.d[i]) max = base.d[i];
        }

        base.max = max;
        base.min = min;

        base.delta = max - min;

        return base;
    }

    static void getInput(){

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        m = new int[M];

        for(int i=0; i<M; i++)
            m[i] = scanner.nextInt();
    }

    public static class Distrib{

        public int[] d = new int[N];
        public int min;
        public int max;
        public int delta;
    }
}