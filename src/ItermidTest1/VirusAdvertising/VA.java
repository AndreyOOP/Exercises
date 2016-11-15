package ItermidTest1.VirusAdvertising;

import java.util.Scanner;

public class VA {

    static int n;
    static int[][] matrix;

    static int[] checked;

    public static void main(String[] args) {

        matrix = getInput();

        checked = new int[n];

        for(int i=0; i<n; i++){

            if(checked[i] == 0){ //not checked

                for(int j=i+1; j<n; j++){

                    if(matrix[i][j] > 0){ //find friend

                        for(int k=j+1; k<n; k++){
                            matrix[i][k] += matrix[j][k];
                        }
                        checked[j] = 1;
                    }
                }
            }
        }
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
