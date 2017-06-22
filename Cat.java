public class Cat {
    private String name = null;
    private int age = 5;
    private int weight = 5;
    private String address = null;
    private String color = "zzz";

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public Cat(int weight, String color) {

        this.weight = weight;
        this.color = color;
    }

    public Cat(int weight, String color, String address) {
        this.weight = weight;
        this.color = color;
        this.address = address;

    }

    public static void main(String[] args) {

    }
}