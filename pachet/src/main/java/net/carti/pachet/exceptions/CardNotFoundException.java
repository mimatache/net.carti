package net.carti.pachet.exceptions;

import net.carti.pachet.PlayingCard;
import net.carti.pachet.enums.Suits;
import net.carti.pachet.enums.Values;

/**
 * Add Description HERE
 *
 * @author Mihai Matache mihmatache@luxoft.com
 * @since 10/1/2019
 */
public class CardNotFoundException extends Exception {
    //Static variables

    //Instance variables

    //Constructors

    public CardNotFoundException(PlayingCard card) {
        super(String.format("The card %s of %s was not found", card.getValue().getProperties().getName(),
                card.getSuit().getProperties().getName()));
    }

    public CardNotFoundException(Suits suit) {
        super(String.format("No %s cards in the deck", suit.getProperties().getName()));
    }

    public CardNotFoundException(Values value) {
        super(String.format("No %ss in the deck", value.getProperties().getName()));
    }

    //Methods


}
