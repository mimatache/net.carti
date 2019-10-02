package net.carti.participants;

import net.carti.pachet.CardDeck;
import net.carti.pachet.exceptions.NotEnoughCardsException;

import java.util.Arrays;
import java.util.List;

/**
 * Add Description HERE
 *
 * @author Mihai Matache mihmatache@luxoft.com
 * @since 10/1/2019
 */
public class Dealer extends CardPlayer{
    //Static variables

    //Instance variables

    //Constructors


    public Dealer(String name) {
        super(name, CardDeck.newDeck());
    }

    //Methods
    public void grabNewCardDeck(){
        this.setDeck(CardDeck.newDeck());
    }

    public void shuffle(){
        CardDeck newDeck = CardDeck.emptyDeck();
        while (this.getDeck().faceUp().size() > 0){
            newDeck.addCard(this.getDeck().getRandomCard());
        }
        this.setDeck(newDeck);
    }


    public void dealCards(List<CardPlayer> players){
        for (CardPlayer player : players){
            try {
                this.getPreviousCards().addCard(player.receiveCard(this.getDeck().getNextCard()));
            } catch (NotEnoughCardsException e) {
                LOGGER.debug("All cards have been dealt equally");
            }
        }
    }

    public void dealCards(List<CardPlayer> players, int numberOfCards){
        while (numberOfCards > 0){
           dealCards(players);
            numberOfCards -= players.size();
        }
    }

    public void dealAllCards(List<CardPlayer> players){
        this.dealCards(players, this.getDeck().faceUp().size());
    }

    public void dealAllCards(CardPlayer... players){
        this.dealAllCards(Arrays.asList(players));
    }

}
