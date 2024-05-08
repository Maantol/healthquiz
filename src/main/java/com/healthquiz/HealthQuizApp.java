package com.healthquiz;

import javax.swing.SwingUtilities;

public class HealthQuizApp {
    public static void main(String[] args) {

        MainFrame view = new MainFrame();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                view.createAndShowGUI();
            }
        });
    }
}