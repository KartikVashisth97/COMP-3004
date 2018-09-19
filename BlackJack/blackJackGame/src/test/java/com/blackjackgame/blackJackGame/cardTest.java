package com.blackjackgame.blackJackGame;

import org.junit.Test;
import junit.framework.TestCase;

public class cardTest extends TestCase

{
		

	// Create a non shuffled deck of cards to test against
	
	
	Card new_card = new Card(Suit.Diamond,2);
	Card new_card2 = new Card(Suit.Heart,5);
	Card new_card3 = new Card(Suit.Heart,6);
	Card new_card4 = new Card(Suit.Heart,7);
	Card new_card5 = new Card(Suit.Heart,8);
	Card new_card6 = new Card(Suit.Heart,9);
	Card new_card7 = new Card(Suit.Heart,10);
	

	
	@Test
	public void testToCreateCardCreated() throws Exception {
		// should return the Ace of Club
		assertNotNull(new Card(Suit.Club, 1));
	}
	
	@Test
	//if any other number is placed the test will fail
	public void testgetNumber() {
		assertEquals(5, new_card2.getNumber());
	}
	
	public void testCompareTo() throws Exception {
		assertEquals(0, new_card.compare(new_card,new_card));
	}
	
	public void testtoString(){
		assertEquals("Two of Diamond",new_card.toString()); 
	}
	
	@Test
	public void testequalsFalse() throws Exception {
		assertEquals(false, new_card.equals(new_card2));
	}
	
	@Test
	public void testequalsTrue() throws Exception {

		boolean temp = new_card3.equals(new_card3);

		assertEquals("Method should return true --> " + temp, true, temp);
	}
	
	
	/*public void testSizeOfDeck() throws Exception {
	
	}
	*/
}