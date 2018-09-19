package com.blackjackgame.blackJackGame;

public class deckOfCardsTest {
	
	Card new_card = new Card(Suit.Diamond,2);
	Card new_card2 = new Card(Suit.Heart,5);
	Card new_card3 = new Card(Suit.Spade,6);
	Card new_card4 = new Card(Suit.Club,7);
	Card new_card5 = new Card(Suit.Diamond,8);
	Card new_card6 = new Card(Suit.Heart,9);
	Card new_card7 = new Card(Suit.Club,10);
	
	public void testDealNextCard() throws Exception {

		assertEquals(new_card, dealNextCard());
	}
}
