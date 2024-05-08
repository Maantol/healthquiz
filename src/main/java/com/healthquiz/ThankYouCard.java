package com.healthquiz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;

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

public class ThankYouCard extends JPanel implements ActionListener {

    private JPanel cardPanel, northPanel, centerPanel, southPanel, navigationPanel, thankYouPanel, cardTitlePanel,
            thankYouImagePanel;

    private JLabel cardTitle, thankYouLabel, thankYouImageLabel;

    private URL thankYouURL, helpURL;
    private ImageIcon thankYouImage, helpIcon;

    private JLabel help;
    private JButton back, share, close;

    public ThankYouCard(JPanel cardPanel) {
        this.cardPanel = cardPanel;
        createThankYouCard();
    }

    /**
     * Sets up the thank you card for the game and configures the context.
     * This method initializes panels, labels, components, and adjusts the layout
     * manager accordingly.
     * All components are added to the container, and event listeners are
     * initialized.
     */
    private void createThankYouCard() {

        setLayout(new BorderLayout());

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        navigationPanel = new JPanel();
        cardTitlePanel = new JPanel();

        thankYouPanel = new JPanel();
        thankYouImagePanel = new JPanel();

        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.X_AXIS));

        cardTitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        thankYouImagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        cardTitle = new JLabel("<html><div style='text-align: center;'>KIITOS<br>VIESTISTÄSI!");
        thankYouLabel = new JLabel("<html><div style='text-align: center;'>"
                + "Olemme sinuun<br>yhteydessä viiden<br>arkipäivän kuluessa." + "</div><html>");

        thankYouURL = ThankYouCard.class.getClassLoader().getResource("cyclist.png");
        helpURL = ThankYouCard.class.getClassLoader().getResource("help.png");

        thankYouImage = new ImageIcon(thankYouURL);
        thankYouImageLabel = new JLabel(thankYouImage);

        helpIcon = new ImageIcon(helpURL);

        help = new JLabel(helpIcon);
        back = new JButton("Palaa tulokseen");
        share = new JButton("Jaa kaverille");
        close = new JButton("Lopeta");

        cardTitle.setFont(new Font("Verdana", Font.BOLD, 30));
        thankYouLabel.setFont(new Font("SansSerif", 0, 16));

        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        cardTitlePanel.add(cardTitle);

        northPanel.add(cardTitlePanel);
        centerPanel.add(thankYouPanel);
        centerPanel.add(thankYouImagePanel);
        centerPanel.add(Box.createVerticalGlue());

        southPanel.add(navigationPanel);

        thankYouPanel.add(thankYouLabel);
        thankYouImagePanel.add(thankYouImageLabel);

        navigationPanel.add(help);
        navigationPanel.add(back);
        navigationPanel.add(share);
        navigationPanel.add(close);

        back.addActionListener(this);
        share.addActionListener(this);
        close.addActionListener(this);

        help.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, SharedMessageStrings.getHelpMessageAfterContact(),
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
        if (e.getSource().equals(back)) {
            if (!GameScore.isUserHealthy()) {
                CardLayout cl = (CardLayout) cardPanel.getLayout();
                cl.show(cardPanel, "NeedsImprovement");
            } else {
                CardLayout cl = (CardLayout) cardPanel.getLayout();
                cl.show(cardPanel, "GoodResult");
            }
        } else if (e.getSource().equals(share)) {
            CardLayout cl = (CardLayout) cardPanel.getLayout();
            cl.show(cardPanel, "Share");
        } else if (e.getSource().equals(close)) {
            Object[] options = { "Lopeta", "Palaa peliin" };

            if (JOptionPane.showOptionDialog(null,
                    "Vahvista pelin lopetus klikkaamalla \"Lopeta\"\n" +
                            "Voit palata peliin klikkaamalla \"Palaa peliin\"",
                    "Pelin lopetus", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

}
