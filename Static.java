public class Static {
    public static void main(String[] args) {
        // Ok.show(); // show is static method so it is associated to class and can be called directly
        System.out.println(Ok.inner.s);
    }
}

class Ok{
    // static int c = 0;

    // static void show(){
    //     System.out.println(c); // can access only static variables
    // }

    static class inner{
        static int s = 10;
    }

}
