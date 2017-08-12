package Exercices.ItermidTest1.Rectangle;

import java.io.PrintWriter;
import java.util.*;

public class Rectangle2 {

    static int t; /**qty of test cases*/
    static ArrayList<Pair> nmList; /**list of input n,m pairs*/

    static long prev;
    static long curr;
    static long diag;

    public static void main(String[] args) {

        getInput();

        PrintWriter pw = new PrintWriter(System.out);

        for (int i=0; i<t; i++){

            long n = nmList.get(i).n;
            long m = nmList.get(i).m;

//            LinkedList<Long> nList = factorize(n);
//            LinkedList<Long> mList = factorize(m);

//            LinkedList<Long> sameM = findSameMultiplier(nList, mList);
            LinkedList<Long> sameM= factorizeSameMultiplier(n,m);

            long mult = generateFigure(sameM);

            n /= mult;
            m /= mult;

            pw.println("Case #" + (i+1));
//            pw.println( mult * findDiagonal1(n, m));
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

    static LinkedList<Long> findSameMultiplier(LinkedList<Long> nList, LinkedList<Long> mList){

        LinkedList<Long> result = new LinkedList<>();

        for(Long l: nList)
            if(mList.contains(l)){
                result.add(l);
                mList.remove(l);
            }

        return result;
    }

    static LinkedList<Long> factorizeSameMultiplier(long n, long m){ //todo to check logic

        LinkedList<Long> result = new LinkedList<>();
        result.add((long)1);

        long max = Math.max(n,m);

        for (long i=2; i<=Math.sqrt(max)+1; i++) {
            while (n%i == 0 && m%i==0){
                result.add(i);
                n /= i;
                m /= i;
            }
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

    static LinkedList<Long> factorizeFerma(long n){

        LinkedList<Long> result = new LinkedList<>();

        long x = (long) Math.sqrt(n)+1;
        long y = 0;
        long r = x*x - y*y - n;

        long a=0;

        while (r != 0){

            if(r==0){

                a = x!=y ? x-y : x+y;
                result.add(a);
            } else {
                if(r>0){
                    r -= y+y+1;
                    ++y;
                }else {
                    r += x+x+1;
                    ++x;
                }
            }
            n /= a;
        }

        return result;
    }

    /**first working version*/
    static long findDiagonal1(long n, long m){

        prev = 0; curr = 0; diag = 0;

        if(n==m) return n;

        long min = Math.min(n,m);
        long max = Math.max(n,m);

        double z = (double) min/max;

        for(long i=1; i<=max; i++){

            curr = (long) (i*z);
            diag = (prev == curr) || (curr == i*z) ? diag+1 : diag+2; /**3 cases but very long execution time*/
            prev = curr;
        }

        return diag;
    }

    /**try to speed up, calculated only half of max*/
    static long findDiagonal2(long n, long m){

        if(n==m) return n;

        long min = Math.min(n,m);
        long max = Math.max(n,m);

        double z = (double) min/max;

        for (long i=1; i<=max/2; i++){

            curr = (long) (i*z);
            diag = (prev == curr) || (curr == i*z) ? diag+1 : diag+2;
            prev = curr;
        }

        diag *= 2;

        if(max%2 != 0){
            long i = max/2+1;
            curr = (long) (i*z);
            diag = (prev == curr) || (curr == i*z) ? diag+1 : diag+2;
        }

        return diag;
    }

    static long findDiagonal3(long n, long m){

        if(n==m) return n;

        long min = Math.min(n,m);
        long max = Math.max(n,m);

        double z = (double) min/max;
        double temp = 0;

        for(long i=1; i<=max; i++){

            temp += z; /** do not work in this way...*/
            curr = (long) temp;
            diag = (prev == curr) || (curr == i*z) ? diag+1 : diag+2; /**3 cases but very long execution time*/
            prev = curr;
        }

        return diag;
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
