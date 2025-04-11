abstract class Animals {
    abstract void sound();
}

class cow extends Animals {
    void sound() {
        System.out.println("moo");
    }
}

public class Abstraction {
    public static void main(String[] args) {
        Animals anisound = new cow();
        anisound.sound();
    }
}

