import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        // [ROW][COLUMN]
        int[][] twoDarray = new int[4][4];

        // Write some values to the Array
        int counter = 0;
        for(int i = 0; i < twoDarray.length; i++) {
            for(int j = 0; j < twoDarray[0].length; j++) {
                twoDarray[i][j] = counter;
                counter++;
            }
        }
        // Check findPossibleNeighbours for all fields
        for(int i = 0; i < twoDarray.length; i++) {
            for(int j = 0; j < twoDarray[0].length; j++) {
                findPossibleNeighbours(i, j, twoDarray);
            }
        }
    }
    public static void findPossibleNeighbours(int x, int y, int[][] array) {
        ArrayList<Coordinates> possibleNeighbours = new ArrayList<>();

        // Check vertical neighbours
        for(int xi = x - 1; xi <= x + 1; xi++) {
            // don't add yourself and check if coordinates are actually in the grid
            if(xi != x && inField(xi, y, array)) {
                System.out.println("Neighbor to " + x + ", " + y + " - " + xi + ", " + y);
                possibleNeighbours.add(new Coordinates(xi, y));
            // if arrived at initial x start looking horizontal for neighbours
            } else if (xi == x) {
                for(int yj = y - 1; yj <= y + 1; yj++) {
                    // don't add yourself and check if coordinates are actually in the grid
                    if(yj != y && inField(xi, yj, array)) {
                        System.out.println("Neighbor to " + x + ", " + y + " - " + xi + ", " + yj);
                        possibleNeighbours.add(new Coordinates(xi, yj));
                    }
                }
            }
        }
        System.out.println(possibleNeighbours);
        System.out.println();
    }
    public static boolean inField(int x, int y, int[][] array) {
        return x >= 0 && x <= array.length - 1 && y >= 0 && y <= array[0].length - 1;
    }
}
