



public class OOP1 {
    public static void main(String[] args) {

        // This line creates an array of size 3.
        // Student[] arr = new Student[3];
        // IMPORTANT: It only reserves space for 3 Student objects.
        // It does NOT create actual Student objects.....Default Value -> Null

        // System.out.println(Arrays.toString(arr));

        // created objects like this
        // arr[0] = new Student();
        // System.out.println(arr[0].name);

        // Student std = new Student(17, "Ketan");

        // Throwing an Object as a parameter
        // Student std2 = new Student(std);

        // System.out.println(std2.name + "  " + std2.num);

        Student std2 = new Student();
        System.out.println(std2.name + "  " + std2.num);



    }
}


class Student{
    public
        int num;
        String name;

    public Student() {
        // Calling contructor from another constructor
        this(69,"Ohh yeahhh");
    }
        
    public Student(Student other) {
        this.num = other.num;
        this.name = other.name;
    }

    public Student(int num,String name) {
        this.num = num;
        this.name = name;
    }
}
