public class Animal {
    // data members
    private String name;
    private int age;
    private double weight;
    private double height;

    public double getHeight() {return height;}
    public void setHeight(double height) {this.height = height;}
    public double getWeight() {return weight;}
    public void setWeight(double weight) {this.weight = weight;}
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Animal() {
    }

    public Animal(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
