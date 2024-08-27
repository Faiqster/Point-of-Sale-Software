import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class switchcashier extends JFrame {
    JLabel l1, l2, l3, l4;
    JTextField u;
    JPasswordField p;
    JButton b1, b2;

    private static String currentCashierName = "";

    public static String getCurrentCashierName() {
        return currentCashierName;
    }

    public void switchcashier() {
        setTitle("Cashier LOGIN");
        ImageIcon icon = new ImageIcon("fir2.png");
        setIconImage(icon.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(400, 350);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(211,211,211));


        l1 = new JLabel("Cashier name");
        l1.setBounds(25, 90, 500, 50);

        l2 = new JLabel("Password");
        l2.setBounds(25, 140, 500, 50);

        l3 = new JLabel("Cashier Login");
        l3.setBounds(120, 30, 500, 50);
        l3.setFont(new Font("arial",Font.BOLD,18));

        add(l1);
        add(l2);
        add(l3);

        u = new JTextField();
        u.setBounds(150, 100, 200, 30);

        p = new JPasswordField();
        p.setBounds(150, 150, 200, 30);

        add(u);
        add(p);

        b1 = new JButton("Cancel");
        b1.setBounds(150, 250, 95, 30);
        b2 = new JButton("OK");
        b2.setBounds(150, 200, 95, 30);

        add(b1);
        add(b2);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(switchcashier.this, "Cashier is not switched.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                dispose(); 
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cashierName = u.getText();
                String cashierPassword = String.valueOf(p.getPassword());

                if (cashierName.isEmpty() || cashierPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(switchcashier.this, "Please fill in both fields.", "Error", JOptionPane.ERROR_MESSAGE);
                } 

                if (verifycashier(cashierName, cashierPassword)) {
                    Application.setCurrentCashierName(cashierName);
                    dispose();
                    JOptionPane.showMessageDialog(switchcashier.this, "Cashier Switched.", "Success", JOptionPane.PLAIN_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(switchcashier.this, "Cashier not found \n Are u sure you are registered cashier.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        setLayout(null);
        setVisible(true);
    }

    public boolean verifycashier(String username, String password) {
        File file = new File("cashier.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "File not found", "Message", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
  }      