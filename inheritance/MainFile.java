package inheritance;

public class MainFile {
    public static void main(String[] args) {
        // As the reference is of Parent class, it will access the Parent class members only
        Parent c = new Child();

        System.out.println("Child name: " + c.name);
        System.out.println("Parent name: " + ((Parent)c).name);

        c.show();
    }
}
