class User {
    private String name;
    private String membership;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public String getMembership() {
        return membership;
    }
}

public class encapsulation {
    public static void main(String[] args) {
        User u = new User();
        u.setName("Mahaks");
        u.setMembership("premium");

        System.out.println(u.getName());
        System.out.println(u.getMembership());
    }
}