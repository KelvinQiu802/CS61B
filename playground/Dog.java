import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    private static class NameComparator implements Comparator<Dog> {
        @Override
        public int compare(Dog a, Dog b) {
            return a.name.compareTo(b.name);
        }
    }

    private String name;
    private int size;

    public Dog(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public int compareTo(Dog dog) {
        return this.size - dog.size;
    }

    public int size() {
        return size;
    }

    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }

    public static void main(String[] args) {
        // use comparable
        Dog[] dogs = new Dog[]{new Dog("Kelvin", 10),
                new Dog("Lydia", 20),
                new Dog("Jack", 5)};
        Dog biggest = (Dog) Maximizer.max(dogs);
        System.out.println(biggest.size());

        // use comparator
        Comparator<Dog> nc = Dog.getNameComparator();
        Dog d1 = new Dog("Kelvin", 100);
        Dog d2 = new Dog("Lydia", 200);
        if (nc.compare(d1, d2) > 0) {
            System.out.println(d1.name);
        } else {
            System.out.println(d2.name);
        }
    }
}
