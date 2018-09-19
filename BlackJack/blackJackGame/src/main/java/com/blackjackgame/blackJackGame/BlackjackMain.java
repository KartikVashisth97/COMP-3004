package com.blackjackgame.blackJackGame;

import java.io.File;
import java.util.Scanner;

/**
 * 
 * Black jack game
 *
 */

public class BlackjackMain {

	// constants
	public static final int BLACKJACK = 21;

	public static enum Scores {
		NoWin, PlayerBlackjack, DealerBlackjack, BlackjackTieGame, TieGame, PlayerWins, DealerWins, DealerBusts, PlayerBusts
	};

	// make key board reader
	private static final Scanner kybd = new Scanner(System.in);

	private DeckOfCards deck;
	private Player player;
	private Player dealer;

	private String mode = "C"; // opewration mode console or file input
	private Scanner fsc; // input file stream

	// construct black jack game
	public BlackjackMain() throws Exception {
		deck = new DeckOfCards();
		player = new Player();
		dealer = new Player();

		// shuffle deck
		deck.shuffle();

	}

	// get card from deck or file
	public Card getCard() throws Exception {
		Card card = null;

		if (mode.equals("C"))
			card = deck.deal();

		// file mode
		else {
			String str = "";

			try {
				str = fsc.next();
				card = new Card(str);
			}

			catch (Exception ex) {
				System.out.println("Bad card in file: " + str);
				throw new Exception("Bad card in file: " + str);
			}
		}

		return card;
	}

	// get dealer response from console or file
	public String getResponse() throws Exception {
		String response = "";

		if (mode.equals("C")) {

			response = kybd.nextLine().toUpperCase();

			while (!(response.equals("H") || response.equals("S"))) {
				System.out.print("You must enter H or S: ");
				response = kybd.nextLine().toUpperCase();

			}
		}

		// file mode
		else {

			try {
				response = fsc.next().toUpperCase();

				if (!(response.equals("H") || response.equals("S"))) {
					throw new Exception("H/S command expected in file: " + response);
				}
			}

			catch (Exception ex) {
				throw new Exception("Bad H/S command in file: " + response);
			}

		}

		return response;
	}

	// return score betwen 2 players
	public Scores checkScore(Player player, Player dealer) {
		int playerScore = player.getScore();
		int dealerScore = dealer.getScore();

		// check if tie
		if (playerScore == dealerScore) {
			if (playerScore == BLACKJACK && dealerScore == BLACKJACK) {
				return Scores.BlackjackTieGame;
			}

			else {
				return Scores.TieGame;
			}
		}

		// check if dealer has a black jack
		else if (dealerScore == BLACKJACK) {
			return Scores.DealerBlackjack;
		}

		// check if player has a black jack
		else if (playerScore == BLACKJACK) {
			return Scores.PlayerBlackjack;
		}

		// check if dealer busts
		else if (dealerScore > BLACKJACK) {
			return Scores.DealerBusts;
		}

		// check if player busts
		else if (playerScore > BLACKJACK) {
			return Scores.PlayerBusts;
		}

		else if (playerScore > dealerScore) {
			return Scores.PlayerWins;
		}

		else {
			return Scores.DealerWins;
		}

	}

	// run game
	// get operating mode console or file
	public void run(String[] args) throws Exception {

		// input file name
		String filename;

		// ask console or file mode
		do {
			System.out.print("C = Console or F = File mode? ");
			mode = kybd.nextLine().toUpperCase();
		} while (!(mode.equals("C") || mode.equals("F")));

		// open file
		if (mode.equals("F")) {

			// get file name from command line
			if (args.length > 0) {
				filename = args[0];
			}

			else {
				System.out.print("Enter input File name: ");
				filename = kybd.nextLine();
			}

			// try to open file
			try {
				fsc = new Scanner(new File(filename));
			}

			catch (Exception ex) {
				System.out.println("Cannot open input File name " + filename);
				return;
			}
		}

		play();

	}

	// play game
	public void play() throws Exception {

		// scores
		int playerScore = 0;
		int dealerScore = 0;

		// deal 2 cards to each player
		Card card = null;
		for (int i = 0; i < 2; i++) {
			card = getCard();
			player.addCard(card);
		}

		for (int i = 0; i < 2; i++) {
			card = getCard();
			dealer.addCard(card);
		}

		// show player cards
		System.out.println("Player Cards: " + player);
		System.out.println("Player Score: " + player.getScore());

		// show dealer cards
		System.out.println("Dealer Up Card: " + dealer.getUpCard());

		// check score
		Scores score = checkScore(player, dealer);

		// check for black jack
		if (score == Scores.BlackjackTieGame) {

			System.out.println("Tie Game both dealer and player have a black jack!");
			System.out.println("Game Over!");
		}

		else if (score == Scores.DealerBlackjack) {

			System.out.println("Dealer has a black jack!");
			System.out.println("Game Over!");
		}

		else if (score == Scores.PlayerBlackjack) {

			System.out.println("Player has a black jack!");
			System.out.println("Game Over!");

		}

		// continue playing
		else {
			
			// hit or stand
			System.out.print("Player (H)it or (S)tand: ");
			String response = getResponse();

			if (mode.equals("F"))
				System.out.println(response);

			boolean busted = false;
			while (!busted && response.equalsIgnoreCase("H")) {
				player.addCard(getCard());
				playerScore = player.getScore();
				System.out.print("Players Cards: "); // print players cards
				System.out.println(player);
				System.out.println("Player's score: " + player.getScore());

				// check For bust
				if (playerScore > BLACKJACK) {
					System.out.println("Player You have busted, You Loose");
					busted = true;
				} else {
					System.out.print("Player (H)it or (S)tand: ");
					response = getResponse();
					if (mode.equals("F"))
						System.out.println(response);
				}
			}

			
			// not busted
			if (!busted) {

				// get players final score
				System.out.print("Players Final Cards: "); // print players
															// cards
				System.out.println(player);
				playerScore = player.getScore();
				System.out.println("Player's final score: " + playerScore);

				// then the dealer draws cards until reaching a total of 17 or
				// more.

				// get dealers score
				dealerScore = dealer.getScore();
				System.out.print("Dealer Score so far: " + dealerScore + "\n");
				while (dealer.dealerCanDraw()) {
					System.out.println("Dealer takes a card");
					dealer.addCard(getCard());
				}

				dealerScore = dealer.getScore();
				System.out.print("Final Dealer Score: " + dealerScore + "\n");

				// print dealer Player
				System.out.print("Dealers Player: ");
				System.out.println(dealer);

				// dealer busts
				if (dealerScore > BLACKJACK) {
					System.out.println("Dealer has busted! Player Wins");
				}

				else {
					score = checkScore(player, dealer);

					printWinner(score);

				} // end else

			}
		}
	}

	// print winner
	public void printWinner(Scores score) {

		// player loose if the customer busts or if the customer's
		// total is
		// less than or equal to the dealer's and the dealer hasn't
		// bust.

		if (score == Scores.BlackjackTieGame) {
			System.out.println("Blackjack Tie Game");

		}

		else if (score == Scores.TieGame) {
			System.out.println("Tie Game");

		}

		else if (score == Scores.PlayerBlackjack) {
			System.out.println("You got a Blackjack! You Win");
		}

		else if (score == Scores.DealerBlackjack) {
			System.out.println("Dealer got a blackjack, You Loose, Dealer wins");
		}

		else if (score == Scores.PlayerWins) {
			System.out.print("You Win" + "\n");
		}

		else if (score == Scores.DealerWins) {
			System.out.print("You Loose, Dealer wins" + "\n");
		}

	}

}
