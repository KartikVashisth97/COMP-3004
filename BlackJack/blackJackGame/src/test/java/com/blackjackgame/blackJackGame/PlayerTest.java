package com.blackjackgame.blackJackGame;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Before;
import org.junit.Test;


public class PlayerTest {
	

		
		private Player playertest;
		
		@Before
		public void setup() {
			playertest = new Player("Tester");
		}
		
		
		@Test
		public void testPlayerCreated() throws Exception {
			assertNotNull(playertest);
		}
		
		
		@Test
		public void testGetName() throws Exception {
			assertEquals("Tester", playertest.getPlayerName());
		}
		
		@Test
		 public void testGetPlayerHand() throws Exception {
			 
			 Card card1 = new Card(Suit.Spade, 1); //Ace
			 Card card2 = new Card(Suit.Club, 2);
			 Card card3 = new Card(Suit.Heart, 3);
			 Card card4 = new Card(Suit.Diamond, 4);
			 Card card5 = new Card(Suit.Diamond, 5);
			 Card card6 = new Card(Suit.Heart, 6);
			 Card card7 = new Card(Suit.Spade, 7);
			 Card card8 = new Card(Suit.Spade, 8);
			 Card card9 = new Card(Suit.Spade, 9);
			 Card card10 = new Card(Suit.Heart, 10);
			 
			 Card[] handTested = new Card[10];
			 handTested[0] = card1;
			 handTested[1] = card2;
			 handTested[2] = card3;
			 handTested[3] = card4;
			 handTested[4] = card5;
			 handTested[5] = card6;
			 handTested[6] = card7;
			 handTested[7] = card8;
			 handTested[8] = card9;
			 handTested[9] = card10;
			 
			 playertest.addCard(card1);
			 playertest.addCard(card2);
			 playertest.addCard(card3);
			 playertest.addCard(card4);
			 playertest.addCard(card5);
			 playertest.addCard(card6);
			 playertest.addCard(card7);
			 playertest.addCard(card8);
			 playertest.addCard(card9);
			 playertest.addCard(card10);
			 
			 assertArrayEquals(handTested, playertest.getPlayerHand());
		 }
		 
		@Test
		public void testGetCard() throws Exception {
		
			Player test = new Player("TesterNo2");
			
			Card card1 = new Card(Suit.Spade, 13);
			Card card2 = new Card(Suit.Spade, 11);
			
			
			test.addCard(card1);
			test.addCard(card2);
			
			assertEquals(card1, test.getCard(0));
		}
		
		
		@Test
		public void testPlayerHasHand() throws Exception {
			
			assertEquals(10, playertest.getPlayerHand().length);
		}
		
		
		@Test
		public void testDealerAndPlayerCreated() throws Exception {
			Player test_dealer = new Player("Dealer");
			
			assertNotSame(test_dealer, playertest);
		}
		
		
		@Test
		public void testAddCardToPlayersHand() throws Exception {
			
			Card temp_card = new Card(Suit.Spade, 13);
			
			playertest.addCard(temp_card);
			
			assertEquals(temp_card, playertest.getPlayerHand()[0]);
		}
		
		
		@Test
		public void testSumOfHand() throws Exception {
			
			Card tempcard = new Card(Suit.Spade, 8);
			Card tempcard2 = new Card(Suit.Spade, 4);
			
			playertest.addCard(tempcard);
			playertest.addCard(tempcard2);
			
			assertEquals(12, playertest.sumOfHand());
		}
		
		@Test
		public void testsumOfHandAces21() throws Exception {
			
			Card temp_card = new Card(Suit.Heart, 1); // Ace of Heart
			Card temp_card_2 = new Card(Suit.Spade, 13); // King of Spade
			
			playertest.addCard(temp_card);
			playertest.addCard(temp_card_2);
			
			assertEquals(21, playertest.sumOfHand());
		}
		
	
		@Test
		public void testSumOfHandAcesWithGreaterThan10() throws Exception {
			
			Card c1 = new Card(Suit.Heart, 1); // Ace of Heart
			Card c2 = new Card(Suit.Spade, 1); // Ace of Spade
			
			playertest.addCard(c1);
			playertest.addCard(c2);
			
			
			assertEquals(12, playertest.sumOfHand());
		}
}
	
	/*private Player test_p;
	
	public void setup(){
		test_p = new Player("Tester"); 
	}
	
	@Test
	public void testPlayerCreated() {
		assertNotNull(test_p);
	}

	@Test
	public void testgetPlayerName() {
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
*/
