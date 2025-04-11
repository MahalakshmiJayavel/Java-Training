class pet {
String name = "snoopy";
int age = 2;
}


class Cat extends pet {
}


public class Inheritance {
    public static void main(String[] args) {
        Cat a = new Cat();
        System.out.println(a.name);
        System.out.println(a.age);
    }
}
