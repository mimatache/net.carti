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
    private Values ranking;

    //Constructors

    PlayingCard(Suits suit, Values ranking) {
        this.suit = suit;
        this.ranking = ranking;
    }

    //Methods
    public Suits getSuit() {
        return suit;
    }

    public void setSuit(Suits suit) {
        this.suit = suit;
    }

    public Values getRanking() {
        return ranking;
    }

    public void setRanking(Values ranking) {
        this.ranking = ranking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayingCard)) return false;
        PlayingCard that = (PlayingCard) o;
        return getSuit() == that.getSuit() &&
                getRanking() == that.getRanking();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSuit(), getRanking());
    }

    @Override
    public String toString() {
        return String.format("%s de %s", this.getRanking().getName(), this.getSuit().getName());
    }

    @Override
    public int compareTo(PlayingCard card) {
        LOGGER.info("Comparing {} to {}", this.toString(), card.toString());
        return (int)(this.suit.getMultiplier()*this.ranking.getValue() -
                card.getSuit().getMultiplier()*card.getRanking().getValue());
    }
}
