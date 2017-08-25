package Exercices.APS.CG;

import java.io.PrintWriter;
import java.util.Scanner;

public class CG_1 {

    static PrintWriter printWriter = new PrintWriter(System.out);;

    static int T;
    static int[] PC, M, MB, pc, m;
    static int[] N;
    static int[][] PCi, Mi, MBi, Pi;
    
    public static void main(String[] args) {

        CG_1 c = new CG_1();

        c.getInput();

        for (int t=0; t<T; t++)
            c.print(printWriter, t, c.findMaxValue(t));
    }

    int findMaxValue(int t){

        Cell[][][] max = new Cell[ PC[t] ][ M[t] ][ MB[t] ];

        for(int j=0; j<M[t]; j++)
            for(int k=0; k<PC[t]; k++)
                max[0][j][k] = new Cell( k*pc[t] + j*m[t], k, j, 0);

        for(int i=1; i<MB[t]; i++){

            for(int j=0; j<M[t]; j++)
                max[i][j][0] = max[0][j][0];

            for(int k=0; k<PC[t]; k++)
                max[i][0][k] = max[0][0][k];
        }

        int Max = -1;

        for(int i=1; i<MB[t]; i++){

            for(int j=1; j<M[t]; j++){

                for(int k=1; k<PC[t]; k++){

                    max[i][j][k] = findMaxAllModels(t, i, j, k, max);

                    Max = Math.max(Max, max[i][j][k].maxValue);
                }
            }
        }

        return Max;
    }

    Cell findMaxAllModels(int t, int i, int j, int k, Cell[][][] max){

        Cell maxCell = new Cell();
        Cell temp    = new Cell();

        for(int n=0; n<N[t]; n++){

            temp = findMaxOneModel(t, n, i, j, k, max);

            if(maxCell.maxValue < temp.maxValue)
                maxCell = temp;
        }

        return maxCell;
    }

    Cell findMaxOneModel(int t, int n, int i, int j, int k, Cell[][][] max){

        Cell maxCell, pc, m, mb;

        /*pc = checkOneDirection(max[i][j][k-1], t, n, 1, 0, 0);
        m  = checkOneDirection(max[i][j-1][k], t, n, 0, 1, 0);
        mb = checkOneDirection(max[i-1][j][k], t, n, 0, 0, 1);*/

        /*pc = checkPC(max[i][j][k-1], t, n);
        m  = checkPC(max[i][j-1][k], t, n);
        mb = checkPC(max[i-1][j][k], t, n);*/

        pc = check(max[i][j][k-1], t, n, 1, 0 ,0);
        m  = check(max[i][j-1][k], t, n, 0, 1, 0);
        mb = check(max[i-1][j][k], t, n, 0, 0, 1);

        maxCell = pc;
        if(maxCell.maxValue < m.maxValue)  maxCell = m;
        if(maxCell.maxValue < mb.maxValue) maxCell = mb;

        return maxCell;
    }

    Cell check(Cell cell, int t, int n, int incPC, int incM, int incMB){

        Cell a = new Cell(); Cell b = new Cell();

        if(cell.availPC + incPC >= PCi[t][n] && cell.availM + incM >= Mi[t][n] && cell.availMB + incMB >= MBi[t][n]){

//            a.maxValue = cell.maxValue + Pi[t][n] - incPC*pc[t] - incM*m[t];
            a.maxValue = cell.maxValue + Pi[t][n];
            a.availPC  = cell.availPC + incPC - PCi[t][n];
            a.availM   = cell.availM  + incM  - Mi[t][n];
            a.availMB  = cell.availMB + incMB - MBi[t][n];
        }

        b.maxValue = cell.maxValue + incPC*pc[t] + incM*m[t];
        b.availPC  = cell.availPC + incPC;
        b.availM   = cell.availM  + incM;
        b.availMB  = cell.availMB + incMB;

        if(a.maxValue > b.maxValue) return a; else return b;
    }

    /*Cell checkPC(Cell cell, int t, int n){

        Cell a = new Cell(); Cell b = new Cell();

        if(cell.availPC + 1 >= PCi[t][n] && cell.availM >= Mi[t][n] && cell.availMB >= MBi[t][n]){

            a.maxValue = cell.maxValue + Pi[t][n] - pc[t];
            a.availPC  = cell.availPC + 1 - PCi[t][n];
            a.availM   = cell.availM - Mi[t][n];
            a.availMB  = cell.availMB - MBi[t][n];
        }

        b.maxValue = cell.maxValue + pc[t];
        b.availPC  = cell.availPC + 1;
        b.availM   = cell.availM;
        b.availMB  = cell.availMB;

        if(a.maxValue > b.maxValue) return a; else return b;
    }

    Cell checkM(Cell cell, int t, int n){

        Cell a = new Cell(); Cell b = new Cell();

        if(cell.availPC >= PCi[t][n] && cell.availM + 1 >= Mi[t][n] && cell.availMB >= MBi[t][n]){

            a.maxValue = cell.maxValue + Pi[t][n] + (cell.availPC - PCi[t][n])*pc[t] + (cell.availM + 1 - Mi[t][n])*m[t];
            a.availPC  = cell.availPC;
            a.availM   = cell.availM + 1;
            a.availMB  = cell.availMB;
        }

        b.maxValue = cell.maxValue + m[t];
        b.availPC  = cell.availPC;
        b.availM   = cell.availM + 1;
        b.availMB  = cell.availMB;

        if(a.maxValue > b.maxValue) return a; else return b;
    }

    Cell checkMB(Cell cell, int t, int n){

        Cell a = new Cell(); Cell b = new Cell();

        if(cell.availPC >= PCi[t][n] && cell.availM >= Mi[t][n] && cell.availMB + 1 >= MBi[t][n]){

            a.maxValue = cell.maxValue + Pi[t][n] + (cell.availPC - PCi[t][n])*pc[t] + (cell.availM - Mi[t][n])*m[t];
            a.availPC  = cell.availPC;
            a.availM   = cell.availM;
            a.availMB  = cell.availMB + 1;
        }

        b.maxValue = cell.maxValue;
        b.availPC  = cell.availPC;
        b.availM   = cell.availM;
        b.availMB  = cell.availMB + 1;

        if(a.maxValue > b.maxValue) return a; else return b;
    }

    Cell checkOneDirection(Cell cell, int t, int n, int incPC, int incM, int incMB){

        Cell a = new Cell(); Cell b = new Cell();

        //possible to create one more IoT
        if(cell.availPC + incPC >= PCi[t][n] && cell.availM + incM >= Mi[t][n] && cell.availMB + incMB >= MBi[t][n]){

            a.maxValue = Pi[t][n] + (cell.availPC + incPC - PCi[t][n])*pc[t] + (cell.availM + incM - Mi[t][n])*m[t];
            a.availPC = cell.availPC + incPC - PCi[t][n];
            a.availM  = cell.availM + incM - Mi[t][n];
            a.availMB = cell.availMB + incMB - MBi[t][n];
        }

        //just sell details
        b = cell;
        b.maxValue = b.maxValue + pc[t];
        b.availPC++;

        b.maxValue = cell.maxValue + (cell.availPC + incPC)*pc[t] + (cell.availM + incM)*m[t];
        b.availPC = cell.availPC + incPC;
        b.availM  = cell.availM + incM;
        b.availMB = cell.availMB + incMB;

        if(a.maxValue > b.maxValue)
            return a;
        else
            return b;
    }*/

    void getInput(){

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

    void print(PrintWriter pw, int test, int answer){

        pw.println("#" + test + " " + answer);
        pw.flush();
    }

    class Cell{

        public Cell(int maxValue, int availPC, int availM, int availMB) {
            this.maxValue = maxValue;
            this.availPC = availPC;
            this.availM = availM;
            this.availMB = availMB;
        }

        public Cell() {}

        int maxValue;
        int availPC, availM, availMB;
    }
}