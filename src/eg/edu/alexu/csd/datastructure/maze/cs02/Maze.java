package eg.edu.alexu.csd.datastructure.maze.cs02;

import java.awt.Point;
import java.io.File;
import java.util.Scanner;
import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.queue.cs02.MyLinkedListQueue;
import eg.edu.alexu.csd.datastructure.stack.cs02.MyStack;

public class Maze implements IMazeSolver {
	private Character[][] result;
	private int n, m;
	private boolean[][] visitedPosition;
	private Point[][] parent;
	public MyLinkedListQueue queue = new MyLinkedListQueue();
	public MyStack stack = new MyStack();
	public int[] startPoint = new int[2];
	public int[] endPoint = new int[2];
	public MyStack reversedPath = new MyStack();
	public int findStartPoint = 0;
	public int findEndPoint = 0;

	public void readFromFile(final File maze) {
		Scanner sc;
		try {
			sc = new Scanner(maze);
			if (!sc.hasNext()) {
				throw new RuntimeException("Empty file!");
			}
			n = sc.nextInt();
			m = sc.nextInt();
			result = new Character[n][m];
			visitedPosition = new boolean[n][m];
			parent = new Point[n][m];
			sc.nextLine();
			int i = 0, j = 0;
			String line;
			while (i < n) {
				line = sc.nextLine();
				for (j = 0; j < m; j++) {
					result[i][j] = line.charAt(j);
					visitedPosition[i][j] = false;
					parent[i][j] = new Point();
					if (line.charAt(j) == 'S') {
						startPoint[0] = i;
						startPoint[1] = j;
						findStartPoint = 1;
					}
					if (line.charAt(j) == 'E') {
						endPoint[0] = i;
						endPoint[1] = j;
						findEndPoint = 1;
					}
				}
				i++;
			}
		} catch (Exception e) {
			throw new RuntimeException("File not found!");

		}

	}

	public int[][] solveBFS(File maze) {
		// TODO Auto-generated method stub
		readFromFile(maze);
		if (findEndPoint == 0 || findStartPoint == 0) {
			throw null;
		}
		queue.enqueue(startPoint);
		int x;
		int y;
		while (!(queue.isEmpty())) {
			int[] temp1 = (int[]) queue.dequeue();
			x = temp1[1];
			y = temp1[0];
			Point po = new Point(x, y);
			if (temp1[0] == endPoint[0] && temp1[1] == endPoint[1]) {
				reversedPath.push(endPoint);
				break;
			}
			if (x > 0 && visitedPosition[y][x - 1] == false && result[y][x - 1] != '#') {
				parent[y][x - 1] = po;
				int[] temp = { y, x - 1 };
				visitedPosition[y][x - 1] = true;
				queue.enqueue(temp);
			}
			if (y > 0 && visitedPosition[y - 1][x] == false && result[y - 1][x] != '#') {
				parent[y - 1][x] = po;
				int[] temp = { y - 1, x };
				visitedPosition[y - 1][x] = true;

				queue.enqueue(temp);
			}
			if (y < n - 1 && visitedPosition[y + 1][x] == false && result[y + 1][x] != '#') {
				parent[y + 1][x] = po;
				int[] temp = { y + 1, x };
				visitedPosition[y + 1][x] = true;

				queue.enqueue(temp);

			}
			if ((x < m - 1 && visitedPosition[y][x + 1] == false) && result[y][x + 1] != '#') {
				parent[y][x + 1] = po;
				int[] temp = { y, x + 1 };
				visitedPosition[y][x + 1] = true;
				queue.enqueue(temp);
			}
			visitedPosition[y][x] = true;

		}
		if (reversedPath.size() == 0) {
			return null;
		}
		int flag = 1;
		while (flag == 1) {
			int[] current = (int[]) reversedPath.peek();
			int[] root = new int[2];
			Point temp = parent[current[0]][current[1]];
			root[1] = temp.x;
			root[0] = temp.y;
			reversedPath.push(root);
			if (root[1] == startPoint[1] && root[0] == startPoint[0]) {
				flag = 0;
			}
		}

		int[][] path = new int[reversedPath.size()][2];
		int i = 0;
		while (!(reversedPath.isEmpty())) {
			int[] temp = (int[]) reversedPath.pop();
			for (int j = 0; j < 2; j++) {
				path[i][j] = temp[j];
			}
			i++;
		}
		return path;

	}

	public int[][] solveDFS(File maze) {
		// TODO Auto-generated method stub
		readFromFile(maze);
		if (findEndPoint == 0 || findStartPoint == 0) {
			throw null;
		}
		stack.push(startPoint);
		
		while (!(stack.isEmpty())) {
			int[] currentNode = (int[]) stack.pop();
			int x = currentNode[1];
			int y = currentNode[0];
			if (x > 0 && visitedPosition[y][x - 1] == false && result[y][x - 1] != '#') {
				int[] temp = { y, x - 1 };
				stack.push(temp);
				parent[y][x - 1] = new Point(x, y);
			}
			if (y > 0 && visitedPosition[y - 1][x] == false && result[y - 1][x] != '#') {
				int[] temp = { y - 1, x };
				stack.push(temp);
				parent[y - 1][x] = new Point(x, y);
			}
			if (y < n - 1 && visitedPosition[y + 1][x] == false && result[y + 1][x] != '#') {
				int[] temp = { y + 1, x };
				stack.push(temp);
				parent[y + 1][x] = new Point(x, y);

			}
			if ((x < m - 1 && visitedPosition[y][x + 1] == false) && result[y][x + 1] != '#') {
				int[] temp = { y, x + 1 };
				stack.push(temp);
				parent[y][x + 1] = new Point(x, y);

			}
			visitedPosition[y][x] = true;

			if (x == endPoint[1] && y == endPoint[0]) {
				reversedPath.push(endPoint);
				break;
			}

		}
		if (reversedPath.size() == 0) {
			return null;
		}
		int flag = 1;
		while (flag == 1) {
			int[] current = (int[]) reversedPath.peek();
			int[] root = new int[2];
			Point temp = parent[current[0]][current[1]];
			root[1] = temp.x;
			root[0] = temp.y;
			reversedPath.push(root);
			if (root[1] == startPoint[1] && root[0] == startPoint[0]) {
				flag = 0;
			}
		}

		int[][] path = new int[reversedPath.size()][2];
		int i = 0;
		while (!(reversedPath.isEmpty())) {
			int[] temp = (int[]) reversedPath.pop();
			for (int j = 0; j < 2; j++) {
				path[i][j] = temp[j];
			}
			i++;
		}
		return path;

	}

}
