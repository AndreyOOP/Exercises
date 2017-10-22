package Exercices.DynamicPrograms;

import java.util.Scanner;

public class H {

    static int n;

    public static void main(String[] args) {

        getInput();

        long q = 9;

        if(n == 1){
            System.out.println(8);
            return;
        }
        if(n == 2){
            System.out.println(16);
            return;
        }

        int[] dp = {2, 2, 2, 2, 3, 0, 3, 2, 2, 2}; //bas

        for(int i=3; i<=n; i++){

            for(int j=0; j<10; j++)
                dp[j] = 2*dp[j];
        }

        int s = 0;
        for(int i=0; i<10; i++)
            s += dp[i];

        System.out.println(s);
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
    }
}
