import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class lookup extends JFrame {
    JLabel l1,l2;
    JButton b1,b2,b3,b4;
    JTextField t1;
    int count=0;
    public String PC;
    public String Des;
    public void lookup(){
        
        l1=new JLabel("Lookup by Description");
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        l1.setForeground(new Color(0,0,205));
        l1.setBounds(10,10,250,20);

        l2=new JLabel("Enter Search Characters:");
        l2.setFont(new Font("Arial", Font.BOLD, 15));
        l2.setForeground(Color.red);
        l2.setBounds(10,50,200,15);

        t1=new JTextField();
        t1.setBounds(200,48,135,20);

        b1=new JButton();
        b1.setText("Lookup by Product Description");
        b1.setFont(new Font("Arial", Font.PLAIN, 18));
        b1.setContentAreaFilled(false);
        b1.setFocusable(false);
        b1.setOpaque(true);
        b1.setBackground(new Color(211, 211, 211));
        b1.setBounds(24,80,290,40);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count=0;
                l1.setText("Lookup by Description");
            }
        });
    

        b2=new JButton();
        b2.setText("Lookup by Product Code");
        b2.setFont(new Font("Arial", Font.PLAIN, 18));
        b2.setContentAreaFilled(false);
        b2.setFocusable(false);
        b2.setOpaque(true);
        b2.setBackground(new Color(211, 211, 211));
        b2.setBounds(24,140,290,40);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l1.setText("Lookup by Product Code");
                count++;
            }
        });

        b3=new JButton();
        b3.setText("Ok");
        b3.setFont(new Font("Arial", Font.PLAIN, 20));
        b3.setContentAreaFilled(false);
        b3.setFocusable(false);
        b3.setOpaque(true);
        b3.setBackground(new Color(211, 211, 211));
        b3.setBounds(28,200,100,40);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!t1.getText().equals("")){
                if(count>0){
                    PC=String.valueOf(t1.getText());
                    
                    if (verifyproductcode(PC)) {
                        dispose();
                        lookup2 look=new lookup2();
                        look.lookup2(PC);
                    } else {
                        JOptionPane.showMessageDialog(null, "Product Not Found!!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    
                }
                else{
                    PC=String.valueOf(t1.getText());
                    if (verifyproductcode(PC)) {
                        dispose();
                        lookup2 look=new lookup2();
                        look.lookup2(PC);
                    } else {
                        JOptionPane.showMessageDialog(null, "Product Not Found!!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please Enter Search Characters!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        b4=new JButton();
        b4.setText("Cancel");
        b4.setFont(new Font("Arial", Font.PLAIN, 20));
        b4.setContentAreaFilled(false);
        b4.setFocusable(false);
        b4.setOpaque(true);
        b4.setBackground(new Color(211, 211, 211));
        b4.setBounds(208,200,100,40);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setLayout(null);

        add(l1);
        add(l2);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(t1);
        setTitle("Product Lookup");
        ImageIcon icon = new ImageIcon("fir2.png");
        setIconImage(icon.getImage());
        setSize(350,300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    public boolean verifyproductcode(String pro) {
        File file = new File("Products.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if(count==0){
                    if (parts.length == 6 && parts[1].equals(pro)) {
                        return true;
                    }
                }
                else{
                    if (parts.length == 6 && parts[0].equals(pro)) {
                        return true;
                    }
                }

            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
}