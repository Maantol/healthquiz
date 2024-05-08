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

public class ExerciseCard extends JPanel implements ActionListener {

    private JPanel cardPanel, northPanel, centerPanel, southPanel, navigationPanel, cardTitlePanel;
    private JPanel questionPanel1, questionPanel2, questionPanel3;
    private JPanel answerPanel1, answerPanel2, answerPanel3;

    private JLabel cardTitle, questionLabel1, questionLabel2, questionLabel3;

    private ButtonGroup buttonGroup1;

    private JRadioButton yesRadioButton1, noRadioButton1;

    private JComboBox<String> hoursComboBox, timesComboBox;

    private JButton exit, previous, next;
    private JLabel help;

    private URL helpURL;
    private ImageIcon helpIcon;

    public ExerciseCard(JPanel cardPanel) {
        this.cardPanel = cardPanel;
        createExerciseCard();
    }

    /**
     * Sets up the exercise card for the game and configures the context.
     * This method initializes panels, labels, components, and adjusts the layout
     * manager accordingly.
     * All components are added to the container, and event listeners are
     * initialized.
     */
    private void createExerciseCard() {

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

        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.X_AXIS));

        cardTitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        questionPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        questionPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        questionPanel3.setLayout(new FlowLayout(FlowLayout.CENTER));

        cardTitle = new JLabel("LIIKUNTA");
        questionLabel1 = new JLabel(
                "<html><div style='text-align: center;'>8. Harrastatko liikuntaa säännöllisesti?</html>");
        questionLabel2 = new JLabel(
                "<html><div style='text-align: center;'>9. Kuinka monta lihaskuntoharjoitusta <br>teet viikossa?<br>Esim. kuntosali, raskaat pihatyöt.</html>");
        questionLabel3 = new JLabel(
                "<html><div style='text-align: center;'>10. Kuinka monta tuntia viikossa teet<br>reipasta kestävyysliikuntaa?<br>Esim. reipas kävely, pyöräily,<br>juoksu, jumppa, uinti, sauvakävely.</html>");

        yesRadioButton1 = new JRadioButton("Kyllä");
        noRadioButton1 = new JRadioButton("Ei");

        hoursComboBox = new JComboBox<>(new String[] { "Valitse listasta", "0 tuntia",
                "Alle 2,5 tuntia", "2,5 tuntia", "Yli 2,5 tuntia" });

        timesComboBox = new JComboBox<>(new String[] { "Valitse listasta", "0 kertaa",
                "1 kertaa", "2 kertaa", "Yli 2 kertaa" });

        helpURL = ExerciseCard.class.getClassLoader().getResource("help.png");

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
        centerPanel.add(Box.createVerticalGlue());

        southPanel.add(navigationPanel);

        questionPanel1.add(questionLabel1);
        questionPanel2.add(questionLabel2);
        questionPanel3.add(questionLabel3);

        buttonGroup1.add(yesRadioButton1);
        buttonGroup1.add(noRadioButton1);

        answerPanel1.add(yesRadioButton1);
        answerPanel1.add(noRadioButton1);
        answerPanel2.add(timesComboBox);
        answerPanel3.add(hoursComboBox);

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
     * As a final question card, the user's points are calculated based on the
     * answers. The user will see the final result card.
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
            if (!checkExerciseAnswers()) {
                JOptionPane.showMessageDialog(null, SharedMessageStrings.getCheckAnswers(), "Tarkista vastauksesi!",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                double exercisePoints = calculateExercisePoints();
                GameScore.setExercisePoints(exercisePoints);
                if (!GameScore.isUserHealthy()) {
                    CardLayout cl = (CardLayout) (cardPanel.getLayout());
                    cl.show(cardPanel, "NeedsImprovement");
                } else {
                    CardLayout cl = (CardLayout) (cardPanel.getLayout());
                    cl.show(cardPanel, "GoodResult");
                }
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
    private boolean checkExerciseAnswers() {
        if (!(yesRadioButton1.isSelected() || noRadioButton1.isSelected()) ||
                hoursComboBox.getSelectedIndex() == 0 ||
                timesComboBox.getSelectedIndex() == 0) {
            return false;
        }
        return true;
    }

    /**
     * Calculates the exercise points based on the user selections.
     * 
     * @return the total exercise points
     */
    private double calculateExercisePoints() {

        double exercisePoints = 0.0;

        if (yesRadioButton1.isSelected()) {
            exercisePoints += 2;
        }
        if (timesComboBox.getSelectedIndex() == 2) {
            exercisePoints += 0.5;
        }
        if (timesComboBox.getSelectedIndex() == 3) {
            exercisePoints += 2;
        }
        if (timesComboBox.getSelectedIndex() == 4) {
            exercisePoints += 3;
        }
        if (hoursComboBox.getSelectedIndex() == 2) {
            exercisePoints += 0.5;
        }
        if (hoursComboBox.getSelectedIndex() == 3) {
            exercisePoints += 2;
        }
        if (hoursComboBox.getSelectedIndex() == 4) {
            exercisePoints += 3;
        }

        return exercisePoints;
    }

}