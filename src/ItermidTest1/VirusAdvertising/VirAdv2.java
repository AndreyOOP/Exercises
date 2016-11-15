package ItermidTest1.VirusAdvertising;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class VirAdv2 {

    static int n;
    static int[][] matrix;
//    static LinkedList<Person> persons = new LinkedList<>();

    static LinkedList<Person> in = new LinkedList<>();
    static LinkedList<Person> out = new LinkedList<>();

    static int count;

    public static void main(String[] args) {

        matrix = getInput();

        for(int i=0; i<n; i++)
            Persons.persons.add( new Person(i, false));


        while (!Persons.persons.isEmpty()) {

            in.push( Persons.persons.getFirst()); //add & remove
            Persons.removePers( in.getFirst().id);

            while ( !in.isEmpty()){

                out = new LinkedList<>();

                Person person = in.pop();
                int id = person.id;

                for(int j=0; j<n; j++) //add all friends of person
                    if (matrix[id][j]==1 && !person.cheked){

                        out.push( Persons.getPerson( matrix[id][j]));
                        Persons.removePers( matrix[id][j]);
                    }

                in = out;
                person.cheked = true;
            }

            count++;
        }

        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.print(count);
        printWriter.flush();
    }

    static class Person{

        Integer id;
        Boolean cheked;

        public Person(int id, Boolean cheked) {
            this.id = id;
            this.cheked = cheked;
        }
    }

    static class Persons{

        static LinkedList<Person> persons = new LinkedList<>();

        public static void mark(int id){

            for(Person p: persons)

                if(p.id == id){

                    p.cheked = true;
                    return;
                }
        }

        static void removePers(int id){
            for(Person p: persons)
                if(p.id == id){
                    persons.remove(p);
                    return;
                }
        }

        static Person getPerson(int id){

            for(Person p: persons){
                if(p.id == id)
                    return p;
            }

            return null;
        }
    }

    static int[][] getInput(){

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        int[][] temp = new int[n][n];

        for(int i=0; i<n; i++){

            for(int j=0; j<n; j++){

                temp[i][j] = scanner.nextInt();
            }
        }

        return temp;
    }
}
