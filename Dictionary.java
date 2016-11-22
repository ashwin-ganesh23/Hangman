/*
 * Name: <Ashwin Ganesh>
 * ID: <A10210060>
 * Login: <asganesh@ucsd.edu>
 */

import java.util.Random;
import java.util.LinkedList;

/**
 *
 * A class that implements a "dictionary" and a few functions associated with it.
 * @since 2015-09-27
 * @version 1.0
 * @author Ashwin Ganesh
 */

public class Dictionary {

	LinkedList<String> Misses = new LinkedList<String>();
	Random rand = new Random();
	public int count;
	public String word;
	public String[] dashes;
	public String[] letters = new String[3];
	public String[] phrase = {"-", "-", "-", "-", "-", "-"};
	public String[] words={"cat", "dog", "rod", "bird", "look", "rate", "grade", "chair", "paper", "puzzle", "aboard", "avenue"};

  /**
   *
   * Initializes the phrase to guess with dashes.
   * @param size of the phrase to guess
   */
	public Dictionary(int size)
	{
		dashes = new String[size];
		System.arraycopy(phrase, 0, dashes, 0, dashes.length);
	}


	public void editDashes(String guess)
	{
		for (int index = word.indexOf(guess); index >= 0; index = word.indexOf(guess, index + 1))
		{
			dashes[index] = word.substring(index, index+1);
		}
	}

  /**
   *
   * Adds a string to the List of missed letters
   * @param miss Input from the user, the letter does not belong to the phrase.
   */
	public void addNewMiss(String miss)
	{
		Misses.addFirst(miss);
	}

  /**
   *
   * Prints an array
   * @param arr
   */
	public void print(String[] arr)
	{
		for (int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i]);
		}
	}

  /**
   *
   * Picks a random word from the dictionary, given the length of the word
   * @param size Input from the user, the word size.
   * @return String a random word from the dictionary
   */
	public String pickWord(int size)
	{
		int a = rand.nextInt(3);
		count = 0;

		for (int x = 0; x < words.length; x++)
		{
			if (words[x].length() == size)
			{
				letters[count] = words[x];
				count++;
			}
		}
		word = letters[a];
		return word;
	}

}
