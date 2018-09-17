package com.blackjackgame.blackJackGame;

public class Card {
	private int rank;
	private int suit;
	private int value; 
	public static String [] ranks = {"ACE", "TWO","THREE","FOUR", "FIVE", "SIX", "SEVEN","EIGHT","NINE","TEN","JACK", "QUEEN","KING"};
	public static String [] suits = {"SPADES", "HEARTS", "DIAMONDS", "CLUBS"};
	
	Card(int cardSuit, int value){
		
		this.suit = cardSuit;
		this.rank = value;
		      
		}
	
	public String toString()
	{
	 	return ranks[rank]+" of "+suits[suit];
	}
	
	public int getRank()
	{
	    return rank;
	}
	
	public int getSuit()
	{
	    return suit;
	}
	
	public int getValue()
	{
	    if(rank > 10)
	    {
	        value = 10;
	    }
	    else if(rank == 1)
	    {
	        value = 11;
	    }
	    else
	    {
	        value = rank;
	    }
	    return value;
	}
	
	public void setValue(int set)
	{
	    value = set;
	}
}
	
