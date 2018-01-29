package eg.edu.alexu.csd.datastructure.linkedList.cs02_11;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

/**
 * @author HOME KH
 *
 */
public class PolynomialSolver implements IPolynomialSolver {
	/**
	 * 
	 */
	SingleLinkedList Alist = new SingleLinkedList();
	/**
	 * 
	 */
	SingleLinkedList Blist = new SingleLinkedList();
	/**
	 * 
	 */
	SingleLinkedList Clist = new SingleLinkedList();
	/**
	 * 
	 */
	SingleLinkedList Rlist = new SingleLinkedList();

	/**
	 * @param terms
	 *            this point array will be sort from the biggest exponent to the
	 *            small one
	 */
	public int IsSort(int[][] terms) {
		for (int i = 0; i < terms.length - 1; i++) {
			if ((terms[i][1] < terms[i + 1][1]) || (terms[i][1] < 0)) {
				return 0;
			}
		}
		return 1;
	}

	/**
	 * . Set polynomial terms (coefficients & exponents)
	 * 
	 * @param poly
	 *            name of the polynomial
	 * @param terms
	 *            array of [coefficients][exponents]
	 */

	public void pleaseSort(Point[] points) {
		int sizeOfpoints = points.length;
		for (int i = 0; i < sizeOfpoints; i++) {
			Point temp = new Point();
			temp = points[i];
			int pos = i;
			while (pos > 0 && (temp.y < points[pos - 1].y || temp.y == points[pos - 1].y)) {
				points[pos] = points[pos - 1];
				pos--;
			}
			points[pos] = temp;
		}
	}

	public void setPolynomial(char poly, int[][] terms) {
		if (terms == null || terms.length == 0) {
			throw new RuntimeException();
		}
		Point[] term = new Point[terms.length];
		for (int i = 0; i < terms.length; i++) {
			if (terms[i][1] < 0) {
				throw null;
			}
			Point a = new Point();
			a.x = terms[i][0];
			a.y = terms[i][1];
			term[i] = a;
		}
		int checkSort = IsSort(terms);
		if (checkSort == 0) {
			throw null;

		} else {
			Character.toLowerCase(poly);
			if (poly == 'a' || poly == 'A') {
				Alist.clear();
				for (int i = 0; i < terms.length; i++) {
					Alist.add(term[i]);
				}
			} else if (poly == 'b' || poly == 'B') {
				Blist.clear();
				for (int i = 0; i < terms.length; i++) {
					Blist.add(term[i]);
				}
			} else if (poly == 'c' || poly == 'C') {
				Clist.clear();
				for (int i = 0; i < terms.length; i++) {
					Clist.add(term[i]);
				}
			} else {
				throw new RuntimeException();
			}
		}
	}

	/**
	 * . Print the polynomial in human readable representation
	 * 
	 * @param poly
	 *            name of the polynomial
	 * @return polynomial in the form like 27x^2+x-1
	 */
	public String print(char poly) {
		// TODO Auto-generated method stub
		Node i = null;
		String expon = "";
		if (poly == 'a' || poly == 'A') {
			i = Alist.head;
		} else if (poly == 'b' || poly == 'B') {
			i = Blist.head;
		} else if (poly == 'c' || poly == 'C') {
			i = Clist.head;
		} else if (poly == 'r' || poly == 'R') {
			i = Rlist.head;
		} else {
			return null;
		}
		if (i == null)
			return null;
		while (i != null) {
			Object k, l;
			k = ((Point) i.value).x;
			l = ((Point) i.value).y;
			int c = (Integer) k;
			int p = (Integer) l;
			if (c == 1 && p != 0)
				;
			else if (c == 1 && p == 0)
				expon = expon + "+" + String.valueOf(c);
			else if (c == 0)
				;
			else if (c < 0) {
				expon = expon + String.valueOf(c);
			} else {
				expon = expon + "+" + String.valueOf(c);
			}
			if (p == 1 && c == 1) {
				expon = expon + "+x";
			} else if (p == 1) {
				expon = expon + "x";
			} else if (p == 0)
				;
			else {
				expon = expon + "x" + "^" + String.valueOf(p);
			}
			i = i.next;
		}
		if (expon.charAt(0) == '+')
			expon = expon.substring(1, expon.length());
		return expon;
	}

	/**
	 * . Clear the polynomial
	 * 
	 * @param poly
	 *            name of the polynomial
	 */
	public void clearPolynomial(char poly) {
		if (poly == 'a' || poly == 'A') {
			if (Alist.isEmpty()) {
				throw new RuntimeException();
			} else {
				Alist.clear();
			}
		} else if (poly == 'b' || poly == 'B') {
			if (Blist.isEmpty()) {
				throw new RuntimeException();
			} else {
				Blist.clear();
			}
		} else if (poly == 'c' || poly == 'C') {
			if (Blist.isEmpty()) {
				throw new RuntimeException();
			} else {
				Blist.clear();
			}
		}
	}

	/**
	 * . Evaluate the polynomial
	 * 
	 * @param poly
	 *            name of the polynomial
	 * @param value
	 *            the polynomial constant
	 * @return the value of the polynomial
	 */
	public float evaluatePolynomial(char poly, float value) {
		Node i = null;
		if (poly == 'a' || poly == 'A') {
			i = Alist.head;
		} else if (poly == 'b' || poly == 'B') {
			i = Blist.head;
		} else if (poly == 'c' || poly == 'C') {
			i = Clist.head;
		} else {
			throw new RuntimeException();
		}
		float ans = 0;
		while (i != null) {
			Object k, l;
			k = ((Point) i.value).x;
			l = ((Point) i.value).y;
			int coeff = (Integer) k;
			int power = (Integer) l;
			ans = (float) (ans + (float) coeff * Math.pow(value, (float) power));
			i = i.next;
		}
		return ans;
	}

	/**
	 * . Add two polynomials
	 * @param poly1
	 *            first polynomial
	 * @param poly2
	 *            second polynomial
	 * @return the result polynomial
	 */
	public int[][] add(char poly1, char poly2) {
		Character.toLowerCase(poly1);
		Character.toLowerCase(poly2);

		Node i = null;
		Node j = null;
		if (poly1 == 'a' || poly1 == 'A') {
			i = Alist.head;
		} else if (poly1 == 'b' || poly1 == 'B') {
			i = Blist.head;
		} else if (poly1 == 'c' || poly1 == 'C') {
			i = Clist.head;
		} else {
			throw new RuntimeException();
		}
		if (poly2 == 'a' || poly2 == 'A') {
			j = Alist.head;
		} else if (poly2 == 'b' || poly2 == 'B') {
			j = Blist.head;
		} else if (poly2 == 'c' || poly2 == 'C') {
			j = Clist.head;
		} else {
			throw null;
		}
		Rlist.clear();
		if (i == null || j == null) {
			return null;

		} else {
			while (i != null && j != null) {
				Point iTerm = (Point) i.value;
				Point jTerm = (Point) j.value;
				Point rTerm = new Point();
				if (iTerm.y > jTerm.y) {
					rTerm.x = iTerm.x;
					rTerm.y = iTerm.y;
					Rlist.add(rTerm);
					i = i.next;
				} else if (iTerm.y < jTerm.y) {
					rTerm.y = jTerm.y;
					rTerm.x = jTerm.x;
					Rlist.add(rTerm);
					j = j.next;
				} else {
					rTerm.x = iTerm.x + jTerm.x;
					rTerm.y = iTerm.y;
					if (rTerm.x != 0) {
						Rlist.add(rTerm);
					}
					i = i.next;
					j = j.next;
				}
			}
			while (i != null) {
				Point iTerm = (Point) i.value;
				Point rTerm = new Point();
				rTerm.x = iTerm.x;
				rTerm.y = iTerm.y;
				Rlist.add(rTerm);
				i = i.next;
			}
			while (j != null) {
				Point jTerm = (Point) j.value;
				Point rTerm = new Point();
				rTerm.x = jTerm.x;
				rTerm.y = jTerm.y;
				Rlist.add(rTerm);
				j = j.next;
			}
		}
		int[][] Addition = new int[Rlist.size()][2];
		for (int x = 0; x < Rlist.size(); x++) {
			Point temp = (Point) Rlist.get(x);
			Addition[x][0] = temp.x;
			Addition[x][1] = temp.y;
		}
		return Addition;
	}

	/**
	 * . Subtract two polynomials
	 * 
	 * @param poly1
	 *            first polynomial
	 * @param poly2
	 *            second polynomial
	 * @return the result polynomial
	 */
	public int[][] subtract(char poly1, char poly2) {
		Character.toLowerCase(poly1);
		Character.toLowerCase(poly2);

		Node i = null;
		Node j = null;
		if (poly1 == 'a' || poly1 == 'A') {
			i = Alist.head;
		} else if (poly1 == 'b' || poly1 == 'B') {
			i = Blist.head;
		} else if (poly1 == 'c' || poly1 == 'C') {
			i = Clist.head;
		} else {
			throw new RuntimeException();
		}
		if (poly2 == 'a' || poly2 == 'A') {
			j = Alist.head;
		} else if (poly2 == 'b' || poly2 == 'B') {
			j = Blist.head;
		} else if (poly2 == 'c' || poly2 == 'C') {
			j = Clist.head;
		} else {
			throw null;
		}
		Rlist.clear();
		if (i == null || j == null) {
			return null;

		} else {
			while (i != null && j != null) {
				Point iTerm = (Point) i.value;
				Point jTerm = (Point) j.value;
				Point rTerm = new Point();
				if (iTerm.y > jTerm.y) {
					rTerm.x = iTerm.x;
					rTerm.y = iTerm.y;
					Rlist.add(rTerm);
					i = i.next;
				} else if (iTerm.y < jTerm.y) {
					rTerm.y = -jTerm.y;
					rTerm.x = jTerm.x;
					Rlist.add(rTerm);
					j = j.next;
				} else {
					rTerm.x = iTerm.x - jTerm.x;
					rTerm.y = iTerm.y;
					if (rTerm.x != 0) {
						Rlist.add(rTerm);
					}
					i = i.next;
					j = j.next;

				}

			}
			while (i != null) {
				Point iTerm = (Point) i.value;
				Point rTerm = new Point();
				rTerm.x = iTerm.x;
				rTerm.y = iTerm.y;
				Rlist.add(rTerm);
				i = i.next;
			}
			while (j != null) {
				Point jTerm = (Point) j.value;
				Point rTerm = new Point();
				rTerm.x = -jTerm.x;
				rTerm.y = jTerm.y;
				Rlist.add(rTerm);
				j = j.next;
			}
		}
		if (Rlist.size > 0) {
			int[][] subtraction = new int[Rlist.size()][2];
			for (int x = 0; x < Rlist.size(); x++) {
				Point temp = (Point) Rlist.get(x);
				subtraction[x][0] = temp.x;
				subtraction[x][1] = temp.y;
			}

			return subtraction;
		} else {
			int[][] subtraction = { { 0 }, { 0 } };
			return subtraction;

		}
	}

	/**
	 * . Multiply two polynomials
	 * 
	 * @param poly1
	 *            first polynomial
	 * @param poly2
	 *            second polynomial
	 * @return the result polynomial
	 */
	public int[][] multiply(char poly1, char poly2) {
		SingleLinkedList templist1 = new SingleLinkedList();
		SingleLinkedList templist2 = new SingleLinkedList();
		SingleLinkedList templist3 = new SingleLinkedList();
		Node i = null;
		Node j = null;
		Rlist.clear();
		if (poly1 == 'a' || poly1 == 'A') {
			i = Alist.head;
		} else if (poly1 == 'b' || poly1 == 'B') {
			i = Blist.head;
		} else if (poly1 == 'c' || poly1 == 'C') {
			i = Clist.head;
		} else {
			throw new RuntimeException();
		}
		if (poly2 == 'a' || poly2 == 'A') {
			j = Alist.head;
		} else if (poly2 == 'b' || poly2 == 'B') {
			j = Blist.head;
		} else if (poly2 == 'c' || poly2 == 'C') {
			j = Clist.head;
		} else {
			throw null;
		}
		if (i == null || j == null) {
			return null;

		} else {
			int counter = 0;
			while (i != null) {
				Point aTerm = (Point) i.value;
				templist1.clear();
				while (j != null) {
					Point bTerm = (Point) j.value;
					Point sub = new Point();
					if (aTerm.x != 0) {
						sub.x = aTerm.x * bTerm.x;
						sub.y = aTerm.y + bTerm.y;
						templist1.add(sub);
					}
					j = j.next;
				}
				if (counter == 0) {
					for (int x = 0; x < templist1.size(); x++) {
						templist2.add(templist1.get(x));
						counter++;
					}
				} else {
					int list1Counter = 0;
					int list2Counter = 0;
					templist3.clear();
					while (list1Counter < templist1.size() && list2Counter < templist2.size()) {
						counter++;
						Point list1Term = (Point) templist1.get(list1Counter);
						Point list2Term = (Point) templist2.get(list2Counter);
						Point list3Term = new Point();
						if (list1Term.y > list2Term.y) {
							list3Term.x = list1Term.x;
							list3Term.y = list1Term.y;
							templist3.add(list3Term);
							list1Counter++;
						} else if (list1Term.y < list2Term.y) {
							list3Term.y = list2Term.y;
							list3Term.x = list2Term.x;
							templist3.add(list3Term);
							list2Counter++;

						} else {
							list3Term.x = list1Term.x + list2Term.x;
							list3Term.y = list1Term.y;
							if (list1Term.x != 0) {
								templist3.add(list3Term);
							}
							list1Counter++;
							list2Counter++;
						}
					}
					while (list1Counter < templist1.size()) {
						Point list1Term = (Point) templist1.get(list1Counter);
						Point list3Term = new Point();
						list3Term.x = list1Term.x;
						list3Term.y = list1Term.y;
						templist3.add(list3Term);
						list1Counter++;
					}
					while (list2Counter < templist2.size()) {
						Point list2Term = (Point) templist2.get(list2Counter);
						Point list3Term = new Point();
						list3Term.x = list2Term.x;
						list3Term.y = list2Term.y;
						templist3.add(list3Term);
						list2Counter++;
					}
					templist2.clear();
					for (int x = 0; x < templist3.size(); x++) {
						templist2.add(templist3.get(x));
					}
				}
				i = i.next;
			}
			if (counter==1){
				for (int x = 0; x < templist1.size(); x++) {
					Rlist.add(templist1.get(x));
				}


			}else {
				for (int x = 0; x < templist3.size(); x++) {
					Rlist.add(templist3.get(x));
				}
			}
			int[][] multiplying = new int[Rlist.size()][2];
			for (int x = 0; x < Rlist.size(); x++) {
				Point temp = (Point) Rlist.get(x);
				multiplying[x][0] = temp.x;
				multiplying[x][1] = temp.y;
			}

			return multiplying;

		}

	}
}
