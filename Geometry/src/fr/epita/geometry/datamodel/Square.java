package fr.epita.geometry.datamodel;


/**
 * To use this square class:
 * 
 * <pre><code>
 * //this will create a square of side 3
 * Square square = new Square(3);</code></pre>
 * @author tbrou
 *
 */
public class Square {
	
	private double side;

	
	
	
	public Square(double side) {
		super();
		this.side = side;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	public double getArea() {
		return side * side;
	}

	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 4 * side;
	}
	
	

}
