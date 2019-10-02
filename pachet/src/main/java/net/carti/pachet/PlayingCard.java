package net.carti.pachet;

import net.carti.logging.CardLogger;
import net.carti.pachet.enums.Suits;
import net.carti.pachet.enums.Values;
import org.slf4j.Logger;

import java.util.Objects;

/**
 * Add Description HERE
 *
 * @author Mihai Matache mihmatache@luxoft.com
 * @since 10/1/2019
 */
public class PlayingCard implements Comparable<PlayingCard> {
    //Static variables
    private static final Logger LOGGER = CardLogger.getInstance(PlayingCard.class);
    //Instance variables
    private Suits suit;
    private Values value;

    //Constructors

    PlayingCard(Suits suit, Values value) {
        this.suit = suit;
        this.value = value;
    }

    //Methods
    public Suits getSuit() {
        return suit;
    }

    public void setSuit(Suits suit) {
        this.suit = suit;
    }

    public Values getValue() {
        return value;
    }

    public void setValue(Values value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayingCard)) return false;
        PlayingCard that = (PlayingCard) o;
        return getSuit() == that.getSuit() &&
                getValue() == that.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSuit(), getValue());
    }

    @Override
    public String toString() {
        return String.format("%s de %s", this.getValue().getProperties().getName(), this.getSuit().getProperties().getName());
    }

    @Override
    public int compareTo(PlayingCard card) {
        LOGGER.info("Comparing {} to {}", this.toString(), card.toString());
        return (int)(this.suit.getProperties().getMultiplier()*this.value.getProperties().getValue() -
                card.getSuit().getProperties().getMultiplier()*card.getValue().getProperties().getValue());
    }
}
