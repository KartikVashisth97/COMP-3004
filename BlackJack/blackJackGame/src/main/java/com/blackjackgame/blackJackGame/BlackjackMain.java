package com.blackjackgame.blackJackGame;

import java.io.File;
import java.util.Scanner;

/**
 * 
 * Black jack game
 *
 */

public class BlackjackMain {

	
	public static final int BJ = 21;

	public static enum Scores {
		NoWin, Pl_BJ, Dealer_BJ, BJ_Tie, TieGame, Pl_Win, DealerWins, DealerBusts, Pl_Busts
	};

	
	private static final Scanner kybd = new Scanner(System.in);

	private DeckOfCards deck;
	private Player player;
	private Player dealer;

	private String mode = "C"; 
	private Scanner fsc; 

	public BlackjackMain() throws Exception {
		deck = new DeckOfCards();
		player = new Player();
		dealer = new Player();

		deck.shuffle();

	}

	public Card getCard() throws Exception {
		Card card = null;

		if (mode.equals("C"))
			
			card = deck.deal();

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

	public String getResponse() throws Exception {
		
		String response = "";

		
		if (mode.equals("C")) {

			
			
			response = kybd.nextLine().toUpperCase();


			while (!(response.equals("H") || response.equals("S"))) {
			
				System.out.print("You must enter H or S: ");
				
				response = kybd.nextLine().toUpperCase();

			}
		}

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
	
	//return score
	public Scores checkScore(Player player, Player dealer) {
		int p_score = player.getScore();
		
		int dealerScore = dealer.getScore();

		
		
		
		if (p_score == dealerScore) {
			//checks if its a tie
		
			if (p_score == BJ && dealerScore == BJ) {
				
				return Scores.BJ_Tie;
			}

			else {
				return Scores.TieGame;
			}
		}

		
		else if (dealerScore == BJ) {
			//check the dealer score
			return Scores.Dealer_BJ;
		}

		
		else if (p_score == BJ) {
			//check if player has BJ
			return Scores.Pl_BJ;
		}

		
		else if (dealerScore > BJ) {
			//dealer busts
			return Scores.DealerBusts;
		}

		
		else if (p_score > BJ) {
			//player busts
			return Scores.Pl_Busts;
		}

		else if (p_score > dealerScore) {
			//p_score 
			return Scores.Pl_Win;
		}

		else {
			//return score
			return Scores.DealerWins;
		}

	}

	
	
	public void run(String[] args) throws Exception {
		//run the game
		//console or file
		// input file name
		
		String filename;

		// ask console or file mode
		
		do {
			//console or file mode
			
			System.out.print("Type C for Console mode or F  File mode");
			mode = kybd.nextLine().toUpperCase();
			
		} while (!(mode.equals("C") || mode.equals("F")));

	
		if (mode.equals("F")) {

			
			if (args.length > 0) {
				filename = args[0];
			}

			else {
				System.out.print("Enter input File name: ");
				filename = kybd.nextLine();
			}

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

	
	public void play() throws Exception {


		int p_score = 0;
		
		int dealerScore = 0;

		
		Card card = null;
		
		for (int i = 0; i < 2; i++) {
		
			card = getCard();
			
			player.addCard(card);
		
		}

		for (int i = 0; i < 2; i++) {
		
			card = getCard();
			
			dealer.addCard(card);
		}

		
		
		System.out.println("Player Cards: " + player);
		
		System.out.println("Player Score: " + player.getScore());

		
		
		System.out.println("Dealer Up Card: " + dealer.getUpCard());

		// check score
		Scores score = checkScore(player, dealer);
		
		// check for black jack
		if (score == Scores.BJ_Tie) {

			System.out.println("Tie Game both dealer and player have a black jack!");
		
			System.out.println("Game Over!");
		}

		
		else if (score == Scores.Dealer_BJ) {

			System.out.println("Dealer has a black jack!");
		
			System.out.println("Game Over!");
		}

		
		else if (score == Scores.Pl_BJ) {

		
			System.out.println("Player has a black jack!");
			
			System.out.println("Game Over!");

		}

		
		else {
			
			// hit or stand
			System.out.print("Player (H)it or (S)tand: ");
		
			String response = getResponse();

			
			if (mode.equals("F"))
			
				System.out.println(response);

			boolean busted = false;
			
			while (!busted && response.equalsIgnoreCase("H")) {
			
				player.addCard(getCard());
				
				p_score = player.getScore();
				
				System.out.print("Players Cards: "); // print players cards
				
				System.out.println(player);
				
				System.out.println("Player's score: " + player.getScore());

				
				
				
				if (p_score > BJ) {
				
					System.out.println("Player You have busted, You Loose");
					
					busted = true;
				} 
				
				else {
				
					System.out.print("Player (H)it or (S)tand: ");
					
					response = getResponse();
					
					if (mode.equals("F"))
					
						System.out.println(response);
				}
			}

			
			
			
			if (!busted) {

			
			
				System.out.print("Players Final Cards: "); // print players
															// cards
				
				System.out.println(player);
				p_score = player.getScore();
				
				System.out.println("Player's final score: " + p_score);

				// then the dealer draws cards until reaching a total of 17 or
				// more.

				
				dealerScore = dealer.getScore();
				System.out.print("Dealer Score so far: " + dealerScore + "\n");
				while (dealer.dealerCanDraw()) {
				
					System.out.println("Dealer takes a card");
					
					dealer.addCard(getCard());
				}

				
				dealerScore = dealer.getScore();
				
				System.out.print("Final Dealer Score: " + dealerScore + "\n");

				
				System.out.print("Dealers Player: ");
				
				System.out.println(dealer);

				
				// dealer busts
				
				if (dealerScore > BJ) {
				
					System.out.println("Dealer has busted! Player Wins");
				}

				
				else {
				
					score = checkScore(player, dealer);

					printWinner(score);

				} 

			}
		}
	}

	// print winner
	public void printWinner(Scores score) {

	

		if (score == Scores.BJ_Tie) {
			System.out.println("BJ Tie Game");

		}

		else if (score == Scores.TieGame) {
	
			System.out.println("Tie Game");

		}

		else if (score == Scores.Pl_BJ) {
			
			System.out.println("You won! You hit BJ");
		}

		else if (score == Scores.Dealer_BJ) {
			
			System.out.println("You Loose, Dealer got BJ");
		}

		else if (score == Scores.Pl_Win) {
			
			System.out.print("You Win" + "\n");
		}

		else if (score == Scores.DealerWins) {
			
			System.out.print("Dealer wins, You loose!" + "\n");
		}

	}

}
