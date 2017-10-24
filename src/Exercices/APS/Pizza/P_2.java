package Exercices.APS.Pizza;

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
 * Solution is to cut all possible pieces & for other array calculate dp[N][M]
 * */
public class P_2 {

//    static int N = 3, M = 5;
//    static int[] p = {0, 4, 3, 8, 6, 5};

    static int N = 2, M = 4;
    static int[] p = {0, 10, 6, 13, 2};
    static int[] ps;

    public static void main(String[] args) {

        ps = new int[M+1];
        DP[][] dp = new DP[N+1][M+1];

        initialize(dp);

        for(int i=2; i<=N; i++){
            for(int j=i; j<=M; j++){
                dp[i][j] = calculate(i, j, dp);
            }
        }

        System.out.println(dp[N][M]);
    }

//    public static DP getBestForArray(int[] p){
//
//    }

    public static DP calculate(int n, int m, DP[][] dp){

        DP temp;
        DP min = new DP(0, Integer.MAX_VALUE);

        for(int i=n-1; i<m; i++){

            DP  d = dp[n-1][i];
            int s = sum(i+1, m, p);

            int a = d.max < s ? s : d.max;
            int b = d.min > s ? s : d.min;

            temp = new DP(a, b);
            if(min.crit > temp.crit)
                min = new DP(temp.min, temp.max);
        }

        return min;
    }

    public static void initialize(DP[][] DP){

        for(int i=1; i<=M; i++){
            DP[1][i] = new DP(sumTo(i, p), sumTo(i, p));
        }

        for(int i=1; i<=M; i++)
            ps[i] = sumTillEnd(i, p);
    }

    public static int sumTillEnd(int from, int[] arr){

        int s = 0;

        for(int i=from; i<arr.length; i++)
            s += arr[i];

        return s;
    }

    public static int sum(int from, int to, int[] arr){

        int s = 0;

        for (int i=from; i<=to; i++)
            s += arr[i];

        return s;
    }

    public static int sumTo(int to, int[] arr){

        int s = 0;

        for(int i=0; i<=to; i++)
            s += arr[i];

        return s;
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
