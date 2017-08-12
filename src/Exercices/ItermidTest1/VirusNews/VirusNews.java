package Exercices.ItermidTest1.VirusNews;

import java.util.LinkedList;
import java.util.Scanner;

public class VirusNews {

    static int n;

    public static void main(String[] args) {

        getInput();

        LinkedList<Integer> newFriends = new LinkedList<>();
        int [] projection;

        //add to all lines to check - all line numbers
        //read first line - add to new friends, remove from lines to check
            //while new friends not end
                //get line add new friend - if size changed

        //add to new friends all from selected line

        while ( ! newFriends.isEmpty()){
            //add to projection next friend
        }

    }

    public static void getInput(){

        Scanner scanner = new Scanner( System.in);

        n = scanner.nextInt();

        for(int i=0; i<n*n; i++){
            System.out.print( scanner.nextInt() + " ");
        }
    }

}
