package 桥接;

public class TinyCar extends RefinedCar {
    public TinyCar(Engine engine) {
        super(engine);
    }

    @Override
    protected String getBrand() {
        return "TinyCar";
    }
}
