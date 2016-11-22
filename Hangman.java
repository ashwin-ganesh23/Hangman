/*
 * Name: <Ashwin Ganesh>
 * ID: <A10210060>
 * Login: <asganesh@ucsd.edu>
 */

import java.util.Scanner;

public class Hangman {

	public static void main(String[] args)
	{
		boolean again=true; 			//y or n
		int length, attempts, games=0;
		int[] wlength = new int[4]; 	//word length chosen
		int[] wins = new int[4]; 		//wins per word length
		int[] losses = new int[4]; 		//losses per word length
		String guess; 					//guessed letter
		String actual, go;

		//Scanner object
		Scanner scan = new Scanner(System.in);
		//Dictionary object
		Dictionary dict;

		//while loop to continue asking user to play
		while (again)
		{
			System.out.println("\nWelcome to Hangman 1.0");
			System.out.println("How long is the word? 3-6: ");
			length = scan.nextInt();
			wlength[length-3] += 1;
			dict = new Dictionary(length);
			attempts = 6;
			int count=0;
			games++;
			actual = dict.pickWord(length);

			//for loop to iterate through guesses per word
			for (int x = 0; x < 6; x++)
			{
				System.out.println()
				dict.print(dict.dashes);
				System.out.println("\n\nMisses: " + dict.Misses);
				System.out.println("Attempts Left: " + attempts);
				System.out.println("your guess? ");
				if (count == 0 && attempts == 6)
				{
					guess = scan.nextLine();
				}
				guess = scan.nextLine();

				//if guess is in word
				if (actual.indexOf(guess) >= 0)
				{
					dict.editDashes(guess);
					count++;
					x=x-1;
					//if all letters are guessed
					if (count==length)
					{
						wins[length-3] += 1;
						break;
					}
				}
				//if guess is not in word
				else
				{
					dict.addNewMiss(guess);
					attempts--;
					if (attempts == 0)
					{
						losses[length-3] += 1;
					}
				}
			}

			System.out.println("again? y/n");
			go = scan.nextLine();
			if (go.equals("y"))
			{
				again = true;
			}
			else
			{
				again = false;
			}
		}

		//Extra Credit analysis of games played
		System.out.println("Number of games played: " + games);
		System.out.println("Words of length 3: " + wlength[0] + " Game(s) played. Won " + wins[0] + " game(s), Lost " + losses[0] + " game(s)");
		System.out.println("Words of length 4: " + wlength[1] + " Game(s) played. Won " + wins[1] + " game(s), Lost " + losses[1] + " game(s)");
		System.out.println("Words of length 5: " + wlength[2] + " Game(s) played. Won " + wins[2] + " game(s), Lost " + losses[2] + " game(s)");
		System.out.println("Words of length 6: " + wlength[3] + " Game(s) played. Won " + wins[3] + " game(s), Lost " + losses[3] + " game(s)");
	}
}
