package eg.edu.alexu.csd.datastructure.iceHockey.cs02;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

/**
 * @author HOME KH
 *
 */
public class IceHockey implements IPlayersFinder {
	/**
	 * @elementGrid the matrix that contain the picture
	 */
	private char[][] elementGrid;
	/**
	 * @gridWidth calculate the length of x axis
	 */
	private int gridWidth;
	/**
	 * @gridHeight calculate the length if the y axis
	 */
	private int gridHeight;
	/**
	 * @visitedPosition is a booleen matrix to mark the visited cell in the
	 *                  array
	 */
	boolean[][] visitedPosition;
	/**
	 * @areaOfTeam count the area of the player in the picture
	 */
	int areaOfTeam;
	/**
	 *
	 */
	private int leftSide;
	/**
	 *
	 */
	private int rightSide;
	/**
	 *
	 */
	private int upperSide;
	/**
	 *
	 */
	private int lowerSide;
	/**
	 * @numOfPlayer counter for the number of center point
	 */
	int numOfPlayer;
	/**
	 *
	 */
	static final int MAXSIZE = 1000;
	/**
	 *
	 */
	private Point[] center;

	/**
	 * @param photo
	 */
	public void setPicturePixel(String[] photo) {
		elementGrid = new char[photo.length][photo[0].length()];
		for (int i = 0; i < photo.length; i++) {
			for (int j = 0; j < photo[0].length(); j++) {
				elementGrid[i][j] = photo[i].charAt(j);
			}
		}
	}

	/**
	 * @param photo
	 */
	public void setVisitedPosition(String[] photo) {
		visitedPosition = new boolean[photo.length][photo[0].length()];
		for (int i = 0; i < photo.length; i++) {
			for (int j = 0; j < photo[0].length(); j++) {
				visitedPosition[i][j] = false;
			}
		}
	}
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		 if (photo.length == 0 || photo == null) {
			 return null;
		 } else {
			 numOfPlayer = 0;
			 center = new Point[MAXSIZE];
			 setVisitedPosition(photo);
			 setPicturePixel(photo);
			 setGridHeight(photo);
			 setGridWidth(photo);
			 searchInGrid(team, threshold, photo);
			 sortCenterPoint(center);
			 Point[] centerPoints = new Point[numOfPlayer];
			 for (int i = 0; i < numOfPlayer; i++) {
				 centerPoints[i] = center[i];
			 }
			 return centerPoints;
		 }
	 }

	 /**
	  * @param photo
	  */
	 public void setGridWidth(String[] photo) {
		 gridWidth = photo[0].length();

	 }

	 /**
	  * @param photo
	  */
	 public void setGridHeight(String[] photo) {
		 gridHeight = photo.length;
	 }

	 /**
	  * @param team
	  * @param threshold
	  * @param photo
	  */
	 public void searchInGrid(int team, int threshold, String[] photo) {
		 final int convertInteger = 48;
		 char s = (char)(team + convertInteger) ;
		 int i, j;
		 int x = 0, y = 0;
		 for (i = 0; i < photo.length; i++) {
			 for (j = 0; j < photo[0].length(); j++) {
				 areaOfTeam = 0;
				 if (elementGrid[i][j] == s){
					 if (visitedPosition[i][j] == false) {
						 visitedPosition[i][j] = true;
						 areaOfTeam++;
						 setLeftSide(gridWidth);
						 setRightSide(0);
						 setUpperSide(gridHeight);
						 setLowerSide(0);
						 leftSide = Math.min(j, leftSide);
						 rightSide = Math.max(j, rightSide);
						 upperSide = Math.min(i, upperSide);
						 lowerSide = Math.max(i, lowerSide);
						 depthFirstSearch(i, j, team);
						 if (areaOfTeam * 4 >= threshold) {
							 center[numOfPlayer] = new Point(x, y);
							 center[numOfPlayer].x = leftSide + rightSide + 1;
							 center[numOfPlayer].y = upperSide + lowerSide + 1;
							 numOfPlayer = numOfPlayer + 1;
						 }
					 }
				 }
			 }
		 }
	 }

	 /**
	  * @param gridWidth
	  */
	 public void setLeftSide(int gridWidth) {
		 this.leftSide = gridWidth;
	 }

	 /**
	  * @param x
	  */
	 public void setRightSide(int x) {
		 this.rightSide = x;
	 }

	 /**
	  * @param gridHeight
	  */
	 public void setUpperSide(int gridHeight) {
		 this.upperSide = gridHeight;
	 }

	 /**
	  * @param x
	  */
	 public void setLowerSide(int x) {
		 this.lowerSide = x;
	 }

	 /**
	  * @param i
	  * @param j
	  * @param team
	  */
	 public void depthFirstSearch(int i, int j, int team) {
		 final int convertInteger = 48;
		 char s = (char)(team + convertInteger) ;
		 if (i - 1 >= 0 && j >= 0 && j < gridWidth && i < gridHeight){
			 if (elementGrid[i - 1][j] == s){
				 if( visitedPosition[i - 1][j] == false) {
					 visitedPosition[i - 1][j] = true;
					 leftSide = Math.min(j, leftSide);
					 rightSide = Math.max(j, rightSide);
					 upperSide = Math.min(i - 1, upperSide);
					 lowerSide = Math.max(i - 1, lowerSide);
					 areaOfTeam++;
					 depthFirstSearch(i - 1, j, team);
				 }
			 }
		 }
		 if (i >= 0 && j - 1 >= 0 && j < gridWidth && i < gridHeight){
			 if (elementGrid[i][j - 1] == s){
				 if ( visitedPosition[i][j - 1] == false) {
					 visitedPosition[i][j - 1] = true;
					 leftSide = Math.min(j - 1, leftSide);
					 rightSide = Math.max(j - 1, rightSide);
					 upperSide = Math.min(i, upperSide);
					 lowerSide = Math.max(i, lowerSide);
					 areaOfTeam++;
					 depthFirstSearch(i, j - 1, team);
				 }
			 }
		 }
		 if (i >= 0 && j >= 0 && j + 1 < gridWidth && i < gridHeight){
			 if ( elementGrid[i][j + 1] == s){
				 if ( visitedPosition[i][j + 1] == false) {
					 visitedPosition[i][j + 1] = true;
					 leftSide = Math.min(j + 1, leftSide);
					 rightSide = Math.max(j + 1, rightSide);
					 upperSide = Math.min(i, upperSide);
					 lowerSide = Math.max(i, lowerSide);
					 areaOfTeam++;
					 depthFirstSearch(i, j + 1, team);
				 }
			 }
		 }
		 if (i >= 0 && j >= 0 && j < gridWidth && i < gridHeight - 1){
			 if ( elementGrid[i + 1][j] == s){
				 if( visitedPosition[i + 1][j] == false) {
					 visitedPosition[i + 1][j] = true;
					 leftSide = Math.min(j, leftSide);
					 rightSide = Math.max(j, rightSide);
					 upperSide = Math.min(i + 1, upperSide);
					 lowerSide = Math.max(i + 1, lowerSide);
					 areaOfTeam++;
					 depthFirstSearch(i + 1, j, team);
				 }
			 }
		 }
	 }

	 /**
	  * @param center
	  */
	 public void sortCenterPoint(Point[] center) {
		 int x = 0, y = 0;
		 Point temp = new Point(x, y);
		 for (int i = 0; i < numOfPlayer; i++) {
			 for (int j = 0; j < numOfPlayer - 1 - i; j++) {
				 if (center[j].x > center[j + 1].x) {
					 temp.x = center[j].x;
					 temp.y = center[j].y;
					 center[j].x = center[j + 1].x;
					 center[j].y = center[j + 1].y;
					 center[j + 1].x = temp.x;
					 center[j + 1].y = temp.y;
				 } else if (center[j].x == center[j + 1].x) {
					 if (center[j].y > center[j + 1].y) {
						 temp.x = center[j].x;
						 temp.y = center[j].y;
						 center[j].x = center[j + 1].x;
						 center[j].y = center[j + 1].y;
						 center[j + 1].x = temp.x;
						 center[j + 1].y = temp.y;
					 }
				 }
			 }
		 }
	 }
}