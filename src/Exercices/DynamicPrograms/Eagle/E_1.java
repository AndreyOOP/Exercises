package Exercices.DynamicPrograms.Eagle;

public class E_1 {

    static int[][] cache = new int[100][10];

    public static void main(String[] args) {

        for(int i=1; i<=10; i++)
            System.out.println( f(100, i));
    }

    /**
     * n - qty of floors
     * k - qty of balls
     * f(n,k) x test floor -> max( f(x-1, k-1), f(n-x, k) )
     * f(n, n) = n
     * f(n, 1) = n
     * test answers
     * f(5, 2) = 3
     * f(100, 2) = 14 */
    static int f(int n, int k){

        int temp;
        int answ = Integer.MAX_VALUE;
        int t = Integer.MAX_VALUE;

        if(cache[n-1][k-1] != 0) return cache[n-1][k-1];

        if(k == 1) return n;

        if(k == n) {

            for(int i=1; i<n; i++){
               int x =  f(n, i);
               t = t > x ? x : t;
            }
            return t;
        }

        for(int i=k; i<n; i++){ //todo check corners...

            temp = Math.max( f(i-1, k-1), f(n-i, k));

            answ = (answ > temp) ? temp : answ;
        }

        cache[n-1][k-1] = answ + 1;

        return answ + 1;
    }
}
