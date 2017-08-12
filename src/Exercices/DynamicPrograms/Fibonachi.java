package Exercices.DynamicPrograms;

public class Fibonachi {

    public static void main(String[] args) {

        int N = 10;
        int[] dp = new int[100];

        dp[0] = 1; dp[1] = 1;

        for(int i=2; i<=N; i++){
            dp[i] = dp[i-2] + dp[i-1];
            System.out.println(dp[i]);
        }

        System.out.println(dp[N]);
    }
}
