package Krish.src.SolidPrinciples.LiskovSubstitution;

public class Main {
    public static void main(String[] args) {
        MotorCar mc = new MotorCar(new Engine());
        ElectricCar ec = new ElectricCar(new Engine());
        mc.turnOnEngine();
        mc.accelerate();
        ec.accelerate();
    }
}