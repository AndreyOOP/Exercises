package Exercices.APS.Pizza;

import java.util.Scanner;

/**
 * Class DP - contains min and max piece, could be calculated criteria
 *
 * dp[N][M] - N peoples, M pieces
 * dp[3][8] - the best way to split 8 pieces between 3 peoples; best way is minimum delta between max & min pieces
 *
 * Next piece calculation
 * dp[3][8] is the best of
 *      dp[2][2] & sum of p[3..8]
 *      dp[2][3] & sum of p[4..8]
 *      dp[2][4] & sum of p[5..8]
 *      dp[2][5] & sum of p[6..8]
 *      dp[2][6] & sum of p[7..8]
 *      dp[2][7] & sum of p[8..8]
 *
 * Solution is to check all possible arrays
 * */
public class P_4 {

    static int T, N, M;
    static int[] p;
    static int[] t;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        T = sc.nextInt();

        for(int j=0; j<T; j++){

            getInput();

            DP[][] dp = new DP[N+1][M+1];

            DP temp;
            DP min = new DP(0, Integer.MAX_VALUE);

            for(int i=1; i<=M; i++){

                t = getNewArray(i);

                temp = getBestForArray(t, dp);
                if(temp.crit < min.crit)
                    min = new DP(temp.min, temp.max);
            }

            System.out.println(min.crit);
        }
    }

    public static int[] getNewArray(int start){

        int sz = 1;
        int[] arr = new int[M+1];

        for(int i=start; i<=M; i++)
            arr[sz++] = p[i];

        for(int i=1; i<start; i++)
            arr[sz++] = p[i];

        return arr;
    }

    public static DP getBestForArray(int[] p, DP[][] dp){

        initialize(dp, p);

        for(int i=2; i<=N; i++){
            for(int j=i; j<=M; j++){
                dp[i][j] = calculate(i, j, dp, p);
            }
        }

        return dp[N][M];
    }

    public static DP calculate(int n, int m, DP[][] dp, int[] p){

        int s, a, b;
        DP d, temp, min;

        min = new DP(0, Integer.MAX_VALUE);

        for(int i=n-1; i<m; i++){

            d = dp[n-1][i];
            s = sum(i+1, m, p);

            a = d.max < s ? s : d.max;
            b = d.min > s ? s : d.min;

            temp = new DP(a, b);

            if(min.crit > temp.crit)
                min = new DP(temp.min, temp.max);
        }

        return min;
    }

    public static void initialize(DP[][] DP, int[] p){

        for(int i=1; i<=M; i++)
            DP[1][i] = new DP(sum(1, i, p), sum(1, i, p));
    }

    public static int sum(int from, int to, int[] arr){

        int s = 0;

        for (int i=from; i<=to; i++)
            s += arr[i];

        return s;
    }

    public static void getInput(){

        N = sc.nextInt();
        M = sc.nextInt();

        p = new int[M+1];

        for(int i=1; i<=M; i++)
            p[i] = sc.nextInt();
    }

    public static class DP{

        public int min;
        public int max;
        public int crit;

        public DP(int a, int b) {

            if(a<b){
                min = a;
                max = b;
            } else {
                min = b;
                max = a;
            }

            crit = max - min;
        }

        @Override
        public String toString(){
            return min + ":" + max + ":" + crit;
        }
    }

}
