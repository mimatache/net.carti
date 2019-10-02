package net.carti.jocuri.razboi;

import net.carti.logging.CardLogger;
import net.carti.pachet.PlayingCard;
import net.carti.pachet.enums.Values;
import net.carti.participants.CardPlayer;
import net.carti.participants.Dealer;
import net.carti.participants.TableTop;
import org.slf4j.Logger;

import java.util.List;


public class Razboi {

    private static Logger LOGGER = CardLogger.getInstance(Razboi.class);



    public static void main(String[] args) {

        CardPlayer gigel = new CardPlayer("Gigel");
        CardPlayer sorel = new CardPlayer("Sorel");

        Dealer mimi = new Dealer("Mimi");
        TableTop tableTop = new TableTop();

        mimi.shuffle();
        mimi.dealAllCards(sorel, gigel);

        play(gigel, sorel, tableTop);



    }

    private static void play(CardPlayer player1, CardPlayer player2, TableTop tableTop) {
        CardPlayer winner = null;
        int rounds = 1;
        while (winner == null) {
            LOGGER.info("Round {}", rounds);
            rounds += 1;
            LOGGER.info("{} has {} cards", player1.getName(), player1.showCards().size());
            LOGGER.info("{} has {} cards", player2.getName(), player2.showCards().size());
            draw(player1, player2, tableTop, 1);
            if (!player1.hasCards()){
                winner = player2;
            }
            if (!player2.hasCards()){
                winner = player1;
            }
        }
        LOGGER.info("########################################");
        LOGGER.info("{} has won the game!", winner.getName());
    }

    private static void draw(CardPlayer player1, CardPlayer player2, TableTop tableTop, int cardCount){
        List<PlayingCard> player1Cards = player1.getCards(cardCount);
        List<PlayingCard> player2Cards = player2.getCards(cardCount);
        tableTop.receiveCards(player1Cards);
        tableTop.receiveCards(player2Cards);
        PlayingCard playingCard1 =  player1Cards.size() == 0 ? player1.getPreviousCards().getLastCard() : player1Cards.get(player1Cards.size()-1);
        LOGGER.info("{} played {}", player1.getName(), playingCard1);
        PlayingCard playingCard2 = player2Cards.size() == 0 ? player2.getPreviousCards().getLastCard() : player2Cards.get(player2Cards.size()-1);
        LOGGER.info("{} played {}", player2.getName(), playingCard2);
        int comp = playingCard1.compareTo(playingCard2);
        if (comp < 0){
            player2.receiveCards(tableTop.giveCards());
        } else if(comp > 0) {
            player1.receiveCards(tableTop.giveCards());
        } else {
            LOGGER.info("!!!!!!!!!!!!!!!!! RAZBOI !!!!!!!!!!!!!!!!!!");
            PlayingCard drawCard = player1Cards.get(player1Cards.size()-1);
            cardCount = drawCard.getValue() == Values.ACE? 1 : drawCard.getValue().getProperties().getValue();
            draw(player1, player2, tableTop, cardCount);
        }
    }
}
