package com.blackjackgame.blackJackGame;

import java.util.Arrays;

//cards contains suit and rank and a value
public class Card {

	private String suit; // H S D C
	private String rank; // 2,3,4,5,6,7,8,9,10,J,Q,K,A
	private int value; // 1-11
	private static final String[] suits = {"Heart","Spade","Diamond","Club"};
	private static final String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	private static final int values[] = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11 };

	// constructor receives suit and rank indexes
	public Card(int s, int r) throws Exception {

		try
		{
		suit = suits[s];
		rank = ranks[r];
		value = values[r];
		}
		
		catch(Exception ex)
		{
			throw new Exception("Index of card is out of bounds " + ex.getMessage());
		}

	}
	
	//This constructor has he suit and rank
	public Card(String str) throws Exception
	{
		if(str.length() > 3 || str.length() < 1) throw new Exception("card string bad: " + str);
		int s = Arrays.asList(suits).indexOf(str.substring(0,1));
		int r = Arrays.asList(ranks).indexOf(str.substring(1));
		
		Card card = new Card(s,r);
		suit = card.suit;
		rank = card.rank;
		value = card.value;
		
	}

	public String getRank() {

		return rank;
	}
	
	public String getSuit() {

		return suit;
	}

	public int getValue() {

		return value;
	}

	//if ace is here then true
	public boolean isAce() {

		return rank.equals("A");
	}

	// return info string
	public String toString() {
		return suit + rank;
	}


// return true if two cards equal
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		
		if (rank == null) {
			if (other.rank != null)
				return false;
		} 
		
		else if (!rank.equals(other.rank))
			return false;
		
		if (suit == null) {
			if (other.suit != null)
				return false;
		} 
		
		else if (!suit.equals(other.suit))
			return false;
		return true;
	}
}
