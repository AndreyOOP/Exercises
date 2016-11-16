package ItermidTest1.VirusAdvertising;

import java.util.Scanner;

public class VA {

    static int n;
    static int[][] matrix;

    static int[] checked;

    public static void main(String[] args) {

        matrix = getInput();

//        checked = new int[n];

        for(int i=0; i<n; i++){

//            if(checked[i] == 0){ //not checked

                for(int j=0; j<n; j++){

                    if(matrix[i][j] > 0){ //find friend

                        for(int k=0; k<n; k++){
                            matrix[i][k] += matrix[j][k];
                            matrix[j][k]  = 0;
                        }
                        print( matrix);
                    }
//                }

//                checked[i] = 1;
            }
        }
    }

    static void print(int[][] matrix){

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
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
