package 桥接;

public class BigCar extends RefinedCar {
    public BigCar(Engine engine) {
        super(engine);
    }

    @Override
    protected String getBrand() {
        return "BigCar";
    }
}
