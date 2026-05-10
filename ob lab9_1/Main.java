import java.util.ArrayList;
import java.util.List;

class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class Lion extends Animal {
    Lion(String name) {
        super(name);
    }
}

class Crane extends Animal {
    Crane(String name) {
        super(name);
    }
}

class Zoo<T extends Animal> {

    public void transferAnimals(
            List<? extends T> source,
            List<? super T> destination) {

        for (T animal : source) {
            destination.add(animal);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        List<Lion> lions = new ArrayList<>();
        lions.add(new Lion("Arslan"));

        List<Animal> animals = new ArrayList<>();

        Zoo<Animal> zoo = new Zoo<>();

        zoo.transferAnimals(lions, animals);

        animals.add(new Crane("Togoruu"));

        for (Animal a : animals) {
            System.out.println(a);
        }
    }
}