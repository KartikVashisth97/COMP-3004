package com.blackjackgame.blackJackGame;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    // test deck class
    
    public void testDeckNumberCards() 
    {
        DeckOfCards deck=null;
		try {
			deck = new DeckOfCards();
		} 
		
		catch (Exception e) {

             assertTrue(false);
		}
    	
    	assertTrue(deck.getNumCards()==52);

    }
    
    public void testShuffle()
    {
    	try
    	{
    	DeckOfCards deck1 = new DeckOfCards();
    	DeckOfCards deck2 = new DeckOfCards();
    	
    	deck2.shuffle();
    	
    	int count = 0;
    	
    	for(int i=0;i<52;i++)
    	{
    		Card c1 = deck1.deal(); 
    		Card c2 = deck2.deal(); 
    		
    		
    		if(c1.getValue()==c2.getValue() && c1.getRank().equals(c2.getRank())
    				&& c1.getSuit().equals(c2.getSuit())) count++;
    		
    		
    	}
    	
    	// count of 5 is accepable
    	assertTrue(count < 5);
    	}
    	
    	catch (Exception e) {

            assertTrue(false);
		}
    	
    }
    
    public void testDeal()
    {
    	try
    	{
       DeckOfCards deck = new DeckOfCards();
       Card c = deck.deal();
       assertTrue(c != null);
       assertTrue(deck.getNumCards()==51);
    	}
    	
    	catch (Exception e) {

            assertTrue(false);
		}
    }
   

    
    public void testInitialize()
    {
    	try
    	{
    	DeckOfCards deck = new DeckOfCards();
    	for(int i=0;i<52;i++)
    	{
    		deck.deal();
    	}

        assertTrue(deck.getNumCards()==52);
        
    	}
    	catch (Exception e) {

            assertTrue(false);
		}
    }
    
    // test card class
    
    // test suit
    public void testSuit()
    {
    	try
    	{
    	Card card = new Card(0,2);
    	assertTrue(card.getSuit().equals("H"));
    	
    	card = new Card(3,12);
    	assertTrue(card.getSuit().equals("C"));
    	}
    	catch (Exception e) {

            assertTrue(false);
		}
    }
    
    
    // test rank
    public void testRank()
    {
    	try
    	{
    	Card card = new Card(0,2);
    	assertTrue(card.getRank().equals("4"));
    	
    	card = new Card(0,11);
    	assertTrue(card.getRank().equals("K"));
    	}
    	catch (Exception e) {

            assertTrue(false);
		}
    }
    
    // test value
    public void testValue()
    {
    	try
    	{
    	Card card = new Card(0,2);
    	assertTrue(card.getValue()==4);
    	
       	card = new Card(0,11);
    	assertTrue(card.getValue()==10);
    	}
    	catch (Exception e) {

            assertTrue(false);
		}
    }
    
    // test is ace
    public void testIsAce()
    {
    	try
    	{
    	Card card = new Card(0,12);
    	assertTrue(card.isAce());
    	
    	card = new Card(0,2);
    	assertFalse(card.isAce());
    	}
    	
    	catch (Exception e) {

            assertTrue(false);
		}
    }
    
    // test to Card string
    public void testCardToString()
    {
    	try
    	{
    	Card card = new Card(0,2);
    	assertTrue(card.toString().equals("H4"));
    	}
    	
    	catch (Exception e) {

            assertTrue(false);
		}
    
    }
    
    
    // test hand class
    
    // test add card to hand
    public void testAddCard()
    {
    	try
    	{
    	Player hand = new Player();
    	hand.addCard(new Card(0,2));
    	Card card = hand.getCard(0);
    	assertTrue(card != null);
    	assertTrue(hand.getNumCards()==1);
    	}
    	catch (Exception e) {

            assertTrue(false);
		}
    }
    
    // test if dealer can draw
 	public void testDealerCanDraw() {
 	
 		try
    	{
 		// less than 16	
    	Player hand = new Player();
    	hand.addCard(new Card(0,8));
    	hand.addCard(new Card(0,4));
  
    	assertTrue(hand.dealerCanDraw());
    	
    	// is  16	
    	hand = new Player();
    	hand.addCard(new Card(0,10));
    	hand.addCard(new Card(0,4));
  
    	assertTrue(hand.dealerCanDraw());
    	
    	// 17 no ace
    	hand = new Player();
    	hand.addCard(new Card(0,10));
    	hand.addCard(new Card(0,5));
    	
    	assertTrue(!hand.dealerCanDraw());
    	
    	// 17 has ace
    	hand = new Player();
    	hand.addCard(new Card(0,12));
    	hand.addCard(new Card(0,4));
    	
    	assertTrue(hand.dealerCanDraw());
    	
    	// greater than 17
    	hand = new Player();
    	hand.addCard(new Card(0,10));
    	hand.addCard(new Card(0,11));
    	
    	assertTrue(!hand.dealerCanDraw());
    	
    	}
    	catch (Exception e) {

            assertTrue(false);
		}
 	}

 
 	// test if hand has a ace
 	public void testHasAce() {

 		try
 		{
 	 	// hand has ace
    	Player hand = new Player();
    	hand.addCard(new Card(0,12));
    	hand.addCard(new Card(0,5));
    	
    	assertTrue(hand.hasAce());
    	
     	// hand has no ace
    	hand = new Player();
    	hand.addCard(new Card(0,10));
    	hand.addCard(new Card(0,5));
    	
    	assertTrue(!hand.hasAce());
    	
    	}
    	catch (Exception e) {

            assertTrue(false);
		}
 		
 	}
 	
 	// test if hand has duplicate card
 	public void testDuplicateCard() {

 		try
 		{
 	 	// hand has duplicate card
 		Player hand = new Player();
    	hand.addCard(new Card(0,10));
    	hand.addCard(new Card(0,10));
 		}
 		
 		catch (Exception e) {

            assertTrue(true);
		}
 		
 	 	// hand has do duplicate card
    	try
    	{
 
    	// hand has do duplicate card
    		Player hand = new Player();
    	hand.addCard(new Card(0,8));
    	hand.addCard(new Card(0,5));
    	
    	}
    	catch (Exception e) {

            assertTrue(false);
		}
 		
 	}
    
    // test add card score
    public void testCardScore()
    {
    	try
    	{
    		Player hand = new Player();
    	hand.addCard(new Card(0,2));
    	hand.addCard(new Card(0,3));
    	hand.addCard(new Card(0,5));
    	hand.addCard(new Card(0,10));
    	int score = hand.getScore();
    	assertTrue(score==26);
    	}
    	
    	catch (Exception e) {

            assertTrue(false);
		}
    }
    
    // test add card score
    public void testCardAceScoreBlackJack()
    {
    	try
    	{
    		Player hand = new Player();
    	hand.addCard(new Card(0,10));
    	hand.addCard(new Card(0,11));
    	hand.addCard(new Card(0,12));
    	assertTrue(hand.getScore()==21);
    	}
    	
    	catch (Exception e) {

            assertTrue(false);
		}
    }
    	
    // test add card score
    public void testCardAceScoreBlackJack2()
    {
    	try
    	{
    		Player hand = new Player();
    	hand.addCard(new Card(0,10));
    	hand.addCard(new Card(0,12));
    	assertTrue(hand.getScore()==21);
    	}
    	
    	catch (Exception e) {

            assertTrue(false);
		}
    }
    
    // test add card score
    public void testCardAceScoreBlackJack3()
    {
    	try
    	{
    		Player hand = new Player();
    	hand.addCard(new Card(0,12));
    	hand.addCard(new Card(0,10));
    	assertTrue(hand.getScore()==21);
    	}
    	
    	catch (Exception e) {

            assertTrue(false);
		}
    }
    
    // test add card score
    public void testCardAceScoreBlackJack4()
    {
    	try
    	{
    		Player hand = new Player();
    	hand.addCard(new Card(0,12));
    	hand.addCard(new Card(0,10));
    	hand.addCard(new Card(1,10));
    	assertTrue(hand.getScore()==21);
    	}
    	
    	catch (Exception e) {

            assertTrue(false);
		}
    }
    
    // test add card score
    public void testCardAceScore()
    {
    	
    	try
    	{
    		Player hand = new Player();
    	hand.addCard(new Card(0,10));
    	hand.addCard(new Card(0,1));
      	hand.addCard(new Card(2,2));
    	hand.addCard(new Card(0,12));
    	int score = hand.getScore();
    	assertTrue(score==18);
    	}
    	catch (Exception e) {

            assertTrue(false);
		}
    }
    	
    // test hand score 1
    // black jack tie
    public void testHandScores1()
    {
    	try
    	{
    		Player player = new Player("DK SA");
    		Player dealer = new Player("SQ DA");
        
        BlackjackMain bj = new BlackjackMain();
        
        BlackjackMain.Scores score = bj.checkScore(player, dealer);
        
        assertTrue(score == BlackjackMain.Scores.BlackjackTieGame);
    	}
    	
    	catch(Exception ex)
    	{
    		assertTrue(false);
    	}
    	
    }
    
    // test hand score 2
    // player wins
    public void testHandScores2()
    {
    	try
    	{
    		Player player = new Player("HQ SQ");
    		Player dealer = new Player("DQ S5 CJ");
        
        BlackjackMain bj = new BlackjackMain();
        
        BlackjackMain.Scores score = bj.checkScore(player, dealer);
        
        assertTrue(score == BlackjackMain.Scores.DealerBusts);
    	}
    	
    	catch(Exception ex)
    	{
    		assertTrue(false);
    	}
    	
    }
    
    // test hand score 3
    // playewr wins
    public void testHandScores3()
    {
    	try
    	{
    		Player player = new Player("S10 D3 H5 SA");
    		Player dealer = new Player("SQ C5 CA D2");
        
        BlackjackMain bj = new BlackjackMain();
        
        BlackjackMain.Scores score = bj.checkScore(player, dealer);
        
        assertTrue(score == BlackjackMain.Scores.PlayerWins);
    	}
    	
    	catch(Exception ex)
    	{
    		assertTrue(false);
    	}
    	
    }
    
    // test hand score 4
    // dealer wins
    public void testHandScores4()
    {
    	try
    	{
    		Player player = new Player("S2 D3 H5 S3");
    		Player dealer = new Player("SQ C5 CA D2");
        
        BlackjackMain bj = new BlackjackMain();
        
        BlackjackMain.Scores score = bj.checkScore(player, dealer);
        
        assertTrue(score == BlackjackMain.Scores.DealerWins);
    	}
    	
    	catch(Exception ex)
    	{
    		assertTrue(false);
    	}
    	
    }
    
    // test hand score 5
    // black jack  player
    public void testHandScores5()
    {
    	try
    	{
    		Player player = new Player("SK HA");
    		Player dealer = new Player("HQ H5");
        
        BlackjackMain bj = new BlackjackMain();
        
        BlackjackMain.Scores score = bj.checkScore(player, dealer);
        
        assertTrue(score == BlackjackMain.Scores.PlayerBlackjack);
    	}
    	
    	catch(Exception ex)
    	{
    		assertTrue(false);
    	}
    	
    }
    
    // test hand score 6
    // black jack dealer
    public void testHandScores6()
    {
    	try
    	{
    		Player player = new Player("D4 HA");
    		Player dealer = new Player("HQ HA");
        
        BlackjackMain bj = new BlackjackMain();
        
        BlackjackMain.Scores score = bj.checkScore(player, dealer);
        
        assertTrue(score == BlackjackMain.Scores.DealerBlackjack);
    	}
    	
    	catch(Exception ex)
    	{
    		assertTrue(false);
    	}
    	
    }
    
    
}