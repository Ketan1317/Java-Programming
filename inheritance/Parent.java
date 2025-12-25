package inheritance;

public class Parent {
    String name = "Parent Class";

    public Parent() {
        super(); // Object Class constructor
        System.out.println("In Parent Constructor");
    }

    void show(){
        System.out.println("In Parent Class");
    }
}
