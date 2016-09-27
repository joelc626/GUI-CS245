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
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.geom.*;
import java.util.ArrayList;

public class Sudoku extends javax.swing.JPanel {

    private static JFrame f = new JFrame("0010 Hangman");      // JFrame here to gain access in other methods
    private static boolean gameOver3;
    private int correctAnswer[] = {3, 5, 1, 9, 2, // by row
        2, 9, 6, 8, 5, 7, 3, 1,
        4, 7, 2, 9, 3, 8,
        6, 1, 4, 2,
        1, 2, 3, 6, 8, 5, 4, 9,
        7, 5, 9, 6,
        6, 7, 8, 1, 3, 4,
        9, 8, 3, 4, 5, 2, 7, 6,
        7, 4, 6, 8, 1};
    private boolean alreadySubtracted[] = new boolean[54];
    private ArrayList<JTextField> txtFields = new ArrayList<JTextField>();
    private int sudokuScore = 540;
    
    public static boolean getGameOver3() {
        return gameOver3;
    }

    public static void setGameOver3() {
        gameOver3 = false;
    }

    public Sudoku(JFrame f) {
        this.f = f;
        initComponents();
        Hangman.timeLabel = timeLabel;    // changes jLabel reference to timeLabels
        scoreLabel.setText("Score: " + Integer.toString(Hangman.getScore()) + "+" + "(" + sudokuScore + ")");
        incorrectLabel1.setVisible(false);   
        incorrectLabel2.setVisible(false);   
        
        txtFields.add(jTextField1);
        txtFields.add(jTextField2);
        txtFields.add(jTextField3);
        txtFields.add(jTextField4);
        txtFields.add(jTextField5);
        txtFields.add(jTextField6);
        txtFields.add(jTextField7);
        txtFields.add(jTextField8);
        txtFields.add(jTextField9);
        txtFields.add(jTextField10);
        txtFields.add(jTextField11);
        txtFields.add(jTextField12);
        txtFields.add(jTextField13);
        txtFields.add(jTextField14);
        txtFields.add(jTextField15);
        txtFields.add(jTextField16);
        txtFields.add(jTextField17);
        txtFields.add(jTextField18);
        txtFields.add(jTextField19);
        txtFields.add(jTextField20);
        txtFields.add(jTextField21);
        txtFields.add(jTextField22);
        txtFields.add(jTextField23);
        txtFields.add(jTextField24);
        txtFields.add(jTextField25);
        txtFields.add(jTextField26);
        txtFields.add(jTextField27);
        txtFields.add(jTextField28);
        txtFields.add(jTextField29);
        txtFields.add(jTextField30);
        txtFields.add(jTextField31);
        txtFields.add(jTextField32);
        txtFields.add(jTextField33);
        txtFields.add(jTextField34);
        txtFields.add(jTextField35);
        txtFields.add(jTextField36);
        txtFields.add(jTextField37);
        txtFields.add(jTextField38);
        txtFields.add(jTextField39);
        txtFields.add(jTextField40);
        txtFields.add(jTextField41);
        txtFields.add(jTextField42);
        txtFields.add(jTextField43);
        txtFields.add(jTextField44);
        txtFields.add(jTextField45);
        txtFields.add(jTextField46);
        txtFields.add(jTextField47);
        txtFields.add(jTextField48);
        txtFields.add(jTextField49);
        txtFields.add(jTextField50);
        txtFields.add(jTextField51);
        txtFields.add(jTextField52);
        txtFields.add(jTextField53);
        txtFields.add(jTextField54);

        for (JTextField jtf : txtFields)
            jtf.setDocument(new JTextFieldLimit(1, f));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); //clear drawing area
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timeLabel = new javax.swing.JLabel();
        nameOfGameLabel = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        scoreLabel = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        jTextField37 = new javax.swing.JTextField();
        jTextField38 = new javax.swing.JTextField();
        jTextField39 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        jTextField41 = new javax.swing.JTextField();
        jTextField42 = new javax.swing.JTextField();
        jTextField43 = new javax.swing.JTextField();
        jTextField44 = new javax.swing.JTextField();
        jTextField45 = new javax.swing.JTextField();
        jTextField46 = new javax.swing.JTextField();
        jTextField47 = new javax.swing.JTextField();
        jTextField48 = new javax.swing.JTextField();
        jTextField49 = new javax.swing.JTextField();
        jTextField50 = new javax.swing.JTextField();
        jTextField51 = new javax.swing.JTextField();
        jTextField52 = new javax.swing.JTextField();
        jTextField53 = new javax.swing.JTextField();
        jTextField54 = new javax.swing.JTextField();
        incorrectLabel1 = new javax.swing.JLabel();
        incorrectLabel2 = new javax.swing.JLabel();
        sudokuBoradLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(600, 400));
        setLayout(null);

        timeLabel.setForeground(new java.awt.Color(51, 255, 51));
        timeLabel.setText("time");
        timeLabel.setToolTipText("Current Date & Time");
        add(timeLabel);
        timeLabel.setBounds(453, 15, 137, 25);

        nameOfGameLabel.setFont(new java.awt.Font("SketchFlow Print", 1, 24)); // NOI18N
        nameOfGameLabel.setForeground(new java.awt.Color(51, 255, 51));
        nameOfGameLabel.setText("Sudoku");
        nameOfGameLabel.setToolTipText("Name Of Game");
        add(nameOfGameLabel);
        nameOfGameLabel.setBounds(10, 11, 92, 26);

        submitButton.setBackground(new java.awt.Color(0, 0, 0));
        submitButton.setForeground(new java.awt.Color(51, 255, 51));
        submitButton.setText("Submit");
        submitButton.setToolTipText("Submit Your Answers");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        add(submitButton);
        submitButton.setBounds(20, 320, 80, 23);

        quitButton.setBackground(new java.awt.Color(0, 0, 0));
        quitButton.setForeground(new java.awt.Color(51, 255, 51));
        quitButton.setText("Quit");
        quitButton.setToolTipText("Quit The Game");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });
        add(quitButton);
        quitButton.setBounds(450, 320, 80, 23);
        quitButton.getAccessibleContext().setAccessibleName("quitButton");

        scoreLabel.setForeground(new java.awt.Color(51, 255, 51));
        scoreLabel.setText("Score:");
        scoreLabel.setToolTipText("From Previous Games + (Sudoku score)");
        add(scoreLabel);
        scoreLabel.setBounds(450, 50, 140, 14);

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(51, 204, 0));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setToolTipText("Enter A Number From 1-9");
        jTextField1.setBorder(null);
        add(jTextField1);
        jTextField1.setBounds(154, 26, 28, 30);

        jTextField2.setBackground(new java.awt.Color(0, 0, 0));
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(51, 204, 0));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setToolTipText("Enter A Number From 1-9");
        jTextField2.setBorder(null);
        add(jTextField2);
        jTextField2.setBounds(188, 26, 28, 30);

        jTextField3.setBackground(new java.awt.Color(0, 0, 0));
        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(51, 204, 0));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setToolTipText("Enter A Number From 1-9");
        jTextField3.setBorder(null);
        add(jTextField3);
        jTextField3.setBounds(257, 26, 28, 30);

        jTextField4.setBackground(new java.awt.Color(0, 0, 0));
        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(51, 204, 0));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setToolTipText("Enter A Number From 1-9");
        jTextField4.setBorder(null);
        add(jTextField4);
        jTextField4.setBounds(332, 26, 28, 30);

        jTextField5.setBackground(new java.awt.Color(0, 0, 0));
        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(51, 204, 0));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setToolTipText("Enter A Number From 1-9");
        jTextField5.setBorder(null);
        add(jTextField5);
        jTextField5.setBounds(366, 26, 28, 30);

        jTextField6.setBackground(new java.awt.Color(0, 0, 0));
        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(51, 204, 0));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setToolTipText("Enter A Number From 1-9");
        jTextField6.setBorder(null);
        add(jTextField6);
        jTextField6.setBounds(120, 62, 28, 30);

        jTextField7.setBackground(new java.awt.Color(0, 0, 0));
        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(51, 204, 0));
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setToolTipText("Enter A Number From 1-9");
        jTextField7.setBorder(null);
        add(jTextField7);
        jTextField7.setBounds(154, 62, 28, 30);

        jTextField8.setBackground(new java.awt.Color(0, 0, 0));
        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(51, 204, 0));
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setToolTipText("Enter A Number From 1-9");
        jTextField8.setBorder(null);
        add(jTextField8);
        jTextField8.setBounds(188, 62, 28, 30);

        jTextField9.setBackground(new java.awt.Color(0, 0, 0));
        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(51, 204, 0));
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setToolTipText("Enter A Number From 1-9");
        jTextField9.setBorder(null);
        add(jTextField9);
        jTextField9.setBounds(224, 62, 28, 30);

        jTextField10.setBackground(new java.awt.Color(0, 0, 0));
        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(51, 204, 0));
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setToolTipText("Enter A Number From 1-9");
        jTextField10.setBorder(null);
        add(jTextField10);
        jTextField10.setBounds(257, 62, 28, 30);

        jTextField11.setBackground(new java.awt.Color(0, 0, 0));
        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(51, 204, 0));
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setToolTipText("Enter A Number From 1-9");
        jTextField11.setBorder(null);
        add(jTextField11);
        jTextField11.setBounds(293, 62, 28, 30);

        jTextField12.setBackground(new java.awt.Color(0, 0, 0));
        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(51, 204, 0));
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setToolTipText("Enter A Number From 1-9");
        jTextField12.setBorder(null);
        add(jTextField12);
        jTextField12.setBounds(366, 62, 28, 30);

        jTextField13.setBackground(new java.awt.Color(0, 0, 0));
        jTextField13.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField13.setForeground(new java.awt.Color(51, 204, 0));
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.setToolTipText("Enter A Number From 1-9");
        jTextField13.setBorder(null);
        add(jTextField13);
        jTextField13.setBounds(400, 62, 28, 30);

        jTextField14.setBackground(new java.awt.Color(0, 0, 0));
        jTextField14.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField14.setForeground(new java.awt.Color(51, 204, 0));
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setToolTipText("Enter A Number From 1-9");
        jTextField14.setBorder(null);
        add(jTextField14);
        jTextField14.setBounds(120, 98, 28, 30);

        jTextField15.setBackground(new java.awt.Color(0, 0, 0));
        jTextField15.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField15.setForeground(new java.awt.Color(51, 204, 0));
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.setToolTipText("Enter A Number From 1-9");
        jTextField15.setBorder(null);
        add(jTextField15);
        jTextField15.setBounds(188, 98, 28, 30);

        jTextField16.setBackground(new java.awt.Color(0, 0, 0));
        jTextField16.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField16.setForeground(new java.awt.Color(51, 204, 0));
        jTextField16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField16.setToolTipText("Enter A Number From 1-9");
        jTextField16.setBorder(null);
        add(jTextField16);
        jTextField16.setBounds(224, 98, 28, 30);

        jTextField17.setBackground(new java.awt.Color(0, 0, 0));
        jTextField17.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField17.setForeground(new java.awt.Color(51, 204, 0));
        jTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField17.setToolTipText("Enter A Number From 1-9");
        jTextField17.setBorder(null);
        add(jTextField17);
        jTextField17.setBounds(257, 98, 28, 30);

        jTextField18.setBackground(new java.awt.Color(0, 0, 0));
        jTextField18.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField18.setForeground(new java.awt.Color(51, 204, 0));
        jTextField18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField18.setToolTipText("Enter A Number From 1-9");
        jTextField18.setBorder(null);
        add(jTextField18);
        jTextField18.setBounds(293, 98, 28, 30);

        jTextField19.setBackground(new java.awt.Color(0, 0, 0));
        jTextField19.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField19.setForeground(new java.awt.Color(51, 204, 0));
        jTextField19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField19.setToolTipText("Enter A Number From 1-9");
        jTextField19.setBorder(null);
        add(jTextField19);
        jTextField19.setBounds(400, 98, 28, 30);

        jTextField20.setBackground(new java.awt.Color(0, 0, 0));
        jTextField20.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField20.setForeground(new java.awt.Color(51, 204, 0));
        jTextField20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField20.setToolTipText("Enter A Number From 1-9");
        jTextField20.setBorder(null);
        add(jTextField20);
        jTextField20.setBounds(154, 137, 28, 30);

        jTextField21.setBackground(new java.awt.Color(0, 0, 0));
        jTextField21.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField21.setForeground(new java.awt.Color(51, 204, 0));
        jTextField21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField21.setToolTipText("Enter A Number From 1-9");
        jTextField21.setBorder(null);
        add(jTextField21);
        jTextField21.setBounds(224, 137, 28, 30);

        jTextField22.setBackground(new java.awt.Color(0, 0, 0));
        jTextField22.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField22.setForeground(new java.awt.Color(51, 204, 0));
        jTextField22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField22.setToolTipText("Enter A Number From 1-9");
        jTextField22.setBorder(null);
        add(jTextField22);
        jTextField22.setBounds(293, 137, 28, 30);

        jTextField23.setBackground(new java.awt.Color(0, 0, 0));
        jTextField23.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField23.setForeground(new java.awt.Color(51, 204, 0));
        jTextField23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField23.setToolTipText("Enter A Number From 1-9");
        jTextField23.setBorder(null);
        add(jTextField23);
        jTextField23.setBounds(400, 137, 28, 30);

        jTextField24.setBackground(new java.awt.Color(0, 0, 0));
        jTextField24.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField24.setForeground(new java.awt.Color(51, 204, 0));
        jTextField24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField24.setToolTipText("Enter A Number From 1-9");
        jTextField24.setBorder(null);
        add(jTextField24);
        jTextField24.setBounds(120, 173, 28, 30);

        jTextField25.setBackground(new java.awt.Color(0, 0, 0));
        jTextField25.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField25.setForeground(new java.awt.Color(51, 204, 0));
        jTextField25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField25.setToolTipText("Enter A Number From 1-9");
        jTextField25.setBorder(null);
        add(jTextField25);
        jTextField25.setBounds(154, 173, 28, 30);

        jTextField26.setBackground(new java.awt.Color(0, 0, 0));
        jTextField26.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField26.setForeground(new java.awt.Color(51, 204, 0));
        jTextField26.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField26.setToolTipText("Enter A Number From 1-9");
        jTextField26.setBorder(null);
        add(jTextField26);
        jTextField26.setBounds(188, 173, 28, 30);

        jTextField27.setBackground(new java.awt.Color(0, 0, 0));
        jTextField27.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField27.setForeground(new java.awt.Color(51, 204, 0));
        jTextField27.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField27.setToolTipText("Enter A Number From 1-9");
        jTextField27.setBorder(null);
        add(jTextField27);
        jTextField27.setBounds(224, 173, 28, 30);

        jTextField28.setBackground(new java.awt.Color(0, 0, 0));
        jTextField28.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField28.setForeground(new java.awt.Color(51, 204, 0));
        jTextField28.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField28.setToolTipText("Enter A Number From 1-9");
        jTextField28.setBorder(null);
        add(jTextField28);
        jTextField28.setBounds(293, 173, 28, 30);

        jTextField29.setBackground(new java.awt.Color(0, 0, 0));
        jTextField29.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField29.setForeground(new java.awt.Color(51, 204, 0));
        jTextField29.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField29.setToolTipText("Enter A Number From 1-9");
        jTextField29.setBorder(null);
        add(jTextField29);
        jTextField29.setBounds(332, 173, 28, 30);

        jTextField30.setBackground(new java.awt.Color(0, 0, 0));
        jTextField30.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField30.setForeground(new java.awt.Color(51, 204, 0));
        jTextField30.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField30.setToolTipText("Enter A Number From 1-9");
        jTextField30.setBorder(null);
        add(jTextField30);
        jTextField30.setBounds(366, 173, 28, 30);

        jTextField31.setBackground(new java.awt.Color(0, 0, 0));
        jTextField31.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField31.setForeground(new java.awt.Color(51, 204, 0));
        jTextField31.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField31.setToolTipText("Enter A Number From 1-9");
        jTextField31.setBorder(null);
        add(jTextField31);
        jTextField31.setBounds(400, 173, 28, 30);

        jTextField32.setBackground(new java.awt.Color(0, 0, 0));
        jTextField32.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField32.setForeground(new java.awt.Color(51, 204, 0));
        jTextField32.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField32.setToolTipText("Enter A Number From 1-9");
        jTextField32.setBorder(null);
        add(jTextField32);
        jTextField32.setBounds(120, 209, 28, 30);

        jTextField33.setBackground(new java.awt.Color(0, 0, 0));
        jTextField33.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField33.setForeground(new java.awt.Color(51, 204, 0));
        jTextField33.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField33.setToolTipText("Enter A Number From 1-9");
        jTextField33.setBorder(null);
        add(jTextField33);
        jTextField33.setBounds(224, 209, 28, 30);

        jTextField34.setBackground(new java.awt.Color(0, 0, 0));
        jTextField34.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField34.setForeground(new java.awt.Color(51, 204, 0));
        jTextField34.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField34.setToolTipText("Enter A Number From 1-9");
        jTextField34.setBorder(null);
        add(jTextField34);
        jTextField34.setBounds(293, 209, 28, 30);

        jTextField35.setBackground(new java.awt.Color(0, 0, 0));
        jTextField35.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField35.setForeground(new java.awt.Color(51, 204, 0));
        jTextField35.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField35.setToolTipText("Enter A Number From 1-9");
        jTextField35.setBorder(null);
        add(jTextField35);
        jTextField35.setBounds(366, 209, 28, 30);

        jTextField36.setBackground(new java.awt.Color(0, 0, 0));
        jTextField36.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField36.setForeground(new java.awt.Color(51, 204, 0));
        jTextField36.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField36.setToolTipText("Enter A Number From 1-9");
        jTextField36.setBorder(null);
        add(jTextField36);
        jTextField36.setBounds(120, 248, 28, 30);

        jTextField37.setBackground(new java.awt.Color(0, 0, 0));
        jTextField37.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField37.setForeground(new java.awt.Color(51, 204, 0));
        jTextField37.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField37.setToolTipText("Enter A Number From 1-9");
        jTextField37.setBorder(null);
        add(jTextField37);
        jTextField37.setBounds(224, 248, 28, 30);

        jTextField38.setBackground(new java.awt.Color(0, 0, 0));
        jTextField38.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField38.setForeground(new java.awt.Color(51, 204, 0));
        jTextField38.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField38.setToolTipText("Enter A Number From 1-9");
        jTextField38.setBorder(null);
        add(jTextField38);
        jTextField38.setBounds(257, 248, 28, 30);

        jTextField39.setBackground(new java.awt.Color(0, 0, 0));
        jTextField39.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField39.setForeground(new java.awt.Color(51, 204, 0));
        jTextField39.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField39.setToolTipText("Enter A Number From 1-9");
        jTextField39.setBorder(null);
        add(jTextField39);
        jTextField39.setBounds(293, 248, 28, 30);

        jTextField40.setBackground(new java.awt.Color(0, 0, 0));
        jTextField40.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField40.setForeground(new java.awt.Color(51, 204, 0));
        jTextField40.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField40.setToolTipText("Enter A Number From 1-9");
        jTextField40.setBorder(null);
        add(jTextField40);
        jTextField40.setBounds(332, 248, 28, 30);

        jTextField41.setBackground(new java.awt.Color(0, 0, 0));
        jTextField41.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField41.setForeground(new java.awt.Color(51, 204, 0));
        jTextField41.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField41.setToolTipText("Enter A Number From 1-9");
        jTextField41.setBorder(null);
        add(jTextField41);
        jTextField41.setBounds(400, 248, 28, 30);

        jTextField42.setBackground(new java.awt.Color(0, 0, 0));
        jTextField42.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField42.setForeground(new java.awt.Color(51, 204, 0));
        jTextField42.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField42.setToolTipText("Enter A Number From 1-9");
        jTextField42.setBorder(null);
        add(jTextField42);
        jTextField42.setBounds(120, 284, 28, 30);

        jTextField43.setBackground(new java.awt.Color(0, 0, 0));
        jTextField43.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField43.setForeground(new java.awt.Color(51, 204, 0));
        jTextField43.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField43.setToolTipText("Enter A Number From 1-9");
        jTextField43.setBorder(null);
        add(jTextField43);
        jTextField43.setBounds(154, 284, 28, 30);

        jTextField44.setBackground(new java.awt.Color(0, 0, 0));
        jTextField44.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField44.setForeground(new java.awt.Color(51, 204, 0));
        jTextField44.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField44.setToolTipText("Enter A Number From 1-9");
        jTextField44.setBorder(null);
        add(jTextField44);
        jTextField44.setBounds(224, 284, 28, 30);

        jTextField45.setBackground(new java.awt.Color(0, 0, 0));
        jTextField45.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField45.setForeground(new java.awt.Color(51, 204, 0));
        jTextField45.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField45.setToolTipText("Enter A Number From 1-9");
        jTextField45.setBorder(null);
        add(jTextField45);
        jTextField45.setBounds(257, 284, 28, 30);

        jTextField46.setBackground(new java.awt.Color(0, 0, 0));
        jTextField46.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField46.setForeground(new java.awt.Color(51, 204, 0));
        jTextField46.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField46.setToolTipText("Enter A Number From 1-9");
        jTextField46.setBorder(null);
        add(jTextField46);
        jTextField46.setBounds(293, 284, 28, 30);

        jTextField47.setBackground(new java.awt.Color(0, 0, 0));
        jTextField47.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField47.setForeground(new java.awt.Color(51, 204, 0));
        jTextField47.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField47.setToolTipText("Enter A Number From 1-9");
        jTextField47.setBorder(null);
        add(jTextField47);
        jTextField47.setBounds(332, 284, 28, 30);

        jTextField48.setBackground(new java.awt.Color(0, 0, 0));
        jTextField48.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField48.setForeground(new java.awt.Color(51, 204, 0));
        jTextField48.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField48.setToolTipText("Enter A Number From 1-9");
        jTextField48.setBorder(null);
        add(jTextField48);
        jTextField48.setBounds(366, 284, 28, 30);

        jTextField49.setBackground(new java.awt.Color(0, 0, 0));
        jTextField49.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField49.setForeground(new java.awt.Color(51, 204, 0));
        jTextField49.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField49.setToolTipText("Enter A Number From 1-9");
        jTextField49.setBorder(null);
        add(jTextField49);
        jTextField49.setBounds(400, 284, 28, 30);

        jTextField50.setBackground(new java.awt.Color(0, 0, 0));
        jTextField50.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField50.setForeground(new java.awt.Color(51, 204, 0));
        jTextField50.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField50.setToolTipText("Enter A Number From 1-9");
        jTextField50.setBorder(null);
        add(jTextField50);
        jTextField50.setBounds(154, 320, 28, 30);

        jTextField51.setBackground(new java.awt.Color(0, 0, 0));
        jTextField51.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField51.setForeground(new java.awt.Color(51, 204, 0));
        jTextField51.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField51.setToolTipText("Enter A Number From 1-9");
        jTextField51.setBorder(null);
        add(jTextField51);
        jTextField51.setBounds(188, 320, 28, 30);

        jTextField52.setBackground(new java.awt.Color(0, 0, 0));
        jTextField52.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField52.setForeground(new java.awt.Color(51, 204, 0));
        jTextField52.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField52.setToolTipText("Enter A Number From 1-9");
        jTextField52.setBorder(null);
        add(jTextField52);
        jTextField52.setBounds(257, 320, 28, 30);

        jTextField53.setBackground(new java.awt.Color(0, 0, 0));
        jTextField53.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField53.setForeground(new java.awt.Color(51, 204, 0));
        jTextField53.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField53.setToolTipText("Enter A Number From 1-9");
        jTextField53.setBorder(null);
        add(jTextField53);
        jTextField53.setBounds(332, 320, 28, 30);

        jTextField54.setBackground(new java.awt.Color(0, 0, 0));
        jTextField54.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jTextField54.setForeground(new java.awt.Color(51, 204, 0));
        jTextField54.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField54.setToolTipText("Enter A Number From 1-9");
        jTextField54.setBorder(null);
        add(jTextField54);
        jTextField54.setBounds(366, 320, 28, 30);

        incorrectLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        incorrectLabel1.setForeground(new java.awt.Color(255, 0, 0));
        incorrectLabel1.setText("All incorrect guesses");
        add(incorrectLabel1);
        incorrectLabel1.setBounds(440, 270, 98, 20);

        incorrectLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        incorrectLabel2.setForeground(new java.awt.Color(255, 0, 0));
        incorrectLabel2.setText("No more points to get");
        add(incorrectLabel2);
        incorrectLabel2.setBounds(440, 290, 110, 20);

        sudokuBoradLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/SudokuBoard.png"))); // NOI18N
        sudokuBoradLabel.setText("jLabel2");
        sudokuBoradLabel.setToolTipText("");
        sudokuBoradLabel.setPreferredSize(new java.awt.Dimension(600, 400));
        add(sudokuBoradLabel);
        sudokuBoradLabel.setBounds(0, -20, 460, 400);
    }// </editor-fold>//GEN-END:initComponents

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        gameOver3 = true;
    }//GEN-LAST:event_quitButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        int index = 0;
        boolean error = false;

        for (JTextField jftf : txtFields)
            if ((jftf.getText().equals(Integer.toString(0))))
                error = true;

        for (JTextField jtf : txtFields) {
            if (!(jtf.getText().equals(Integer.toString(correctAnswer[index])))) {
                if (alreadySubtracted[index] == false)
                    sudokuScore -= 10;
                alreadySubtracted[index] = true;
            }
            index++;
        }

        Hangman.timeLabel = timeLabel;

        scoreLabel.setText("Score: " + Integer.toString(Hangman.getScore()) + "+" + "(" + sudokuScore + ")");
        if (sudokuScore == 0) {
            incorrectLabel1.setVisible(true);   
            incorrectLabel2.setVisible(true);   
        }
            
        //Check if all the answer are right
        index = 0;
        for (JTextField jtf : txtFields)
            if ((jtf.getText().equals(Integer.toString(correctAnswer[index]))))
                index++;
                
        if (index == 54) {
            Hangman.setScore(Hangman.getScore() + sudokuScore);
            gameOver3 = true;
        }
        
        f.requestFocus();
    }//GEN-LAST:event_submitButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel incorrectLabel1;
    private javax.swing.JLabel incorrectLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel nameOfGameLabel;
    private javax.swing.JButton quitButton;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel sudokuBoradLabel;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}
