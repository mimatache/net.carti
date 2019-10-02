package net.carti.pachet.enums;

/**
 * Add Description HERE
 *
 * @author Mihai Matache mihmatache@luxoft.com
 * @since 10/1/2019
 */
public enum Suits {
    //Static variables
    HEARTS(new SuiteProperties("Inima Rosie", 1, false)),
    SPADES(new SuiteProperties("Inima Neagra", 1, false)),
    DIAMONDS(new SuiteProperties("Romb", 1, false)),
    CLUBS(new SuiteProperties("Trefla", 1, false));

    //Instance variables
    private SuiteProperties properties;

    //Constructors


    Suits(SuiteProperties properties) {
        this.properties = properties;
    }

    //Methods


    private SuiteProperties getProperties() {
        return properties;
    }

    public String getName() {
        return getProperties().getName();
    }

    public void setName(String name) {
        this.getProperties().setName(name);
    }

    public float getMultiplier() {
        return getProperties().getMultiplier();
    }

    public void setMultiplier(float multiplier) {
        this.getProperties().setMultiplier(multiplier);
    }

    public boolean isTrumpCard() {
        return getProperties().isTrumpCard();
    }

    public void setTrumpCard(boolean trumpCard) {
        this.getProperties().setTrumpCard(trumpCard);
    }

    private static class SuiteProperties{

        private String name;
        private float multiplier;
        private boolean trumpCard;

        private SuiteProperties(String name, float multiplier, boolean trumpCard) {
            this.name = name;
            this.multiplier = multiplier;
            this.trumpCard = trumpCard;
        }

        private String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        private float getMultiplier() {
            return multiplier;
        }

        private void setMultiplier(float multiplier) {
            this.multiplier = multiplier;
        }

        private boolean isTrumpCard() {
            return trumpCard;
        }

        private void setTrumpCard(boolean trumpCard) {
            this.trumpCard = trumpCard;
        }
    }


}
