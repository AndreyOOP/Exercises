package Premutation;

public class Premutation {

    static int length;
    static String [] alphbet;

    public static void main(String[] args) {

        length  = 3;
        alphbet = new String[]{"a", "b", "c", "d"};

//        printAllPremutations();
//        withoutRepeating();
        allRecursive("", "abcdefg"); //for all length todo add for length 2, 3 etc
    }

    public static void printAllPremutations(){

        for (int i=0; i<alphbet.length; i++){

            for (int j=0; j<alphbet.length; j++){

                for (int k=0; k<alphbet.length; k++) {

                    System.out.println(alphbet[i] + alphbet[j] + alphbet[k]);
                }
            }
        }
    }

    public static void withoutRepeating(){

        for (int i=0; i<alphbet.length; i++){

            for (int j=0; j<alphbet.length; j++){

                if ( !alphbet[i].equals(alphbet[j]) ) {

                    for (int k=0; k<alphbet.length; k++) {

                        if ( !alphbet[i].equals( alphbet[k]) && !alphbet[j].equals( alphbet[k])) {

                            System.out.println(alphbet[i] + alphbet[j] + alphbet[k]);
                        }
                    }
                }
            }
        }
    }

    public static void allRecursive(String prefix, String str){

        int n = str.length();

        if( n > 0){

            for(int i=0; i<n; i++){

                String newPrefix = prefix + str.charAt(i);

                String newStr    = str.substring(0, i) + str.substring(i+1, n);

                allRecursive(newPrefix, newStr);
            }

        }else
            System.out.println(prefix);
    }
}
