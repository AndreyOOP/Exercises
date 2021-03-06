package Exercices.ItermidTest1.SisterBro;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**4 answers are incorrect, not clear why?*/
public class SisterBrother {

    //region Variables
    static int n; //qty of programmers
    static int m; //links
    static int q;

    static int a;
    static int b;

    static LinkedList<HashSet<Integer>> list = new LinkedList<>(); /**list of founded relatives*/

    static HashSet<Integer> setA;
    static HashSet<Integer> setB;
    static HashSet<Integer> temp;

    static Boolean found;

    static PrintWriter printWriter = new PrintWriter(System.out);
    //endregion

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt(); //is n uses somewhere ?
        m = scanner.nextInt();

        for(int i=0; i<m; i++){

            a = scanner.nextInt(); b = scanner.nextInt();

            setA = getSet(a); setB = getSet(b);

            if(setA == null && setB == null){       /**no set with a and b -> create new HashSet*/

                temp = new HashSet<>();

                temp.add(a); temp.add(b);

                list.add(temp);

            } else if(setA != null && setB == null){ /**only a or b in set -> add a or b to set*/

                setA.add(b);

            } else if(setA == null && setB != null){ /**only a or b in set -> add a or b to set*/

                setB.add(a);

            } else if(setA != setB){                 /**a & b in different sets -> merge sets*/

                list.remove(setB);
                setA.addAll(setB);
            }                                       /**a & b in the same set -> nothing*/
        }

        q = scanner.nextInt();

        for(int i=0; i<q; i++){

            a = scanner.nextInt(); b = scanner.nextInt();
            found = false;

            for(HashSet<Integer> set: list){

                if(set.contains(a) && set.contains(b)){

                    printWriter.println(":)");
                    found = true;
                    break;
                }
            }

            if ( !found)
                printWriter.println(":(");
        }

        printWriter.flush();
    }

    static HashSet<Integer> getSet(int i){

        for(HashSet<Integer> set: list){

            if(set.contains(i))
                return set;
        }

        return null;
    }
}
