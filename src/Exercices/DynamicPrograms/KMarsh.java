package Exercices.DynamicPrograms;

import java.util.Scanner;

public class KMarsh {

    static int M, N;

    static Scanner sc = new Scanner(System.in);
    static boolean[][] field;

    static int[][] dp, nt;

    public static void main(String[] args) {

        getInput();

        int max = -1;
        dp = new int[N][N];


        for (int m=0; m<M; m++) {

            for(int i=0; i<N; i++){

                for(int j=i+1; j<N; j++){

                    if(dp[i][j] >= 0){

                        if(dp[i][j] == 0){

                            if(field[m][i] && field[m][j])
                                dp[i][j]++;
                            else
                                dp[i][j] = -1;
                        }

                        if(line(m, i, j) == 0)
                            max = Math.max(2*(dp[i][j]-1) + 2*(j-i-1), max);


                    }
                }
            }
        }
    }

    static int line(int m, int i, int j){

        for(int k=i; k<=j; k++)
            if(!field[m][k]) return  -1;

        return 0;
    }


    static void getInput(){

        M = sc.nextInt();
        N = sc.nextInt();

        field = new boolean[M][N];

        for(int i=0; i<M; i++){

            for(int j=0; j<N; j++){

                if(sc.nextLine().charAt(0) == '.') field[i][j] = true;
            }
        }

        sc.close();
    }
}
