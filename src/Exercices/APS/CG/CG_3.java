package Exercices.APS.CG;

import java.io.PrintWriter;
import java.util.Scanner;

/**First brute force solution -> 100% tests passed; 0,25 sec max execution time*/
public class CG_3 {

    static PrintWriter printWriter = new PrintWriter(System.out);;

    static int T;
    static int[] PC, M, MB, pc, m;
    static int[] N;
    static int[][] PCi, Mi, MBi, Pi;

    public static void main(String[] args) {

        getInput();

        for(int t=0; t<T; t++){

            if(N[t] == 1)
                print(printWriter, t, finMaxThreeModel(t, 0, 0, 0));

            if(N[t] == 2)
                print(printWriter, t, finMaxThreeModel(t, 0, 0, 1));

            if(N[t] >= 3){

                int mx = 0;

                for(int i=0; i<N[t]; i++)
                    for(int j=i+1; j<N[t]; j++)
                        for(int k=j+1; k<N[t]; k++)
                                mx = Math.max(mx, finMaxThreeModel(t, i, j, k));

                print(printWriter, t, mx);
            }
        }
    }

    static int finMaxThreeModel(int t, int n1, int n2, int n3){

        int max = 0;

        for(int i=0; i<=getModelLimit(t, n1); i++){

            for(int j=0; j<=getModelLimit(t, n2); j++){

                for(int k=0; k<=getModelLimit(t, n3); k++){

                    if( i*PCi[t][n1] + j*PCi[t][n2] + k*PCi[t][n3] <= PC[t] &&
                        i*Mi[t][n1]  + j*Mi[t][n2]  + k*Mi[t][n3]  <= M[t]  &&
                        i*MBi[t][n1] + j*MBi[t][n2] + k*MBi[t][n3] <= MB[t] )
                    {
                        int temp = i*(Pi[t][n1] - PCi[t][n1]*pc[t] - Mi[t][n1]*m[t]) +
                                   j*(Pi[t][n2] - PCi[t][n2]*pc[t] - Mi[t][n2]*m[t]) +
                                   k*(Pi[t][n3] - PCi[t][n3]*pc[t] - Mi[t][n3]*m[t]) +
                                   PC[t]*pc[t] + M[t]*m[t];

                        if(temp > max) max = temp;
                    }
                }
            }
        }

        return max;
    }

    static int getModelLimit(int t, int n){

        int pcLimit = PC[t] / PCi[t][n];
        int mLimit  = M[t]  / Mi[t][n];
        int mbLimit = MB[t] / MBi[t][n];

        return findMin(pcLimit, mLimit, mbLimit);
    }

    static int findMin(int a, int b, int c){

        int min = a;

        min = Math.min(min, b);
        min = Math.min(min, c);

        return min;
    }

    static void getInput(){

        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();

        PC = new int[T]; M = new int[T]; MB = new int[T]; pc = new int[T]; m = new int[T]; N = new int[T];
        PCi = new int[T][8]; Mi = new int[T][8]; MBi = new int[T][8]; Pi = new int[T][8];

        for(int i=0; i<T; i++){

            PC[i] = scanner.nextInt();
            M [i] = scanner.nextInt();
            MB[i] = scanner.nextInt();
            pc[i] = scanner.nextInt();
            m [i] = scanner.nextInt();

            N[i] = scanner.nextInt();

            for(int j=0; j<N[i]; j++){

                PCi[i][j] = scanner.nextInt();
                Mi [i][j] = scanner.nextInt();
                MBi[i][j] = scanner.nextInt();
                Pi [i][j] = scanner.nextInt();
            }
        }
    }

    static void print(PrintWriter pw, int test, int answer){

        pw.println("#" + (test+1) + " " + answer);
        pw.flush();
    }
}
