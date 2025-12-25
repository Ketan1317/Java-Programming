public class RunTimePoly {
    public static void main(String[] args) {

        // Parent reference pointing to Child object → Runtime Polymorphism (Upcasting)
        A obj = new B();

        // Even though obj points to B object, it can only access members defined in class A
        // obj.a = "Changed value"; // Uncommenting this won't affect B's 'a'
        
        // Calling method using Parent reference → calls overridden method if exists in B
        obj.show();  // It will execute A's show() here (not overridden in B)
        
        // obj.ok();       // ❌ Error: Cannot access child-specific methods using Parent reference
        // obj.display();  // ❌ Error: display() is in B, but reference type is A
    }
}

class A {
    // public String a = "A class variable";

    static void show() {
        System.out.println("In A");
    }
}

class B extends A {
    // This variable hides Parent's 'a' (not overriding, just hiding)
    public String a = "B class variable";

    // This method is specific to B, not overriding A's show()
    // void show() {
    //     System.out.println("In B");
    // }

    void display() {
        System.out.println("In display");
    }
}
