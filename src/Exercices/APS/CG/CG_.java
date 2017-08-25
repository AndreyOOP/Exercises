//package Exercices.APS;
//
//import java.io.PrintWriter;
//import java.util.Collections;
//import java.util.Scanner;
//
//public class CG {
//
//    static PrintWriter printWriter = new PrintWriter(System.out);;
//
//    static int T;
//    static int[] PC_, M_, MB_, pc_, m_;
//    static int[] N_;
//    static int[][] PCi_, Mi_, MBi_, Pi_;
//
//    public static void main(String[] args) {
//
//        getInput();
//
//        for(int t=0; t<T; t++)
//            print(printWriter, t, getAnswer(t));
//    }
//
//    static int getAnswer(int t){
//
//        int PC, M, MB, pc, m;
//        int N;
//        int[] PCi, Mi, MBi, Pi;
//
//        PC = PC_[t]; M = M_[t]; MB = MB_[t]; pc = pc_[t]; m = m_[t];
//        N = N_[t];
//
//        for(int i=0; i<N; i++){
//
//            PCi = new int[N];
//            Mi  = new int[N];
//            MBi = new int[N];
//            Pi  = new int[N];
//
//            PCi[i] = PCi_[t][i];
//            Mi[i]  = Mi_[t][i];
//            MBi[i] = MBi_[t][i];
//            Pi[i]  = Pi_[t][i];
//        }
//
//        int[][][] max   = new int[PC][M][MB];
//        int[][][] ostPC = new int[PC][M][MB];
//        int[][][] ostM  = new int[PC][M][MB];
//        int[][][] ostMB = new int[PC][M][MB];
//
//        int mx = -1;
//
//        for(int k=0; k<MB; k++){
//
//            for(int j=0; j<M; j++){
//
//                for(int i=0; i<PC; i++){
//
////                    max[i][j][k] = findAllModelMax();
////                    mx = Math.max(mx, max[i][j][k]);
////                    Collections.m
//                }
//            }
//        }
//
//    return mx;
//}
//
//    static int findAllModelMax(int i, int j, int k, int model){
//
//        int max = 0;
//
////        for(int n=0; n<N; n++){
////            max = Math.max(max, findOneModelMax(i, j, k, n));
////        }
//
//        //not create model just sum
//
//        return max;
//    }
//
//    static int findOneModelMax(int i, int j, int k, int model, int[][][] ostPC){
//
//        int m = 0;
//
//        if(ostPC[i][j][k] < PCi[model]) m = 0; //3 checks
//
//        //if all greater then calc addition value & calc ost else just sum and calc ost
//
//        m = Math.max(max[i][j][k], max[i-1][j][k] + m);
//        m = Math.max(max[i][j][k], max[i][j-1][k]);
//        m = Math.max(max[i][j][k], max[i][j][k-1]);
//        //
//    }
//
//    static int maxForModels(int n, int PCqty, int Mqty, int MBqty){
//
//        int max = 0;
//
//        for(int i=0; i<N[n]; i++)
//            max = Math.max( getModel(i, n, PCqty, Mqty, MBqty), max);
//
//        max = Math.max(PCqty*pc[n] + Mqty*m[n], max);
//
//        return max;
//    }
//
//    static int getModel(int n, int i, int PCqty, int Mqty, int MBqty){
//
//        //is it possible to create model i based on qtyies - if no - return 0; if yes return price
//        if(PCqty < PCi[i][n]) return 0;
//        if(Mqty  <  Mi[i][n]) return 0;
//        if(MBqty < MBi[i][n]) return 0;
//
//        return Pi[i][n];
//    }
//
//    static void getInput(){
//
//        Scanner scanner = new Scanner(System.in);
//
//        T = scanner.nextInt();
//
//        for(int i=0; i<T; i++){
//
//            PC_[i] = scanner.nextInt();
//            M_ [i] = scanner.nextInt();
//            MB_[i] = scanner.nextInt();
//            pc_[i] = scanner.nextInt();
//            m_ [i] = scanner.nextInt();
//
//            N_[i] = scanner.nextInt();
//
//            for(int j=0; j<N_[i]; j++){
//
//                PCi_[i][j] = scanner.nextInt();
//                Mi_ [i][j] = scanner.nextInt();
//                MBi_[i][j] = scanner.nextInt();
//                Pi_ [i][j] = scanner.nextInt();
//            }
//        }
//    }
//
//    static void print(PrintWriter pw, int t, int v){
//
//        pw.println("#" + t + " " + v);
//        pw.flush();
//    }
//}
