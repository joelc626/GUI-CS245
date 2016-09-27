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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class MainScreen extends javax.swing.JPanel {
    private static JFrame f = new JFrame("0010 Hangman");      // JFrame here to gain access in other methods    

    /**
     * Creates new form MainScreen
     */
    public MainScreen(JFrame f) throws IOException {
        this.f=f;
        initComponents();
        f.requestFocus();   //request focus sets the current frame focused for the dialog box

        // create highscores file if does not exist
        File highscoresFile = new File("Highscores.txt");
        if(!highscoresFile.exists()) {
            highscoresFile.createNewFile();
            PrintStream ps = new PrintStream(new FileOutputStream("HighScores.txt"));
            FileOutputStream oFile = new FileOutputStream(highscoresFile, false); 
            ps.println("abc\t315");
            ps.println("def\t295");
            ps.println("ghi\t214");
            ps.println("jkl\t111");
            ps.println("mno\t43");
            ps.close();
            oFile.close();
        }  
    }
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playButton = new javax.swing.JButton();
        highscoresButton = new javax.swing.JButton();
        creditsButton = new javax.swing.JButton();
        teamImageLabel = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(600, 400));
        setLayout(null);

        playButton.setBackground(new java.awt.Color(0, 0, 0));
        playButton.setFont(new java.awt.Font("HP PSG", 3, 24)); // NOI18N
        playButton.setForeground(new java.awt.Color(51, 204, 0));
        playButton.setText("PLAY");
        playButton.setToolTipText("Play The Game");
        playButton.setBorder(null);
        playButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        playButton.setMinimumSize(new java.awt.Dimension(135, 33));
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        add(playButton);
        playButton.setBounds(390, 230, 200, 30);

        highscoresButton.setBackground(new java.awt.Color(0, 0, 0));
        highscoresButton.setFont(new java.awt.Font("HP PSG", 3, 24)); // NOI18N
        highscoresButton.setForeground(new java.awt.Color(51, 204, 0));
        highscoresButton.setText("HIGHSCORES");
        highscoresButton.setToolTipText("See The Highscores");
        highscoresButton.setBorder(null);
        highscoresButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        highscoresButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highscoresButtonActionPerformed(evt);
            }
        });
        add(highscoresButton);
        highscoresButton.setBounds(390, 310, 200, 30);

        creditsButton.setBackground(new java.awt.Color(0, 0, 0));
        creditsButton.setFont(new java.awt.Font("HP PSG", 3, 24)); // NOI18N
        creditsButton.setForeground(new java.awt.Color(51, 204, 0));
        creditsButton.setText("CREDITS");
        creditsButton.setToolTipText("See The Credits");
        creditsButton.setBorder(null);
        creditsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        creditsButton.setMaximumSize(new java.awt.Dimension(135, 33));
        creditsButton.setMinimumSize(new java.awt.Dimension(135, 33));
        creditsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditsButtonActionPerformed(evt);
            }
        });
        add(creditsButton);
        creditsButton.setBounds(390, 270, 200, 30);

        teamImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/teamI.jpg"))); // NOI18N
        teamImageLabel.setText("jLabel2");
        teamImageLabel.setMaximumSize(new java.awt.Dimension(600, 400));
        teamImageLabel.setMinimumSize(new java.awt.Dimension(600, 400));
        add(teamImageLabel);
        teamImageLabel.setBounds(0, 0, 600, 400);
    }// </editor-fold>//GEN-END:initComponents

    private void highscoresButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highscoresButtonActionPerformed
        // TODO add your handling code here:
        f.getContentPane().removeAll();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            f.add(new Highscores(f));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        f.pack();
        f.setVisible(true);
    }//GEN-LAST:event_highscoresButtonActionPerformed

    private void creditsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditsButtonActionPerformed
        // TODO add your handling code here:
        f.getContentPane().removeAll();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Credits(f));
        f.pack();
        f.setVisible(true);
    }//GEN-LAST:event_creditsButtonActionPerformed

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        // TODO add your handling code here:
        f.getContentPane().removeAll();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Play(f));
        f.pack();
        f.setVisible(true);
    }//GEN-LAST:event_playButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton creditsButton;
    private javax.swing.JButton highscoresButton;
    private javax.swing.JButton playButton;
    private javax.swing.JLabel teamImageLabel;
    // End of variables declaration//GEN-END:variables

}
