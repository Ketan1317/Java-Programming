interface first{
    default void show(){
        System.out.println("Hello from first");
    }
}
interface second{
    default void show(){
        System.out.println("Hello from second");
    }
}


class Middle implements first,second{

    @Override
    public void show(){
        second.super.show();
    }

}

public class ResolveAmbiguity {
    
}
