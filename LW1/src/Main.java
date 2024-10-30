public class Main {
    public static void main(String[] args)
    {
        Animal animal = new Animal() {
            @Override
            public void eat() {
                System.out.println("Animal is eating");
            }
        };
        animal.eat();
    }
}

