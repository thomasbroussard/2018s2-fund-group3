package fr.epita.geometry.datamodel;


/**
 * This class will be part of the geometry datamodel, it is representing a circle,
 * and this how we can use it
 * 
 * <pre><code>
 * //this is how to instantiate a circle of radius 3
 * Circle circle = new Circle(3);
 * </code></pre>
 * 
 * @author tbrou
 *
 */
public class Circle implements Shape{
	private double radius;

	
	
	public Circle(double radius) {
		this.radius = radius;
	}



	public double getRadius() {
		return radius;
	}



	public void setRadius(double radius) {
		this.radius = radius;
	}


	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}
	
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
}
