public class LastLetter {
    public static void main(String[] args) {

        String fruit = "blackberry";

        for (int i = 0; i < fruit.length(); i++) {
            char letter = fruit.charAt(i);
            System.out.println(letter);
        }

        System.out.println("Last letter: " + fruit.charAt(fruit.length() - 1));
        System.out.println("Reversed: " + reverse(fruit));
        System.out.println("The letter b appears first at index " + fruit.indexOf('b'));
        System.out.println("The letter b appears second at index " + fruit.indexOf('b', 1));
        System.out.println("The letter b appears last at index " + fruit.lastIndexOf('b'));

        System.out.println("The first five letters: " + fruit.substring(0, 5));
        System.out.println("The last five letters: " + fruit.substring(5));
    }

    private static String reverse(String fruit) {
        String r = "";

        for (int i = fruit.length() - 1; i >= 0; i--) {
            r += fruit.charAt(i);
        }

        return r;
    }
}