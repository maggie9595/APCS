//Maggie Yu

import java.util.*;
public class Game
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        //Choose a random number from 0 to 999,999.
        int mysteryNumber = (new Random()).nextInt(1000000);
        int guessCounter = 0;
        boolean userCorrect = false;
        
        //Let the user guess up to 20 numbers, but stop if the user is able to guess the correct number under 20 tries.
        while(!userCorrect && guessCounter < 20)
        {
			//Show the user how many guesses he/she has left.
            if(guessCounter == 0)
                System.out.println("There is a random number from 0 to 999,999; can you try to guess what it is?");
            else 
				if((guessCounter > 0) && (guessCounter < 19))
					System.out.println("You have " + (20-guessCounter) + " guesses left. Try again!");
				else
					System.out.println("You only have 1 more guess left. Try again!");

            int userGuess = input.nextInt();
            guessCounter++;
            
            //Tell the user whether his/her guess was high, low, or correct.
            if(userGuess > mysteryNumber)
                System.out.println("Your guess was high.");
            else 
                if(userGuess < mysteryNumber)
                    System.out.println("Your guess was low.");
                else
                    userCorrect = true;
        }

        //Tell the user whether or not he/she guessed the correct number after 20 guesses.
        if(userCorrect)
            System.out.println("Congratulations, you guessed the correct number!!");
        else
            System.out.println("Sorry, you've already used up your 20 guesses. You lost!");
    }
}
