//package ItermidTest1.PreparationToCertif;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class CP3 {

    static int n;
    static int [] a;

    static int pos;

    static int max;
    static int len;
    static int maxLen;
    static int maxInd;

    static LinkedList<Integer> stack = new LinkedList<>();

    public static void main(String[] args) {

        a = getInput();

        for (int i=0; i<n; i++) {

//            System.out.println();
//            System.out.println(maxLen);

            stack.push(i); pos = i; max = a[i]; len++;

//            System.out.print(stack.peek() + " ");

            while ( !stack.isEmpty()){

                if( (maxInd = findNext(pos)) >= 0){

                    stack.push(maxInd);
//                    System.out.print(stack.peek() + " ");

                }else{

//                    System.out.print("-" + stack.peek() + " ");
                    pos = stack.pop();

                    max = stack.isEmpty() ? -1 : a[stack.peek()];
                    /*if(stack.isEmpty())
                        max = -1;
                    else
                        max = a[stack.peek()];*/
                }
            }

        }

        print(maxLen);
    }

    /**search figure which is greater than current maximum
     * if found - reassign new max & return index
     * if not found return -1*/
    static int findNext(int startPos){

        for(int i=startPos+1; i<n; i++){

            if(a[i] > max){

                max = a[i];
                len++;

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
