package Krish.src.SolidPrinciples.LiskovSubstitution;

public class Main {
    static void main() {
        MotorCar mc = new MotorCar(new Engine());
        ElectricCar ec = new ElectricCar(new Engine());
        mc.turnOnEngine();
        mc.accelerate();
        ec.accelerate();
    }
}