package Krish.src.SolidPrinciples.LiskovSubstitution;

public class MotorCar implements CarWithEngine {
    private final Engine engine;

    public MotorCar(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void turnOnEngine() {
        engine.on();
    }

    @Override
    public void accelerate() {
        engine.accelerate();
    }
}