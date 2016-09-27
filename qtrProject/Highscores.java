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

import java.io.FileNotFoundException;
import javax.swing.*;   // For modifying original JFrame
import java.util.Scanner;
import java.io.*;

public class Highscores extends javax.swing.JPanel {
    private static JFrame f = new JFrame("0010 Hangman");      // JFrame here to gain access in other methods
    private static String hScore1 = "35";
    private static String hScore2 = "25";
    private static String hScore3 = "15";
    private static String hScore4 = "5";
    private static String hScore5 = "0";
    String []name = new String[5];
    /**
     * Creates new form Highscores
     */
    public Highscores(JFrame f) throws FileNotFoundException {
        this.f = f;
        initComponents();
        f.requestFocus();
        Scanner sc = new Scanner(new File("Highscores.txt"));

        int []score = new int[5];
        for (int i=0; i<5; i++) {
            name[i] = sc.next();
            score[i] = sc.nextInt();
        }
        sc.close();
        
        setHighScore();
        printHighScore();
        hsLabel1.setText(Integer.toString(score[0]));
        hsLabel2.setText(Integer.toString(score[1]));
        hsLabel3.setText(Integer.toString(score[2]));
        hsLabel4.setText(Integer.toString(score[3]));
        hsLabel5.setText(Integer.toString(score[4]));
        // check highscore
        if (Integer.parseInt(hsLabel1.getText()) < Hangman.getScore()) {
            name[4] = name[3];
            name[3] = name[2];
            name[2] = name[1];            
            name[1] = name[0];
            name[0] = Hangman.getTheName();
            hsLabel5.setText(hsLabel4.getText());
            hsLabel4.setText(hsLabel3.getText());
            hsLabel3.setText(hsLabel2.getText());
            hsLabel2.setText(hsLabel1.getText());
            hsLabel1.setText(Integer.toString(Hangman.getScore()));
        }
        else if (Integer.parseInt(hsLabel2.getText()) < Hangman.getScore()) {
            name[4] = name[3];
            name[3] = name[2];
            name[2] = name[1];            
            name[1] = Hangman.getTheName();
            hsLabel5.setText(hsLabel4.getText());
            hsLabel4.setText(hsLabel3.getText());
            hsLabel3.setText(hsLabel2.getText());
            hsLabel2.setText(Integer.toString(Hangman.getScore()));
        }
        else if (Integer.parseInt(hsLabel3.getText()) < Hangman.getScore()) {
            name[4] = name[3];
            name[3] = name[2];
            name[2] = Hangman.getTheName();
            hsLabel5.setText(hsLabel4.getText());
            hsLabel4.setText(hsLabel3.getText());
            hsLabel3.setText(Integer.toString(Hangman.getScore()));
        }
        else if (Integer.parseInt(hsLabel4.getText()) < Hangman.getScore()) {
            name[4] = name[3];
            name[3] = Hangman.getTheName();
            hsLabel5.setText(hsLabel4.getText());
            hsLabel4.setText(Integer.toString(Hangman.getScore()));
        }
        else if (Integer.parseInt(hsLabel5.getText()) < Hangman.getScore()) {
            name[4] = Hangman.getTheName();
            hsLabel5.setText(Integer.toString(Hangman.getScore()));
        }        
        setHighScore();
        printHighScore();
        
        PrintStream ps = new PrintStream(new FileOutputStream("HighScores.txt"));
        
        ps.println(hsLabel1.getText());
        ps.println(hsLabel2.getText());
        ps.println(hsLabel3.getText());
        ps.println(hsLabel4.getText());
        ps.println(hsLabel5.getText());
        
        ps.close();
        // reset score
        Hangman.setScore(0);
    }
    private void setHighScore() {
        hScore1=hsLabel1.getText();
        hScore2=hsLabel2.getText();
        hScore3=hsLabel3.getText();
        hScore4=hsLabel4.getText();
        hScore5=hsLabel5.getText();
    }
    private void printHighScore() {
        hsLabel1.setText(name[0] + "   " + hScore1);
        hsLabel2.setText(name[1] + "   " + hScore2);
        hsLabel3.setText(name[2] + "   " + hScore3);
        hsLabel4.setText(name[3] + "   " + hScore4);
        hsLabel5.setText(name[4] + "   " + hScore5);
    }

    public int getLowest() {
        return Integer.parseInt(hsLabel5.getText());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        hsLabel1 = new javax.swing.JLabel();
        hsLabel2 = new javax.swing.JLabel();
        hsLabel3 = new javax.swing.JLabel();
        hsLabel4 = new javax.swing.JLabel();
        hsLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(null);

        backButton.setBackground(new java.awt.Color(51, 51, 51));
        backButton.setFont(new java.awt.Font("HP PSG", 0, 18)); // NOI18N
        backButton.setForeground(new java.awt.Color(51, 255, 51));
        backButton.setText("BACK");
        backButton.setToolTipText("Back To The Function Screen");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        hsLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        hsLabel1.setForeground(new java.awt.Color(51, 255, 51));
        hsLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hsLabel1.setText("000");
        hsLabel1.setToolTipText("First Place");

        hsLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        hsLabel2.setForeground(new java.awt.Color(51, 255, 51));
        hsLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hsLabel2.setText("000");
        hsLabel2.setToolTipText("Second Place");

        hsLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        hsLabel3.setForeground(new java.awt.Color(51, 255, 51));
        hsLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hsLabel3.setText("000");
        hsLabel3.setToolTipText("Third Place");

        hsLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        hsLabel4.setForeground(new java.awt.Color(51, 255, 51));
        hsLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hsLabel4.setText("000");
        hsLabel4.setToolTipText("Fourth Place");

        hsLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        hsLabel5.setForeground(new java.awt.Color(51, 255, 51));
        hsLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hsLabel5.setText("000");
        hsLabel5.setToolTipText("Fifth Place");

        jLabel1.setFont(new java.awt.Font("HP PSG", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HIGHSCORES");
        jLabel1.setToolTipText("Highscores");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(hsLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hsLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hsLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hsLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hsLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(117, 117, 117))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(hsLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hsLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hsLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hsLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hsLabel5)
                .addGap(33, 33, 33)
                .addComponent(backButton)
                .addGap(57, 57, 57))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        f.getContentPane().removeAll();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Hangman.makeM();
        f.pack();
        f.setVisible(true); 
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel hsLabel1;
    private javax.swing.JLabel hsLabel2;
    private javax.swing.JLabel hsLabel3;
    private javax.swing.JLabel hsLabel4;
    private javax.swing.JLabel hsLabel5;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}