/***************************************************************
 * Driver: Hangman.java
 * Author: Joel Castro & (Parter's name)
 * Class: CS 245
 *
 * Assignment: Quarter project
 * Purpose: Quarter Project consisting of 1st, 2nd, and final versions
 *
 * v1.0: Splash screen to the Menu (High Scores, Credits, Play)
 *      Display current time and date
 *      Implement initial dummy High Scores, Credits with team members info,
 *      and first game: Hangman with point system.
 *
 * V1.1: Implement second game: Color Game (commonly known as Color Trap)
 *
 * V1.2: Final third game: Sudoku. Also extra small features:
 *      Tool tips. Pressing F1 pops up display showing: names, id #'s,
 *      project name, and term. Pressing the ESC key exits the program
 ****************************************************************/

package hangman;

import java.util.Scanner;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class End extends javax.swing.JPanel {

    private static JFrame f = new JFrame("0010 Hangman");
    private boolean save;
   
    public End(JFrame f) {
        this.f = f;
        initComponents();
        f.requestFocus();
        scoreLabel.setText("Score: " + Integer.toString(Hangman.getScore()));
        nameSavedLabel.setVisible(false);
        try {
            Scanner sc = new Scanner(new File("Highscores.txt"));
            int[] score = new int[5];
            int temp = 0;
            for (int i = 0; i < 5; i++) {
                sc.next();
                temp = sc.nextInt();
            }
            sc.close();
            if (Hangman.getScore() < temp) {
                saveButton.setVisible(false);
                nameTextField.setVisible(false);
                newHSLabel.setVisible(false);
            }
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(End.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameOverLabel = new javax.swing.JLabel();
        endButton = new javax.swing.JButton();
        newHSLabel = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        nameSavedLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        gameOverLabel.setFont(new java.awt.Font("Aharoni", 0, 48)); // NOI18N
        gameOverLabel.setForeground(new java.awt.Color(51, 204, 0));
        gameOverLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameOverLabel.setText("Game Over");
        gameOverLabel.setToolTipText("Game Over");
        gameOverLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gameOverLabel.setPreferredSize(new java.awt.Dimension(250, 49));

        endButton.setBackground(new java.awt.Color(0, 0, 0));
        endButton.setForeground(new java.awt.Color(51, 204, 0));
        endButton.setText("End");
        endButton.setToolTipText("Go To The Function Screen");
        endButton.setRolloverEnabled(false);
        endButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endButtonActionPerformed(evt);
            }
        });

        newHSLabel.setForeground(new java.awt.Color(51, 204, 0));
        newHSLabel.setText("New Highscore");
        newHSLabel.setToolTipText("You Have A New Highscores");

        scoreLabel.setForeground(new java.awt.Color(51, 204, 0));
        scoreLabel.setText("Score");
        scoreLabel.setToolTipText("Your Score");

        nameTextField.setText("Name");
        nameTextField.setToolTipText("Enter Your Name");
        nameTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameTextFieldMouseClicked(evt);
            }
        });

        saveButton.setBackground(new java.awt.Color(0, 0, 0));
        saveButton.setForeground(new java.awt.Color(51, 204, 0));
        saveButton.setText("Save");
        saveButton.setToolTipText("Save Your Name");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        nameSavedLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameSavedLabel.setForeground(new java.awt.Color(51, 204, 0));
        nameSavedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameSavedLabel.setText("Name Saved!");
        nameSavedLabel.setToolTipText("Name Has Been Saved");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(gameOverLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(scoreLabel)
                    .addComponent(endButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newHSLabel))
                .addContainerGap(169, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(saveButton)
                .addContainerGap())
            .addComponent(nameSavedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(gameOverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(newHSLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scoreLabel)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton))
                .addGap(18, 18, 18)
                .addComponent(nameSavedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(endButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void endButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endButtonActionPerformed
        // TODO add your handling code here:
        if (save == false) 
            Hangman.setScore(0);
        f.getContentPane().removeAll();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Hangman.makeM();
        f.pack();
        f.setVisible(true);
    }//GEN-LAST:event_endButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        //set the name
        Hangman.setTheName(nameTextField.getText());
        nameSavedLabel.setVisible(true);
        save = true;
    }//GEN-LAST:event_saveButtonActionPerformed

    private void nameTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameTextFieldMouseClicked
        //erases the "Name" and lets user enter their name
        nameTextField.setText("");
    }//GEN-LAST:event_nameTextFieldMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton endButton;
    private javax.swing.JLabel gameOverLabel;
    private javax.swing.JLabel nameSavedLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel newHSLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel scoreLabel;
    // End of variables declaration//GEN-END:variables
}