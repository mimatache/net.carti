package net.carti.pachet.enums;

/**
 * Add Description HERE
 *
 * @author Mihai Matache mihmatache@luxoft.com
 * @since 10/1/2019
 */
public enum Values {
    //Values
    ACE(new ValueProperties(15, 1, "As")),
    TWO(new ValueProperties(2, "Doi")),
    THREE(new ValueProperties(3, "Trei")),
    FOUR(new ValueProperties(4, "Patru")),
    FIVE(new ValueProperties(5, "Cinci")),
    SIX(new ValueProperties(6, "Sase")),
    SEVEN(new ValueProperties(7, "Sapte")),
    EIGHT(new ValueProperties(8, "Opt")),
    NINE(new ValueProperties(9, "Noua")),
    TEN(new ValueProperties(10, "Zece")),
    JACK(new ValueProperties(12, "Valet")),
    QUEEN(new ValueProperties(13, "Regina")),
    KING(new ValueProperties(14, "Popa"));

    //Instance variables
    private ValueProperties properties;

    //Constructors

    Values(ValueProperties properties) {
        this.properties = properties;
    }


    //Methods


    private ValueProperties getProperties() {
        return properties;
    }

    public int getValue() {
        return getProperties().getValue();
    }

    public void setValue(int value) {
        this.getProperties().setValue(value);
    }

    public String getName() {
        return getProperties().getName();
    }

    public void setName(String name) {
        this.getProperties().setName(name);
    }

    public int getOrdinal() {
        return getProperties().getOrdinal();
    }

    public void setOrdinal(int ordinal) {
        this.getProperties().setOrdinal(ordinal);
    }

    private static class ValueProperties{

        private int value;
        private String name;
        private int ordinal;

        private ValueProperties(int value, int ordinal, String name) {
            this.value = value;
            this.name = name;
            this.ordinal = ordinal;
        }

        private ValueProperties(int value, String name) {
            this.value = value;
            this.name = name;
            this.ordinal = value;
        }

        private int getValue() {
            return value;
        }

        private void setValue(int value) {
            this.value = value;
        }

        private String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        private int getOrdinal() {
            return ordinal;
        }

        public void setOrdinal(int ordinal) {
            this.ordinal = ordinal;
        }
    }




}
