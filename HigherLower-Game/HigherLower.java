import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.util.*;
/*<applet code="HigherLower" width=600 height=600></applet>*/
public class HigherLower extends JApplet implements ActionListener
{
    JTextField cardMain,card1,card2,card3;
    JTextField score1,score2;
    JButton btnNewGame,btnLower,btnHigher,btnStartGame;
    
    int main,c1,c2,c3;
    String card[] = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    String hint,first,second,third;
    int TRIES = 1,chances = 3,score = 0;;
    int R, G, B;
    final int MAX_SCORE = 3;
    
    public void init()
    {

        JOptionPane.showMessageDialog(null,"Welcome to the Lower or Higher Java Applet Game.\n\nEnjoy the Game!");
        
        setLayout(null);
        setSize(1024,460);
                
        int R = (int) (250 * Math.random());
        int G = (int) (250 * Math.random());
        int B = (int) (250 * Math.random());
        
        Color color = new Color(R,G,B);

        cardMain = new JTextField(20);
        cardMain.setBounds(10,30,250,270);
        cardMain.setFont(new Font("Arial",Font.BOLD,220));
        cardMain.setEditable(false);
        cardMain.setBackground(Color.lightGray);
        cardMain.setForeground(color);
        cardMain.setBorder(BorderFactory.createEtchedBorder());
        add(cardMain);
        card1 = new JTextField(20);
        card1.setBounds(260,30,250,270);
        card1.setFont(new Font("Arial",Font.BOLD,220));
        card1.setEditable(false);
        card1.setVisible(false);
        card1.setBackground(Color.lightGray);
        card1.setForeground(color);
        card1.setBorder(BorderFactory.createEtchedBorder());
        add(card1);
        card2 = new JTextField(20);
        card2.setBounds(510,30,250,270);
        card2.setFont(new Font("Arial",Font.BOLD,220));
        card2.setEditable(false);
        card2.setVisible(false);
        card2.setBackground(Color.lightGray);
        card2.setForeground(color);
        card2.setBorder(BorderFactory.createEtchedBorder());
        add(card2);
        card3 = new JTextField(20);
        card3.setBounds(760,30,240,270);
        card3.setFont(new Font("Arial",Font.BOLD,220));
        card3.setEditable(false);
        card3.setVisible(false);
        card3.setBackground(Color.lightGray);
        card3.setForeground(color);
        card3.setBorder(BorderFactory.createEtchedBorder());
        add(card3);

        
        btnStartGame = new JButton("Start Game");
        btnStartGame.setBounds(150,320,250,60);
        btnStartGame.setFont(new Font("Serif",Font.BOLD,32));
        btnStartGame.setForeground(Color.green);
        add(btnStartGame);
        btnNewGame = new JButton("New Game");
        btnNewGame.setBounds(150,320,250,60);
        btnNewGame.setFont(new Font("Serif",Font.BOLD,32));
        btnNewGame.setForeground(Color.green);
        btnNewGame.setVisible(false);
        add(btnNewGame);
        
        btnHigher = new JButton("Higher");
        btnHigher.setBounds(450,320,180,60);
        btnHigher.setFont(new Font("CenturyGothic",Font.BOLD,32));
        btnHigher.setForeground(Color.blue);
        btnHigher.setEnabled(false);
        add(btnHigher);
        btnLower = new JButton("Lower");
        btnLower.setBounds(650,320,180,60);
        btnLower.setFont(new Font("CenturyGothic",Font.BOLD,32));
        btnLower.setForeground(Color.red);
        btnLower.setEnabled(false);
        add(btnLower);
        
        score1 = new JTextField("Your Score: " + score);
        score1.setBounds(240,400,500,50);
        score1.setFont(new Font("CenturyGothic",Font.BOLD,32));
        score1.setBackground(Color.black);
        score1.setForeground(Color.yellow);
        score1.setEditable(false);
        score1.setBorder(BorderFactory.createEtchedBorder());
        add(score1);
 
        btnNewGame.requestFocus();
        btnStartGame.addActionListener(this);
        btnNewGame.addActionListener(this);
        btnHigher.addActionListener(this);
        btnLower.addActionListener(this);
    }

    public void paint(Graphics g)
    {
        showStatus("Rahul Reddy Thummala");
    }
    
    public void gameStart()
    {
        main = (int) (12 * Math.random());
        c1 = (int) (12 * Math.random());
        c2 = (int) (12 * Math.random());
        c3 = (int) (12 * Math.random());
        
        hint= card[main];
        first = card[c1];
        second = card[c2];
        third = card[c3];
        cardMain.setText(""+hint);
    }

    public void displayStat() 
    {
        if(TRIES<3) 
        {
            //JOptionPane.showMessageDialog(null,"You still have " + --chances + " tries.");
            ++TRIES;
        }
        else 
        {
            //JOptionPane.showMessageDialog(null,"Sorry, No More TRIES!");
            btnHigher.setEnabled(false);
            btnLower.setEnabled(false);
            btnNewGame.setEnabled(true);
            btnNewGame.requestFocus();
            
            if(score==3)
            {
                JOptionPane.showMessageDialog(null,"YOU GOT " + score + " out of " + MAX_SCORE + ". \nEXCELLENT!You are a GENIUS!.");
            }
            else if(score==2)
            {
                JOptionPane.showMessageDialog(null,"YOU GOT " + score + " out of " + MAX_SCORE + ".\nVERY GOOD! You are SMART.");
            }
            else if(score==1)
            {
                JOptionPane.showMessageDialog(null,"YOU GOT " + score + " out of " + MAX_SCORE + ".\nGOOD! You are NORMAL.");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"YOU GOT " + score + " out of " + MAX_SCORE + ".\nBETTER LUCK NEXT TIME!!!\nYou are an IDIOT!");
            }
            //JOptionPane.showConfirmDialog(null,"Try another game?","EXIT", JOptionPane.YES_NO_OPTION);
            continueGame();

        }
    }
        
    public void guessHigher()
    {
        if (TRIES==1)
        {
            btnNewGame.setEnabled(false);
            if(c1>main)
            {
                card1.setVisible(true);
                card1.setText(""+first);
                JOptionPane.showMessageDialog(null,"You win!\nYou still have " + --chances + " tries.");
                score++;
                score1.setText("Your Score: " + score);
                
            }
            else if(c1==main)
            {
                card1.setVisible(true);
                card1.setText(""+first);
                JOptionPane.showMessageDialog(null,"Draw!\nYou still have " + --chances + " tries.");
            }
            else
            {
                card1.setVisible(true);
                card1.setText(""+first);
                JOptionPane.showMessageDialog(null,"You lose!\nYou still have " + --chances + " tries.");
            }
            
        }
        else if (TRIES==2)
        {
            btnNewGame.setEnabled(false);
            if(c2>c1)
            {
                card2.setVisible(true);
                card2.setText(""+second);
                JOptionPane.showMessageDialog(null,"You win!\nYou still have " + --chances + " tries.");
                score++;
                score1.setText("Your Score: " + score);
            }
            else if(c2==c1)
            {
                card2.setVisible(true);
                card2.setText(""+second);
                JOptionPane.showMessageDialog(null,"Draw!\nYou still have " + --chances + " tries.");
            }
            else
            {
                card2.setVisible(true);
                card2.setText(""+second);
                JOptionPane.showMessageDialog(null,"You lose!\nYou still have " + --chances + " tries.");
            }
            
        }
        else
        {
            btnNewGame.setEnabled(false);
            if(c3>c2)
            {
                card3.setVisible(true);
                card3.setText(""+third);
                JOptionPane.showMessageDialog(null,"You win!\nSorry, No More TRIES!");
                score++;
                score1.setText("Your Score: " + score);
                
            }
            else if(c3==c2)
            {
                card3.setVisible(true);
                card3.setText(""+third);
                JOptionPane.showMessageDialog(null,"Draw!\nSorry, No More TRIES!");
            }
            else
            {
                card3.setVisible(true);
                card3.setText(""+third);
                JOptionPane.showMessageDialog(null,"You lose!\nSorry, No More TRIES!");
            }           
        }
    }
        
    public void guessLower()
    {
        if(TRIES==1)
        {
            btnNewGame.setEnabled(false);
            if(c1<main)
            {
                card1.setVisible(true);
                card1.setText(""+first);
                JOptionPane.showMessageDialog(null,"You win!\nYou still have " + --chances + " tries.");
                score++;
                score1.setText("Your Score: " + score);
            }
            else if(c1==main)
            {
                card1.setVisible(true);
                card1.setText(""+first);
                JOptionPane.showMessageDialog(null,"Draw!\nYou still have " + --chances + " tries.");
            }
            else
            {
                card1.setVisible(true);
                card1.setText(""+first);
                JOptionPane.showMessageDialog(null,"You lose!\nYou still have " + --chances + " tries.");
            }
        }
         else if (TRIES==2)
        {
            btnNewGame.setEnabled(false);
            if(c2<c1)
            {
                card2.setVisible(true);
                card2.setText(""+second);
                JOptionPane.showMessageDialog(null,"You win!\nYou still have " + --chances + " tries.");
                score++;
                score1.setText("Your Score: " + score);
            }
            else if(c2==c1)
            {
                card2.setVisible(true);
                card2.setText(""+second);
                JOptionPane.showMessageDialog(null,"Draw!\nYou still have " + --chances + " tries.");
            }
            else
            {
                card2.setVisible(true);
                card2.setText(""+second);
                JOptionPane.showMessageDialog(null,"You lose!\nYou still have " + --chances + " tries.");
            }
        }
        else
        {
            btnNewGame.setEnabled(false);
            if(c3<c2)
            {
                card3.setVisible(true);
                card3.setText(""+third);
                JOptionPane.showMessageDialog(null,"You win!\nSorry, No More TRIES!");
                score++;
                score1.setText("Your Score: " + score);
            }
            else if(c3==c2)
            {
                card3.setVisible(true);
                card3.setText(""+third);
                JOptionPane.showMessageDialog(null,"Draw!\nSorry, No More TRIES!");
            }
            else
            {
                card3.setVisible(true);
                card3.setText(""+third);
                JOptionPane.showMessageDialog(null,"You lose!\nSorry, No More TRIES!");
            }
        }
    }
    
    public void randomColor()
    {
        R = (int) (250 * Math.random());
        G = (int) (250 * Math.random());
        B = (int) (250 * Math.random());
        
        cardMain.setForeground(new Color(R,G,B));
        card1.setForeground(new Color(R,G,B));
        card2.setForeground(new Color(R,G,B));
        card3.setForeground(new Color(R,G,B));
    }
    
    public void newGame()
    {
        
        TRIES = 1;
        chances = 3;
        score = 0;
        score1.setText("Your Score: " + score);
        card1.setText("");
        card2.setText("");
        card3.setText("");
                
        main = (int) (12 * Math.random());
        c1 = (int) (12 * Math.random());
        c2 = (int) (12 * Math.random());
        c3 = (int) (12 * Math.random());
        
        hint = card[main];
        first = card[c1];
        second = card[c2];
        third = card[c3];
        cardMain.setText(""+hint);
        
        btnHigher.setEnabled(true);
        btnLower.setEnabled(true);
        
    }
    
    public void invisible()
    {
        card1.setVisible(false);
        card2.setVisible(false);
        card3.setVisible(false);
    }
    
    public void startGame()
    {
        btnStartGame.setVisible(false);
        btnNewGame.setVisible(true);
        btnNewGame.setEnabled(false);
        btnHigher.setEnabled(true);
        btnLower.setEnabled(true);
    }
    
    public void stopGame()
    {
        btnStartGame.setVisible(false);
        btnNewGame.setVisible(false);
        btnHigher.setVisible(false);
        btnLower.setVisible(false);
        score1.setVisible(false);
        cardMain.setVisible(false);
        card1.setVisible(false);
        card2.setVisible(false);
        card3.setVisible(false);
    }
    
    public void continueGame()
    {
        int n = JOptionPane.showConfirmDialog(null,"Would you like to continue?","Lower or Higher",JOptionPane.YES_NO_OPTION);
        if(n==0)
        {
            startGame();
            btnNewGame.setEnabled(true);
            btnHigher.setEnabled(false);
            btnLower.setEnabled(false);
            
        }
        else
        {
            stopGame();
            
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnStartGame)
        {
            gameStart();
            startGame();
        }
                
        if(e.getSource()==btnHigher)
        {
            guessHigher();
            displayStat();
        }
        
        if(e.getSource()==btnLower)
        {
            guessLower();
            displayStat();
        }

        if(e.getSource()==btnNewGame)
        {
            newGame();            
            randomColor();
            invisible();
        }
    }
}