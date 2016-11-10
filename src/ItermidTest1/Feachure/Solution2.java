package ItermidTest1.Feachure;

import java.util.*;

public class Solution2 {

    public static int n;

    public static List<Integer> f;

    public static void main(String[] args) {

        getInput();

        Set<Integer> unique = new HashSet<>(f);

        for (Integer i: unique) {
            for(Integer j: f){
                if(i == j){
                    i.
                }

            }
        }
    }

    public static void getInput(){

        Scanner scanner = new Scanner( System.in);

        n = scanner.nextInt();

        f = new ArrayList<>();

        for(int i=0; i<n; i++){
            f.add( scanner.nextInt());
        }
    }
}
