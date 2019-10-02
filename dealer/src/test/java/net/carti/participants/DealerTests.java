package net.carti.participants;

import org.junit.Test;

/**
 * Add Description HERE
 *
 * @author Mihai Matache mihmatache@luxoft.com
 * @since 10/1/2019
 */
public class DealerTests {
    //Static variables

    //Instance variables

    //Constructors

    //Methods
    @Test
    public void shuffleTest(){
        Dealer dealer = new Dealer("Mimi");
        dealer.giveCards().forEach(System.out::println);
        dealer.shuffle();
        System.out.println("################### Shuffled cards ##################");
        dealer.giveCards().forEach(System.out::println);
    }


}
