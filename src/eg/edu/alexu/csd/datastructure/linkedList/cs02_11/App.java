package eg.edu.alexu.csd.datastructure.linkedList.cs02_11;

import java.util.Scanner;

public class App {
	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		PolynomialSolver s = new PolynomialSolver();
		char letter = 0;
		char letter2 = 0;
		int flag = 1;
		while (flag == 1) {
			System.out.println("Please choose an action");
			System.out.println("-----------------------");
			System.out
			.println("1 - Set a polynomial variable\n"
					+ "2 - Print the value of a polynomial variable\n"
					+ "3 - Add two polynomials\n"
					+ "4 - Subtract two polynomials\n"
					+ "5 - Multiply two polynomials\n"
					+ "6 - Evaluate a polynomial at some point\n"
					+ "7 - Clear a polynomial variable\n"
					+ "====================================================================");
			int action = scan.nextInt();
			String coff = new String();
			int i = 0;
			int j = 0, k = 0;
			switch (action) {
			case 1: {
				System.out.println("Insert the variable name : A , B or C");
				letter = scan.next().charAt(0);
				System.out.println("Insert the polynomial terms in the form :");
				System.out
				.println("( coeff1 , exponent1 ) , ( coeff2 , exponent2 ) , ...");
				coff = scan.next();
				int lenOfArr = 0;
				final int width = 2;
				while (i < coff.length()) {
					if (coff.charAt(i) == '(') {
						lenOfArr++;
					}
					i++;
				}
				int[][] terms = new int[lenOfArr][width];
				i = 0;
				while (i < coff.length()) {
					if ((coff.charAt(i) >= '0' && coff.charAt(i) <= '9')
							|| coff.charAt(i) == '-') {
						if (coff.charAt(i) == '-') {
							i++;
							if (j == 0) {
								terms[k][j] = -(coff.charAt(i) - '0');
								j++;
							} else {
								terms[k][j] = -(coff.charAt(i) - '0');
								k++;
								j = 0;
							}
						} else {
							if (j == 0) {
								terms[k][j] = (coff.charAt(i) - '0');
								j++;
							} else {
								terms[k][j] = (coff.charAt(i) - '0');
								j = 0;
								k++;
							}
						}
					}
					i++;
				}
				s.setPolynomial(letter, terms);
				if (coff.length() > 0) {
					System.out.println("Polynomial " + letter + " is set");
				} else {
					System.out.println("Variable not set");
				}
				System.out
				.println("====================================================================");
				break;
			}
			case 2: {
				int right = 1;
				while (right == 1) {
					System.out.println("Insert the variable name : A , B , C oR R");
					letter = scan.next().charAt(0);
					if (letter == 'A') {
						if (s.Alist.head == null) {
							System.out.println("A is not set");
						} else {
							right = 0;
						}
					} else if (letter == 'B') {
						if (s.Blist.head == null) {
							System.out.println("B is not set");
						} else {
							right = 0;
						}
					} else if (letter == 'C') {
						if (s.Clist.head == null) {
							System.out.println("C is not set");
						} else {
							right = 0;
						}
					} else if (letter == 'R') {
						if (s.Rlist.head == null) {
							System.out.println("R is not set");
						} else {
							right = 0;
						}
					} else {
						System.out.println("It's not the right variabe");
					}
				}
				System.out.println(s.print(letter));
				System.out
				.println("====================================================================");
				break;

			}
			case 3: {
				int right = 1;
				while (right == 1) {
					System.out.println("Insert the variable name : A , B or C");
					letter = scan.next().charAt(0);
					if (letter == 'A') {
						if (s.Alist.head == null) {
							System.out.println("A is not set");
						} else {
							right = 0;
						}
					} else if (letter == 'B') {
						if (s.Blist.head == null) {
							System.out.println("B is not set");
						} else {
							right = 0;
						}
					} else if (letter == 'C') {
						if (s.Clist.head == null) {
							System.out.println("C is not set");
						} else {
							right = 0;
						}
					} else {
						System.out.println("It's not the right variabe");
					}
				}
				right = 1;
				while (right == 1) {
					System.out.println("Insert the variable name : A , B or C");
					letter2 = scan.next().charAt(0);
					if (letter2 == 'A') {
						if (s.Alist.head == null) {
							System.out.println("A is not set");
						} else {
							right = 0;
						}
					} else if (letter2 == 'B') {
						if (s.Blist.head == null) {
							System.out.println("B is not set");
						} else {
							right = 0;
						}
					} else if (letter2 == 'C') {
					} else {
						System.out.println("It's not the right variabe");
					}
				}

				int[][] answer = new int[s.add(letter, letter2).length][];
				answer = s.add(letter, letter2);

				for (int f = 0; f < answer.length; f++)
					System.out.println("(" + answer[f][0] + ", " + answer[f][1]
							+ ") ,");
				System.out
				.println("====================================================================");
				break;

			}
			case 4: {
				int right = 1;
				while (right == 1) {
					System.out.println("Insert the variable name : A , B or C");
					letter = scan.next().charAt(0);
					if (letter == 'A') {
						if (s.Alist.head == null) {
							System.out.println("A is not set");
						} else {
							right = 0;
						}
					} else if (letter == 'B') {
						if (s.Blist.head == null) {
							System.out.println("B is not set");
						} else {
							right = 0;
						}
					} else if (letter == 'C') {
						if (s.Clist.head == null) {
							System.out.println("C is not set");
						} else {
							right = 0;
						}
					} else {
						System.out.println("It's not the right variabe");
					}
				}
				right = 1;
				while (right == 1) {
					System.out.println("Insert the variable name : A , B or C");
					letter2 = scan.next().charAt(0);
					if (letter2 == 'A') {
						if (s.Alist.head == null) {
							System.out.println("A is not set");
						} else {
							right = 0;
						}
					} else if (letter2 == 'B') {
						if (s.Blist.head == null) {
							System.out.println("B is not set");
						} else {
							right = 0;
						}
					} else if (letter2 == 'C') {
					} else {
						System.out.println("It's not the right variabe");
					}
				}
				int[][] answer = new int[s.subtract(letter, letter2).length][];
				answer = s.subtract(letter, letter2);
				if (answer.length > 1) {
					for (int f = 0; f < answer.length; f++)
						System.out.println("(" + answer[f][0] + ", "
								+ answer[f][1] + ") ,");
				} else {
					System.out.println("(0,0)");
				}
				System.out
				.println("====================================================================");
				break;

			}
			case 5: {
				int right = 1;
				while (right == 1) {
					System.out.println("Insert the variable name : A , B or C");
					letter = scan.next().charAt(0);
					if (letter == 'A') {
						if (s.Alist.head == null) {
							System.out.println("A is not set");
						} else {
							right = 0;
						}
					} else if (letter == 'B') {
						if (s.Blist.head == null) {
							System.out.println("B is not set");
						} else {
							right = 0;
						}
					} else if (letter == 'C') {
						if (s.Clist.head == null) {
							System.out.println("C is not set");
						} else {
							right = 0;
						}
					} else {
						System.out.println("It's not the right variabe");
					}
				}
				right = 1;
				while (right == 1) {
					System.out.println("Insert the variable name : A , B or C");
					letter2 = scan.next().charAt(0);
					if (letter2 == 'A') {
						if (s.Alist.head == null) {
							System.out.println("A is not set");
						} else {
							right = 0;
						}
					} else if (letter2 == 'B') {
						if (s.Blist.head == null) {
							System.out.println("B is not set");
						} else {
							right = 0;
						}
					} else if (letter2 == 'C') {
					} else {
						System.out.println("It's not the right variabe");
					}
				}
				int[][] answer = new int[s.multiply(letter, letter2).length][];
				answer = s.multiply(letter, letter2);

				for (int f = 0; f < answer.length; f++)
					System.out.println("(" + answer[i][0] + ", " + answer[f][1]
							+ ") ,");
				System.out
				.println("====================================================================");
				break;

			}
			case 6: {
				int right = 1;
				while (right == 1) {
					System.out.println("Insert the variable name : A , B or C");
					letter = scan.next().charAt(0);
					if (letter == 'A') {
						if (s.Alist.head == null) {
							System.out.println("A is not set");
						}
					} else if (letter == 'B') {
						if (s.Blist.head == null) {
							System.out.println("B is not set");
						}

					} else if (letter == 'C') {
						if (s.Clist.head == null) {
							System.out.println("C is not set");
						}

					} else {
						right = 0;
					}
				}
				System.out.println("Insert the value");
				float value = scan.nextFloat();
				System.out.println(s.evaluatePolynomial(letter, value));
				System.out
				.println("====================================================================");
				break;

			}
			case 7: {
				System.out.println("Insert the variable name : A , B , C or R");
				letter = scan.next().charAt(0);
				s.clearPolynomial(letter);
				System.out.println(letter + "is clear");
				System.out
				.println("====================================================================");
				break;

			}
			default: {
				flag = 0;
				break;

			}
			}

		}

	}
}