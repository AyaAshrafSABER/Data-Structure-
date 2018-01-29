package eg.edu.alexu.csd.datastructure.calculator.cs02;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;

/**
 * @author HOME KH
 *
 */
public class Calculator implements ICalculator {

	/**
	 * Adds given two numbers
	 * @param x first number
	 * @param y second number
	 * @return the sum of the two numbers
	 */
	public int add(int x, int y) {
		return x + y;
	}

	 /**
	  * Divids two numbers
	  * @param x first number
	  * @param y second number
	  * @return the division result
	  */
	public float divide(int x, int y) {
		return (float) x / y;
	}

}
