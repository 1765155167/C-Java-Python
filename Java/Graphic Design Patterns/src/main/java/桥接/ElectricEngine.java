package 桥接;

public class ElectricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Start Electric Engine...");
    }
}
