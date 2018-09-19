package com.blackjackgame.blackJackGame;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author John Rose Apr 26, 2017
 */
public class BlackjackMain{

	/**
	 * void
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Rules of the game
		String[] rule_list_array = new String[7];
		rule_list_array[0] = "You can not bet more money than you own.";
		rule_list_array[1] = "Minimum bet is $1.";
		rule_list_array[2] = "Bets are doubled if you win a hand.";
		rule_list_array[3] = "You only lose the amount you bet.";
		rule_list_array[4] = "If you break either the minimum or maximum bet rule the game will automatically start over.";
		rule_list_array[5] = "You can play as long as your total money amount is greater than $0 or less than $10000.";
		rule_list_array[6] = "No swear words allowed.";
		
		// Initialize Scanner object to take in input from player
		Scanner player_input = new Scanner(System.in);

		System.out.println("Please enter your name to begin Blackjack game or \"q\" to quit the game.");
		String player_name = player_input.nextLine();

		if (player_name.equalsIgnoreCase("q")) {
			
			System.out.println("\nThank you for playing!");
			System.exit(1);
		}
		
		// Initialize player and dealer set their money to play with
		Player player_one = new Player(player_name);

		// Dealer's money represents the total money the player is allowed to
		// win
		Player dealer = new Player("Dealer");

		// Initialize deck of cards
		DeckOfCards deck = new DeckOfCards();

		// Shuffle deck
		deck.shuffleDeck();

		// Print basic rules for the player to read
		System.out.println("\n" + player_name + " here are the basic rules:");
		for (int i = 1; i <= rule_list_array.length; i++) {

			System.out.println(i + ". " + rule_list_array[i - 1]);
	

		// Variable for player's answers
		String answer;
		
		// Print out betting instructions and prompt player for bet amount
		System.out.println("\nAlright, " + player_name + "Get ready for BlackJack!"); 
		

		

		// Check for incorrect input and restart game if exception is thrown
		try {

			// Game should run while the player has cash
			

				// Create variable to mark when each round is over
				boolean round_over = false;
				// Check player bet is less than $1
				

					// Print basic rules for the player to read
					System.out.println("\n" + player_name + " here are the basic rules. Please read them this time:");
					for (int i1 = 1; i1 <= rule_list_array.length; i1++) {

						System.out.println(i1 + ". " + rule_list_array[i1 - 1]);


				// Check player did not bet more than they own
			

					System.out.println("\n" + player_name
							+ ", I might have been born at night but it wasn't last night!"
							+ "\nThat kind of behavior will not be tolerated if you would like to keep your teeth.");
					System.out.println("\nThe game will reset now please read the rules again.\n");

					// restart game
					BlackjackMain.main(args);

					
				// Deal the player a card
				player_one.addCard(deck.dealNextCard());

				// Deal the dealer a card
				dealer.addCard(deck.dealNextCard());

				// Deal the player a card
				player_one.addCard(deck.dealNextCard());

				// Deal the dealer a card
				dealer.addCard(deck.dealNextCard());

				// While loop for player one to hit or stay
				while (true) {

					System.out.println();
					System.out.println(player_name + " you are at " + player_one.sumOfHand() + " points.");

					player_one.printHand(true);
					dealer.printHand(false);

					// Player's turn
					System.out.println("Would you like to Hit or Stay?\nPlease enter H or S.");
					answer = player_input.next();

					// Player hits
					if (answer.equalsIgnoreCase("H")) {

						// Add a card to player hand
						player_one.addCard(deck.dealNextCard());

						// Check player for bust
						if (player_one.sumOfHand() > 21) {
							System.out.println();
							System.out.println("You Busted! --> " + player_one.sumOfHand());
							System.out.println(player_name + " kiss $" + " goodbye.");
							round_over = true;
							break;
						}
					} 

					// Player stays
					if (answer.equalsIgnoreCase("S")) {
						break;
					}

				} // Closes player one inner game loop

				// Show dealer cards once player has finished
				System.out.println();
				System.out.println(dealer.getPlayerName() + "'s cards before hit. --> " + dealer.sumOfHand());
				dealer.printHand(true);

				// Dealer hits at 16 and stays at 17
				while ((dealer.sumOfHand() < 17) && round_over == false) {

					// Deal card to dealer
					dealer.addCard(deck.dealNextCard());
					System.out.println(dealer.getPlayerName() + "'s hand after hit. --> " + dealer.sumOfHand());
					dealer.printHand(true);

				}

				// Check to see if dealer busted
				if (dealer.sumOfHand() > 21 && round_over == false) {
					System.out.println();
					System.out.println(dealer.getPlayerName() + " Busted! --> " + dealer.sumOfHand());
					System.out.println(" so " + player_one.getPlayerName());
					round_over = true;
				}

				// Check to see if dealer wins by total points
				if ((dealer.sumOfHand() > player_one.sumOfHand()) && round_over == false) {

					System.out.println(dealer.getPlayerName() + " Wins! --> " + dealer.sumOfHand());
					System.out.println(player_name + " loses $");
					round_over = true;
					
				}

				// Check to see if there is a draw
				if (dealer.sumOfHand() == player_one.sumOfHand() && round_over == false) {

					System.out.println("It's a draw!");
					System.out.println(player_name + " has " + player_one.sumOfHand() + " and " + dealer.getPlayerName()
							+ " has " + dealer.sumOfHand());
					round_over = true;
				}

				// Check to see if player one wins by total points
				if (player_one.sumOfHand() > dealer.sumOfHand() && round_over == false) {

					System.out.println(player_name + " Wins! --> " + player_one.sumOfHand());
					round_over = true;
				}

				// Dealer wins by default
				else if (round_over == false) {

					System.out.println(dealer.getPlayerName() + " Wins!" + dealer.sumOfHand());
				}

				} 

					
					System.out.println("\nHand is over and " + player_name);
					System.out.println("Do it to it Son!");
					System.out.println();

				// Reset player hand, playing deck and shuffle playing deck
				player_one.resetPlayerHand();
				dealer.resetPlayerHand();
				deck = deck.resetDeck();
				deck.shuffleDeck();
				// Closes main game loop
		
		}
	
		// Print message for player when they've lost all their money
		System.out.println("Dang " + player_name + "! You lost all your scratch.");
		

		// Close scanner object
		player_input.close();

}// Closes Main method
 // Closes class
