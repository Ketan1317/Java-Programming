
// Example of Runtime Polymorphism in Java using Method Overriding
public class RunTime {
    public static void main(String[] args) {
        final Animal myAnimal = new Animal(); // Animal reference and object
        Animal myDog = new Dog(); // Animal reference but Dog object

        myAnimal.sound(); // Outputs "Animal makes a sound"
        myDog.sound();    // Outputs "Dog barks"
    }

    
}
// Final classes cannot be extended
class Animal {
    // final methods cannot be overridden
    // static methods Can Also Not be overridden
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}