package com.blackjackgame.blackJackGame;

import org.junit.Test;

import junit.framework.TestCase;

public class cardTest extends TestCase

{
	private Card[] testd;
	private DeckOfCards real_deck; 
	
	Card new_card = new Card(Suit.Diamond,5);
	Card new_card2 = new Card(Suit.Heart,7);
	
	public void getRank(){
	}
	
	public void getSuit(){
	}
	public void testSetup() {
	
	real_deck = new DeckOfCards();

	// Create a non shuffled deck of cards to test against
	testd = new Card[52];

	//testing deck of 52 cards 13 of each suit

	// Hearts
	testd[0] = new Card(Suit.Heart, 1);
	testd[1] = new Card(Suit.Heart, 2);
	testd[2] = new Card(Suit.Heart, 3);
	testd[3] = new Card(Suit.Heart, 4);
	testd[4] = new Card(Suit.Heart, 5);
	testd[5] = new Card(Suit.Heart, 6);
	testd[6] = new Card(Suit.Heart, 7);
	testd[7] = new Card(Suit.Heart, 8);
	testd[8] = new Card(Suit.Heart, 9);
	testd[9] = new Card(Suit.Heart, 10);
	testd[10] = new Card(Suit.Heart, 11);
	testd[11] = new Card(Suit.Heart, 12);
	testd[12] = new Card(Suit.Heart, 13);

	// Spades
	testd[13] = new Card(Suit.Spade, 1);
	testd[14] = new Card(Suit.Spade, 2);
	testd[15] = new Card(Suit.Spade, 3);
	testd[16] = new Card(Suit.Spade, 4);
	testd[17] = new Card(Suit.Spade, 5);
	testd[18] = new Card(Suit.Spade, 6);
	testd[19] = new Card(Suit.Spade, 7);
	testd[20] = new Card(Suit.Spade, 8);
	testd[21] = new Card(Suit.Spade, 9);
	testd[22] = new Card(Suit.Spade, 10);
	testd[23] = new Card(Suit.Spade, 11);
	testd[24] = new Card(Suit.Spade, 12);
	testd[25] = new Card(Suit.Spade, 13);

	// Diamonds
	testd[26] = new Card(Suit.Diamond, 1);
	testd[27] = new Card(Suit.Diamond, 2);
	testd[28] = new Card(Suit.Diamond, 3);
	testd[29] = new Card(Suit.Diamond, 4);
	testd[30] = new Card(Suit.Diamond, 5);
	testd[31] = new Card(Suit.Diamond, 6);
	testd[32] = new Card(Suit.Diamond, 7);
	testd[33] = new Card(Suit.Diamond, 8);
	testd[34] = new Card(Suit.Diamond, 9);
	testd[35] = new Card(Suit.Diamond, 10);
	testd[36] = new Card(Suit.Diamond, 11);
	testd[37] = new Card(Suit.Diamond, 12);
	testd[38] = new Card(Suit.Diamond, 13);

	// Clubs
	testd[39] = new Card(Suit.Club, 1);
	testd[40] = new Card(Suit.Club, 2);
	testd[41] = new Card(Suit.Club, 3);
	testd[42] = new Card(Suit.Club, 4);
	testd[43] = new Card(Suit.Club, 5);
	testd[44] = new Card(Suit.Club, 6);
	testd[45] = new Card(Suit.Club, 7);
	testd[46] = new Card(Suit.Club, 8);
	testd[47] = new Card(Suit.Club, 9);
	testd[48] = new Card(Suit.Club, 10);
	testd[49] = new Card(Suit.Club, 11);
	testd[50] = new Card(Suit.Club, 12);
	testd[51] = new Card(Suit.Club, 13);
	
}
	@Test
	public void testToCreateCardCreated() throws Exception {
		// should return the Ace of Club
		assertNotNull(new Card(Suit.Club, 1));
	}
	
	@Test
	public void testgetCardIdNumber() {
		assertEquals(5, new_card.getCardIdNumber());
	}
	
	public void testCompareTo() throws Exception {
		assertEquals(0, testd[0].compare(testd[0], testd[0]));
	}
	
	@Test
	public void testSizeOfDeck() throws Exception {
		assertEquals(52, real_deck.sizeOfDeck());
	}
}