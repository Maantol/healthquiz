package com.healthquiz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Box;

public class WelcomeCard extends JPanel implements ActionListener {

    private JPanel cardPanel, northPanel, centerPanel, southPanel, navigationPanel;
    private JPanel welcomePanel1, welcomePanel2;

    private JLabel welcomeLabel1;

    private JButton exit, start;
    private JLabel help;

    private URL helpUrl;
    private ImageIcon helpIcon;

    public WelcomeCard(JPanel cardPanel) {
        this.cardPanel = cardPanel;
        createWelcomeCard();
    }

    /**
     * Sets up the welcome card for the game and configures the context.
     * This method initializes panels, labels, components, and adjusts the layout
     * manager accordingly.
     * All components are added to the container, and event listeners are
     * initialized.
     */
    private void createWelcomeCard() {

        setLayout(new BorderLayout());

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        navigationPanel = new JPanel();
        welcomePanel1 = new JPanel();
        welcomePanel2 = new JPanel();

        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.X_AXIS));
        welcomePanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        welcomePanel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        welcomeLabel1 = new JLabel(
                "<html><div style='text-align: center;'>TESTAA<br>ELÄMÄNTAPASI<br>10<br>KYSYMYKSELLÄ!</div></html>");

        welcomeLabel1.setFont(new Font("Verdana", Font.BOLD, 30));

        helpUrl = WelcomeCard.class.getClassLoader().getResource("help.png");

        helpIcon = new ImageIcon(helpUrl);
        help = new JLabel(helpIcon);

        start = new JButton("ALOITA >>>");
        exit = new JButton("Lopeta");

        start.setFont(new Font("Verdana", Font.BOLD, 20));
        start.setPreferredSize(new Dimension(180, 100));
        start.setHorizontalAlignment(JButton.CENTER);

        welcomePanel1.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
        welcomePanel2.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));

        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        welcomePanel1.add(welcomeLabel1);
        welcomePanel2.add(start);

        centerPanel.add(welcomePanel1);
        centerPanel.add(welcomePanel2);
        centerPanel.add(Box.createVerticalGlue());

        southPanel.add(navigationPanel, BorderLayout.CENTER);

        navigationPanel.add(help);
        navigationPanel.add(Box.createRigidArea(new Dimension(228, 0)));
        navigationPanel.add(exit);

        exit.addActionListener(this);
        start.addActionListener(this);

        help.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, SharedMessageStrings.getWelcomeHelpMessage(),
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
        } else if (e.getSource().equals(start)) {
            CardLayout cl = (CardLayout) (cardPanel.getLayout());
            cl.show(cardPanel, "Guide");
        }
    }
}
