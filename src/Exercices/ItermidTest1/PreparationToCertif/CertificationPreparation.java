package Exercices.ItermidTest1.PreparationToCertif;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class CertificationPreparation {

    static int n;
    static int [] a;

    static LinkedList<Integer> stack = new LinkedList<>();

    static int startPos = 1;
    static int currMax = -1;
    static int next;

    static int max;
    static int depth;

    static PrintWriter printWriter = new PrintWriter(System.out);

    public static void main(String[] args) {

        a = getInput();

        for(int i=0; i<n; i++)
            searchInDepth(i);

        printWriter.println(max);
        printWriter.flush();
    }


    static void searchInDepth(int startPosition){

        stack.push(startPosition);

        startPos = startPosition;
        currMax  = a[startPosition];
        depth++;

        while ( !stack.isEmpty()){

            next = findNext(a, startPos, currMax);

            if(next>0){

                stack.push(next);

                startPos = next;

                currMax = a[next];

                depth++;

                if(depth>max)
                    max = depth;

            } else {

                startPos = stack.pop()+1;

                currMax = stack.isEmpty() ? -1: a[stack.peek()];

                depth--;
            }
        }
    }

    static int findNext(int[] arr, int startPos, int prevMax){ //find next figure which is greater than current, return next position which is greater

        int i = startPos;
        int n = arr.length;

        while (i < n){

            if(arr[i] > prevMax)
                return i;

            i++;
        }

        return -1;
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
