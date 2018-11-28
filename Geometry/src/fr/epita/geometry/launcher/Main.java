package fr.epita.geometry.launcher;

import fr.epita.geometry.datamodel.Circle;
import fr.epita.geometry.datamodel.Square;
import fr.epita.geometry.datamodel.Triangle;

public class Main {

	public static void main(String[] args) {
		Circle circle = new Circle(3);
		System.out.println("*Area : " + circle.getArea());
		System.out.println("*Perimeter : " + circle.getPerimeter());
		
		Circle circle2 = new Circle(5);
		System.out.println("*Area : " + circle2.getArea());
		System.out.println("*Perimeter : " + circle2.getPerimeter());
		
		Square square = new Square(4);
		System.out.println("*Area : " + square.getArea());
		System.out.println("*Perimeter : " + square.getPerimeter());
	
		Square square2 = new Square(5);
		System.out.println("*Area : " + square2.getArea());
		System.out.println("*Perimeter : " + square2.getPerimeter());
		
		Triangle triangle = new Triangle(13,7, 9, 5);
		System.out.println("*Area : " + triangle.getArea());
		System.out.println("*Perimeter : " + triangle.getPerimeter());
		
		Triangle triangle2 = new Triangle(14,8, 9, 5);
		System.out.println("*Area : " + triangle2.getArea());
		System.out.println("*Perimeter : " + triangle2.getPerimeter());
		
	}

}
