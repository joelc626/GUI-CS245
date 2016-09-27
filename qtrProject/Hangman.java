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

import java.awt.*;
import javax.swing.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hangman extends JPanel {

    private static JFrame f = new JFrame("0010 Hangman");      // JFrame here to gain access in other methods
    private static JComponent popup = new JOptionPane();
    private Calendar cal;
    private static String date;
    public static JLabel timeLabel = new javax.swing.JLabel();
    private static int score;
    private static String name;

    /**
     * @param args the command line arguments
     */
    public Hangman() {
        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 112) 
                    JOptionPane.showMessageDialog(new JFrame("ok"), "Project Name: CS245 Quarter Project\n"
                            + "Joel Castro, #########\n**** ****,"
                            + "#########\nTeam Name: 0010\nTerm: CS245\n",
                            "Information", JOptionPane.INFORMATION_MESSAGE);
                if (e.getKeyCode() == 27) System.exit(0);
            }
        };
        f.addKeyListener(keyListener);

    }

    public static String getDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy    hh:mm:ss ");
        date = sdf.format(cal.getTimeInMillis());
        return date;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int i) {
        score = i;
    }

    public static String getTheName() {
        return name;
    }

    public static void setTheName(String n) {
        name = n;
    }

    public static void main(String[] args) {
        timeLabel.setText(Hangman.getDate());
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(f);
            }
        });

        sleeper(3000);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                makeM();
            }
        });

        // keeps UI/time updated
        while (true) {
            timeLabel.setText(Hangman.getDate());
            if (Play.getGameOver1() == true) {
                Play.setGameOver1();
                sleeper(1500);

                //Second game
                f.getContentPane().removeAll();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.add(new ColorGame(f));
                f.pack();
                f.setVisible(true);
            }

            if (ColorGame.getGameOver2() == true) {
                //Then highscore
                ColorGame.setGameOver2();
                f.getContentPane().removeAll();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.add(new Sudoku(f));
                f.pack();
                f.setVisible(true);
            }

            if (Sudoku.getGameOver3() == true) {
                //Then highscore
                Sudoku.setGameOver3();
                f.getContentPane().removeAll();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.add(new End(f));
                f.pack();
                f.setVisible(true);
            }
        }
    }

    private static void createAndShowGUI(JFrame f) {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setPreferredSize(new Dimension(600, 400));        // make sure size stays
        f.add(new IntroPanel());
        f.pack();
        f.setLocationRelativeTo(null);  // Sets window to center of screen if placed after f.pack();
        f.setBackground(Color.yellow);
        f.setVisible(true);
    }

    public static void makeM() {
        f.getContentPane().removeAll();     // Erases last Pane for new one
        f.getContentPane().add(new JPanel());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            f.add(new MainScreen(f));
        } catch (IOException ex) {
            Logger.getLogger(Hangman.class.getName()).log(Level.SEVERE, null, ex);
        }
        f.pack();
        f.setVisible(true);



        f.requestFocus();
    }

    static void sleeper(int n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
        }
    }
}