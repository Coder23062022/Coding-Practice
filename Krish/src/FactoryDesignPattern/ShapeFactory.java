package src.FactoryDesignPattern;

public class ShapeFactory {
	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if ("Rectangle".equalsIgnoreCase(shapeType)) {
			return new Rectangle();
		} else if ("Circle".equalsIgnoreCase(shapeType)) {
			return new Circle();
		} else if ("Square".equalsIgnoreCase(shapeType)) {
			return new Square();
		}
		return null;
	}
}
