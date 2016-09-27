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
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.RenderingHints;

public class IntroPanel extends Hangman {
    public IntroPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(Color.BLACK);
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);        
    }
    
    public void paintComponent(Graphics g) {        
        super.paintComponent(g);
        Font font = new Font(null, Font.BOLD, 38);
        Graphics2D g2 = (Graphics2D) g;

        g2.setFont(font);
        g2.setColor(Color.green);

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
        //Draw Text
        g.drawString("CS 245 Quarter Project", 75, 50);
        font = new Font("Chiller", Font.ITALIC, 28);
        g2.setFont(font);
        g2.drawString("By: Team 0010", 230, 300);
        ImageIcon icon = new ImageIcon("image.jpg"); 
    }
}