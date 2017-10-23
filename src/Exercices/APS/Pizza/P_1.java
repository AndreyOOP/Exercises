package Exercices.APS.Pizza;

/**Sub task
 * Find the best distribution in array
 * Should work like
 * d(N,M) -> best of d(N-1, N-1) to d(N-1, M)*/
public class P_1 {

    static int N = 4;
    static int M = 6;
    static int[] p = {0, 3, 5, 6, 8, 9, 4}; //zero just for indexes

    public static void main(String[] args) {

        DP[][] dp = new DP[N+1][M+1];

        //N=1
        dp[1][1] = new DP(3, 3);        //state of split to N people, M pieces; calculate
        dp[1][2] = new DP(8, 8);
        dp[1][3] = new DP(14, 14);
        dp[1][4] = new DP(22, 22);
        dp[1][5] = new DP(31, 31);
        dp[1][6] = new DP(35, 35);

        //N=2, dp[2][2] till dp[2][M-1]
        for(int i=2; i<M; i++){

            dp[2][i] = calculate(2, i, dp);

            //calculate dp[2][M]
            //dp[2][i] =

            //dp[2][2] = dp[1][1] & p[2]
            //dp[2][3] = dp[1][1], dp[1][2]
            //dp[2][4] = dp[1][1] & p, dp[1][2] & p, dp[1][3] & p
            //... for 5 & 6

            //dp[3][3] = dp[2][2] & p[3]
            //dp[3][4] = dp[2][2] &, dp[2][3] &
        }

    }

    static DP calculate(int N, int M, DP[][] dp){

        DP temp;
        DP min = new DP(0, Integer.MAX_VALUE);

        for(int i=N-1; i<M; i++){

            temp = check(dp[N-1][i], i+1);

            if(temp.max - temp.min < min.max-min.min){

                min.min = temp.min;
                min.max = temp.max;
            }
        }

        return min;
    }

    static DP check(DP dp, int v){

        int s = 0;
        for(int i=v; i<=v; i++){
            s += p[i];
        }

        if(dp.max == dp.min) {
            //dp.max - s;
        }
        if(s > dp.max) dp.max = s;
        if(s < dp.min) dp.min = s;

        return dp;
    }

    static class DP{

        int min;
        int max;

        public DP(int a, int b) {

            if(a>b){
                max = a;
                min = b;
            }else {
                max = b;
                min = a;
            }
        }

        @Override
        public String toString(){
            return min + ":" + max + ":" + (max-min);
        }
    }
}