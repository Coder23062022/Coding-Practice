package Krish.src.SolidPrinciples.LiskovSubstitution;

public class ElectricCar implements EnginelessCar {
    private final Engine engine;

    public ElectricCar(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void accelerate() {
        engine.accelerate();
    }
}