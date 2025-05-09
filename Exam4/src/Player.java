public class Player {
    private String name;
    public Die die;

    public Player(String name, int sides) {
        this.name = name;
        this.die = new Die(sides);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", die=" + die +
                '}';
    }
}
