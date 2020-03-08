package 桥接;

public class BossCar extends RefinedCar {
    public BossCar(Engine engine) {
        super(engine);
    }

    @Override
    protected String getBrand() {
        return "Boss";
    }
}
