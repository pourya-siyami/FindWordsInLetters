import java.util.Random;

public class Main {
    public static void main(String[] args) {
        char[][] letters = getChars();
        WordSearch wordSearch = new WordSearch(letters);
        wordSearch.play();
    }

    private static char[][] getChars() {
        Random random = new Random();
        int rows = 3, columns = 3;
        char[][] letters = new char[rows][columns];
        // initializing array elements:
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                char randomizedCharacter = (char) (random.nextInt(26) + 'a');
                letters[i][j] = (randomizedCharacter);
            }
        }
        return letters;
    }
}