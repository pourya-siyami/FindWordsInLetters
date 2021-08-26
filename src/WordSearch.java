import java.util.Scanner;

public class WordSearch {
    private char[][] array;
    private String targetWord;
    private int rowLocation;
    private int colLocation;

    public WordSearch(char[][] inArray) {
        array = inArray;
    }

    public void play() {
        do {
            for (int row = 0; row < array.length; row++) {
                for (int col = 0; col < array[row].length; col++) {
                    System.out.print(array[row][col]);
                }
                System.out.println();
            }

            System.out.println();
            Scanner input = new Scanner(System.in);
            System.out.println("What word would you like to search for? Type end to quit: ");
            targetWord = input.nextLine();
            System.out.println("Typed in: " + targetWord);
            System.out.println();

            compareFirst(targetWord);
        } while (!targetWord.equals("end"));
    }

    public void compareFirst(String inWord) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if (array[row][col] == inWord.charAt(0)) {

                    rowLocation = row;
                    colLocation = col;

                    suspectAnalysis();
                }
            }
        }
    }

    public void suspectAnalysis() {
        checkRight();
        checkDown();
        checkDiagonal();
    }

    public void checkRight() {
        for (int i = 1; i < (targetWord.length()); i++) {
            if (colLocation + i > array[0].length - 1) {
                return;
            } else if (array[rowLocation][colLocation + i] != targetWord.charAt(i)) {
                return;
            }
        }
        System.err.println(targetWord + " found horizontally at row " + rowLocation + " and column " + colLocation);
        System.out.println();
        return;
    }

    public void checkDown() {
        for (int i = 1; i < (targetWord.length()); i++) {
            if (rowLocation + i > array.length - 1 && colLocation + i > array[0].length - 1) {
                return;
            } else if (array[rowLocation + i][colLocation] != targetWord.charAt(i)) {
                return;
            }
        }
        System.err.println(targetWord + " found vertically at row " + rowLocation + " and column " + colLocation);
        System.out.println();
        return;
    }

    public void checkDiagonal() {
        for (int i = 1; i < (targetWord.length()); i++) {
            if (colLocation + i > array[0].length - 1 || rowLocation + i > array.length - 1) {
                return;
            } else if (array[rowLocation + i][colLocation + i] != targetWord.charAt(i)) {
                return;
            }
        }
        System.err.println(targetWord + " found diagonally at row " + rowLocation + " and column " + colLocation);
        System.out.println();
    }
}