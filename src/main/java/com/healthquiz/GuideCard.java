package com.healthquiz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuideCard extends JPanel implements ActionListener {

    private JPanel cardPanel, northPanel, centerPanel, southPanel, cardTitlePanel, navigationPanel, infoPanel;

    private JLabel cardTitle, infoLabel;

    private JLabel help;
    private JButton previous, next, close;

    private URL helpURL;

    private ImageIcon helpIcon;

    public GuideCard(JPanel cardPanel) {
        this.cardPanel = cardPanel;
        createGuideCard();
    }

    /**
     * Sets up the guide card for the game and configures the context.
     * This method initializes panels, labels, components, and adjusts the layout
     * manager accordingly. Context font sizes and styles are set.
     * All components are added to the container, and event listeners are
     * initialized.
     */
    private void createGuideCard() {

        setLayout(new BorderLayout());

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        navigationPanel = new JPanel();
        cardTitlePanel = new JPanel();

        infoPanel = new JPanel();

        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.X_AXIS));

        cardTitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        cardTitle = new JLabel("<html><div style='text-align: center;'>PELIN OHJE");
        infoLabel = new JLabel(
                "<html><div style='text-align: center;'> Pelissä on 10 kysymystä<br>liittyen uneen, ravitsemukseen<br>ja liikuntaan.<br><br>"
                        +
                        "Kaikkiin kysymyksiin on vastattava<br>saadaksesi sanallisen palautteen.<br><br>" +
                        "Voit liikkua sivujen välillä ja<br>keskeyttää milloin haluat.<br><br>" +
                        "Voit halutessasi jättää<br>meille yhteydenttopyynnön<br>(valmennuspalvelut täysi-ikäisille).<br><br>"
                        +
                        "Tietojasi ei tallenneta kuin<br>jättäessäsi yhteydenottopyynnön.<br>Tietojasi ei luovuteta ulkopuolisille.</div></html>");

        helpURL = GuideCard.class.getClassLoader().getResource("help.png");

        helpIcon = new ImageIcon(helpURL);

        help = new JLabel(helpIcon);
        previous = new JButton("< Edellinen");
        next = new JButton("Seuraava >");
        close = new JButton("Lopeta");

        cardTitle.setFont(new Font("Verdana", Font.BOLD, 30));
        infoLabel.setFont(new Font("SansSerif", 0, 16));

        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        cardTitlePanel.add(cardTitle);

        northPanel.add(cardTitlePanel);
        centerPanel.add(infoPanel);
        centerPanel.add(Box.createVerticalGlue());

        southPanel.add(navigationPanel);

        infoPanel.add(infoLabel);

        navigationPanel.add(help);
        navigationPanel.add(previous);
        navigationPanel.add(next);
        navigationPanel.add(close);

        previous.addActionListener(this);
        next.addActionListener(this);
        close.addActionListener(this);

        help.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, SharedMessageStrings.getGuideHelpMessage(),
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
        if (e.getSource().equals(close)) {
            Object[] options = { "Lopeta", "Palaa peliin" };
            if (JOptionPane.showOptionDialog(null,
                    SharedMessageStrings.getExitMessage(),
                    "Pelin lopetus", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else if (e.getSource().equals(previous)) {
            CardLayout cl = (CardLayout) cardPanel.getLayout();
            cl.previous(cardPanel);
        } else if (e.getSource().equals(next)) {
            CardLayout cl = (CardLayout) cardPanel.getLayout();
            cl.next(cardPanel);
        }
    }

}
