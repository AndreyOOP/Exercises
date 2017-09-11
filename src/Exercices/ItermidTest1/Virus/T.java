package Exercices.ItermidTest1.Virus;

import java.io.PrintWriter;
import java.util.Scanner;

public class T {

    static String D;
    static boolean[][] m;

    public static void main(String[] args) {

        getInput();

        int l = D.length();

        m = new boolean[l][l];

        for(int i=0; i<l; i++){
            for(int j=0; j<l; j++){
                if(D.charAt(i) == D.charAt(j)) m[i][j] = true;
            }
        }

        int maxLen = 0;
        int k = 1;
        String temp = "";
        String maxStr = "";
        //find max len of diagonal of true - store coordinates
        for(k=1; k<l; k++){

            int currLen = 0;
            temp = "";

            for(int i=0; i+k<l; i++){

                if(m[i][k+i]){
                    currLen++; //current Diagonal counter ++
                    temp += D.charAt(i);
                }else {

                    if(currLen > maxLen){
                        maxLen = currLen;
                        maxStr = temp;
                    }
                    //max check ->if success save positin
                   temp = "";
                   currLen = 0; //current Diagonal counter ++ to zero
                }

                if(currLen > maxLen){
                    maxLen = currLen;
                    maxStr = temp;
                }
            }
        }

        print(maxStr);
    }

    static void getInput(){

        Scanner sc = new Scanner(System.in);
        D = sc.nextLine();
    }

    static void print(String val){

        PrintWriter pw = new PrintWriter(System.out);
        pw.println(val);
        pw.flush();
    }
}
