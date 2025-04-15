public class Pig extends Animal {
    // data members
    private boolean isHungry;

    public boolean isHungry() {return isHungry;}
    public void setHungry(boolean isHungry) {this.isHungry = isHungry;}

    public Pig() {
    }

    public Pig(boolean isHungry) {
        this.isHungry = isHungry;
    }

    public Pig(String name, int age, double weight, double height, boolean isHungry) {
        super(name, age, weight, height);
        this.isHungry = isHungry;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", weight=" + getWeight() +
                ", height=" + getHeight() +
                ", isHungry=" + isHungry +
                '}';
    }
}