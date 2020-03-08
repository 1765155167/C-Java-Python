package 桥接;

public class Main {
    public static void main(String[] args) {
        RefinedCar car = new BossCar(new HybridEngine());
        car.drive();
        RefinedCar car1 = new TinyCar(new HybridEngine());
        car.engine = null;
        car1.drive();
    }
}
