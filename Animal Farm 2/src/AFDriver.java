import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AFDriver {
    public static void main(String[] args) {
        File myFile = createFile();
        ArrayList<Animal> animals = readFile(myFile);

        inputNew(animals);

        writeFile(myFile, animals);
        printAnimals(animals);
    }

    private static void inputNew(ArrayList<Animal> animals) {
        Scanner input = new Scanner(System.in);
        Animal ani;
        System.out.println("What is the animal type (Cow, Pig, or Animal):");
        String type = input.next();
        System.out.println("Height:");
        int height = input.nextInt();
        System.out.println("Weight:");
        int weight = input.nextInt();
        System.out.println("Name:");
        String name = input.next();

        if (type.equals("Pig")) {
            System.out.println("Color:");
            String color = input.next();
            ani = new Pig(height, weight, name, color);

        } else if (type.equals("Cow")) {
            ani = new Cow(height, weight, name);
        } else {
            ani = new Animal(height, weight, name);
        }

        animals.add(ani);
    }

    public static ArrayList<Animal> readFile(File myFile) {
        ArrayList<Animal> animals = new ArrayList<>();
        Animal ani;

        try {
            Scanner reader = new Scanner(myFile);
            while (reader.hasNextLine()) {
                String type = reader.nextLine();
                int height = Integer.parseInt(reader.nextLine());
                int weight = Integer.parseInt(reader.nextLine());
                String name = reader.nextLine();

                if (type.equals("Pig")) {
                    String color = reader.nextLine();
                    ani = new Pig(height, weight, name, color);
                } else if (type.equals("Animal")) {
                    ani = new Animal(height, weight, name);
                } else {
                    ani = new Cow(height, weight, name);
                }

                animals.add(ani);
            }

            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return animals;
    }

    public static void printAnimals(ArrayList<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal.getName() + ":");
            System.out.println("Height: " + animal.getHeight());
            System.out.println("Weight: " + animal.getWeight());

            if (animal instanceof Pig) {
                System.out.println("Color: " + animal.getColor());
            }

            System.out.println();
        }
    }

    public static File createFile() {
        File aFarm = new File("AnimalFarm.txt");
        try {
            if (aFarm.createNewFile()) {
                System.out.println("File created: " + aFarm.getAbsolutePath());
            } else {
                System.out.println("File already exists: " + aFarm.getAbsolutePath());
            }
        } catch (java.io.IOException e) {
            System.out.println("File could not be created: " + aFarm.getAbsolutePath());
            e.printStackTrace();
        }
        return aFarm;
    }

    public static void writeFile(File myFile, ArrayList<Animal> animals) {
        try {
            FileWriter myWriter = new FileWriter(myFile.getName());
            for (Animal animal : animals) {
                myWriter.write(animal.getType() + "\n");
                myWriter.write(animal.getHeight() + "\n");
                myWriter.write(animal.getWeight() + "\n");
                myWriter.write(animal.getName() + "\n");
                if (animal.getType().equals("Pig")) myWriter.write(animal.getColor() + "\n");
            }
            myWriter.close();
            System.out.println("Data written to: " + myFile.getAbsolutePath());

        } catch (java.io.IOException e) {
            System.out.println("File could not be written: " + myFile.getAbsolutePath());
            e.printStackTrace();
        }
    }
}