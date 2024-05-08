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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class NutritionCard extends JPanel implements ActionListener {

    private JPanel cardPanel, northPanel, centerPanel, southPanel, navigationPanel, cardTitlePanel;
    private JPanel questionPanel1, questionPanel2, questionPanel3;
    private JPanel answerPanel1, answerPanel2, answerPanel3;

    private JLabel cardTitle, questionLabel1, questionLabel2, questionLabel3;

    private ButtonGroup buttonGroup1, buttonGroup2, buttonGroup3;

    private JRadioButton yesRadioButton1, noRadioButton1, yesRadioButton2, noRadioButton2, yesRadioButton3,
            noRadioButton3;

    private JButton exit, previous, next;
    private JLabel information, help;

    private URL informationURL, helpURL;
    private ImageIcon informationIcon, helpIcon;

    public NutritionCard(JPanel cardPanel) {
        this.cardPanel = cardPanel;
        createNutritionCard();
    }

    /**
     * Sets up the nutrition card for the game and configures the context.
     * This method initializes panels, labels, components, and adjusts the layout
     * manager accordingly.
     * All components are added to the container, and event listeners are
     * initialized.
     */
    private void createNutritionCard() {

        setLayout(new BorderLayout());

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        navigationPanel = new JPanel();
        cardTitlePanel = new JPanel();

        questionPanel1 = new JPanel();
        questionPanel2 = new JPanel();
        questionPanel3 = new JPanel();

        answerPanel1 = new JPanel();
        answerPanel2 = new JPanel();
        answerPanel3 = new JPanel();

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

        answerPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        answerPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        answerPanel3.setLayout(new FlowLayout(FlowLayout.CENTER));

        cardTitle = new JLabel("RAVITSEMUS");
        questionLabel1 = new JLabel(
                "<html><div style='text-align: center;'>5. Onko sinulla säännöllinen<br> ruokarytmi?</div></html>");
        questionLabel2 = new JLabel(
                "<html><div style='text-align: center;'>6. Syötkö kasviksia, marjoja<br> ja hedelmiä päivittäin?</div></html>");
        questionLabel3 = new JLabel(
                "<html><div style='text-align: center;'>7. Syötkö yli 350 g punaista<br> lihaa viikossa?</div></html>");

        yesRadioButton1 = new JRadioButton("Kyllä");
        noRadioButton1 = new JRadioButton("Ei");
        yesRadioButton2 = new JRadioButton("Kyllä");
        noRadioButton2 = new JRadioButton("Ei");
        yesRadioButton3 = new JRadioButton("Kyllä");
        noRadioButton3 = new JRadioButton("Ei");

        informationURL = NutritionCard.class.getClassLoader().getResource("informationmark.png");
        helpURL = NutritionCard.class.getClassLoader().getResource("help.png");

        informationIcon = new ImageIcon(informationURL);
        helpIcon = new ImageIcon(helpURL);

        information = new JLabel(informationIcon);
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
        centerPanel.add(Box.createVerticalGlue());

        southPanel.add(navigationPanel);

        questionPanel1.add(questionLabel1);
        questionPanel2.add(questionLabel2);
        questionPanel3.add(questionLabel3);
        questionPanel3.add(information);

        buttonGroup1.add(yesRadioButton1);
        buttonGroup1.add(noRadioButton1);
        buttonGroup2.add(yesRadioButton2);
        buttonGroup2.add(noRadioButton2);
        buttonGroup3.add(yesRadioButton3);
        buttonGroup3.add(noRadioButton3);

        answerPanel1.add(yesRadioButton1);
        answerPanel1.add(noRadioButton1);
        answerPanel2.add(yesRadioButton2);
        answerPanel2.add(noRadioButton2);
        answerPanel3.add(yesRadioButton3);
        answerPanel3.add(noRadioButton3);

        navigationPanel.add(help);
        navigationPanel.add(previous);
        navigationPanel.add(next);
        navigationPanel.add(exit);

        previous.addActionListener(this);
        next.addActionListener(this);
        exit.addActionListener(this);

        information.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Ravisemussuositus on korkeintaan 350 g/vko", "Ravitsemus",
                        JOptionPane.PLAIN_MESSAGE);
            }
        });

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
            if (!checkNutritionAnswers()) {
                JOptionPane.showMessageDialog(null, SharedMessageStrings.getCheckAnswers(), "Tarkista vastauksesi!",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                double nutritionPoints = calculateNutritionPoints();
                GameScore.setNutritionPoints(nutritionPoints);
                CardLayout cl = (CardLayout) (cardPanel.getLayout());
                cl.show(cardPanel, "Exercise");
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
    private boolean checkNutritionAnswers() {
        if (!(yesRadioButton1.isSelected() || noRadioButton1.isSelected()) ||
                !(yesRadioButton2.isSelected() || noRadioButton2.isSelected()) ||
                !(yesRadioButton3.isSelected() || noRadioButton3.isSelected())) {
            return false;
        }
        return true;
    }

    /**
     * Calculates the nutrition points based on the user selections.
     * 
     * @return the total nutrition points
     */
    private double calculateNutritionPoints() {

        double nutritionPoints = 0.0;

        if (yesRadioButton1.isSelected()) {
            nutritionPoints += 2;
        }
        if (yesRadioButton2.isSelected()) {
            nutritionPoints += 2;
        }
        if (noRadioButton3.isSelected()) {
            nutritionPoints += 2;
        }

        return nutritionPoints;

    }

}
