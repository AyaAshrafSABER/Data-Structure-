package eg.edu.alexu.csd.datastructure.stack.cs02;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

/**
 * @author HOME KH
 *
 */
public class MyExpressionEvaluator implements IExpressionEvaluator {

	/**
	 * Takes a symbolic/numeric infix expression as input and converts it to
	 * postfix notation. There is no assumption on spaces between terms or the
	 * length of the term (e.g., two digits symbolic or numeric term)
	 * 
	 * @param expression
	 *            infix expression
	 * @return postfix expression
	 */
	public String infixToPostfix(String expression) {
		MyStack s = new MyStack();
		StringBuilder exp = new StringBuilder();
		int counter = 0;
		// int len = expression.length();
		Character get = null;
		if (expression == null || expression.length() == 0) {
			throw new RuntimeException();
		}
		if (expression.charAt(0) != '+' || expression.charAt(0) != '-' || expression.charAt(0) != '/'
				|| expression.charAt(0) != '*') {
			while (counter < expression.length()) {
				if (expression.charAt(counter) == ' ') {
					counter++;
				}
				if ((expression.charAt(counter) >= '0' && expression.charAt(counter) <= '9')
						|| (expression.charAt(counter) >= 'A' && expression.charAt(counter) <= 'z')) {
					exp.append(expression.charAt(counter));
					exp.append(' ');
				} else if (expression.charAt(counter) == '(') {
					s.push(expression.charAt(counter));
				} else if (expression.charAt(counter) == ')') {
					if (!(s.isEmpty()))
						get = (Character) s.peek();
					int flag = 1;
					while (s.size() > 0 && flag == 1) {
						if (get != '(') {
							exp.append((Character) s.pop());
							exp.append(' ');
							if (!(s.isEmpty()))
								get = (Character) s.peek();
						} else {
							flag = 0;
						}
					}
					if (!(s.isEmpty())) {
						s.pop();
					}
				} else if (expression.charAt(counter) == '+' || expression.charAt(counter) == '-'
						|| expression.charAt(counter) == '*' || expression.charAt(counter) == '/') {
					if (s.isEmpty() || (Character) s.peek() == '(') {
						s.push(expression.charAt(counter));
					} else {
						if (!(s.isEmpty())) {
							get = (Character) s.peek();
						}
						if (expression.charAt(counter) == '+') {
							if (expression.charAt(counter + 1) == '+') {
								throw null;
							} else if (expression.charAt(counter + 1) == ' ' && expression.charAt(counter + 2) == '+') {
								throw new RuntimeException();
							} else {
								int flag = 1;
								while (s.size() > 0 && flag == 1) {
									if (get != '(') {
										exp.append((Character) s.pop());
										exp.append(' ');
										if (!(s.isEmpty()))
											get = (Character) s.peek();
									} else {
										flag = 0;
									}
								}

								s.push(expression.charAt(counter));

							}
						} else if (expression.charAt(counter) == '-') {
							if (expression.charAt(counter + 1) == '-') {
								throw null;
							} else if (expression.charAt(counter + 1) == ' ' && expression.charAt(counter + 2) == '-') {
								throw new RuntimeException();
							} else {
								if (!(s.isEmpty())) {
									get = (Character) s.peek();
								}
								if (get == '+') {
									s.push(expression.charAt(counter));
								} else {
									int flag = 1;
									while (s.size() > 0 && flag == 1) {
										if (get != '(') {
											exp.append((Character) s.pop());
											exp.append(' ');
											if (!(s.isEmpty()))
												get = (Character) s.peek();
										} else {
											flag = 0;
										}
									}
									s.push(expression.charAt(counter));
								}
							}
						} else if (expression.charAt(counter) == '*') {
							if (get == '/' || get == '*') {
								exp.append((Character) s.pop());
								exp.append(' ');
							}
							s.push(expression.charAt(counter));

						} else if (expression.charAt(counter) == '/') {
							if (get == '*' || get == '/') {
								exp.append((Character) s.pop());
								exp.append(' ');
							}
							s.push(expression.charAt(counter));
						} else {
							throw null;
						}

					}

				}
				counter++;
			}
		} else {
			throw new RuntimeException();
		}
		while (!(s.isEmpty())) {
			exp.append((Character) s.pop());
			exp.append(' ');
		}
		exp.deleteCharAt(exp.length() - 1);
		String evaluate = new String();
		evaluate = exp.toString();
		return evaluate;
	}

	/**
	 * Evaluate a postfix numeric expression, with a single space separator
	 * 
	 * @param expression
	 *            postfix expression
	 * @return the expression evaluated value
	 */
	public int evaluate(String expression) {
		MyStack s = new MyStack();
		int counter = 0;
		int element1;
		int element2;
		int result;
		char operation;
		if (expression == null || expression.length() == 0) {
			throw new RuntimeException();
		} else {
			while (counter < expression.length()) {
				if (expression.charAt(counter) != '+' && expression.charAt(counter) != '-'
						&& expression.charAt(counter) != '/' && expression.charAt(counter) != '*') {
					StringBuilder num = new StringBuilder();
					while (expression.charAt(counter) != ' ') {
						num.append(expression.charAt(counter));
						counter++;
					}
					s.push(Integer.parseInt(num.toString()));
					counter++;
				} else {
					operation = expression.charAt(counter);
					if (!(s.isEmpty())) {						
						element1 =(Integer) s.pop();
						if (!(s.isEmpty())) {
							element2 =(Integer) s.pop();
						} else {
							throw new RuntimeException();
						}
					} else {
						throw new RuntimeException();
					}
					switch (operation) {
					case '+': {
						result = element1 + element2;
						s.push(result);
						break;
					}
					case '-': {
						result = element2 - element1;
						s.push(result);
						break;
					}
					case '*': {
						result = element1 * element2;
						s.push(result);
						break;
					}
					case '/': {
						result = element2 / element1;
						s.push(result);
						break;
					}
					default: {
						throw null;
					}
					}
					counter=counter+2;
				}
			}

		}
		if (s.size() == 1) {
			return (Integer) s.pop();

		} else if (s.size() == 0) {
			throw new RuntimeException();
		} else {

			return 0;
		}
	}

}
