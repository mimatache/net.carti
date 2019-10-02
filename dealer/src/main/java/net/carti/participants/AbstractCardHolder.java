package net.carti.participants;

import net.carti.logging.CardLogger;
import net.carti.pachet.CardDeck;
import net.carti.pachet.PlayingCard;
import net.carti.pachet.exceptions.CardNotFoundException;
import org.slf4j.Logger;

import java.util.LinkedList;
import java.util.List;

/**
 * Add Description HERE
 *
 * @author Mihai Matache mihmatache@luxoft.com
 * @since 10/1/2019
 */
public abstract class AbstractCardHolder {
    //Static variables
    static Logger LOGGER = CardLogger.getInstance(AbstractCardHolder.class);

    //Instance variables
    private CardDeck deck;
    private CardDeck previousCards = CardDeck.emptyDeck();

    //Constructors


    AbstractCardHolder(CardDeck deck) {
        this.deck = deck;
    }

    //Methods
    public PlayingCard receiveCard(PlayingCard card){
        this.deck.addCard(card);
        return card;
    }

    public void receiveCards(List<PlayingCard> cards){
        this.deck.addCards(cards);
    }

    public List<PlayingCard> showCards(){
        return this.deck.faceUp();
    }

    public PlayingCard giveCard(PlayingCard card) throws CardNotFoundException {
        this.previousCards.addCard(card);
        return this.deck.getCard(card);
    }

    public List<PlayingCard> giveCards(List<PlayingCard> cards) throws CardNotFoundException {
        List<PlayingCard> cardsTaken = new LinkedList<>();
        for (PlayingCard card : cards){
            cardsTaken.add(this.deck.getCard(card));
        }
        this.previousCards.addCards(cardsTaken);
        return cardsTaken;
    }

    public List<PlayingCard> giveCards() {
        this.previousCards.addCards(this.deck);
        return this.deck.getCards();
    }

    CardDeck getDeck(){
        return this.deck;
    }

    void setDeck(CardDeck deck){
        this.deck = deck;
    }

    public boolean hasCards(){
        return !this.deck.isEmpty();
    }

    public CardDeck getPreviousCards() {
        return previousCards;
    }
}
