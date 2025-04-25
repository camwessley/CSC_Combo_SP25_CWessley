public class Cow extends Animal {
    private String type;

    public Cow(int height, int weight, String name) {
        super(height, weight, name);
        this.type = "Cow";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void animalSound() {
        System.out.println("Moooo");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}