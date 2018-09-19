package com.blackjackgame.blackJackGame;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJackMain {
	
	
	private static ArrayList<Card> hand;//represents the user's hand
	private static int handvalue;//the value of the user's hand
	private static String name;//name of the user
	public static void main(String[] args){
		System.out.println("Hi! What is your name?");
	    Scanner scan = new Scanner(System.in);
	    name = scan.nextLine();
	    System.out.println("Hello, "+ name +", lets play some BlackJack!");
	    DeckOfCards deck = new Deck();//initialize deck, dealer, hands, and set the bet.
        deck.shuffleDeck();
         dealer = new Dealer(deck);
        List<Card> hand = new ArrayList<>();
        hand.add(deck.drawCard());
        hand.add(deck.drawCard());
	}
	
}
