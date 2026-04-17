
public class ThreadScheduling {

    public static void main(String[] args) {
        A t1 = new A();
        A t2 = new A();
        A t3 = new A();
        t1.setName("t1");
        t3.setName("t3");
        t2.setName("t2");
        t1.start();
        t2.start();
        t3.start();
        String name = Thread.currentThread().getName();

        for (int i = 0; i < 3; i++) {
            System.out.println(name);
        }

    }
}

class A extends Thread {

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 3; i++) {
            System.out.println(name);
        }
    }
}



// 1. Method-Level Synchronization ->
// Entire method is synchronized

// public synchronized void increment() {
//     count++;
// }

// Lock Used
// Object lock (this)

// Key Points :
// Simple to use
// Slower (large critical section)
// Only one thread per object can execute

// 2. Block-Level Synchronization ->
// Only a specific block is synchronized

// void increment() {
// ;;;;;;; 1000 KLOC
//     synchronized(this) {
//         count++;
//     }
// ;;;;;;; 1000 KLOC
// }

// Lock Used
// Depends on object inside synchronized(...)

// Key Points :
// Better performance
// Fine-grained control



// 1. Normal (instance) synchronized
// Synchronizes non-static methods or blocks
// Works at object level

// synchronized void increment() {
//     count++;
// }

// Lock Used
// Object lock (this)

// Key Points
// Each object has its own lock
// Threads working on different objects can run in parallel
// Used to protect instance variables

// 2. Static synchronized
// Synchronizes static methods
// Works at class level

// static synchronized void display() {
// }

// Lock Used
// Class object lock

// Key Points
// One lock for all objects
// Threads across all instances are blocked
// Used to protect static (class-level) data
