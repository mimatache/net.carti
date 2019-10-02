package net.carti.participants;


import net.carti.pachet.CardDeck;
import net.carti.pachet.PlayingCard;
import net.carti.pachet.exceptions.NotEnoughCardsException;

import java.util.ArrayList;
import java.util.List;

/**
 * Add Description HERE
 *
 * @author Mihai Matache mihmatache@luxoft.com
 * @since 10/1/2019
 */
public class CardPlayer extends AbstractCardHolder {
    //Static variables

    //Instance variables
    private String name;

    //Constructors

    public CardPlayer(String name) {
        super(CardDeck.emptyDeck());
        this.name = name;

    }

    public CardPlayer(String name, CardDeck deck) {
        super(deck);
        this.name = name;

    }

    //Methods

    public PlayingCard giveRandomCard(){
        LOGGER.debug("{} gave a random card", this.getName());
        PlayingCard card = this.getDeck().getRandomCard();
        this.getPreviousCards().addCard(card);
        return card;
    }

    public PlayingCard giveFirstCard() throws NotEnoughCardsException {
        LOGGER.debug("{} gave a card from the top of the deck", this.getName());
        PlayingCard card = this.getDeck().getNextCard();
        this.getPreviousCards().addCard(card);
        return card;
    }

    public List<PlayingCard> getCards(int number){
        List<PlayingCard> cards = new ArrayList<>();
        while (number > 0){
            try {
                cards.add(this.getDeck().getNextCard());
                number -= 1;
            } catch (NotEnoughCardsException e) {
                break;
            }
        }
        this.getPreviousCards().addCards(cards);
        return cards;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public void receiveCards(List<PlayingCard> cards){
        LOGGER.info("{} received {} cards", this.getName(), cards.size());
        super.receiveCards(cards);
    }

}
