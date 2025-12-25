interface Practice {

    // Abstract methods (must be implemented by child classes)
    void display(String name);
    void show(int age);

    // Static method (belongs to the interface itself)
    static void addressShow(String addr) {
        System.out.println("The address is: " + addr);
    }

    // Default method (can be used directly or overridden)
    default void countryShow(String country) {
        System.out.println("The Country is: " + country);
    }
}

interface Sample{
    default void countryShow(String country) {
        System.out.println("The Name of the country is: " + country);
    }
}


// ✅ Class implementing the interface
class Human implements Practice,Sample {

    // Implementing abstract method 'display'
    @Override
    public void display(String name) {
        System.out.println("Name: " + name);
    }

    // Implementing abstract method 'show'
    @Override
    public void show(int age) {
        System.out.println("Age: " + age);
    }

    // Optional: overriding default method
    @Override
    public void countryShow(String country) {
        System.out.println("Country (Overridden): " + country);
    }
}


// ✅ Main class to test everything
public class Test {
    public static void main(String[] args) {

        Human h = new Human();
        h.display("Ketan Goyal");
        h.show(20);

        // Calling overridden default method
        h.countryShow("India");

        // Calling static method of interface (note: called via interface name)
        Practice.addressShow("Pune, Maharashtra");
    }
}
