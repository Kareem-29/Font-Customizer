/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class Application extends JFrame implements ActionListener, ItemListener{
    static String[] FO = {"Monospaced","Serif", "SanSerif"};
    static JComboBox Co1 = new JComboBox(FO);
    static String[] Size = {"1", "2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
    static JComboBox Co2 = new JComboBox(Size);
    static JButton BU = new JButton("Select Color");
    static JTextArea TE = new JTextArea(10, 30);
    static Color C;

    
    public static void main(String[] args) {
        Application A = new Application();
        A.setTitle("Main Frame");
        A.setVisible(true);
        A.setLayout(new FlowLayout());
        A.setSize(450, 250);
        A.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        A.add(Co1);
        A.add(Co2);
        A.add(BU);
        A.add(TE);
        
        Co1.addItemListener(A);
        Co2.addItemListener(A);
        BU.addActionListener(A);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        C = JColorChooser.showDialog(this, "Choose Text Color", C);
        TE.setForeground(C);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Font f = null;
        if (e.getStateChange() == 1){
           f= new Font ((String) Co1.getSelectedItem(), Font.PLAIN, Co2.getSelectedIndex());
           TE.setFont(f);
        }

    }
}
