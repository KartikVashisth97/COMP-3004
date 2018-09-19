package com.blackjackgame.blackJackGame;

/**
 * Blackjack Game
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Blackjack Game" );
        
        try
        {
        // run black jack game
        new BlackjackMain().run(args);
        }
        
        catch (Exception ex)
        {
        	System.out.println(ex.getMessage());
        	
        }
    }
}