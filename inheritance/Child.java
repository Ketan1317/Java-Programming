package inheritance;

public class Child extends Parent {
    String name = "Child Class";
    int num = 90;

    public Child() {
        // super();
        System.out.println("In Child Constructor");
    }

    @Override
    void show(){
        super.show();
        System.out.println("In Child Class");
    }
}
