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
import java.awt.Color;
import javax.swing.*;
import java.util.Random;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


public class Play extends javax.swing.JPanel {
    private static JFrame f = new JFrame("0010 Hangman");      // JFrame here to gain access in other methods
    private String[] wordList = {"abstract", "cemetery", "nurse", "pharmacy", "climbing"};
    private String word = "band";   //just a test word for now
    private String keyPressed;
    private int uniqueLetters;
    private int score;
    private String underline;
    private static boolean gameOver1 = false;   // repaint() time can not be controlled unfortunately so I need to end the game after method ends
    
    /**
     * Creates new form Play
     */
    public static boolean getGameOver1() {
        return gameOver1;
    }
    public static void setGameOver1() {
        gameOver1 = false;
    }
    public Play(JFrame f) {
        this.f = f;
        initComponents();
        f.requestFocus();
        Random rand = new Random();
        word = wordList[rand.nextInt(5)];
        Hangman.setScore(100);
        scoreLabel.setText("Score: " + Integer.toString(Hangman.getScore()));
        Hangman.timeLabel = timeLabel;    // changes jLabel reference to timeLabels
        uniqueLetters = 0;
        score = 0;
        
        // ascii value for a-z, counts unique letters
        for (int i=97; i<=122; i++) {
            if (word.contains("" + (char)i)) 
                uniqueLetters++;
        }
        
        underline = "_";
        // create _ _ _ text (no spaces)
        for (int i=1; i<word.length(); i++)
            underline+="_";
        wordLabel.setText(injectSpace());
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.setStroke(new BasicStroke(5F)); // stroke width 5
        g2D.setColor(Color.green);
        
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2D.drawLine(150, 200, 450, 200);   // stage
        g2D.drawLine(250, 200, 250, 20);    // vertical wood
        g2D.drawLine(250, 20, 315, 20);     // horizontal wood
        g2D.drawLine(315, 20, 315, 48);     // rope
        g2D.setStroke(new BasicStroke(3F));
        if (Hangman.getScore() < 100)
            g2D.drawOval(300, 50, 30, 40);    // head
        if (Hangman.getScore() < 90)
            g2D.drawLine(315, 90, 315, 150);  // body
        if (Hangman.getScore() < 80)
            g2D.drawLine(314, 105, 295, 125); // left arm
        if (Hangman.getScore() < 70)
            g2D.drawLine(316, 105, 335, 125); // right arm
        if (Hangman.getScore() < 60)
            g2D.drawLine(314, 150, 295, 180); // left leg
        if (Hangman.getScore() < 50) {
            g2D.drawLine(316, 150, 335, 180); // right leg
            g2D.setStroke(new BasicStroke(1F));
            g2D.drawLine(305, 70, 313, 60); //part 1 of left eye
            g2D.drawLine(305, 60, 313, 70); //part 2 of left eye
            g2D.drawLine(315, 70, 323, 60); //part 1 of right eye
            g2D.drawLine(315, 60, 323, 70); //part 2 of right eye
            g2D.drawArc(310, 75, 10, 25, 10, 160); //sad face
        }
    }
    
    // injects a space in underline to get _ _ _ before printing
    private String injectSpace() {
        String buffer = underline.charAt(0) + "";
        for (int i=1;i<word.length();i++)
            buffer += " " + underline.charAt(i);
        return buffer;
    }
    private void checkLetter() {
        //if wrong letter pressed
        if (!word.contains(keyPressed)) {
            Hangman.setScore(Hangman.getScore() - 10);
            repaint();  // paint stick figure parts
        }
        else {
            String buffer = "";
            buffer = underline.substring(0, word.indexOf(keyPressed));
            buffer += keyPressed;
            for (int i=word.indexOf(keyPressed)+1; i<word.length(); i++) {
                String checkLetter = word.charAt(i)+"";
                if (checkLetter.equals(keyPressed)) {
                    buffer +=underline.substring(buffer.length(), i);
                    buffer += keyPressed;
                }
            }
            buffer += underline.substring(buffer.length(), word.length());
            underline = buffer;
            wordLabel.setText(injectSpace());
            score++;
        } 
        scoreLabel.setText("Score: " + Integer.toString(Hangman.getScore()));
        //game over when score = 40 or when user wins
        if ((Hangman.getScore() == 40) || (score == uniqueLetters)) {
            
            //Dont let user press another button if lost
            //If user does, it throughs the program off and adds more than
            //just 500 points for the Color Game
            aButton.setEnabled(false);
            aButton.setBackground(Color.black);                                         
            bButton.setEnabled(false);
            bButton.setBackground(Color.black);                                        
            cButton.setEnabled(false);
            cButton.setBackground(Color.black);                                        
            dButton.setEnabled(false);
            dButton.setBackground(Color.black);                                        
            eButton.setEnabled(false);
            eButton.setBackground(Color.black);                                        
            fButton.setEnabled(false);
            fButton.setBackground(Color.black);                                         
            gButton.setEnabled(false);
            gButton.setBackground(Color.black);                                        
            hButton.setEnabled(false);
            hButton.setBackground(Color.black);                                         
            iButton.setEnabled(false);
            iButton.setBackground(Color.black);                                         
            jButton.setEnabled(false);
            jButton.setBackground(Color.black);                                          
            kButton.setEnabled(false);
            kButton.setBackground(Color.black);                                         
            lButton.setEnabled(false);
            lButton.setBackground(Color.black);                                         
            mButton.setEnabled(false);
            mButton.setBackground(Color.black);                                         
            nButton.setEnabled(false);
            nButton.setBackground(Color.black);                                         
            oButton.setEnabled(false);
            oButton.setBackground(Color.black);                                          
            pButton.setEnabled(false);
            pButton.setBackground(Color.black);                                          
            qButton.setEnabled(false);
            qButton.setBackground(Color.black);                                          
            rButton.setEnabled(false);
            rButton.setBackground(Color.black);                                          
            sButton.setEnabled(false);
            sButton.setBackground(Color.black);                                          
            tButton.setEnabled(false);
            tButton.setBackground(Color.black);                                          
            uButton.setEnabled(false);
            uButton.setBackground(Color.black);                                          
            vButton.setEnabled(false);
            vButton.setBackground(Color.black);                                         
            wButton.setEnabled(false);
            wButton.setBackground(Color.black);                                         
            xButton.setEnabled(false);
            xButton.setBackground(Color.black);                                          
            yButton.setEnabled(false);
            yButton.setBackground(Color.black);                                          
            zButton.setEnabled(false);
            zButton.setBackground(Color.black);                                        
            skipButton.setEnabled(false);
            skipButton.setBackground(Color.black);
            gameOver1 = true;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aButton = new javax.swing.JButton();
        bButton = new javax.swing.JButton();
        cButton = new javax.swing.JButton();
        dButton = new javax.swing.JButton();
        eButton = new javax.swing.JButton();
        fButton = new javax.swing.JButton();
        gButton = new javax.swing.JButton();
        hButton = new javax.swing.JButton();
        iButton = new javax.swing.JButton();
        jButton = new javax.swing.JButton();
        kButton = new javax.swing.JButton();
        lButton = new javax.swing.JButton();
        mButton = new javax.swing.JButton();
        nButton = new javax.swing.JButton();
        oButton = new javax.swing.JButton();
        pButton = new javax.swing.JButton();
        qButton = new javax.swing.JButton();
        rButton = new javax.swing.JButton();
        sButton = new javax.swing.JButton();
        tButton = new javax.swing.JButton();
        uButton = new javax.swing.JButton();
        vButton = new javax.swing.JButton();
        wButton = new javax.swing.JButton();
        xButton = new javax.swing.JButton();
        yButton = new javax.swing.JButton();
        zButton = new javax.swing.JButton();
        skipButton = new javax.swing.JButton();
        timeLabel = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        wordLabel = new javax.swing.JLabel();
        nameOfGameLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setToolTipText("");
        setMaximumSize(null);

        aButton.setBackground(new java.awt.Color(102, 102, 102));
        aButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        aButton.setForeground(new java.awt.Color(51, 255, 51));
        aButton.setText("A");
        aButton.setToolTipText("Select This Letter");
        aButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aButton.setFocusable(false);
        aButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        aButton.setMaximumSize(new java.awt.Dimension(39, 21));
        aButton.setMinimumSize(new java.awt.Dimension(39, 21));
        aButton.setRolloverEnabled(false);
        aButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aButtonActionPerformed(evt);
            }
        });

        bButton.setBackground(new java.awt.Color(102, 102, 102));
        bButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        bButton.setForeground(new java.awt.Color(51, 255, 51));
        bButton.setText("B");
        bButton.setToolTipText("Select This Letter");
        bButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bButton.setFocusable(false);
        bButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bButton.setRolloverEnabled(false);
        bButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bButtonActionPerformed(evt);
            }
        });

        cButton.setBackground(new java.awt.Color(102, 102, 102));
        cButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        cButton.setForeground(new java.awt.Color(51, 255, 51));
        cButton.setText("C");
        cButton.setToolTipText("Select This Letter");
        cButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cButton.setFocusable(false);
        cButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cButton.setRolloverEnabled(false);
        cButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButtonActionPerformed(evt);
            }
        });

        dButton.setBackground(new java.awt.Color(102, 102, 102));
        dButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        dButton.setForeground(new java.awt.Color(51, 255, 51));
        dButton.setText("D");
        dButton.setToolTipText("Select This Letter");
        dButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dButton.setFocusable(false);
        dButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dButton.setMaximumSize(new java.awt.Dimension(39, 19));
        dButton.setRolloverEnabled(false);
        dButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dButtonActionPerformed(evt);
            }
        });

        eButton.setBackground(new java.awt.Color(102, 102, 102));
        eButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        eButton.setForeground(new java.awt.Color(51, 255, 51));
        eButton.setText("E");
        eButton.setToolTipText("Select This Letter");
        eButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eButton.setFocusable(false);
        eButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        eButton.setMaximumSize(new java.awt.Dimension(39, 19));
        eButton.setRolloverEnabled(false);
        eButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eButtonActionPerformed(evt);
            }
        });

        fButton.setBackground(new java.awt.Color(102, 102, 102));
        fButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        fButton.setForeground(new java.awt.Color(51, 255, 51));
        fButton.setText("F");
        fButton.setToolTipText("Select This Letter");
        fButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fButton.setFocusable(false);
        fButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fButton.setMaximumSize(new java.awt.Dimension(39, 19));
        fButton.setRolloverEnabled(false);
        fButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fButtonActionPerformed(evt);
            }
        });

        gButton.setBackground(new java.awt.Color(102, 102, 102));
        gButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        gButton.setForeground(new java.awt.Color(51, 255, 51));
        gButton.setText("G");
        gButton.setToolTipText("Select This Letter");
        gButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gButton.setFocusable(false);
        gButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        gButton.setMaximumSize(new java.awt.Dimension(39, 19));
        gButton.setRolloverEnabled(false);
        gButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gButtonActionPerformed(evt);
            }
        });

        hButton.setBackground(new java.awt.Color(102, 102, 102));
        hButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        hButton.setForeground(new java.awt.Color(51, 255, 51));
        hButton.setText("H");
        hButton.setToolTipText("Select This Letter");
        hButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hButton.setFocusable(false);
        hButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hButton.setMaximumSize(new java.awt.Dimension(39, 19));
        hButton.setRolloverEnabled(false);
        hButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hButtonActionPerformed(evt);
            }
        });

        iButton.setBackground(new java.awt.Color(102, 102, 102));
        iButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        iButton.setForeground(new java.awt.Color(51, 255, 51));
        iButton.setText("I");
        iButton.setToolTipText("Select This Letter");
        iButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iButton.setFocusable(false);
        iButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        iButton.setMaximumSize(new java.awt.Dimension(35, 19));
        iButton.setRolloverEnabled(false);
        iButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iButtonActionPerformed(evt);
            }
        });

        jButton.setBackground(new java.awt.Color(102, 102, 102));
        jButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        jButton.setForeground(new java.awt.Color(51, 255, 51));
        jButton.setText("J");
        jButton.setToolTipText("Select This Letter");
        jButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton.setFocusable(false);
        jButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton.setMaximumSize(new java.awt.Dimension(37, 19));
        jButton.setRolloverEnabled(false);
        jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        });

        kButton.setBackground(new java.awt.Color(102, 102, 102));
        kButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        kButton.setForeground(new java.awt.Color(51, 255, 51));
        kButton.setText("K");
        kButton.setToolTipText("Select This Letter");
        kButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kButton.setFocusable(false);
        kButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kButton.setMaximumSize(new java.awt.Dimension(39, 19));
        kButton.setRolloverEnabled(false);
        kButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButtonActionPerformed(evt);
            }
        });

        lButton.setBackground(new java.awt.Color(102, 102, 102));
        lButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        lButton.setForeground(new java.awt.Color(51, 255, 51));
        lButton.setText("L");
        lButton.setToolTipText("Select This Letter");
        lButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lButton.setFocusable(false);
        lButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lButton.setMaximumSize(new java.awt.Dimension(39, 19));
        lButton.setRolloverEnabled(false);
        lButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lButtonActionPerformed(evt);
            }
        });

        mButton.setBackground(new java.awt.Color(102, 102, 102));
        mButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        mButton.setForeground(new java.awt.Color(51, 255, 51));
        mButton.setText("M");
        mButton.setToolTipText("Select This Letter");
        mButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mButton.setFocusable(false);
        mButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mButton.setMaximumSize(new java.awt.Dimension(41, 19));
        mButton.setMinimumSize(new java.awt.Dimension(41, 19));
        mButton.setRolloverEnabled(false);
        mButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mButtonActionPerformed(evt);
            }
        });

        nButton.setBackground(new java.awt.Color(102, 102, 102));
        nButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        nButton.setForeground(new java.awt.Color(51, 255, 51));
        nButton.setText("N");
        nButton.setToolTipText("Select This Letter");
        nButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nButton.setFocusable(false);
        nButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nButton.setMaximumSize(new java.awt.Dimension(39, 19));
        nButton.setRolloverEnabled(false);
        nButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nButtonActionPerformed(evt);
            }
        });

        oButton.setBackground(new java.awt.Color(102, 102, 102));
        oButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        oButton.setForeground(new java.awt.Color(51, 255, 51));
        oButton.setText("O");
        oButton.setToolTipText("Select This Letter");
        oButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        oButton.setFocusable(false);
        oButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        oButton.setMaximumSize(new java.awt.Dimension(39, 19));
        oButton.setRolloverEnabled(false);
        oButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oButtonActionPerformed(evt);
            }
        });

        pButton.setBackground(new java.awt.Color(102, 102, 102));
        pButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        pButton.setForeground(new java.awt.Color(51, 255, 51));
        pButton.setText("P");
        pButton.setToolTipText("Select This Letter");
        pButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pButton.setFocusable(false);
        pButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pButton.setMaximumSize(new java.awt.Dimension(39, 19));
        pButton.setRolloverEnabled(false);
        pButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pButtonActionPerformed(evt);
            }
        });

        qButton.setBackground(new java.awt.Color(102, 102, 102));
        qButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        qButton.setForeground(new java.awt.Color(51, 255, 51));
        qButton.setText("Q");
        qButton.setToolTipText("Select This Letter");
        qButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        qButton.setFocusable(false);
        qButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        qButton.setMaximumSize(new java.awt.Dimension(39, 19));
        qButton.setRolloverEnabled(false);
        qButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qButtonActionPerformed(evt);
            }
        });

        rButton.setBackground(new java.awt.Color(102, 102, 102));
        rButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        rButton.setForeground(new java.awt.Color(51, 255, 51));
        rButton.setText("R");
        rButton.setToolTipText("Select This Letter");
        rButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rButton.setFocusable(false);
        rButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rButton.setRolloverEnabled(false);
        rButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rButtonActionPerformed(evt);
            }
        });

        sButton.setBackground(new java.awt.Color(102, 102, 102));
        sButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        sButton.setForeground(new java.awt.Color(51, 255, 51));
        sButton.setText("S");
        sButton.setToolTipText("Select This Letter");
        sButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sButton.setFocusable(false);
        sButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sButton.setMaximumSize(new java.awt.Dimension(39, 19));
        sButton.setRolloverEnabled(false);
        sButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sButtonActionPerformed(evt);
            }
        });

        tButton.setBackground(new java.awt.Color(102, 102, 102));
        tButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        tButton.setForeground(new java.awt.Color(51, 255, 51));
        tButton.setText("T");
        tButton.setToolTipText("Select This Letter");
        tButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tButton.setFocusable(false);
        tButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tButton.setMaximumSize(new java.awt.Dimension(39, 19));
        tButton.setRolloverEnabled(false);
        tButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tButtonActionPerformed(evt);
            }
        });

        uButton.setBackground(new java.awt.Color(102, 102, 102));
        uButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        uButton.setForeground(new java.awt.Color(51, 255, 51));
        uButton.setText("U");
        uButton.setToolTipText("Select This Letter");
        uButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uButton.setFocusable(false);
        uButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        uButton.setMaximumSize(new java.awt.Dimension(39, 19));
        uButton.setRolloverEnabled(false);
        uButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uButtonActionPerformed(evt);
            }
        });

        vButton.setBackground(new java.awt.Color(102, 102, 102));
        vButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        vButton.setForeground(new java.awt.Color(51, 255, 51));
        vButton.setText("V");
        vButton.setToolTipText("Select This Letter");
        vButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vButton.setFocusable(false);
        vButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vButton.setMaximumSize(new java.awt.Dimension(39, 19));
        vButton.setRolloverEnabled(false);
        vButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vButtonActionPerformed(evt);
            }
        });

        wButton.setBackground(new java.awt.Color(102, 102, 102));
        wButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        wButton.setForeground(new java.awt.Color(51, 255, 51));
        wButton.setText("W");
        wButton.setToolTipText("Select This Letter");
        wButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        wButton.setFocusable(false);
        wButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        wButton.setMaximumSize(new java.awt.Dimension(41, 19));
        wButton.setRolloverEnabled(false);
        wButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wButtonActionPerformed(evt);
            }
        });

        xButton.setBackground(new java.awt.Color(102, 102, 102));
        xButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        xButton.setForeground(new java.awt.Color(51, 255, 51));
        xButton.setText("X");
        xButton.setToolTipText("Select This Letter");
        xButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        xButton.setFocusable(false);
        xButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        xButton.setMaximumSize(new java.awt.Dimension(39, 19));
        xButton.setRolloverEnabled(false);
        xButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xButtonActionPerformed(evt);
            }
        });

        yButton.setBackground(new java.awt.Color(102, 102, 102));
        yButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        yButton.setForeground(new java.awt.Color(51, 255, 51));
        yButton.setText("Y");
        yButton.setToolTipText("Select This Letter");
        yButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        yButton.setFocusable(false);
        yButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        yButton.setMaximumSize(new java.awt.Dimension(39, 19));
        yButton.setRolloverEnabled(false);
        yButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yButtonActionPerformed(evt);
            }
        });

        zButton.setBackground(new java.awt.Color(102, 102, 102));
        zButton.setFont(new java.awt.Font("David", 1, 13)); // NOI18N
        zButton.setForeground(new java.awt.Color(51, 255, 51));
        zButton.setText("Z");
        zButton.setToolTipText("Select This Letter");
        zButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        zButton.setFocusable(false);
        zButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        zButton.setMaximumSize(new java.awt.Dimension(39, 19));
        zButton.setRolloverEnabled(false);
        zButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zButtonActionPerformed(evt);
            }
        });

        skipButton.setBackground(new java.awt.Color(51, 51, 51));
        skipButton.setForeground(new java.awt.Color(51, 255, 51));
        skipButton.setText("Skip");
        skipButton.setToolTipText("Skip Hangman Game");
        skipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipButtonActionPerformed(evt);
            }
        });

        timeLabel.setForeground(new java.awt.Color(51, 255, 51));
        timeLabel.setText("time");
        timeLabel.setToolTipText("Current Date & Time");

        scoreLabel.setForeground(new java.awt.Color(51, 255, 51));
        scoreLabel.setText("Score:");
        scoreLabel.setToolTipText("Current Score Of Hangman");

        wordLabel.setFont(new java.awt.Font("Courier New", 0, 36)); // NOI18N
        wordLabel.setForeground(new java.awt.Color(51, 255, 51));
        wordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wordLabel.setText("___");
        wordLabel.setToolTipText("Word To Guess");

        nameOfGameLabel.setFont(new java.awt.Font("SketchFlow Print", 0, 24)); // NOI18N
        nameOfGameLabel.setForeground(new java.awt.Color(51, 255, 51));
        nameOfGameLabel.setText("HANGMAN");
        nameOfGameLabel.setToolTipText("The Name Of The Game");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(sButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(uButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(vButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(wButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(xButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(yButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(zButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(aButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bButton)
                                .addGap(18, 18, 18)
                                .addComponent(cButton)
                                .addGap(18, 18, 18)
                                .addComponent(dButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(eButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(fButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(gButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(skipButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(iButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(wordLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addComponent(jButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(kButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(mButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(nButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(oButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(pButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(qButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(rButton))))
                        .addGap(0, 23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nameOfGameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(scoreLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nameOfGameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(skipButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(wordLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bButton)
                    .addComponent(cButton)
                    .addComponent(dButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void aButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aButtonActionPerformed
        // TODO add your handling code here:
        aButton.setEnabled(false);
        aButton.setBackground(Color.black);
        keyPressed="a";
        checkLetter();
    }//GEN-LAST:event_aButtonActionPerformed

    private void skipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipButtonActionPerformed
        // TODO add your handling code here:
        Hangman.setScore(0);
        f.getContentPane().removeAll();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new ColorGame(f));
        f.pack();
        f.setVisible(true);   
    }//GEN-LAST:event_skipButtonActionPerformed

    private void bButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bButtonActionPerformed
        bButton.setEnabled(false);
        bButton.setBackground(Color.black);
        keyPressed="b";
        checkLetter();
    }//GEN-LAST:event_bButtonActionPerformed

    private void cButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButtonActionPerformed
        cButton.setEnabled(false);
        cButton.setBackground(Color.black);
        keyPressed="c";
        checkLetter();
    }//GEN-LAST:event_cButtonActionPerformed

    private void dButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dButtonActionPerformed
        dButton.setEnabled(false);
        dButton.setBackground(Color.black);
        keyPressed="d";
        checkLetter();
    }//GEN-LAST:event_dButtonActionPerformed

    private void eButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eButtonActionPerformed
        eButton.setEnabled(false);
        eButton.setBackground(Color.black);
        keyPressed="e";
        checkLetter();
    }//GEN-LAST:event_eButtonActionPerformed

    private void fButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fButtonActionPerformed
        fButton.setEnabled(false);
        fButton.setBackground(Color.black);
        keyPressed="f";
        checkLetter();
    }//GEN-LAST:event_fButtonActionPerformed

    private void gButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gButtonActionPerformed
        gButton.setEnabled(false);
        gButton.setBackground(Color.black);
        keyPressed="g";
        checkLetter();
    }//GEN-LAST:event_gButtonActionPerformed

    private void hButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hButtonActionPerformed
        hButton.setEnabled(false);
        hButton.setBackground(Color.black);
        keyPressed="h";
        checkLetter();
    }//GEN-LAST:event_hButtonActionPerformed

    private void iButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iButtonActionPerformed
        iButton.setEnabled(false);
        iButton.setBackground(Color.black);
        keyPressed="i";
        checkLetter();
    }//GEN-LAST:event_iButtonActionPerformed

    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionPerformed
        jButton.setEnabled(false);
        jButton.setBackground(Color.black);
        keyPressed="j";
        checkLetter();
    }//GEN-LAST:event_jButtonActionPerformed

    private void kButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButtonActionPerformed
        kButton.setEnabled(false);
        kButton.setBackground(Color.black);
        keyPressed="k";
        checkLetter();
    }//GEN-LAST:event_kButtonActionPerformed

    private void lButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lButtonActionPerformed
        lButton.setEnabled(false);
        lButton.setBackground(Color.black);
        keyPressed="l";
        checkLetter();
    }//GEN-LAST:event_lButtonActionPerformed

    private void mButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mButtonActionPerformed
        mButton.setEnabled(false);
        mButton.setBackground(Color.black);
        keyPressed="m";
        checkLetter();
    }//GEN-LAST:event_mButtonActionPerformed

    private void nButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nButtonActionPerformed
        nButton.setEnabled(false);
        nButton.setBackground(Color.black);
        keyPressed="n";
        checkLetter();
    }//GEN-LAST:event_nButtonActionPerformed

    private void oButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oButtonActionPerformed
        oButton.setEnabled(false);
        oButton.setBackground(Color.black);
        keyPressed="o";
        checkLetter();
    }//GEN-LAST:event_oButtonActionPerformed

    private void pButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pButtonActionPerformed
        pButton.setEnabled(false);
        pButton.setBackground(Color.black);
        keyPressed="p";
        checkLetter();
    }//GEN-LAST:event_pButtonActionPerformed

    private void qButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qButtonActionPerformed
        qButton.setEnabled(false);
        qButton.setBackground(Color.black);
        keyPressed="q";
        checkLetter();
    }//GEN-LAST:event_qButtonActionPerformed

    private void rButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButtonActionPerformed
        rButton.setEnabled(false);
        rButton.setBackground(Color.black);
        keyPressed="r";
        checkLetter();
    }//GEN-LAST:event_rButtonActionPerformed

    private void sButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sButtonActionPerformed
        sButton.setEnabled(false);
        sButton.setBackground(Color.black);
        keyPressed="s";
        checkLetter();
    }//GEN-LAST:event_sButtonActionPerformed

    private void tButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tButtonActionPerformed
        tButton.setEnabled(false);
        tButton.setBackground(Color.black);
        keyPressed="t";
        checkLetter();
    }//GEN-LAST:event_tButtonActionPerformed

    private void uButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uButtonActionPerformed
        uButton.setEnabled(false);
        uButton.setBackground(Color.black);
        keyPressed="u";
        checkLetter();
    }//GEN-LAST:event_uButtonActionPerformed

    private void vButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vButtonActionPerformed
        vButton.setEnabled(false);
        vButton.setBackground(Color.black);
        keyPressed="v";
        checkLetter();
    }//GEN-LAST:event_vButtonActionPerformed

    private void wButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wButtonActionPerformed
        wButton.setEnabled(false);
        wButton.setBackground(Color.black);
        keyPressed="w";
        checkLetter();
    }//GEN-LAST:event_wButtonActionPerformed

    private void xButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xButtonActionPerformed
        xButton.setEnabled(false);
        xButton.setBackground(Color.black);
        keyPressed="x";
        checkLetter();
    }//GEN-LAST:event_xButtonActionPerformed

    private void yButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yButtonActionPerformed
        yButton.setEnabled(false);
        yButton.setBackground(Color.black);
        keyPressed="y";
        checkLetter();
    }//GEN-LAST:event_yButtonActionPerformed

    private void zButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zButtonActionPerformed
        zButton.setEnabled(false);
        zButton.setBackground(Color.black);
        keyPressed="z";
        checkLetter();
    }//GEN-LAST:event_zButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aButton;
    private javax.swing.JButton bButton;
    private javax.swing.JButton cButton;
    private javax.swing.JButton dButton;
    private javax.swing.JButton eButton;
    private javax.swing.JButton fButton;
    private javax.swing.JButton gButton;
    private javax.swing.JButton hButton;
    private javax.swing.JButton iButton;
    private javax.swing.JButton jButton;
    private javax.swing.JButton kButton;
    private javax.swing.JButton lButton;
    private javax.swing.JButton mButton;
    private javax.swing.JButton nButton;
    private javax.swing.JLabel nameOfGameLabel;
    private javax.swing.JButton oButton;
    private javax.swing.JButton pButton;
    private javax.swing.JButton qButton;
    private javax.swing.JButton rButton;
    private javax.swing.JButton sButton;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JButton skipButton;
    private javax.swing.JButton tButton;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JButton uButton;
    private javax.swing.JButton vButton;
    private javax.swing.JButton wButton;
    private javax.swing.JLabel wordLabel;
    private javax.swing.JButton xButton;
    private javax.swing.JButton yButton;
    private javax.swing.JButton zButton;
    // End of variables declaration//GEN-END:variables
}