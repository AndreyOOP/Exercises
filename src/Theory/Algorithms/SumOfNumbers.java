package Theory.Algorithms;

public class SumOfNumbers {

    public static void main(String[] args) {

        long n  = 842937621;

        int sum = 0;

        while (n > 0){

            sum += n%10;
            n /= 10;
        }

        System.out.println(sum);
    }
}
