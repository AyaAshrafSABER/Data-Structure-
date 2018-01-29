package eg.edu.alexu.csd.datastructure.stack.cs02;

public class TestMain {
public static void main(String[] args) {
	MyStack s =new MyStack();
	s.push("55");
	System.out.println(s.peek());
	System.out.println(s.pop());
	System.out.println(s.isEmpty());
	
}
}
