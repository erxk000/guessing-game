package guessingGame.main;

import java.util.Random;
import java.util.Scanner;

public class MainGuessingGame {

	public static boolean gamewin = false;
	static String nameInput;
	
	public static void main(String[] args) {
		
		//Initial game start 
		GameStartup();
    }

	//Game reset method that is called when you didn't guess correctly
	//this method is an option to start game again, if you wish
	public static void GameReset() {

		System.out.println();
		System.out.println("Wanna try again?");
		System.out.println();
		System.out.println("type 1 for yes");
		System.out.println("type 2 for no");
		System.out.println();

		Scanner gameAgain = new Scanner(System.in);

		int again = gameAgain.nextInt();

		if (again == 1) {

			Process(nameInput);

		} else if (again == 2) {

			System.out.println("Maybe next time, have a nice day :)");
		}
		if (again != 1 && again != 2) {

			System.out.println("I see you didn't stick to instructions... okay then");
		}
	}

	//Game initial Startup method
	public static String GameStartup() {
		
		//creating scanner for new input
		Scanner sc = new Scanner(System.in);
		
		//print out few welcoming lines
        System.out.println("Hi");
		System.out.println("What are you gonna call yourself?");

		//creating string "nameInput" and tying it up with recently created scanner input "sc"
		String nameInput = sc.nextLine();
		
        System.out.println("Let's play a guessing game " + nameInput);
        System.out.println("if you want to play press 1, if not press 2");

        // creating new user input and naming it "start"
       	Scanner start = new Scanner(System.in);
        
        //creating integer "getStart" and assigning it to "start", giving it integer input option
        int getStart = start.nextInt();
		
        if (getStart == 1) {

            Process(nameInput);

        } else {

            System.out.println();
        }
		//returning our previously typed input, or : what we are going to call ourselves
		return nameInput;
	}

	//GAME process method, and using our stored nameInput from previous method
    public static void Process(String nameInput) {

        Scanner start2 = new Scanner(System.in);

        //creating integer "max", giving it value 10
        int max = 10;
        
		System.out.println();
        System.out.println("lets play, I've created a random number from 0 to 10, you have to guess it, you have 3 guesses");

        //creating random variable, naming it "rndNum";
        Random rndNum = new Random();

        //creating integer, naming it "GeneratedNum" and giving it value of "rndNum" input number
        int GeneratedNum = rndNum.nextInt(max);
        int getGuess = 0;
        int attempts = 3;
		
        Scanner guess = new Scanner(System.in);
        
        System.out.println("Whats your guess? ");
  
		//Guessing method. I separated it into 3 scenarios... 
		//1st, when number is guessed correctly at any point. 
		//2nd, when number is guessed incorrectly and player has more than 1 attempt left.
		//3rd, when number is guessed incorrectly and player has less than 1 attempt left.
		/*scenario when player has 1 attempt is not necessary because, the moment that the player has 1 attempt, is when he is choosing his last guess, 
		therefore right after choosing his last guess, number of attempts is less than 1 */
		
        do {
                
            getGuess = guess.nextInt();

            //first scenario, when user types the right number
            if (getGuess == GeneratedNum) {

				System.out.println("Nice job " + nameInput + ", the number was: " + GeneratedNum);
				System.out.println("Thanx for playing our guessing game!");
				System.out.print("Created and written by: \"PlayinFractured tm\"");
	
				gamewin = true;
					
                break; 	
			}

			//second scenario, when user types the wrong number and have more than 1 attempt left
            if (getGuess != GeneratedNum && attempts > 1)  {

                System.out.println("Oooops, you have: " + (attempts - 1 ) + " attempts left");
            }

            attempts -= 1;
 	
			//third scenario, when user types the wrong number and have less than 1 attempt
            if (attempts < 1 && getGuess != GeneratedNum) {

                System.out.print("No attempts left, ");
                System.out.print("YOU LOSE.. the number was: " + GeneratedNum);
				System.out.println();
				
                break;
            }

        } while (getGuess != GeneratedNum); 

		//gives you option to reset if you didn't guess correctly
		if (gamewin != true) {
			GameReset();
		} 
	}
}