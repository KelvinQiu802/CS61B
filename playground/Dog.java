public class Dog implements MyComparable {
    private String name;
    private int size;

    public Dog(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public int compareTo(Object o) {
        return this.size - ((Dog) o).size;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Dog[] dogs = new Dog[]{new Dog("Kelvin", 10),
                new Dog("Lydia", 20),
                new Dog("Jack", 5)};
        Dog biggest = (Dog) Maximizer.max(dogs);
        System.out.println(biggest.size());
    }
}
