interface petAnimal {
    default void sound() {
        System.out.println("Animal makes sound");
    }
}

interface DogTrait {
    default void sound() {
        System.out.println("Dog barks");
    }
}

interface PetTrait  {
    default void sound() {
        System.out.println("Pet makes soft sound");
    }
}

class FriendlyDog implements DogTrait, PetTrait {
    @Override
    public void sound() {
        DogTrait.super.sound();

       // DogTrait.super.sound();  // or PetTrait.super.sound();
    }
}

public class DiamondProblem {
    public static void main(String[] args) {
        FriendlyDog dog = new FriendlyDog();
        dog.sound();
    }
}
