package eg.edu.alexu.csd.datastructure.hangman.cs02;

import java.util.Random;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

/**
 * @author AyaOsman
 *
 */
public class MyHangman implements IHangman {
	
	/**
	 *
	 */
	static final int SIZE = 100;
	/**
	 *
	 */
	private char[] tempSecretWord = new char[SIZE];

	/**
	 * 
	 */
	private String[] words = null;

	/**
	 *
	 */
	private String secretWord = null;

	/**
	 *
	 */
	private String playerWord = null;

	/**
	 *
	 */
	private char[] tempPlayerWord;

	/**
	 *
	 */
	private int maxNumberOfWrongGuess = 0;

	public void setDictionary(final String[] words) {
		this.words = words;
	}

	public String selectRandomSecretWord() {
		if (words == null || words.length == 0) {
			return null;
		} else {
			Random rand = new Random();
			int lengthOfArr = words.length;
			int randIndex = rand.nextInt(lengthOfArr);
			secretWord = words[randIndex];
			secretWord = secretWord.toUpperCase();
			tempPlayerWord = new char[secretWord.length()];
			for (int i = 0; i < secretWord.length(); i++) {
				tempPlayerWord[i] = '-';
			}
			playerWord = new String(tempPlayerWord);
			return secretWord;
		}
	}

	
	/**
	 *
	 */

	public String guess(Character c) {
		c = Character.toUpperCase(c);
		int flag = 0;
		if (playerWord == null) {
			return null;
		} else {
			for (int index = 0; index < secretWord.length(); index++) {
				tempSecretWord[index] = secretWord.charAt(index);
				if (c == tempSecretWord[index]) {
					tempPlayerWord[index] = c;
					flag = 1;
				}
			}
			playerWord = new String(tempPlayerWord);
			if (flag == 0) {
				maxNumberOfWrongGuess--;
			}
			if (maxNumberOfWrongGuess <= 0) {
				return null;
			}
			return playerWord;
		}
	}

	public void setMaxWrongGuesses(Integer max) {
		this.maxNumberOfWrongGuess = max;
	}
}