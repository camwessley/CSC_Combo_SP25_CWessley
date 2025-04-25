public class Pig extends Animal {
    private String color;
    private String type;

    public Pig(int height, int weight, String name, String color) {
        super(height, weight, name);
        this.color = color;
        this.type = "Pig";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void animalSound() {
        System.out.println("Oink");
    }

    @Override
    public String toString() {
        return super.toString() + " Pig [color=" + color + "]";
    }
}