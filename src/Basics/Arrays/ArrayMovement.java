package Basics.Arrays;

/*modeMap.put(Mode.RIGHT, new ModeInfo( 1,  0));
        modeMap.put(Mode.LEFT , new ModeInfo(-1,  0));
        modeMap.put(Mode.UP   , new ModeInfo( 0, -1));
        modeMap.put(Mode.DOWN , new ModeInfo( 0,  1));*/

/**It is possible to realise via hash map for switch mode based on conditions*/
import java.util.HashMap;

public class ArrayMovement {

    static int n = 6;
    static int a[][] = new int[n][n];
    static HashMap<Integer, ModeInfo> modeMap = new HashMap<>();

    public static void main(String[] args) {

        populateArray();

        print(a);

        System.out.println();

        int[] dx = new int[] {0, 1,  0};
        int[] dy = new int[] {1, 0, -1};
        arrayMovement(dx, dy, Mode.DOWN);
    }

    static void arrayMovement(int[] dx, int[] dy, int mode){

        int i = 0;int j = 0;int k = 0;

        while ( ++k <= n*n){

            mode = getMode(i, mode); /**Change to hash map -> key conditions - output mode*/

            printElement(i, j);

            i += dy[mode];
            j += dx[mode];
        }

    }

    static int getMode(int i, int mode){

        if(i==n-1 && mode == Mode.DOWN)
            return Mode.RIGHT;

        else if(i==n-1 && mode == Mode.RIGHT)
            return Mode.UP;

        else if (i==0 && mode == Mode.UP)
            return Mode.RIGHT;

        else if (i==0 && mode == Mode.RIGHT)
            return Mode.DOWN;

        return mode;
    }

    static void printElement(int i, int j){

        if(a[i][j]<10)
            System.out.print(a[i][j] + "  ");
        else
            System.out.print(a[i][j] + " ");
    }

    static void populateArray(){

        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                a[i][j] = n*i + j + 1;
    }

    static void print(int[][] arr){

        for(int i=0; i<arr.length; i++){

            for(int j=0; j<arr.length; j++)
                printElement(i, j);

            System.out.println();
        }
    }

    interface Mode{

        Integer DOWN  = 0;
        Integer RIGHT = 1;
        Integer UP    = 2;
        Integer LEFT  = 3;
    }

    static class ModeInfo{

        int x;
        int y;

        public ModeInfo(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
