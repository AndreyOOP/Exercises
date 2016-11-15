package ItermidTest1.VirusAdvertising;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class VirAdv3 {

    static int n;
    static int count;
    static int[][] matrix;

    static LinkedList<Integer> in  = new LinkedList<>();
    static LinkedList<Integer> out = new LinkedList<>();

    public static void main(String[] args) {

        matrix = getInput();

        for(int i=0; i<n; i++){ //for person i

            for(int j=i+1; j<n; j++){

                if(matrix[i][j] != 0){ //if found not zero item we should find all friends of it

                    in.add(j);
                    matrix[i][j] = 0;

                    while (in.size() > 0){

                        out = new LinkedList<>();

                        for(int k=in.peek(); k<n; k++){
                            if( matrix[ in.peek()][k] != 0){
                                out.add( matrix[in.peek()][k]);
                                matrix[in.pop()][k] = 0;
                            }
                        }
                        in = out;
                    }

                    count++;
                }
            }
        }

        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.print(count);
        printWriter.flush();
    }

    static int[][] getInput(){

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        int[][] temp = new int[n][n];

        for(int i=0; i<n; i++){

            for(int j=0; j<n; j++){

                temp[i][j] = scanner.nextInt();
            }
        }

        return temp;
    }
}
