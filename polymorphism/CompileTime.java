// Example of Compile-Time or Static Polymorphism using Method Overloading
public class CompileTime {
    void show(int num) {
        System.out.println("In CompileTime class: " + num); 
    }

    void show(String str) {
        System.out.println("In CompileTime class: " + str); 
    }

    public static void main(String[] args) {
        CompileTime obj = new CompileTime();
        obj.show(90);          // Calls show(int num)
        obj.show("Hello");    // Calls show(String str)
    }
    
}
