package com.healthquiz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ContactCard extends JPanel implements ActionListener {

    private JPanel cardPanel, northPanel, centerPanel, southPanel, navigationPanel, cardTitlePanel;
    private JPanel headerPanel, firstNamePanel, lastNamePanel, emailPanel, phonePanel, agePanel, servicePanel;
    private JPanel firstNameAnswer, lastNameAnswer, emailAnswer, phoneAnswer, ageAnswer, serviceAnswer;

    private JLabel cardTitle, headerLabel, firstNameLabel, lastNameLabel, emailLabel, phoneLabel, ageLabel,
            serviceTypeLabel;
    private JTextField firstnameInput, lastnameInput, emailInput, phoneInput, ageInput;

    private ButtonGroup buttonGroup1;

    private JRadioButton liveToggleButton, remoteToggleButton, combinationToggleButton;

    private JLabel help;
    private JButton back, send, exit;

    private URL helpURL;
    private ImageIcon helpIcon;

    public ContactCard(JPanel cardPanel) {
        this.cardPanel = cardPanel;
        createContactCard();
    }

    /**
     * Sets up the contact card for the game and configures the context.
     * This method initializes panels, labels, components, and adjusts the layout
     * manager accordingly.
     * All components are added to the container, and event listeners are
     * initialized.
     */
    private void createContactCard() {

        setLayout(new BorderLayout());

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        navigationPanel = new JPanel();
        cardTitlePanel = new JPanel();

        headerPanel = new JPanel();
        firstNamePanel = new JPanel();
        lastNamePanel = new JPanel();
        emailPanel = new JPanel();
        phonePanel = new JPanel();
        agePanel = new JPanel();
        servicePanel = new JPanel();

        firstNameAnswer = new JPanel();
        lastNameAnswer = new JPanel();
        emailAnswer = new JPanel();
        phoneAnswer = new JPanel();
        ageAnswer = new JPanel();
        serviceAnswer = new JPanel();

        buttonGroup1 = new ButtonGroup();

        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.X_AXIS));

        cardTitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        firstNamePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        lastNamePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        emailPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        phonePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        agePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        servicePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        firstNameAnswer.setLayout(new FlowLayout(FlowLayout.CENTER));
        lastNameAnswer.setLayout(new FlowLayout(FlowLayout.CENTER));
        emailAnswer.setLayout(new FlowLayout(FlowLayout.CENTER));
        phoneAnswer.setLayout(new FlowLayout(FlowLayout.CENTER));
        ageAnswer.setLayout(new FlowLayout(FlowLayout.CENTER));
        serviceAnswer.setLayout(new FlowLayout(FlowLayout.CENTER));

        cardTitle = new JLabel("JÄTÄ VIESTI");

        headerLabel = new JLabel("Tähdellä merkityt kohdat ovat pakollisia.");
        firstNameLabel = new JLabel("* Etunimi:");
        lastNameLabel = new JLabel("* Sukunimi:");
        emailLabel = new JLabel("* Sähköpostiosoite:");
        phoneLabel = new JLabel("* Puhelinnumero:");
        ageLabel = new JLabel("* Ikä:");
        serviceTypeLabel = new JLabel("Haluaisitko live- vai etävalmennusta?");

        liveToggleButton = new JRadioButton("Live");
        remoteToggleButton = new JRadioButton("Etä");
        combinationToggleButton = new JRadioButton("Yhdistelmä");

        helpURL = ContactCard.class.getClassLoader().getResource("help.png");
        helpIcon = new ImageIcon(helpURL);

        help = new JLabel(helpIcon);
        back = new JButton("Palaa tulokseen");
        send = new JButton("Lähetä");
        exit = new JButton("Lopeta");

        cardTitle.setFont(new Font("Verdana", Font.BOLD, 30));

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        firstnameInput = new JTextField(15);
        firstnameInput.setMargin(new Insets(5, 10, 5, 10));

        lastnameInput = new JTextField(15);
        lastnameInput.setMargin(new Insets(5, 10, 5, 10));

        emailInput = new JTextField(15);
        emailInput.setMargin(new Insets(5, 10, 5, 10));

        phoneInput = new JTextField(15);
        phoneInput.setMargin(new Insets(5, 10, 5, 10));

        ageInput = new JTextField(3);
        ageInput.setMargin(new Insets(5, 10, 5, 10));

        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        cardTitlePanel.add(cardTitle);

        headerPanel.add(headerLabel);
        firstNamePanel.add(firstNameLabel);
        lastNamePanel.add(lastNameLabel);
        emailPanel.add(emailLabel);
        phonePanel.add(phoneLabel);
        agePanel.add(ageLabel);
        servicePanel.add(serviceTypeLabel);

        buttonGroup1.add(liveToggleButton);
        buttonGroup1.add(remoteToggleButton);
        buttonGroup1.add(combinationToggleButton);

        firstNameAnswer.add(firstnameInput);
        lastNameAnswer.add(lastnameInput);
        emailAnswer.add(emailInput);
        phoneAnswer.add(phoneInput);
        ageAnswer.add(ageInput);

        northPanel.add(cardTitlePanel);
        centerPanel.add(headerPanel);
        centerPanel.add(firstNamePanel);
        centerPanel.add(firstNameAnswer);
        centerPanel.add(lastNamePanel);
        centerPanel.add(lastNameAnswer);
        centerPanel.add(emailPanel);
        centerPanel.add(emailAnswer);
        centerPanel.add(phonePanel);
        centerPanel.add(phoneAnswer);
        centerPanel.add(agePanel);
        centerPanel.add(ageAnswer);
        centerPanel.add(servicePanel);
        centerPanel.add(serviceAnswer);

        serviceAnswer.add(liveToggleButton);
        serviceAnswer.add(remoteToggleButton);
        serviceAnswer.add(combinationToggleButton);

        southPanel.add(navigationPanel);

        navigationPanel.add(help);
        navigationPanel.add(back);
        navigationPanel.add(send);
        navigationPanel.add(exit);

        back.addActionListener(this);
        send.addActionListener(this);
        exit.addActionListener(this);

        help.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, SharedMessageStrings.getHelpMessageContactForm(),
                        "Testaa elämäntapasi!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    /**
     * Handles corresponding actions for the navigation buttons
     * and validates user input before sending the message to the provider.
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
        } else if (e.getSource().equals(send)) {
            if (firstnameInput.getText().isEmpty() || lastnameInput.getText().isEmpty()
                    || ageInput.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Täytä kaikki kentät", "Huomio", JOptionPane.WARNING_MESSAGE);
            } else if (!ValidateTextInput(firstnameInput.getText())) {
                JOptionPane.showMessageDialog(null, "Käytä etunimessä vain kirjaimia", "Tarkista muoto",
                        JOptionPane.WARNING_MESSAGE);
            } else if (!ValidateTextInput(lastnameInput.getText())) {
                JOptionPane.showMessageDialog(null, "Käytä sukunimessä vain kirjaimia", "Tarkista muoto",
                        JOptionPane.WARNING_MESSAGE);
            } else if (!ValidateEmailAddress(emailInput.getText())) {
                JOptionPane.showMessageDialog(null, "Tarkista sähköpostiosoitteen muoto\n" + "abc@abc.fi",
                        "Tarkista muoto", JOptionPane.WARNING_MESSAGE);
            } else if (!ValidatePhoneNumber(phoneInput.getText())) {
                JOptionPane.showMessageDialog(null, "Syötä puhelinnumero ilman suuntanumeroa\n" + "ja välilyöntejä",
                        "Tarkista muoto", JOptionPane.WARNING_MESSAGE);
            } else if (!ValidateNumberInput(ageInput.getText())) {
                JOptionPane.showMessageDialog(null, "Käytä iässä vain numeroita", "Tarkista muoto",
                        JOptionPane.WARNING_MESSAGE);
            } else if (!ValidateUnderAgeLimit(ageInput.getText())) {
                JOptionPane.showMessageDialog(null, "Valmennuspalvelu on tarkoitettu yli 18-vuotiaille", "Ikäraja",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                Object[] options = { "Lähetä", "Palaa peliin" };

                if (JOptionPane.showOptionDialog(null,
                        "Vahvista viestin lähetys klikkaamalla \"Lähetä\".\n" +
                                "Voit palata peliin klikkaamalla \"Palaa peliin\".\n",
                        "Viestin lähetys", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]) == JOptionPane.YES_OPTION) {
                    CardLayout cl = (CardLayout) cardPanel.getLayout();
                    cl.show(cardPanel, "ThankYou");
                }
            }
        }
    }

    /**
     * Validates a phone number input according to Finnish rules.
     *
     * @param phoneInput the phone number input to be validated
     * @return true if the phone number is valid, false otherwise
     */
    public boolean ValidatePhoneNumber(String phoneInput) {

        Pattern pattern = Pattern.compile("[0-9]{7,13}");
        Matcher matcher = pattern.matcher(phoneInput);

        if (!matcher.matches()) {
            return false;
        }
        return true;
    }

    /**
     * Validates a email address input according to allowed symbols.
     *
     * @param emailInput the email address input to be validated
     * @return true if the email address is valid, false otherwise
     */
    public boolean ValidateEmailAddress(String emailInput) {

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_.'%!+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Matcher matcher = pattern.matcher(emailInput);

        if (!matcher.matches()) {
            return false;
        }
        return true;
    }

    /**
     * Validates a text input according to allowed symbols.
     * Must accept Scandinavian characters and input must be between 2-20
     * characters.
     *
     * @param textInput the text input to be validated
     * @return true if the text input is valid, false otherwise
     */
    public boolean ValidateTextInput(String textInput) {

        Pattern pattern = Pattern.compile("[a-zA-ZäöüßÄÖÜ\\-]{2,20}");

        Matcher matcher = pattern.matcher(textInput);

        if (!matcher.matches()) {
            return false;
        }
        return true;
    }

    /**
     * Validates a number input according to allowed symbols.
     * Must accept only numbers and input must be between 1-3 characters.
     *
     * @param numberInput the number input to be validated
     * @return true if the number input is valid, false otherwise
     */
    public boolean ValidateNumberInput(String numberInput) {

        Pattern pattern = Pattern.compile("^(0|[1-9][0-9]*)$");

        Matcher matcher = pattern.matcher(numberInput);

        if (!matcher.matches()) {
            return false;
        }
        return true;
    }

    /**
     * Validates if the given age is above 18 years old.
     *
     * 
     * @param ageInput the age to be validated as a string
     * @return true if the age is above the legal age limit, false otherwise
     */
    public boolean ValidateUnderAgeLimit(String ageInput) {
        int age = Integer.parseInt(ageInput);
        if (age < 18) {
            return false;
        }
        return true;
    }

}