class Animal {
    public void sound() {
        System.out.println("Animals make sounds");
    }
}

class Lion extends Animal {
    @Override
    public void sound() {
        System.out.println("Lion roars");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Animal a = new Lion();
        a.sound();

        Animal b = new Dog();
        b.sound();


    }
}
