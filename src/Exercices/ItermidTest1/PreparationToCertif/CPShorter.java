package Exercices.ItermidTest1.PreparationToCertif;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class CPShorter {

    //region Variables
    static int n;
    static int [] a;

    static int pos;

    static int max;
    static int maxInd;

    static int len;
    static int maxLen;
    //endregion

    static LinkedList<Integer> stack = new LinkedList<>();

    public static void main(String[] args) {

        a = getInput();

        for (int i=0; i<n; i++) {

            stack.push(i); pos = i; max = a[i]; len++;

            while ( !stack.isEmpty()){

                if( (maxInd = findNext(pos)) >= 0){

                    stack.push(maxInd);
                }else{

                    pos = stack.pop();
                    max = stack.isEmpty() ? -1 : a[stack.peek()];
                }
            }
        }

        print(maxLen);
    }

    static int findNext(int startPos){

        for(int i=startPos+1; i<n; i++){

            if(a[i] > max){

                max = a[i]; len++;

                if(len>maxLen)
                    maxLen = len;

                return i;
            }
        }
        len--;

        return -1;
    }

    static void print(int answer){

        PrintWriter printWriter = new PrintWriter(System.out);

        printWriter.println(answer);

        printWriter.flush();
    }

    static int[] getInput(){

        Scanner scanner = new Scanner( System.in);

        n = scanner.nextInt();

        int[] temp = new int[n];

        for(int i=0; i<n; i++)
            temp[i] = scanner.nextInt();

        return temp;
    }
}
