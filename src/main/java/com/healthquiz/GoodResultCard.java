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

public class GoodResultCard extends JPanel implements ActionListener {

    private JPanel cardPanel, northPanel, centerPanel, southPanel, navigationPanel, cardTitlePanel;
    private JPanel goodFeedbackPanel1, goodFeedbackPanel2, goodFeedbackTrophyPanel;

    private JLabel cardTitle, goodFeedbackLabel1, goodFeedbackTrophyLabel, goodFeedbackLabel2;

    private JLabel help;
    private JButton contact, share, exit;

    private URL goodFeedBackTrophyURL, helpURL;

    private ImageIcon goodFeedbackTrophy, helpIcon;

    public GoodResultCard(JPanel cardPanel) {
        this.cardPanel = cardPanel;
        createGoodResultCard();
    }

    /**
     * Sets up the good result card for the game and configures the context.
     * This method initializes panels, labels, components, and adjusts the layout
     * manager accordingly.
     * All components are added to the container, and event listeners are
     * initialized.
     */
    private void createGoodResultCard() {

        setLayout(new BorderLayout());

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        navigationPanel = new JPanel();
        cardTitlePanel = new JPanel();

        goodFeedbackPanel1 = new JPanel();
        goodFeedbackPanel2 = new JPanel();
        goodFeedbackTrophyPanel = new JPanel();

        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.X_AXIS));

        cardTitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        goodFeedbackPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        goodFeedbackPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        goodFeedbackTrophyPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        cardTitle = new JLabel("TULOS");
        goodFeedbackLabel1 = new JLabel("<html><div style='text-align: center;'>ONNEKSI OLKOON!</html>");
        goodFeedbackLabel2 = new JLabel(
                "<html><div style='text-align: center;'>Elämäntapasi ovat<br>hyvällä mallilla.<br>Jatka samalla tavalla!<br><br>Voit halutessasi jättää<br>meille yhteydenottopyynnön<br>tai jakaa tuloksesi kavereillesi.</div></html>");

        goodFeedBackTrophyURL = GoodResultCard.class.getClassLoader().getResource("trophy.png");
        goodFeedbackTrophy = new ImageIcon(goodFeedBackTrophyURL);
        goodFeedbackTrophyLabel = new JLabel(goodFeedbackTrophy);

        helpURL = GoodResultCard.class.getClassLoader().getResource("help.png");
        helpIcon = new ImageIcon(helpURL);

        help = new JLabel(helpIcon);
        contact = new JButton("Jätä viesti");
        share = new JButton("Jaa kaverille");
        exit = new JButton("Lopeta");

        cardTitle.setFont(new Font("Verdana", Font.BOLD, 30));
        goodFeedbackLabel1.setFont(new Font("SansSerif", Font.BOLD, 26));
        goodFeedbackLabel2.setFont(new Font("SansSerif", 0, 14));

        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        cardTitlePanel.add(cardTitle);

        northPanel.add(cardTitlePanel);
        centerPanel.add(goodFeedbackTrophyPanel);
        centerPanel.add(goodFeedbackPanel1);
        centerPanel.add(goodFeedbackPanel2);
        centerPanel.add(Box.createVerticalGlue());

        southPanel.add(navigationPanel);

        goodFeedbackTrophyPanel.add(goodFeedbackTrophyLabel);
        goodFeedbackPanel1.add(goodFeedbackLabel1);
        goodFeedbackPanel2.add(goodFeedbackLabel2);

        navigationPanel.add(help);
        navigationPanel.add(contact);
        navigationPanel.add(share);
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
