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


    public SuiteProperties getProperties() {
        return properties;
    }

    public static class SuiteProperties{

        private String name;
        private float multiplier;
        private boolean trumpCard;

        public SuiteProperties(String name, float multiplier, boolean trumpCard) {
            this.name = name;
            this.multiplier = multiplier;
            this.trumpCard = trumpCard;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getMultiplier() {
            return multiplier;
        }

        public void setMultiplier(float multiplier) {
            this.multiplier = multiplier;
        }

        public boolean isTrumpCard() {
            return trumpCard;
        }

        public void setTrumpCard(boolean trumpCard) {
            this.trumpCard = trumpCard;
        }
    }


}
