package ItermidTest1.Rectangle;

import java.io.PrintWriter;
import java.util.*;

public class Rectangle {

    static int t;
    static ArrayList<Pair> list;

    public static void main(String[] args) {

        getInput();

        PrintWriter pw = new PrintWriter(System.out);

        for (int i=0; i<t; i++){

            pw.println("Case #" + (i+1));
            pw.println( findQty( list.get(i).n, list.get(i).m));
            pw.flush();
        }
    }

    static LinkedList<Long> factorize(long x){

        LinkedList<Long> list = new LinkedList<>();

        for(long i=2; i<=Math.sqrt(x); i++){
            while (x % i == 0){
                x /= i;
                list.add(i);
            }
        }

        if(x != 1)
            list.add(x);

        return list;
    }

    static long mult(LinkedList<Long> list){

        long res = 1;

        for(Long l: list)
            res *= l;

        return res;
    }

    public static long findQty(long n, long m){

        double curr;
        double prev = 0;

        LinkedList<Long> nList = factorize(n);
        LinkedList<Long> mList = factorize(m);

        HashSet<Long> uniq = new HashSet<>();
        uniq.add((long)1);

        uniq.addAll(nList);
        uniq.addAll(mList);

        clear(nList, uniq);
        clear(mList, uniq);
//        nList.removeAll(uniq);
//        mList.removeAll(uniq);

        n = mult(nList);
        m = mult(mList);

        long un = 1;
        for(Long i: uniq)
            un *= i;


        long max = Math.max(n,m);
        long min = Math.min(n,m);

        long i = 0;

        long qty = 0;

        double z = (double)min/max;

        while (++i <= max){

            curr = (int)(i * z);

            if( curr == i * z)
                qty++;
            else if(curr == prev)
                qty++;
            else
                qty += 2;

            prev = curr;
        }

        return qty * un;
    }

    public static void clear(LinkedList<Long> a, HashSet<Long> un){

        for(Long l: un)
            a.remove(l);
    }

    public static void getInput(){

        Scanner scanner = new Scanner(System.in);

        t = scanner.nextInt();

        list = new ArrayList<>(t);

        for (int i=0; i<t; i++)
            list.add( new Pair(scanner.nextLong(), scanner.nextLong()));
    }

    static class Pair{

        long n; long m;

        Pair(long n, long m){
            this.n = n;
            this.m = m;
        }
    }
}
