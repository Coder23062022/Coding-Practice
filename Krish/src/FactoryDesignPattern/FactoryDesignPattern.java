package src.FactoryDesignPattern;

public class FactoryDesignPattern {
	static void main() {
		ShapeFactory sf = new ShapeFactory();
		Shape shape1 = sf.getShape("Circle");
		shape1.draw();
	}
}
