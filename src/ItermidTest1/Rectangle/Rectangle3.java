package ItermidTest1.Rectangle;

import java.io.PrintWriter;
import java.util.*;

/**atm the best solution - 9 of 10 cases, 1 time limit ...*/
public class Rectangle3 {

    static int t; /**qty of test cases*/
    static ArrayList<Pair> nmList; /**list of input n,m pairs*/

    public static void main(String[] args) {

        getInput();

        PrintWriter pw = new PrintWriter(System.out);

        for (int i=0; i<t; i++){

            long n = nmList.get(i).n;
            long m = nmList.get(i).m;

            LinkedList<Long> nList = factorize(n);
            LinkedList<Long> mList = factorize(m);

            LinkedList<Long> sameM = findSameMultiplier(nList, mList);

            long mult = generateFigure(sameM);

            n /= mult;
            m /= mult;

            pw.println("Case #" + (i+1));
            pw.println( mult * ( n + m - 1)); /**if vzaimnoprstue -> qty of diagonal m+n-1*/
            pw.flush();
        }
    }

    static long generateFigure(LinkedList<Long> list){

        long result = 1;

        for(Long l: list)
            result *= l;

        return result;
    }

    //todo calculate same multiplier here
    static LinkedList<Long> findSameMultiplier(LinkedList<Long> nList, LinkedList<Long> mList){

        LinkedList<Long> result = new LinkedList<>();

        for(Long l: nList)
            if(mList.contains(l)){
                result.add(l);
                mList.remove(l);
            }

        return result;
    }

    static LinkedList<Long> factorize(long x){

        LinkedList<Long> result = new LinkedList<>();

        for (long i=2; i<=Math.sqrt(x)+1; i++) {
            while (x%i == 0){
                result.add(i);
                x /= i;
            }
        }

        if(x != 1)
            result.add(x);

        return result;
    }

    public static void getInput(){

        Scanner scanner = new Scanner(System.in);

        t = scanner.nextInt();

        nmList = new ArrayList<>(t);

        for (int i=0; i<t; i++)
            nmList.add( new Pair(scanner.nextLong(), scanner.nextLong()));
    }

    static class Pair{

        long n; long m;

        Pair(long n, long m){
            this.n = n;
            this.m = m;
        }
    }
}
