package Theory.Algorithms;

public class SumOfNumbers {

    public static void main(String[] args) {

        int n  = 842937621;

        System.out.println(sum(n));
        System.out.println(sumRec(n));
    }

    static int sum(int n){

        int sum = 0;

        while (n > 0){

            sum += n%10;
            n /= 10;
        }

        return sum;
    }

    static int sumRec(int n){

        if(n < 10) return n;

        return sumRec(n/10) + n%10;
    }
}
