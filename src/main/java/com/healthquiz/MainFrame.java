package com.healthquiz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

    private JFrame frame;

    private JPanel cards;
    private WelcomeCard panel1;
    private GuideCard panel2;
    private SleepingCard panel3;
    private NutritionCard panel4;
    private ExerciseCard panel5;
    private GoodResultCard panel6;
    private NeedsImprovementCard panel7;
    private ContactCard panel8;
    private ShareCard panel9;
    private ThankYouCard panel10;

    /**
     * Creates main frame for the health quiz mockup game, sets up cards for the
     * game and makes the frame visible.
     */
    public void createAndShowGUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setTitle("Testaa elämäntapasi!");
        frame.setLocationRelativeTo(null);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitOption();
            }
        });

        cards = new JPanel(new CardLayout());
        panel1 = new WelcomeCard(cards);
        panel2 = new GuideCard(cards);
        panel3 = new SleepingCard(cards);
        panel4 = new NutritionCard(cards);
        panel5 = new ExerciseCard(cards);
        panel6 = new GoodResultCard(cards);
        panel7 = new NeedsImprovementCard(cards);
        panel8 = new ContactCard(cards);
        panel9 = new ShareCard(cards);
        panel10 = new ThankYouCard(cards);

        cards.add(panel1, "Welcome");
        cards.add(panel2, "Guide");
        cards.add(panel3, "Sleeping");
        cards.add(panel4, "Nutrition");
        cards.add(panel5, "Exercise");
        cards.add(panel6, "GoodResult");
        cards.add(panel7, "NeedsImprovement");
        cards.add(panel8, "Contact");
        cards.add(panel9, "Share");
        cards.add(panel10, "ThankYou");

        Container pane = frame.getContentPane();
        pane.add(cards, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Adds exit confirmation to the game, if user accidentally selects exit from
     * the main frame window
     */
    public void exitOption() {
        Object[] options = { "Lopeta", "Palaa peliin" };
        if (JOptionPane.showOptionDialog(null,
                SharedMessageStrings.getExitMessage(),
                "Pelin lopetus", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
