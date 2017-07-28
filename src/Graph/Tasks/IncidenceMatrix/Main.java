package Graph.Tasks.IncidenceMatrix;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static int n, m;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        int[][] incMatrix = new int[n][m];

        for(int i=0; i<m; i++){

            incMatrix[ in.nextInt()-1][i] = 1;
            incMatrix[ in.nextInt()-1][i] = 1;
        }

        PrintWriter pw = new PrintWriter(System.out);

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                pw.print(incMatrix[i][j] + " ");
            }
            pw.println();
        }

        pw.flush();
    }

}
