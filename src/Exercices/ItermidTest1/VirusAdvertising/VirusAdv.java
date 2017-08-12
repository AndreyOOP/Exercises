package Exercices.ItermidTest1.VirusAdvertising;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class VirusAdv {

    static Node[][] matrix;

    static LinkedList<Node> stack = new LinkedList<>();

    static int qty = 0;

    static Boolean newPath;

    public static void main(String[] args) {

        matrix = getInput();

        for (int i=0; i<matrix.length; i++) {

            newPath = false;
            int k = i;

            do{

                for (int j=k; j<matrix.length; j++) { //for each persons friend

                    if( !matrix[k][j].visited && matrix[k][j].value == 1){

                        matrix[k][j].visited = true;
                        stack.push( matrix[k][j]); //if not marked friend - add it to stack

                        newPath = true;
                    }
                }

                k = stack.isEmpty() ? -1 : stack.pop().j;

            } while ( k >= 0);

            int sum = 0;
            for (int j=0; j<matrix.length; j++)
                sum += matrix[i][j].value;

            if(sum==0)
                qty++;

            if (newPath)
                qty++;
        }

        PrintWriter printWriter = new PrintWriter( System.out);
        printWriter.println(qty);
        printWriter.flush();
    }

    static Node[][] getInput(){

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Node[][] temp = new Node[n][n];

        for(int i=0; i<n; i++){

            for(int j=0; j<n; j++){

                temp[i][j] = new Node(false, scanner.nextInt(), i, j);
            }
        }

        return temp;
    }

    public static class Node{

        Boolean visited;
        int     value;

        int i;
        int j;

        public Node(Boolean visited, int value, int i, int j) {
            this.visited = visited;
            this.value = value;
            this.i = i;
            this.j = j;
        }
    }
}
