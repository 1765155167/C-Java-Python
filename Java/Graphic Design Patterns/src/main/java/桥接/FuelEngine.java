package 桥接;

public class FuelEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Start Fuel Engine...");
    }
}
