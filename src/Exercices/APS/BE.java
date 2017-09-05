package Exercices.APS;

import java.io.PrintWriter;
import java.util.Scanner;

public class BE {

    static int w, h;
    static boolean[][] matrix; //true - dark, false - white;

    public static void main(String[] args) {

        getInput();

        int maxR = getMaxR(); //find max possible radius

        for(int r = maxR; r>0; r--){

            boolean[][] pattern = generatePattern(r); //calculate pattern;

            for(int x=0; x<=(w-2*r-1); x++){ //getPosition - primitive realization -> should be speed up here by move left, move down

                for(int y=0; y<=(h-2*r-1); y++){

                    if(isMoon(pattern, x, y)) {
                        print(r);
                        return;
                    }
                }
            }
        }

        print(0);
    }

    static int getMaxR(){

        int min = Math.min(w, h);

        return min % 2 == 0 ? min/2 - 1 : min/2;
    }

    static boolean isMoon(boolean[][] pattern, int x, int y){

        int n = pattern.length;

        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                if( !pattern[i][j] && matrix[x+i][y+j]) //moon part of pattern && matrix(xi, yj is dark - stop - it is not moon
                        return false;

        return true;
    }

    static boolean[][] generatePattern(int r){ //true - ignore, false - moon

        boolean[][] patt = new boolean[2*r + 1][2*r + 1];

        for(int i=0; i<r; i++){

            for(int j=0; j<r; j++){

                int a = r-i; int b = r-j;

                if(Math.sqrt(a*a + b*b) > r){

                    patt[i][j]         = true; //left top
                    patt[i][2*r-j]     = true;
                    patt[2*r-i][j]     = true;
                    patt[2*r-i][2*r-j] = true; //right bottom
                }
            }
        }

        return patt;
    }

    static void getInput(){

        Scanner scanner = new Scanner(System.in);

        w = scanner.nextInt();
        h = scanner.nextInt();

        matrix = new boolean[w][h];

        String line = scanner.nextLine();

        for(int i=0; i<h; i++){

            line = scanner.nextLine();

            for(int j=0; j<w; j++)
                if(line.charAt(j) == '.') matrix[j][i] = true; //* is white space is 0, so no need to read
        }

    }

    static void print(int val){

        PrintWriter pw = new PrintWriter(System.out);
        pw.print(val);
        pw.flush();
    }
}
