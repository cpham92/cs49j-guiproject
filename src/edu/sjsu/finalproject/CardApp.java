package edu.sjsu.finalproject;

import javax.swing.*;

/**
 * Class to generate a GUI that takes a user-inputted playing card shorthand and returns the full description
 */
public class CardApp {
    private JPanel panel;

    /**
     * Class constructor which contains the Get Card button listener in order to display error messages
     *  and description results
     */
    public CardApp() {
        getCardButton.addActionListener(e -> {
            String shorthand = userInput.getText();
            if (shorthand.equals("")) {
                resultText.setText("");
                cardDescription.setText("");
                errorMessage.setText("Please enter a card.");
            } else {
                Card card = new Card(shorthand);
                if (!card.validRank(card.getRank())) {
                    if (!card.validSuit(card.getSuit())) {
                        resultText.setText("");
                        cardDescription.setText("");
                        errorMessage.setText("<html>Invalid rank and suit.<br/>Please try again!<html>");
                    } else {
                        resultText.setText("");
                        cardDescription.setText("");
                        errorMessage.setText("<html>Invalid rank.<br/>Please try again!<html>");
                    }
                } else if (!card.validSuit(card.getSuit())) {
                    resultText.setText("");
                    cardDescription.setText("");
                    errorMessage.setText("<html>Invalid suit.<br/>Please try again!<html>");
                } else {
                    errorMessage.setText("");
                    String description = card.getDescription();
                    resultText.setText("Your card is the:");
                    cardDescription.setText(description);
                }
            }
        });
    }

    /**
     * Main method to generate the GUI frame and initialize the CardApp panel
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Card Simulator");
        frame.setContentPane(new CardApp().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JTextField userInput;
    private JButton getCardButton;
    private JLabel errorMessage;
    private JLabel resultText;
    private JTextField cardDescription;

}
