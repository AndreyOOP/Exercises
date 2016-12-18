//package ItermidTest1.Dinners;

import java.io.PrintWriter;
import java.util.*;

/**seems this solution become out of memory because of very big fs array*/
/** it is enougth time for collections but problem with memory ? */
public class Dinner {

    //region Variables
    static int f;
    static int s;
    static int b;
    static int k;

    static ArrayList<Integer> priceF = new ArrayList<>();
    static ArrayList<Integer> priceS = new ArrayList<>();
    static ArrayList<Integer> priceB = new ArrayList<>();

    static LinkedList<Integer> fs = new LinkedList<>();
    //endregion

    public static void main(String[] args) {

        getInput();

        for(int i=0; i<f; i++)
            for(int j=0; j<s; j++)
                fs.add( priceF.get(i) + priceS.get(j));

        fs.addAll(priceB);

        Collections.sort(fs);

        printAnswer(fs);
    }

    public static void getInput(){

        Scanner scanner = new Scanner(System.in);

        f = scanner.nextInt();
        s = scanner.nextInt();
        b = scanner.nextInt();

        for(int i=0; i<f; i++)
            priceF.add( scanner.nextInt());

        Collections.sort(priceF);

        for(int i=0; i<s; i++)
            priceS.add( scanner.nextInt());

        Collections.sort(priceS);

        for(int i=0; i<b; i++)
            priceB.add( scanner.nextInt());

        Collections.sort(priceB);

        k = scanner.nextInt();
    }

    public static void printAnswer(LinkedList<Integer> fsb){

        PrintWriter printWriter = new PrintWriter(System.out);

        int z=0;

        for(Integer i: fsb){

            if (z++<k)
                printWriter.print( i + " ");
        }

        printWriter.flush();
    }
}
