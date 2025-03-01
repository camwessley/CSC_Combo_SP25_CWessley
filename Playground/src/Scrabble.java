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
            System.out.println("Your word matches!");
        } else {
            System.out.println("Your word doesn't match!");
        }
    }

    public static boolean canSpell(String tiles, String word) {
        int hits = 0;
        for (int letterInTiles = 0; letterInTiles < tiles.length(); letterInTiles++) {
            for (int letterInWord = 0; letterInWord < word.length(); letterInWord++) {
                if (word.charAt(letterInWord) == tiles.charAt(letterInTiles)) {
                    hits++;
                }
            }
        }

        return hits >= word.length();
    }

    public static String randomString(int length) {
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
