package fr.epita.geometry.launcher;

import java.util.Arrays;
import java.util.List;

import fr.epita.geometry.datamodel.Circle;
import fr.epita.geometry.datamodel.Rectangle;
import fr.epita.geometry.datamodel.Shape;
import fr.epita.geometry.datamodel.Square;
import fr.epita.geometry.datamodel.Triangle;

public class Main {

	public static void main(String[] args) {
		Shape circle = new Circle(3);
		Shape circle2 = new Circle(5);
		Shape square = new Square(4);
		Shape square2 = new Square(5);
		Shape triangle = new Triangle(13,7, 9, 5);
		Shape triangle2 = new Triangle(14,8, 9, 5);
		Rectangle rectangle = new Rectangle(5,10);
		
		
		
		
		List<Shape> shapes = Arrays.asList(circle,circle2,triangle,triangle2,square,square2);
		double globalArea = 0.0;
		double globalPerimeter= 0.0;
		for (Shape shape : shapes) {
			displayShape(shape);
			globalArea += shape.getArea();
			globalPerimeter += shape.getPerimeter();
		}
		
		System.out.println("global Area : " +globalArea);
		System.out.println("global Perimeter : " +globalPerimeter);
		
		
		
	}

	private static void displayShape(Shape shape) {
		System.out.println("displaying characteristics of a : "+ shape.getClass().getSimpleName());
		System.out.println("*Area : " + shape.getArea());
		System.out.println("*Perimeter : " + shape.getPerimeter());
	}

}
