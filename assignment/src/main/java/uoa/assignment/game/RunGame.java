package uoa.assignment.game;

import java.util.Scanner;

public class RunGame {

	private static boolean gameOver = false;

	public static void main(String[] args) {
		
		// check if sufficient parameters are provided
		if (args.length < 2) {
            System.out.println("Please provide height and width as command line arguments.");
            return;
        }

        try {
            // get height and width from command line arguments
            int height = Integer.parseInt(args[0]);
            int width = Integer.parseInt(args[1]);

            // create Game object and pass height and width parameters
            Game game = new Game(height, width);

		int round = 1;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
			// print the number of the round
            System.out.println("Round " + round);

			System.out.print("Enter something (or a condition to end the game): ");
            String userInput = scanner.nextLine();

            // check whether the game is over 
            if ("end".equals(userInput)) {
                gameOver = true;
            }

			round++;
		}

		scanner.close();
	} catch (NumberFormatException e) {
            System.out.println("Invalid height or width. Please provide valid integer values.");
        }
    }
}
