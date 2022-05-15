package edu.sjsu.finalproject;

/**
 * Class to take a playing card shorthand and convert it to the full description
 */
public class Card {

    private final String rank, suit;

    /**
     * Class constructor which takes a card shorthand and uses it to initialize the rank and suit
     * @param shorthand card shorthand
     */
    public Card(String shorthand) {
        int length = shorthand.length();
        rank = shorthand.substring(0, length - 1);
        suit = shorthand.substring(length - 1);
    }

    /**
     * Getter method to return the card rank
     * @return  card rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * Getter method to return the card suit
     * @return  card suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Method to return the full description of the card
     * @return  card full description
     */
    public String getDescription() {
        String fullRank = switch(rank) {
            case "A" -> "Ace";
            case "2" -> "Two";
            case "3" -> "Three";
            case "4" -> "Four";
            case "5" -> "Five";
            case "6" -> "Six";
            case "7" -> "Seven";
            case "8" -> "Eight";
            case "9" -> "Nine";
            case "10" -> "Ten";
            case "J" -> "Jack";
            case "Q" -> "Queen";
            case "K" -> "King";
            default -> "";
        };

        String fullSuit = switch(suit) {
            case "D" -> "Diamonds";
            case "H" -> "Hearts";
            case "S" -> "Spades";
            case "C" -> "Clubs";
            default -> "";
        };

        return fullRank + " of " + fullSuit;
    }

    /**
     * Method which takes in a String and checks whether it is a valid rank
     * @param rank  rank to check if valid
     * @return      true if valid rank, false if not
     */
    public boolean validRank(String rank) {
        return switch(rank) {
            case "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" -> true;
            default -> false;
        };
    }

    /**
     * Method which takes in a String and checks whether it is a valid suit
     * @param suit  suit to check if valid
     * @return      true if valid suit, false if not
     */
    public boolean validSuit(String suit) {
        return switch(suit) {
            case "D", "H", "S", "C" -> true;
            default -> false;
        };
    }
}

