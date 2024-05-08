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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.Box;

public class ShareCard extends JPanel implements ActionListener {

    private JPanel cardPanel, northPanel, centerPanel, southPanel, navigationPanel, cardTitlePanel;
    private JPanel infoPanel, sharePanel1, sharePanel2;
    private GridBagConstraints sharePanelGrid;

    private JLabel cardTitle, infoLabel;
    private JLabel InstagramLabel, FacebookLabel, TiktokLabel, WhatsAppLabel, EmailLabel, SnapchatLabel;

    private JLabel help;
    private JButton back, exit;

    private URL InstagramURL, FacebookURL, TiktokURL, WhatsAppURL, EmailURL, SnapchatURL, helpURL;

    private ImageIcon InstagramIcon, FacebookIcon, TiktokIcon, WhatsuppIcon, EmailIcon, SnapchatIcon;
    private ImageIcon helpIcon;

    public ShareCard(JPanel cardPanel) {
        this.cardPanel = cardPanel;
        createShareCard();
    }

    /**
     * Sets up the share result card for the game and configures the context.
     * This method initializes panels, labels, components, and adjusts the layout
     * manager accordingly.
     * All components are added to the container, and event listeners are
     * initialized.
     */
    private void createShareCard() {

        setLayout(new BorderLayout());

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        navigationPanel = new JPanel();
        cardTitlePanel = new JPanel();

        infoPanel = new JPanel();
        sharePanel1 = new JPanel();
        sharePanel2 = new JPanel();

        sharePanelGrid = new GridBagConstraints();

        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.X_AXIS));

        cardTitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        sharePanel1.setLayout(new BoxLayout(sharePanel1, BoxLayout.Y_AXIS));
        sharePanel2.setLayout(new GridBagLayout());

        cardTitle = new JLabel("KUTSU YSTÄVÄ");
        infoLabel = new JLabel(
                "<html><div style='text-align: center;'><br>testaamaan<br>omat elämäntapansa!</html>");

        helpURL = ShareCard.class.getClassLoader().getResource("help.png");
        InstagramURL = ShareCard.class.getClassLoader().getResource("ig.png");
        FacebookURL = ShareCard.class.getClassLoader().getResource("fb.png");
        TiktokURL = ShareCard.class.getClassLoader().getResource("tiktok.png");
        WhatsAppURL = ShareCard.class.getClassLoader().getResource("whatsapp.png");
        EmailURL = ShareCard.class.getClassLoader().getResource("email.png");
        SnapchatURL = ShareCard.class.getClassLoader().getResource("snapchat.png");

        helpIcon = new ImageIcon(helpURL);
        InstagramIcon = new ImageIcon(InstagramURL);
        FacebookIcon = new ImageIcon(FacebookURL);
        TiktokIcon = new ImageIcon(TiktokURL);
        WhatsuppIcon = new ImageIcon(WhatsAppURL);
        EmailIcon = new ImageIcon(EmailURL);
        SnapchatIcon = new ImageIcon(SnapchatURL);

        InstagramLabel = new JLabel(InstagramIcon);
        FacebookLabel = new JLabel(FacebookIcon);
        EmailLabel = new JLabel(EmailIcon);
        SnapchatLabel = new JLabel(SnapchatIcon);
        WhatsAppLabel = new JLabel(WhatsuppIcon);
        TiktokLabel = new JLabel(TiktokIcon);

        sharePanelGrid.gridx = 0;
        sharePanelGrid.gridy = 0;
        sharePanel2.add(InstagramLabel, sharePanelGrid);

        sharePanelGrid.gridx = 1;
        sharePanel2.add(FacebookLabel, sharePanelGrid);

        sharePanelGrid.gridx = 2;
        sharePanel2.add(EmailLabel, sharePanelGrid);

        sharePanelGrid.gridx = 0;
        sharePanelGrid.gridy = 1;
        sharePanel2.add(SnapchatLabel, sharePanelGrid);

        sharePanelGrid.gridx = 1;
        sharePanel2.add(WhatsAppLabel, sharePanelGrid);

        sharePanelGrid.gridx = 2;
        sharePanel2.add(TiktokLabel, sharePanelGrid);

        help = new JLabel(helpIcon);
        back = new JButton("Palaa tulokseen");
        exit = new JButton("Lopeta");

        cardTitle.setFont(new Font("Verdana", Font.BOLD, 30));
        infoLabel.setFont(new Font("SansSerif", 0, 22));

        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        cardTitlePanel.add(cardTitle);

        northPanel.add(cardTitlePanel);
        northPanel.add(Box.createHorizontalGlue());

        centerPanel.add(sharePanel1);
        centerPanel.add(sharePanel2);

        southPanel.add(navigationPanel);

        infoPanel.add(infoLabel);

        sharePanel1.add(infoPanel);

        navigationPanel.add(help);
        navigationPanel.add(back);
        navigationPanel.add(exit);

        back.addActionListener(this);
        exit.addActionListener(this);

        help.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, SharedMessageStrings.getHelpMessageShare(), "Testaa elämäntapasi!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        InstagramLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Tuloksesi on nyt jaettu Instagramiin, kiitos!",
                        "Testaa elämäntapasi!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        FacebookLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Tuloksesi on nyt jaettu Facebookiin, kiitos!",
                        "Testaa elämäntapasi!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        EmailLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Tuloksesi jaettiin sähköpostilla, kiitos!", "Testaa elämäntapasi!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        SnapchatLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Tuloksesi on nyt jaettu Snapchatiin, kiitos!",
                        "Testaa elämäntapasi!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        WhatsAppLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Tuloksesi on nyt jaettu WhatsAppiin, kiitos!",
                        "Testaa elämäntapasi!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        TiktokLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Tuloksesi on nyt jaettu Tiktokiin, kiitos!",
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
        } else if (e.getSource().equals(back)) {
            if (!GameScore.isUserHealthy()) {
                CardLayout cl = (CardLayout) (cardPanel.getLayout());
                cl.show(cardPanel, "NeedsImprovement");
            } else {
                CardLayout cl = (CardLayout) (cardPanel.getLayout());
                cl.show(cardPanel, "GoodResult");
            }
        }
    }
}