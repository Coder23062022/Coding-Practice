package FactoryDesignPattern;

public class FactoryDesignPattern {
	public static void main(String[] args) {
		ShapeFactory sf = new ShapeFactory();
		Shape shape1 = sf.getShape("Circle");
		shape1.draw();
	}
}
