package fr.epita.geometry.datamodel;

public class Rectangle implements Shape {

	private double height;
	private double width;

	public Rectangle(double height, double width) {
		this.height = height;
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public double getPerimeter() {
		return 2 * width + 2 * height;
	}

	@Override
	public double getArea() {
		return width * height;
	}

}
