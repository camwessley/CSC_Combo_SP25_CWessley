import java.util.Random;
import java.util.Scanner;

public class Scrabble {
    public static void main(String[] args) {

        String tiles = randomString(7);
        System.out.println("Tiles: " + tiles);

        Scanner input = new Scanner(System.in);
        System.out.print("Enter word: ");
        String word = input.nextLine();
        input.close();

        if (canSpell(tiles, word)) {
            System.out.println("Your word matches!\n");
        } else {
            System.out.println("Your word doesn't match!\n");
        }
    }

//    public static boolean canSpell(String tiles, String word) {
//        int hits = 0;
//        for (int letterInTiles = 0; letterInTiles < tiles.length(); letterInTiles++) {
//            for (int letterInWord = 0; letterInWord < word.length(); letterInWord++) {
//                if (word.charAt(letterInWord) == tiles.charAt(letterInTiles)) {
//                    hits++;
//                }
//            }
//        }
//        return hits >= word.length();
//    }

    // Enforce using only available tiles
    public static boolean canSpell(String tiles, String word) {
        char[] tileArray = tiles.toCharArray();

        for (char c : word.toCharArray()) {
            boolean found = false;

            for (int i = 0; i < tileArray.length; i++) {

                if (c == tileArray[i]) {

                    // Mark the tile as used with null char
                    tileArray[i] = '\0';
                    found = true;

                    break;
                }
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }

    public static String randomString(int length) {

        //noinspection SpellCheckingInspection
        String alph = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder s = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alph.length());
            s.append(alph.charAt(index));
        }

        return s.toString();
    }
}
