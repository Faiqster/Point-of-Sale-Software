import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.w3c.dom.Text;

public class New_Products extends JFrame {
    JLabel L1, L2, L3, L4, L5, L6;
    JTextField T1, T2, T3, T4, T5, T6;
    JButton B1, B2, B3;
    ImageIcon I1,I2,I3;

    public void Add_NewPro() {
        Container container = getContentPane();
        container.setLayout(null);
        L1 = new JLabel("Enter Product Code:");
        L1.setFont(new Font("Arial", Font.BOLD, 20));
        L1.setBounds(130, 50, 200, 20);
        container.add(L1);
        L2 = new JLabel("Description One:");
        L2.setFont(new Font("Arial", Font.BOLD, 20));
        L2.setBounds(163, 100, 200, 20);
        container.add(L2);
        L3 = new JLabel("Description Two:");
        L3.setFont(new Font("Arial", Font.BOLD, 20));
        L3.setBounds(163, 150, 200, 20);
        container.add(L3);
        L4 = new JLabel("Inventory Quantity:");
        L4.setFont(new Font("Arial", Font.BOLD, 20));
        L4.setBounds(141, 200, 200, 20);
        container.add(L4);
        L5 = new JLabel("Standard Price:");
        L5.setFont(new Font("Arial", Font.BOLD, 20));
        L5.setBounds(176, 250, 200, 20);
        container.add(L5);
        L6 = new JLabel("Current Cost:");
        L6.setFont(new Font("Arial", Font.BOLD, 20));
        L6.setBounds(195, 300, 200, 20);
        container.add(L6);

        T1 = new JTextField();
        T1.setBounds(340, 50, 200, 20);
        container.add(T1);
        T2 = new JTextField();
        T2.setBounds(340, 100, 200, 20);
        container.add(T2);
        T3 = new JTextField();
        T3.setBounds(340, 150, 200, 20);
        container.add(T3);
        T4 = new JTextField();
        T4.setText("0");
        T4.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(T4.getText().equals("0")){
                    T4.setText("");
                }
                
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(T4.getText().equals("")){
                    T4.setText("0");
                }
                else{
                    if(checkInteger(String.valueOf(T4.getText()))==false){
                        T4.setText("0");
                    }
                }
            }
        });
        
        T4.setBounds(340, 200, 200, 20);
        container.add(T4);
        T5 = new JTextField();
        T5.setText("0.00");
        T5.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(T5.getText().equals("0.00")){
                    T5.setText("");
                }
                
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(T5.getText().equals("")){
                    T5.setText("0.00");
                }
                else{
                    if(checkFloat(String.valueOf(T5.getText()))==false){
                        T5.setText("0.00");
                    }
                }
            }
        });
        T5.setBounds(340, 250, 200, 20);
        container.add(T5);
        T6 = new JTextField();
        T6.setText("0.00");
        T6.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(T6.getText().equals("0.00")){
                    T6.setText("");
                }
                else{
                    T6.getText();
                }
                
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(T6.getText().equals("")){
                    T6.setText("0.00");
                }
                else{
                    if(checkFloat(String.valueOf(T6.getText()))==false){
                        T6.setText("0.00");
                    }
                }   
            }
        });
        T6.setBounds(340, 300, 200, 20);
        container.add(T6);
        
        I1 = new ImageIcon("Save.png");
        Image image = I1.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        B1 = new JButton("Save");
        B1.setFont(new Font("Arial", Font.BOLD, 20));
        B1.setBounds(140,370, 105,50);
        B1.setFocusable(false);
        B1.setToolTipText("Save the form");
        B1.setContentAreaFilled(false);
        B1.setIconTextGap(2);
        B1.setIcon(scaledIcon);
        B1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!T1.getText().isEmpty() && !T2.getText().isEmpty() && !T3.getText().isEmpty() &&
                !T4.getText().isEmpty() && !T5.getText().isEmpty() && !T6.getText().isEmpty()) {
                saveToFile(T1.getText(), T2.getText(), T3.getText(), T4.getText(), T5.getText(), T6.getText());
                JOptionPane.showMessageDialog(null, "Product Successfully Saved", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please Fill All The Entities", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        I2 = new ImageIcon("Clear.png");
        Image image1 = I2.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(image1);
        B2 = new JButton("Clear"); 
        B2.setFont(new Font("Arial", Font.BOLD, 20));
        B2.setBounds(290,370, 120,50);
        B2.setFocusable(false);
        B2.setToolTipText("Clear the form");
        B2.setContentAreaFilled(false);
        B2.setIconTextGap(2);
        B2.setIcon(scaledIcon1);
        B2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                        T1.setText("");
                        T2.setText("");
                        T3.setText("");
                        T4.setText("0");
                        T5.setText("0.00");
                        T6.setText("0.00");        
            }
        });

        I3 = new ImageIcon("Exit.png");
        Image image2 = I3.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(image2);
        B3 = new JButton("Exit"); 
        B3.setFont(new Font("Arial", Font.BOLD, 20));
        B3.setBounds(440,370, 105,50);
        B3.setFocusable(false);
        B3.setToolTipText("Close the form");
        B3.setContentAreaFilled(false);
        B3.setIconTextGap(2);
        B3.setIcon(scaledIcon2);
        B3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    dispose();
            }
        });

        container.add(B1);
        container.add(B2);
        container.add(B3);
        setSize(700, 500);
        setTitle("Add New Products/Inventory");
        ImageIcon icon = new ImageIcon("fir2.png");
        setIconImage(icon.getImage());
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
        public boolean checkInteger(String T) {
            String input = T.trim();
            try {
                int intValue = Integer.parseInt(input);
                return true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please Enter An Integer.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        public boolean checkFloat(String T) {
            String input = T.trim();
            try {
                float FloatValue = Float.parseFloat(input);
                return true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please Enter Float Value.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        public void saveToFile(String T1,String T2,String T3,String T4,String T5,String T6) {
        try (FileWriter writer = new FileWriter("Products.txt", true)) {
            writer.write(T1 + "," + T2 + "," + T3 + "," + T4 + "," + T5 + "," + T6+ System.lineSeparator());
        } catch (IOException ex) {
            System.out.println("File not found");
        }
    }
}