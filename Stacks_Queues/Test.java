// Test.java
public class Test {
    public static void main(String[] args) throws StackException {
        Custom_Stack stack = new DynamicStack(3);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println(stack.peek()); // 30

        System.out.println(stack.pop()); // 30
        System.out.println(stack.pop()); // 20
        System.out.println(stack.pop()); // 10
        
    }
}
