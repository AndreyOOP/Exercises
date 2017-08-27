package Exercices.APS;

import java.io.PrintWriter;
import java.util.Scanner;

public class D {

    static int R, N;
    static int [] robotX; //i num of robot, x
    static int [] robotY; //i num of robot, y

    public static void main(String[] args) {

        getInput();

        int sum = 0;

        for(int i=0; i<N; i++){

            sum += attak(i);
        }

        print(sum);
    }

    static int attak(int n){

        int a = 0;

        for(int i=0; i<N; i++){

            if(i!=n)
                if(isOpen(n, i))
                    a++;
        }

        return a;
    }

    static boolean isOpen(int i, int j){

        int lx = Math.abs(robotX[i] - robotX[j]);
        int ly = Math.abs(robotY[i] - robotY[j]);

        int gcd = gcdX(lx, ly);

        if(gcd == 1) return true;

        for(int r=0; r<N; r++) {

            if (r != i)
                if (robotX[r] % gcd == 0 && robotY[r] % gcd == 0)
                    if( robotX[r] > robotX[i] && robotX[r] < robotX[j] &&
                        robotY[r] > robotY[i] && robotY[r] < robotY[j])
                            return false;
        }

        return true;
    }

    static int gcdX(int q, int r){

        if(r==0) return q;
        return gcdX(r, q%r);
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        N = sc.nextInt();

        robotX = new int[N];
        robotY = new int[N];

        for(int i=0; i<N; i++){
            robotX[i] = sc.nextInt();
            robotY[i] = sc.nextInt();
        }
    }

    static void print(int val){

        PrintWriter pw = new PrintWriter(System.out);
        pw.print(val);
        pw.flush();
    }
}
