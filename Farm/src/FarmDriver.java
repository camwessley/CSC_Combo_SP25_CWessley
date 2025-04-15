public class FarmDriver {
    public static void main(String[] args) {
        Pig pig1 = new Pig("Betsy", 3, 140.00, 40, true);
        Pig pig2 = new Pig();

        pig1.setHungry(false);
        if (pig1.isHungry()) System.out.println(pig1);
    }
}