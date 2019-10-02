package net.carti.pachet;

import net.carti.pachet.enums.Suits;
import net.carti.pachet.enums.Values;
import net.carti.pachet.exceptions.CardNotFoundException;
import net.carti.pachet.exceptions.NotEnoughCardsException;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Add Description HERE
 *
 * @author Mihai Matache mihmatache@luxoft.com
 * @since 10/1/2019
 */
public class CardDeck {
    //Static variables
    private List<PlayingCard> cards;

    //Instance variables

    //Constructors
    private CardDeck(List<PlayingCard> cards) {
        this.cards = cards;
    }

    public static CardDeck newDeck() {
        List<PlayingCard> cards = new LinkedList<>();
        for (Suits suit : Suits.values()){
            for (Values value : Values.values()){
                cards.add(new PlayingCard(suit, value));
            }
        }
        return new CardDeck(cards);
    }

    public static CardDeck withCards(List<PlayingCard> cards){
        return new CardDeck(cards);
    }

    public static CardDeck emptyDeck(){
        return new CardDeck(new LinkedList<PlayingCard>());
    }

    // Methods

    public List<PlayingCard> faceUp() {
        return cards;
    }

    public PlayingCard getNextCard() throws NotEnoughCardsException {
        return this.getCard(0);
    }

    public PlayingCard getRandomCard(){
        Random random = new Random();
        return this.cards.remove(random.nextInt(this.cards.size()));
    }

    public PlayingCard getCard(PlayingCard card) throws CardNotFoundException{
        if (!this.cards.remove(card)) throw new CardNotFoundException(card);
        return card;
    }

    public PlayingCard getCard(int position) throws NotEnoughCardsException {
        try {
            return cards.remove(position);
        } catch (IndexOutOfBoundsException e){
            throw new NotEnoughCardsException();
        }
    }

    public PlayingCard getCardOfSuit(Suits suit) throws CardNotFoundException {
        return cards.stream().filter(c -> c.getSuit().equals(suit)).findFirst().orElseThrow(() -> new CardNotFoundException(suit));
    }

    public List<PlayingCard> getAllCardsOfSuit(Suits suit){
        return cards.stream().filter(c -> c.getSuit().equals(suit)).collect(Collectors.toList());
    }

    public PlayingCard getCardOfValue(Values value) throws CardNotFoundException {
        return cards.stream().filter(c -> c.getRanking().equals(value)).findFirst().orElseThrow(() -> new CardNotFoundException(value));
    }

    public List<PlayingCard> getCards(){
        List<PlayingCard> currentCards = new LinkedList<>(this.cards);
        this.cards = new LinkedList<>();
        return currentCards;
    }

    public List<PlayingCard> getAllCardsOfValue(Values value){
        return cards.stream().filter(c -> c.getRanking().equals(value)).collect(Collectors.toList());
    }

    public void addCard(PlayingCard card){
        this.cards.add(card);
    }

    public void addCards(List<PlayingCard> cards){
        this.cards.addAll(cards);
    }

    public void addCards(CardDeck deck){
        this.cards.addAll(deck.faceUp());
    }

    public boolean isEmpty() {
        return this.cards.size()==0;
    }

    public PlayingCard getLastCard() {
        return this.cards.get(this.cards.size() - 1);
    }
}
