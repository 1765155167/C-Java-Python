package Interface;

public class Person implements Interface {

    @Override
    public void working() {
        System.out.println("working");
    }

    @Override
    public void playing() {
        System.out.println("playing");
    }

    @Override
    public void studying() {
        System.out.println("studying");
    }
}
