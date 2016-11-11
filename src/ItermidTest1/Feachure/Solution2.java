package ItermidTest1.Feachure;

import java.io.PrintWriter;
import java.util.*;

public class Solution2 {

    public static int n;

    static HashMap<Integer, Integer> map;

    public static void main(String[] args) {

        map = getInputAndCountFeatures();

        int maxVoutes = Collections.max( map.values());

        LinkedList<Integer> answer = createAnswerSet(map, maxVoutes);

        Collections.sort(answer);

        printResult( answer);
    }

    public static HashMap<Integer, Integer> getInputAndCountFeatures(){

        Scanner scanner = new Scanner( System.in);

        n = scanner.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();
        int featureId = 0;

        for(int i=0; i<n; i++){

            featureId = scanner.nextInt();

            if( map.containsKey( featureId)){

                map.put( featureId, map.get(featureId)+1);
            } else {
                map.put( featureId, 1);
            }
        }

        return map;
    }

    public static LinkedList<Integer> createAnswerSet(HashMap<Integer, Integer> map, int max){

        LinkedList<Integer> answer = new LinkedList<>();

        for(Integer i: map.keySet()){

            if( map.get(i) == max){
                answer.add(i);
            }
        }

        return answer;
    }

    public static void printResult(LinkedList<Integer> list){

        PrintWriter printWriter = new PrintWriter( System.out);

        for(Integer i: list){

            printWriter.print(i);
            printWriter.print(" ");
        }

        printWriter.flush();
    }
}
