package com.blackjackgame.blackJackGame;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.Before;

public class PlayerTest {
	
	private Player test_p;
	
	@Test
	public void testGetName() throws Exception {
		assertEquals("Tester", test_p.getPlayerName());
	}
	
	@Test
	public void testGetCard() throws Exception {
	
		// Player is created with a hand of 10 cards
		Player test = new Player("Test_person");
		
		Card card1 = new Card(Suit.Heart, 13);
		Card card2 = new Card(Suit.Spade, 4);
		Card card3 = new Card(Suit.Spade, 5);
		// Add a card to player hand
		
		test.addCard(card1);
		test.addCard(card2);
		test.addCard(card3);
		
		assertEquals(card1, test.getCard(0));
		assertEquals(card2, test.getCard(1));
		assertEquals(card3, test.getCard(2));
	}
	
	
	@Test
	 public void testGetPlayerHand() throws Exception {
		 
		 Card card1 = new Card(Suit.Heart, 1); //Ace
		 Card card2 = new Card(Suit.Heart, 2);
		 Card card3 = new Card(Suit.Heart, 3);
		 Card card4 = new Card(Suit.Heart, 4);
		 Card card5 = new Card(Suit.Heart, 5);
		 Card card6 = new Card(Suit.Heart, 6);
		 Card card7 = new Card(Suit.Heart, 7);
		 Card card8 = new Card(Suit.Heart, 8);
		 Card card9 = new Card(Suit.Heart, 9);
		 Card card10 = new Card(Suit.Heart, 10);
		 
		 Card[] handtest = new Card[10];
		 handtest[0] = card1;
		 handtest[1] = card2;
		 handtest[2] = card3;
		 handtest[3] = card4;
		 handtest[4] = card5;
		 handtest[5] = card6;
		 handtest[6] = card7;
		 handtest[7] = card8;
		 handtest[8] = card9;
		 handtest[9] = card10;
		 
		 test_p.addCard(card1);
		 test_p.addCard(card2);
		 test_p.addCard(card3);
		 test_p.addCard(card4);
		 test_p.addCard(card5);
		 test_p.addCard(card6);
		 test_p.addCard(card7);
		 test_p.addCard(card8);
		 test_p.addCard(card9);
		 test_p.addCard(card10);
		 
		 assertArrayEquals(handtest, test_p.getPlayerHand());
	 }
	
	@Test
	public void testPlayerCreated() throws Exception {
		assertNotNull(test_p);
	}
	
	@Test
	public void testPlayerHasHand() throws Exception {
		
		assertEquals(11, test_p.getPlayerHand().length);
	}
	@Test
	public void testSumOfHand() throws Exception {
		
		Card temp_card = new Card(Suit.Spade, 5);
		Card temp_card_2 = new Card(Suit.Spade, 7);
		
		test_p.addCard(temp_card);
		test_p.addCard(temp_card_2);
		
		assertEquals(12, test_p.sumOfHand());
	}
	
	
	
}
