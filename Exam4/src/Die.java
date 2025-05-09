import java.util.Random;

public class Die {
    private int numSides;
    private int value;

    public Die() {
        this.numSides = 6;
        this.value = 1;
    }

    public Die(int sides) {
        this.numSides = sides;
        this.value = 1;
    }

    public int getNumSides() {
        return numSides;
    }

    public void setNumSides(int sides) {
        this.numSides = sides;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Die{" +
                "numSides=" + numSides +
                ", value=" + value +
                '}';
    }

    public void roll() {
        Random random = new Random();
        value = random.nextInt(numSides) + 1;
    }
}