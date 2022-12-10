import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.util.*;
import java.awt.GridLayout;
import java.lang.Math;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculatortest implements ActionListener {// use A.L to get notified about clicking a button
    JFrame frame;
    JTextField textfield;
    JButton[] numb = new JButton[10];
    JButton[] funcb = new JButton[8];
    JButton[] onenum = new JButton[6];

    JButton addb, subb, divb, mulb;
    JButton decb, eqb, clrb, delb;
    JButton sqtb, squareb, pieb, eb, expob, factb;

    JPanel panel;

    double num1, num2, res = 0;
    int fact = 1;
    char operator;

    Calculatortest() {
        frame = new JFrame();
        frame.setTitle("Scientific Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// x button
        frame.setResizable(false);// cannot resize
        frame.setSize(500, 750);
        frame.getContentPane().setBackground(Color.PINK);
        frame.setLayout(null);
        ImageIcon img = new ImageIcon("icon.jpeg");
        Image newimg = img.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon reimg = new ImageIcon(newimg);

        Font myfont = new Font("Serif", Font.BOLD, 20);
        Font font1 = new Font("Serif", Font.BOLD, 15);

        JLabel label = new JLabel();
        label.setBackground(Color.white);
        label.setForeground(new Color(193, 71, 233));// text color
        label.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 10));
        label.setOpaque(true);
        label.setFont(myfont);
        label.setText("Welcome to Togepi's Calculator! ");
        label.setIcon(reimg);
        label.setVerticalAlignment(JLabel.TOP);
        label.setBounds(0, 0, 485, 150);

        textfield = new JTextField();
        textfield.setBounds(25, 175, 420, 50);
        textfield.setEditable(false);// user cant edit directly only using button
        textfield.setBackground(new Color(248, 249, 136));
        textfield.setFont(myfont);

        addb = new JButton("+");
        subb = new JButton("-");
        mulb = new JButton("*");
        divb = new JButton("/");
        decb = new JButton(".");
        clrb = new JButton("CLEAR");
        delb = new JButton("DEL");
        eqb = new JButton("=");
        expob = new JButton("x\u02b8");
        eb = new JButton("e");
        squareb = new JButton("x\u00B2");
        sqtb = new JButton("\u221A");
        pieb = new JButton("\u03C0");
        factb = new JButton("n!");

        funcb[0] = addb;
        funcb[1] = subb;
        funcb[2] = mulb;
        funcb[3] = divb;
        funcb[4] = decb;
        funcb[5] = clrb;
        funcb[6] = delb;
        funcb[7] = eqb;

        onenum[0] = expob;
        onenum[1] = eb;
        onenum[2] = pieb;
        onenum[3] = factb;
        onenum[4] = sqtb;
        onenum[5] = squareb;

        for (int i = 0; i < 8; i++) {
            funcb[i].addActionListener(this);
            funcb[i].setFocusable(false);
        }

        for (int i = 0; i < 6; i++) {
            onenum[i].addActionListener(this);
            onenum[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numb[i] = new JButton(String.valueOf(i));
            numb[i].addActionListener(this);
            numb[i].setFocusable(false);
            numb[i].setBackground(new Color(229, 184, 244));
            numb[i].setForeground(new Color(129, 12, 168));

        }

        delb.setBounds(345, 235, 100, 50);
        delb.setFont(myfont);
        delb.setBackground(new Color(192, 238, 228));
        delb.setForeground(new Color(129, 12, 168));
        clrb.setBounds(240, 235, 100, 50);
        clrb.setBackground(new Color(192, 238, 228));
        clrb.setFont(font1);
        clrb.setForeground(new Color(129, 12, 168));

        pieb.setBounds(25, 235, 100, 50);
        pieb.setBackground(new Color(192, 238, 228));
        pieb.setFont(font1);
        pieb.setForeground(new Color(129, 12, 168));

        factb.setBounds(130, 235, 100, 50);
        factb.setBackground(new Color(192, 238, 228));
        factb.setFont(font1);
        factb.setForeground(new Color(129, 12, 168));

        addb.setBackground(new Color(192, 238, 228));
        addb.setForeground(new Color(129, 12, 168));
        addb.setFont(myfont);

        subb.setBackground(new Color(192, 238, 228));
        subb.setForeground(new Color(129, 12, 168));
        subb.setFont(myfont);

        mulb.setBackground(new Color(192, 238, 228));
        mulb.setForeground(new Color(129, 12, 168));
        mulb.setFont(myfont);

        divb.setBackground(new Color(192, 238, 228));
        divb.setForeground(new Color(129, 12, 168));
        divb.setFont(myfont);

        decb.setBackground(new Color(192, 238, 228));
        decb.setForeground(new Color(129, 12, 168));
        decb.setFont(myfont);

        eqb.setBackground(new Color(192, 238, 228));
        eqb.setForeground(new Color(129, 12, 168));
        eqb.setFont(myfont);

        expob.setBackground(new Color(192, 238, 228));
        expob.setForeground(new Color(129, 12, 168));
        expob.setFont(myfont);

        eb.setBackground(new Color(192, 238, 228));
        eb.setForeground(new Color(129, 12, 168));
        eb.setFont(myfont);

        pieb.setBackground(new Color(192, 238, 228));
        pieb.setForeground(new Color(129, 12, 168));
        pieb.setFont(myfont);

        factb.setBackground(new Color(192, 238, 228));
        factb.setForeground(new Color(129, 12, 168));
        factb.setFont(myfont);

        sqtb.setBackground(new Color(192, 238, 228));
        sqtb.setForeground(new Color(129, 12, 168));
        sqtb.setFont(myfont);

        squareb.setBackground(new Color(192, 238, 228));
        squareb.setForeground(new Color(129, 12, 168));
        squareb.setFont(myfont);

        panel = new JPanel();
        JLabel lowlabel = new JLabel();
        panel.setBackground(new Color(255, 116, 177));
        panel.setBounds(25, 295, 420, 300);
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        panel.add(numb[1]);
        panel.add(numb[2]);
        panel.add(numb[3]);
        panel.add(addb);
        panel.add(numb[4]);
        panel.add(numb[5]);
        panel.add(numb[6]);
        panel.add(subb);
        panel.add(numb[7]);
        panel.add(numb[8]);
        panel.add(numb[9]);
        panel.add(mulb);
        panel.add(divb);
        panel.add(numb[0]);
        panel.add(decb);
        panel.add(eqb);
        panel.add(eb);
        panel.add(expob);
        panel.add(squareb);
        panel.add(sqtb);

        ImageIcon ig = new ImageIcon("pooka.jpg");
        Image newig = ig.getImage().getScaledInstance(240, 169, Image.SCALE_DEFAULT);
        ImageIcon re = new ImageIcon(newig);
        lowlabel.setForeground(new Color(193, 71, 233));
        lowlabel.setText("60004210201 and 60004210209");
        lowlabel.setBackground(Color.white);
        lowlabel.setBounds(0, 605, 485, 105);
        lowlabel.setOpaque(true);

        lowlabel.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 10));
        lowlabel.setIcon(re);

        frame.add(factb);
        frame.add(lowlabel);
        frame.add(pieb);
        frame.add(panel);
        frame.add(delb);
        frame.add(clrb);
        frame.add(label);
        frame.add(textfield);
        frame.setVisible(true);
        frame.validate();
    }

    public static void main(String[] args) {
        Calculatortest calc = new Calculatortest();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numb[i])// if the event is clicking the number button
            {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));// concat the number button value with
                                                                                 // field
            }
        }

        if (e.getSource() == decb) {
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == pieb) {
            textfield.setText(textfield.getText().concat("3.142"));
        }

        if (e.getSource() == addb) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == subb) {

            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == mulb) {

            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if (e.getSource() == divb) {

            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }

        if (e.getSource() == expob) {

            num1 = Double.parseDouble(textfield.getText());
            textfield.setText("");
            //textfield.setText(textfield.getText().concat("^"));
            
            operator = '^';
            //num2 = Double.parseDouble(textfield.getText());
        }
        if (e.getSource() == eb) {
            textfield.setText("2.71828");
        }
        if (e.getSource() == pieb) {
            textfield.setText("3.142");
        }
        if (e.getSource() == factb) {

            num1 = Double.parseDouble(textfield.getText());
            textfield.setText(textfield.getText().concat("!"));
            operator = '!';
        }

        if (e.getSource() == sqtb) {

            num1 = Double.parseDouble(textfield.getText());
            operator = 'S';
            textfield.setText("^1/2");
        }
        if (e.getSource() == squareb) {

            num1 = Double.parseDouble(textfield.getText());
            operator = 's';
            textfield.setText("^2");
        }

        if (e.getSource() == eqb) {

            switch (operator) {
                case '+': {
                    num2 = Double.parseDouble(textfield.getText());

                    res = num1 + num2;
                    break;

                }
                case '-': {
                    num2 = Double.parseDouble(textfield.getText());

                    res = num1 - num2;
                    break;

                }
                case '*': {
                    num2 = Double.parseDouble(textfield.getText());

                    res = num1 * num2;
                    break;

                }
                case '/': {
                    num2 = Double.parseDouble(textfield.getText());

                    if (num2 != 0) {

                        res = num1 / num2;

                    } else {
                        textfield.setText("Error");
                    }
                    break;

                }
                case '!': {
                    fact = 1;
                    for (int i = 1; i <= num1; i++) {
                        fact = fact * i;
                    }
                    res = fact;
                    break;

                }
                case 'S':// sqrt
                {
                    res = Math.sqrt(num1);
                    break;
                }
                case 's': {
                    res = (num1) * (num1);
                    break;
                }
                case '^': {

                    num2 = Double.parseDouble(textfield.getText());
        
                    res = Math.pow(num1, num2);
                    break;
                }

            }

            textfield.setText(String.valueOf(res));// if u have to use previous result
            num1 = res;

        }

        if (e.getSource() == clrb)

        {
            textfield.setText("");
        }
        if (e.getSource() == delb) {
            String string = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }

    }

}