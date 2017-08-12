package Exercices.ItermidTest1.Dinners;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Dinner2 {

    //region Variables
    static int f;
    static int s;
    static int b;
    static int k;

    static ArrayList<Integer> priceF = new ArrayList<>();
    static ArrayList<Integer> priceS = new ArrayList<>();
    static ArrayList<Integer> priceB = new ArrayList<>();

    static int stateI  = 0;
    static int stateJ  = 0;
    static int stateI_ = 0;
    static int stateJ_ = 0;

    //endregion

    public static void main(String[] args) {

        getInput();

        ArrayList<Integer> fs = new ArrayList<>( Math.min(100000, f*s + b ));

        Collections.sort(priceF);
        Collections.sort(priceS);

        int fFrom=0, sFrom=0;
        int fTo=0, sTo=0;
        int sum1, sum2;
        int c = 0;

        sum1 = priceF.get(0) + priceS.get(0);
        sum2 = sum1;

        sum1 = getNextF();
        sum2 = getNextS();

        if(sum1 <= sum2){
            fs.add(sum1);
            sum1 = getNextF();
        }else {
            fs.add(sum2);
            sum2 = getNextS();
        }



        while (++c <= k && fFrom<f && sFrom<s){

            if(sum1 <= sum2){

                fs.add(sum1);
                if(++sTo>=s){
                    sTo=0;
                    fFrom++;
                }
                sum1 = priceF.get(fFrom) + priceS.get(sTo);

            } else {

                fs.add(sum2);
                if(++fTo>=f) {
                    fTo=0;
                    sFrom++;
                }
                sum2 = priceS.get(sFrom) + priceF.get(fTo);
            }
        }

        if(fFrom == f)
            for(int i=sFrom; i<s; i++)
                for(int j=0; j<f; j++)
                    if(++c<k+2*f)
                        fs.add(priceS.get(i) + priceF.get(j));

        if(sFrom == s)
            for(int i=fFrom; i<f; i++)
                for(int j=0; j<s; j++)
                    if(++c<k+2*s)
                        fs.add(priceS.get(j) + priceF.get(k));


        fs.addAll(priceB);

        Collections.sort(fs);

        printAnswer(fs);
    }

    public static int getNextF(){

        for(int i=stateI; i<f; i++)

            for(int j=stateJ; j<s; j++){

                stateI = i; stateJ = j;

                return priceF.get(i) + priceS.get(j);
            }

        return -1;
    }

    public static int getNextS(){

        for(int i=stateI_; i<s; i++)

            for(int j=stateJ_; j<f; j++){

                stateI_ = i; stateJ_ = j;

                return priceF.get(j) + priceS.get(i);
            }

        return -1;
    }

    public static void getInput(){

        Scanner scanner = new Scanner(System.in);

        f = scanner.nextInt();
        s = scanner.nextInt();
        b = scanner.nextInt();

        for(int i=0; i<f; i++)
            priceF.add( scanner.nextInt());

        for(int i=0; i<s; i++)
            priceS.add( scanner.nextInt());

        for(int i=0; i<b; i++)
            priceB.add( scanner.nextInt());

        k = scanner.nextInt();

        scanner.close();
    }

    public static void printAnswer(ArrayList<Integer> fsb){

        PrintWriter printWriter = new PrintWriter(System.out);

        for(int i=0; i<k; i++)
            printWriter.print( fsb.get(i) + " ");

        printWriter.flush();
        printWriter.close();
    }
}
