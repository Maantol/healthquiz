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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NeedsImprovementCard extends JPanel implements ActionListener {

    private JPanel cardPanel, northPanel, centerPanel, southPanel, navigationPanel, cardTitlePanel;
    private JPanel badFeedbackPanel1, badFeedbackPanel2, badFeedbackTrophyPanel;

    private JLabel cardTitle, badFeedbackLabel1, badFeedbackTrophyLabel, badFeedbackLabel2;

    private JLabel help;
    private JButton contact, share, exit;

    private URL badFeedBackTrophyURL, helpURL;
    private ImageIcon badFeedbackTrophy, helpIcon;

    public NeedsImprovementCard(JPanel cardPanel) {
        this.cardPanel = cardPanel;
        createNeedsImprovementCard();
    }

    /**
     * Sets up the improvement card for the game and configures the context.
     * This method initializes panels, labels, components, and adjusts the layout
     * manager accordingly.
     * All components are added to the container, and event listeners are
     * initialized.
     */
    private void createNeedsImprovementCard() {

        setLayout(new BorderLayout());

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        navigationPanel = new JPanel();
        cardTitlePanel = new JPanel();

        badFeedbackPanel1 = new JPanel();
        badFeedbackPanel2 = new JPanel();
        badFeedbackTrophyPanel = new JPanel();

        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.X_AXIS));

        cardTitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        badFeedbackPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        badFeedbackPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        badFeedbackTrophyPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        cardTitle = new JLabel("TULOS");
        badFeedbackLabel1 = new JLabel("<html><div style='text-align: center;'>IHAN HYVÄ!</html>");
        badFeedbackLabel2 = new JLabel(
                "<html><div style='text-align: center;'>Mutta voisit vielä parantaa.<br>Voisimme auttaa sinua.<br><br><b>Jätä yhteystietosi<b><br> ja olemme sinuun yhteydessä!</div></html>");
        badFeedBackTrophyURL = NeedsImprovementCard.class.getClassLoader().getResource("ok.png");
        badFeedbackTrophy = new ImageIcon(badFeedBackTrophyURL);
        badFeedbackTrophyLabel = new JLabel(badFeedbackTrophy);

        helpURL = NeedsImprovementCard.class.getClassLoader().getResource("help.png");
        helpIcon = new ImageIcon(helpURL);

        help = new JLabel(helpIcon);
        contact = new JButton("Jätä viesti");
        share = new JButton("Jaa kaverille");
        exit = new JButton("Lopeta");

        cardTitle.setFont(new Font("Verdana", Font.BOLD, 30));
        badFeedbackLabel1.setFont(new Font("SansSerif", Font.BOLD, 26));
        badFeedbackLabel2.setFont(new Font("SansSerif", 0, 14));

        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        cardTitlePanel.add(cardTitle);

        northPanel.add(cardTitlePanel);
        centerPanel.add(badFeedbackTrophyPanel);
        centerPanel.add(badFeedbackPanel1);
        centerPanel.add(badFeedbackPanel2);
        centerPanel.add(Box.createVerticalGlue());

        southPanel.add(navigationPanel);

        badFeedbackTrophyPanel.add(badFeedbackTrophyLabel);
        badFeedbackPanel1.add(badFeedbackLabel1);
        badFeedbackPanel2.add(badFeedbackLabel2);

        navigationPanel.add(help);
        navigationPanel.add(share);
        navigationPanel.add(contact);
        navigationPanel.add(exit);

        contact.addActionListener(this);
        share.addActionListener(this);
        exit.addActionListener(this);

        help.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, SharedMessageStrings.getHelpMessageAfterComplete(),
                        "Testaa elämäntapasi!",
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
        } else if (e.getSource().equals(share)) {
            CardLayout cl = (CardLayout) cardPanel.getLayout();
            cl.show(cardPanel, "Share");
        } else if (e.getSource().equals(contact)) {
            CardLayout cl = (CardLayout) cardPanel.getLayout();
            cl.show(cardPanel, "Contact");
        }
    }
}