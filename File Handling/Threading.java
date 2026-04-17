
public class Threading {

    public static void main(String[] args) throws InterruptedException {
        // A t = new A();
        // t.start();
        B r = new B();
        Thread t = new Thread(r);
        t.start();
        for (int i = 0; i <= 5; i++) {
            System.out.println("garvit");
            Thread.sleep(1000);

        }
    }
}
// By Extending Thread class
class A extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("Ketan");
        }
    }
}

// By implementing Runnable interface
class B implements Runnable{
    @Override
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Goyal");
        }
    }
}


// 1. sleep()
// Purpose: Pause the current thread for a fixed time.
// Thread.sleep(1000); // 1 second

// Static method
// Does not release locks
// Throws InterruptedException

// 2. join()
// Purpose: Make the current thread wait until another thread finishes.
// t.join();

// Instance method
// Used for thread coordination
// Throws InterruptedException

// 3. suspend() ❌ (Deprecated)
// Purpose: Pause a thread.

// Deprecated due to deadlock risk
// Thread may hold locks forever
// ❗ Do NOT use

// 4. resume() ❌ (Deprecated)
// Purpose: Resume a suspended thread.

// Deprecated
// Unsafe with suspend()
// ❗ Do NOT use

// 5. yield()
// Purpose: Hint the scheduler to give CPU to another thread.
// Thread.yield();

// Static method
// No guarantee
// Thread stays runnable

// 6. stop() ❌ (Deprecated)
// Purpose: Forcefully stop a thread.

// Deprecated
// Can leave shared data inconsistent
// ❗ Do NOT use

// 7. isAlive()
// Purpose: Check if thread is still running.

// t.isAlive();
// Returns true if thread has started and not terminated

// 8. interrupt()
// Purpose: Request a thread to stop what it’s doing.

// t.interrupt();

// Sets interrupt flag
// If sleeping/waiting → throws InterruptedException
// Safe way to stop a thread cooperatively

// 9. getPriority()
// Purpose: Get thread priority.
// int p = t.getPriority();

// Range: 1 (MIN) to 10 (MAX)
// Default: 5

// 10. setPriority()
// Purpose: Set thread priority.

// t.setPriority(Thread.MAX_PRIORITY);

// Scheduler dependent
// No guarantee of execution order