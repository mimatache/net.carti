package net.carti.pachet;

import org.junit.Test;

/**
 * Add Description HERE
 *
 * @author Mihai Matache mihmatache@luxoft.com
 * @since 10/1/2019
 */
public class DeckTests {
    //Static variables

    //Instance variables

    //Constructors

    //Methods
    @Test
    public void listCardsTest(){
        CardDeck.newDeck().faceUp().forEach(System.out::println);
    }


}
