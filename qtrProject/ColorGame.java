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

import java.awt.BasicStroke;
import javax.swing.*;
import java.util.Random;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import java.awt.*;
import java.awt.geom.*;

public class ColorGame extends javax.swing.JPanel {
    private static JFrame f = new JFrame("0010 Hangman");      // JFrame here to gain access in other methods
    private String[] colorList = {"BLUE", "GREEN", "PURPLE", "RED", "YELLOW"};
    private String wordText;
    private int colorPressed;
    private int rounds;
    boolean startNewRound = true;
    private static boolean gameOver2;
    private int[] xLocation = {0, 110, 40, 20, 150, 180, 320, 280, 400, 460, 430};
    private int[] yLocation = {0, 40, 150, 260, 230, 130, 100, 210, 250, 150, 40};
    private int[] xLocation2 = {90, 20, 10, 110, 220, 210, 340, 330, 460, 440, 480};
    private int[] yLocation2 = {20, 120, 250, 210, 250, 140, 80, 190, 260, 150, 50};
    
    private int randOffsetX;
    private int randOffsetY;
    private int randSetColorLabel;
    private int a, b, c, d, e;
    
    public static boolean getGameOver2() {
        return gameOver2;
    }
    public static void setGameOver2() {
        gameOver2 = false;
    }
    
    public ColorGame(JFrame f) {
        this.f = f;
        initComponents();
        f.requestFocus();
        Hangman.setScore(Hangman.getScore() + 500);
        Hangman.timeLabel = timeLabel;    // changes jLabel reference to timeLabels
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g); //clear drawing area
        Random rand = new Random();
        if (startNewRound == true) {
            //Randomly choose a Color Text
            wordText = colorList[rand.nextInt(5)];
            //Randomly choose a label color for the word
            randSetColorLabel = rand.nextInt(5);
            
            //Must be inside the if statement or else PROBLEM!
            //Slighty changes the color of the buttons when mouse over button
            blueButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/BlueButtonHighlight.png")));
            blueButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/BlueButtonPressed.png")));
            greenButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/GreenButtonHighlight.png")));
            greenButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/GreenButtonPressed.png")));
            purpleButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/PurpleButtonHighlight.png")));
            purpleButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/PurpleButtonPressed.png")));
            redButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/RedButtonHighlight.png")));
            redButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/RedButtonPressed.png")));
            yellowButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/YellowButtonHighlight.png")));
            yellowButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/YellowButtonPressed.png")));
            
            //Random offset for buttons
            randOffsetX = rand.nextInt(5);
            randOffsetY = rand.nextInt(5);
            
            //Randomly get index for the array of locations
            a = rand.nextInt(11);
            do {
                b = rand.nextInt(11);
            }
            while (b == a);
            
            do {
                c = rand.nextInt(11);
            }
            while (c == a || c == b);
            
            do {
                d = rand.nextInt(11);
            }
            while (d == a || d == b || d == c);
            
            do {
                e = rand.nextInt(11);
            }
            while (e == a || e == b || e == c || e == d);
        }
        //To stop the program from choosing random location before user
        //clicks on a button
        startNewRound = false;
        
        blueButton.setLocation((xLocation[a]+randOffsetX), (yLocation[a]+randOffsetY));
        greenButton.setLocation((xLocation[b]+randOffsetX), (yLocation[b]+randOffsetY));
        purpleButton.setLocation((xLocation[c]+randOffsetX), (yLocation[c]+randOffsetY));
        redButton.setLocation((xLocation[d]+randOffsetX), (yLocation[d]+randOffsetY));
        yellowButton.setLocation((xLocation[e]+randOffsetX), (yLocation[e]+randOffsetY));
        
        //Make the random position a little more nicer
        if (rounds % 2 == 0) {
            blueButton.setLocation((xLocation2[a]+randOffsetX), (yLocation2[a]+randOffsetY));
            greenButton.setLocation((xLocation2[b]+randOffsetX), (yLocation2[b]+randOffsetY));
            purpleButton.setLocation((xLocation2[c]+randOffsetX), (yLocation2[c]+randOffsetY));
            redButton.setLocation((xLocation2[d]+randOffsetX), (yLocation2[d]+randOffsetY));
            yellowButton.setLocation((xLocation2[e]+randOffsetX), (yLocation2[e]+randOffsetY));
        }
        
        //Set the correct random color of the colorLabel text
        if (randSetColorLabel == 0) //BLUE
            colorLabel.setForeground(new java.awt.Color(0, 0, 255));
        if (randSetColorLabel == 1) //GREEN
            colorLabel.setForeground(new java.awt.Color(0, 255, 0));
        if (randSetColorLabel == 2) //PURPLE
            colorLabel.setForeground(new java.awt.Color(186, 85, 211));
        if (randSetColorLabel == 3) //RED
            colorLabel.setForeground(new java.awt.Color(255, 0, 0));
        if (randSetColorLabel == 4) //YELLOW
            colorLabel.setForeground(new java.awt.Color(255, 255, 0));
        colorLabel.setText(wordText);
    }
   
    private void checkColor() {
        //if wrong button pressed subtract 100
        if (randSetColorLabel != colorPressed) {
            Hangman.setScore(Hangman.getScore() - 100);
        }
        
        rounds++;
        if (rounds >= 5) {
            gameOver2 = true;
        }
        else {
            startNewRound = true;
            repaint();
        }
        f.requestFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timeLabel = new javax.swing.JLabel();
        blueButton = new javax.swing.JButton();
        greenButton = new javax.swing.JButton();
        purpleButton = new javax.swing.JButton();
        redButton = new javax.swing.JButton();
        yellowButton = new javax.swing.JButton();
        colorLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(600, 400));

        timeLabel.setForeground(new java.awt.Color(51, 255, 51));
        timeLabel.setText("time");
        timeLabel.setToolTipText("Current Date & Time");

        blueButton.setBackground(new java.awt.Color(0, 0, 0));
        blueButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/BlueButton.png"))); // NOI18N
        blueButton.setToolTipText("Blue Button");
        blueButton.setBorder(null);
        blueButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        blueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueButtonActionPerformed(evt);
            }
        });

        greenButton.setBackground(new java.awt.Color(0, 0, 0));
        greenButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/GreenButton.png"))); // NOI18N
        greenButton.setToolTipText("Green Button");
        greenButton.setBorder(null);
        greenButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        greenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greenButtonActionPerformed(evt);
            }
        });

        purpleButton.setBackground(new java.awt.Color(0, 0, 0));
        purpleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/PurpleButton.png"))); // NOI18N
        purpleButton.setToolTipText("Purple Button");
        purpleButton.setBorder(null);
        purpleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        purpleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purpleButtonActionPerformed(evt);
            }
        });

        redButton.setBackground(new java.awt.Color(0, 0, 0));
        redButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/RedButton.png"))); // NOI18N
        redButton.setToolTipText("Red Button");
        redButton.setBorder(null);
        redButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        redButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redButtonActionPerformed(evt);
            }
        });

        yellowButton.setBackground(new java.awt.Color(0, 0, 0));
        yellowButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/YellowButton.png"))); // NOI18N
        yellowButton.setToolTipText("Yellow Button");
        yellowButton.setBorder(null);
        yellowButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        yellowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yellowButtonActionPerformed(evt);
            }
        });

        colorLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        colorLabel.setForeground(new java.awt.Color(102, 102, 102));
        colorLabel.setText("color");
        colorLabel.setToolTipText("Select The Color Of Text");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(colorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(purpleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(130, 130, 130)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(redButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(yellowButton)
                                .addGap(28, 28, 28)))))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(yellowButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(colorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(purpleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void blueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueButtonActionPerformed
        // TODO add your handling code here:
        colorPressed = 0;
        checkColor();
    }//GEN-LAST:event_blueButtonActionPerformed

    private void greenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greenButtonActionPerformed
        // TODO add your handling code here:
        colorPressed = 1;
        checkColor();
    }//GEN-LAST:event_greenButtonActionPerformed

    private void purpleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purpleButtonActionPerformed
        // TODO add your handling code here:
        colorPressed = 2;
        checkColor();
    }//GEN-LAST:event_purpleButtonActionPerformed

    private void redButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redButtonActionPerformed
        // TODO add your handling code here:
        colorPressed = 3;
        checkColor();
    }//GEN-LAST:event_redButtonActionPerformed

    private void yellowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yellowButtonActionPerformed
        // TODO add your handling code here:
        colorPressed = 4;
        checkColor();
    }//GEN-LAST:event_yellowButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton blueButton;
    private javax.swing.JLabel colorLabel;
    private javax.swing.JButton greenButton;
    private javax.swing.JButton purpleButton;
    private javax.swing.JButton redButton;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JButton yellowButton;
    // End of variables declaration//GEN-END:variables
}