package com.blackjackgame.blackJackGame;

public class Player {

		public static final int DeckCount = 52;
		private Card[] cards = new Card[DeckCount];
		private int numCards;

		// initialize empty hand
		public Player() {

			numCards = 0;
		}

		// initialize hand from String
		public Player(String str) throws Exception {

			String[] tokens = str.split("\\s+");

			for (int i = 0; i < tokens.length; i++) {

				Card card = new Card(tokens[i]);
				addCard(card);
			}
		}

		// return dealer up card
		public Card getUpCard() {

			return cards[0];
		}

		// add card to hand
		public void addCard(Card card) throws Exception {

			// check for duplicates
			for (int i = 0; i < numCards; i++) {
				if (card.equals(cards[i]))
					throw new Exception("Duplicate card in Hand: " + card);

			}

			// add card
			cards[numCards++] = card;

		}

		// clear hand
		public void clear() {

			numCards = 0;
		}

		// return card at index i
		public Card getCard(int i) {

			Card card = null;

			if (i >= 0 && i < numCards)
				card = cards[i];

			return card;
		}

		// return the dealer's total hand value.
		public int getScore() {

			Card card;
			int score = 0;
			int countAces = 0;

			// count score and aces
			for (int i = 0; i < numCards; i++) {

				card = cards[i];
				int value = card.getValue();

				if (value == 11) // ace?
				{
					countAces++;
				}

				score = score + value;
			}

			// subtract aces
			while (score > 21 && countAces > 0) {
				score = score - 10;
				countAces--;
			}

			return score;

		}

		// return true if player can draw another card
		public boolean playerCanDraw(Card dealerUpCard) {

			int score = getScore();
			int dealerUpCardValue = dealerUpCard.getValue();

			if (score < 17 && dealerUpCardValue >= 7) {
				return true;
			} else if (score < 12 && dealerUpCardValue <= 6) {
				return true;
			} else
				return false;
		}

		// return true if dealewr can draw another card
		// stands at 17
		public boolean dealerCanDraw() {

			int score = getScore();
			return score <= 16 || (score == 17 && hasAce());
		}

		// return num cards
		public int getNumCards() {

			return numCards;
		}

		// return true if has ace
		public boolean hasAce() {
			for (int i = 0; i < numCards; i++) {
				if (cards[i].getRank().equals("A"))
					return true;
			}

			return false;
		}

		// print hand
		public String toString() {

			String s = "";

			for (int i = 0; i < numCards; i++) {
				Card card = cards[i];
				s += card + " ";
			}

			return s;
		}

	}
