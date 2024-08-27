import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import java.awt.*;

public class lookup2 extends JFrame{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JButton b3,b4;
    int c=0;
    int clk=0;
    int count=0;
    String[] product;
    public void lookup2(String PC){
        
        l6=new JLabel();
        l6.setText("");
        l6.setFont(new Font("Arial", Font.PLAIN, 15));
        l6.setBounds(562,53,100,15);

        l7=new JLabel();
        l7.setText("");
        l7.setFont(new Font("Arial", Font.PLAIN, 15));
        l7.setBounds(562,103,100,15);

        l8=new JLabel();
        l8.setText("");
        l8.setFont(new Font("Arial", Font.PLAIN, 15));
        l8.setBounds(562,153,100,15);

        l9=new JLabel();
        l9.setText("");
        l9.setFont(new Font("Arial", Font.PLAIN, 15));
        l9.setBounds(562,203,100,15);

        l5=new JLabel();
        l5.setText(PC);
        l5.setFont(new Font("Arial", Font.PLAIN, 25));
        l5.setBounds(5,5,545,30);
        l5.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        l5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent m) {
                clk++;
                addproducts(PC);
                l6.setText(String.valueOf(product[0]));
                l7.setText(String.valueOf(product[1]));
                l8.setText(String.valueOf(product[3]));
                l9.setText(String.valueOf(product[4]));
                l5.setOpaque(true);
                l5.setBackground(new Color(0, 87, 184));
                l5.setForeground(Color.white);
                l5.repaint();
                }
            });
        Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
            @Override
            public void eventDispatched(AWTEvent event) {
                if (!(event.getSource() instanceof JLabel)) {
                    l5.setOpaque(false);
                    l5.setForeground(Color.black);
                    l5.repaint(); 
                }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);
        



        JPanel panel1=new JPanel();
        panel1.setBounds(1,0,550,500);
        panel1.setBorder(BorderFactory.createLineBorder(Color.black));
        panel1.setBackground(Color.white);
        panel1.setLayout(null);

        l1=new JLabel();
        l1.setText("Product Code:");
        l1.setForeground(new Color(0,0,205));
        l1.setFont(new Font("Arial", Font.PLAIN, 12));
        l1.setBounds(560,30,100,15);

        JPanel panel2=new JPanel();
        panel2.setBackground(new Color(211, 211, 211));
        panel2.setBorder(BorderFactory.createLineBorder(Color.black));
        panel2.setBounds(560,50,220,20);

     

        l2=new JLabel();
        l2.setText("Description:");
        l2.setForeground(new Color(0,0,205));
        l2.setFont(new Font("Arial", Font.PLAIN, 12));
        l2.setBounds(560,80,100,15);

        JPanel panel3=new JPanel();
        panel3.setBackground(new Color(211, 211, 211));
        panel3.setBorder(BorderFactory.createLineBorder(Color.black));
        panel3.setBounds(560,100,220,20);

        l3=new JLabel();
        l3.setText("Inventory Quantity:");
        l3.setForeground(new Color(0,0,205));
        l3.setFont(new Font("Arial", Font.PLAIN, 12));
        l3.setBounds(560,130,100,15);

        JPanel panel4=new JPanel();
        panel4.setBackground(new Color(211, 211, 211));
        panel4.setBorder(BorderFactory.createLineBorder(Color.black));
        panel4.setBounds(560,150,220,20);

        l4=new JLabel();
        l4.setText("Standard Price:");
        l4.setForeground(new Color(0,0,205));
        l4.setFont(new Font("Arial", Font.PLAIN, 12));
        l4.setBounds(560,180,100,15);

        JPanel panel5=new JPanel();
        panel5.setBackground(new Color(211, 211, 211));
        panel5.setBorder(BorderFactory.createLineBorder(Color.black));
        panel5.setBounds(560,200,220,20);

        b3=new JButton();
        b3.setText("Ok");
        b3.setFont(new Font("Arial", Font.PLAIN, 20));
        b3.setContentAreaFilled(false);
        b3.setFocusable(false);
        b3.setOpaque(true);
        b3.setBackground(new Color(211, 211, 211));
        b3.setBounds(620,330,100,40);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clk>0){
                    count++;
                    clk=0;
                    dispose();
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
        b4.setBounds(620,400,100,40);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setLayout(null);
        add(l5);
        add(l6);
        add(l7);
        add(l8);
        add(l9);
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);
        

        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(b3);
        add(b4);
        setSize(800,500);
        setTitle("Product Lookup");
        ImageIcon icon = new ImageIcon("fir2.png");
        setIconImage(icon.getImage());
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    public void addproducts(String PC) {
        File file = new File("Products.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine() && c != 1) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length > 1) { // Check if there are at least two parts in the line
                    if (PC.equals(parts[0]) || PC.equals(parts[1])) {
                        product = parts;
                        c++;
                    }
                } else if (parts.length > 0 && PC.equals(parts[0])) {
                    product = parts;
                    c++;
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}