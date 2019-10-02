package net.carti.participants;

import net.carti.pachet.CardDeck;
import net.carti.pachet.PlayingCard;

/**
 * Add Description HERE
 *
 * @author Mihai Matache mihmatache@luxoft.com
 * @since 10/1/2019
 */
public class TableTop extends AbstractCardHolder{

    public TableTop() {
        super(CardDeck.emptyDeck());
    }

    @Override
    public PlayingCard receiveCard(PlayingCard card){
        LOGGER.info(" {} has been place on the table", card.toString());
        return super.receiveCard(card);
    }

}
