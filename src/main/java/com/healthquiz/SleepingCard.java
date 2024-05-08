package com.healthquiz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SleepingCard extends JPanel implements ActionListener {

    private JPanel cardPanel, northPanel, centerPanel, southPanel, navigationPanel, cardTitlePanel;
    private JPanel questionPanel1, questionPanel2, questionPanel3, questionPanel4;
    private JPanel answerPanel1, answerPanel2, answerPanel3, answerPanel4;

    private JLabel cardTitle, questionLabel1, questionLabel2, questionLabel3, questionLabel4;

    private ButtonGroup buttonGroup1, buttonGroup2, buttonGroup3;

    private JRadioButton yesRadioButton1, noRadioButton1, yesRadioButton3, noRadioButton3, yesRadioButton4,
            noRadioButton4;

    private JLabel help;
    private JButton previous, next, exit;

    private URL helpURL;
    private ImageIcon helpIcon;

    private JComboBox<String> hoursComboBox;

    public SleepingCard(JPanel cardPanel) {
        this.cardPanel = cardPanel;
        createSleepingCard();
    }

    /**
     * Sets up the sleeping card for the game and configures the context.
     * This method initializes panels, labels, components, and adjusts the layout
     * manager accordingly.
     * All components are added to the container, and event listeners are
     * initialized.
     */
    private void createSleepingCard() {

        setLayout(new BorderLayout());

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        navigationPanel = new JPanel();
        cardTitlePanel = new JPanel();

        questionPanel1 = new JPanel();
        questionPanel2 = new JPanel();
        questionPanel3 = new JPanel();
        questionPanel4 = new JPanel();

        answerPanel1 = new JPanel();
        answerPanel2 = new JPanel();
        answerPanel3 = new JPanel();
        answerPanel4 = new JPanel();

        buttonGroup1 = new ButtonGroup();
        buttonGroup2 = new ButtonGroup();
        buttonGroup3 = new ButtonGroup();

        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.X_AXIS));

        cardTitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        questionPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        questionPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        questionPanel3.setLayout(new FlowLayout(FlowLayout.CENTER));
        questionPanel4.setLayout(new FlowLayout(FlowLayout.CENTER));

        answerPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        answerPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        answerPanel3.setLayout(new FlowLayout(FlowLayout.CENTER));
        answerPanel4.setLayout(new FlowLayout(FlowLayout.CENTER));

        cardTitle = new JLabel("UNI");
        questionLabel1 = new JLabel(
                "<html><div style='text-align: center;'>1. Onko sinulla säännöllinen<br> unirytmi?</div></html>");
        questionLabel2 = new JLabel(
                "<html><div style='text-align: center;'>2. Kuinka monta tuntia<br> keskimäärin nukut yössä?</div></html>");
        questionLabel3 = new JLabel("<html><div style='text-align: center;'>3. Onko sinun helppo herätä?</div></html>");
        questionLabel4 = new JLabel(
                "<html><div style='text-align: center;'>4. Onko sinun helppo nukahtaa?</div></html>");

        yesRadioButton1 = new JRadioButton("Kyllä");
        noRadioButton1 = new JRadioButton("Ei");
        yesRadioButton3 = new JRadioButton("Kyllä");
        noRadioButton3 = new JRadioButton("Ei");
        yesRadioButton4 = new JRadioButton("Kyllä");
        noRadioButton4 = new JRadioButton("Ei");

        hoursComboBox = new JComboBox<>(new String[] { "Valitse listasta", "Alle 6 tuntia",
                "6-7 tuntia", "7-9 tuntia", "Yli 9 tuntia" });

        helpURL = SleepingCard.class.getClassLoader().getResource("help.png");

        helpIcon = new ImageIcon(helpURL);

        help = new JLabel(helpIcon);
        previous = new JButton("< Edellinen");
        next = new JButton("Seuraava >");
        exit = new JButton("Lopeta");

        cardTitle.setFont(new Font("Verdana", Font.BOLD, 30));

        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        cardTitlePanel.add(cardTitle);

        northPanel.add(cardTitlePanel);

        centerPanel.add(questionPanel1);
        centerPanel.add(answerPanel1);
        centerPanel.add(questionPanel2);
        centerPanel.add(answerPanel2);
        centerPanel.add(questionPanel3);
        centerPanel.add(answerPanel3);
        centerPanel.add(questionPanel4);
        centerPanel.add(answerPanel4);
        centerPanel.add(Box.createVerticalGlue());

        southPanel.add(navigationPanel);

        questionPanel1.add(questionLabel1);
        questionPanel2.add(questionLabel2);
        questionPanel3.add(questionLabel3);
        questionPanel4.add(questionLabel4);

        buttonGroup1.add(yesRadioButton1);
        buttonGroup1.add(noRadioButton1);
        buttonGroup2.add(yesRadioButton3);
        buttonGroup2.add(noRadioButton3);
        buttonGroup3.add(yesRadioButton4);
        buttonGroup3.add(noRadioButton4);

        answerPanel1.add(yesRadioButton1);
        answerPanel1.add(noRadioButton1);
        answerPanel2.add(hoursComboBox);
        answerPanel3.add(yesRadioButton3);
        answerPanel3.add(noRadioButton3);
        answerPanel4.add(yesRadioButton4);
        answerPanel4.add(noRadioButton4);

        navigationPanel.add(help);
        navigationPanel.add(previous);
        navigationPanel.add(next);
        navigationPanel.add(exit);

        previous.addActionListener(this);
        next.addActionListener(this);
        exit.addActionListener(this);

        help.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, SharedMessageStrings.getHelpMessage(), "Testaa elämäntapasi!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    /**
     * Handles corresponding actions for the navigation buttons.
     * 
     * @param e the action button that selected
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(exit)) {
            Object[] options = { "Lopeta", "Palaa peliin" };
            if (JOptionPane.showOptionDialog(null,
                    SharedMessageStrings.getExitMessage(),
                    "Pelin lopetus", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else if (e.getSource().equals(next)) {
            if (!checkSleepAnswers()) {
                JOptionPane.showMessageDialog(null, SharedMessageStrings.getCheckAnswers(), "Tarkista vastauksesi!",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                double sleepingPoints = calculateSleepingPoints();
                GameScore.setSleepingPoints(sleepingPoints);
                CardLayout cl = (CardLayout) (cardPanel.getLayout());
                cl.show(cardPanel, "Nutrition");
            }
        } else if (e.getSource().equals(previous)) {
            CardLayout cl = (CardLayout) cardPanel.getLayout();
            cl.previous(cardPanel);
        }
    }

    /**
     * Checks if the user has answered all the questions.
     * 
     * @return true if all questions are answered, false otherwise
     */
    private boolean checkSleepAnswers() {
        if (!(yesRadioButton1.isSelected() || noRadioButton1.isSelected()) ||
                !(yesRadioButton3.isSelected() || noRadioButton3.isSelected()) ||
                !(yesRadioButton4.isSelected() || noRadioButton4.isSelected()) ||
                hoursComboBox.getSelectedIndex() == 0) {
            return false;
        }
        return true;
    }

    /**
     * Calculates the sleeping points based on the user selections.
     * 
     * @return the total sleeping points
     */
    private double calculateSleepingPoints() {

        double sleepingPoints = 0.0;

        if (yesRadioButton1.isSelected()) {
            sleepingPoints += 2;
        }
        if (hoursComboBox.getSelectedIndex() == 2) {
            sleepingPoints += 1;
        }
        if (hoursComboBox.getSelectedIndex() == 3) {
            sleepingPoints += 2;
        }
        if (hoursComboBox.getSelectedIndex() == 4) {
            sleepingPoints += 3;
        }

        if (yesRadioButton3.isSelected()) {
            sleepingPoints += 2;
        }
        if (yesRadioButton3.isSelected()) {
            sleepingPoints += 2;
        }

        return sleepingPoints;
    }

}
