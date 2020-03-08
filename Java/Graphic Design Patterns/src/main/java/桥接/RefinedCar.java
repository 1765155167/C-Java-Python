package 桥接;

public abstract class RefinedCar extends Car{
    public RefinedCar(Engine engine) {
        super(engine);
    }

    @Override
    public void drive() {
        this.engine.start();
        System.out.println("Drive " + getBrand() + " car...");
    }

    protected abstract String getBrand();
}
