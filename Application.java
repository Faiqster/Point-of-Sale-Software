import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.event.*;
import java.io.*; 
import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Scanner;
import java.awt.event.KeyAdapter;

public class Application extends JFrame {
    String[] parts;
    JLabel l1, l2, l3, l4, l5, l6, l7;
    private JLabel l8;
    private JTextField t1, t2;
    private JTable t;
    private JButton addPro, Look_up;
    private JMenuItem item11;
    int c = 0;
    int count = 1;
    int ft = 0;
    int close = 1;
    int InCash = 0;
    double sum = 0, sum1 = 0, tsum = 0, ssum = 0;
    private String[] aproduct = new String[6];
    public String AP;
    private identifycashier identifyCashier;

    public void Application() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        JMenuBar Menu_bar = new JMenuBar();
        JMenu Menu1 = new JMenu("File");
        JMenuItem item4 = new JMenuItem("Save Current Transaction");
        
        JMenuItem item5 = new JMenuItem("Lock Register");

        JMenuItem item6 = new JMenuItem("Exit");
        item6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == item6) {
                    int choice = JOptionPane.showConfirmDialog(null, "Are you sure u want to leave without saving?",
                            "Leave Application?", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                }
            }
        });
        Menu1.add(item4);
        Menu1.addSeparator();
        Menu1.add(item5);
        Menu1.addSeparator();
        Menu1.add(item6);
        JMenu Menu2 = new JMenu("Edit");
        item11 = new JMenuItem("Delete/Clear Current Transaction");

        Menu2.add(item11);

        JMenu Menu4 = new JMenu("Security");
        JMenuItem item16 = new JMenuItem("Identify Cashier");
        item16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (close == 1) {
                    identifyCashier = new identifycashier();
                    identifyCashier.identifycashier();
                    openregister();
                    item16.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Please lock the register.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JMenuItem item17 = new JMenuItem("Switch Cashier");
        item17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (close == 1) {
                    switchcashier sc = new switchcashier();
                    sc.switchcashier();
                    openregister();
                } else {
                    JOptionPane.showMessageDialog(null, "Please lock the register.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JMenuItem item18 = new JMenuItem("Show Current Cashier");
        item18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Application.this, "Current Cashier: " + getCurrentCashierName(),
                        "Current Cashier", JOptionPane.PLAIN_MESSAGE);
            }
        });
        
        Menu4.add(item16);
        Menu4.add(item17);
        Menu4.addSeparator();
        Menu4.add(item18);
        JMenu Menu5 = new JMenu("Help");
        JMenuItem item20 = new JMenuItem("About FIR");
        item20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aboutus au = new aboutus();
                au.aboutus();
            }
        });

        Menu5.addSeparator();
        Menu5.add(item20);
        Menu_bar.add(Menu1);
        Menu_bar.add(Menu2);
        Menu_bar.add(Menu4);
        Menu_bar.add(Menu5);

        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 0, screenSize.width, 60);
        panel1.setBackground(new Color(211, 211, 211));
        panel1.setLayout(null);
        addPro = new JButton("Add");
        addPro.setFont(new Font("Arial", Font.BOLD, 9));
        ImageIcon I1 = new ImageIcon("Addp.png");
        Image image = I1.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        addPro.setBounds((screenSize.width - 80), 5, 54, 50);
        addPro.setFocusable(false);
        addPro.setToolTipText("Add New Product(s)");
        addPro.setContentAreaFilled(false);
        addPro.setIconTextGap(1);
        addPro.setVerticalTextPosition(SwingConstants.BOTTOM);
        addPro.setHorizontalTextPosition(SwingConstants.CENTER);
        addPro.setIcon(scaledIcon);
        addPro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                New_Products addproducts = new New_Products();
                addproducts.Add_NewPro();
            }
        });

        panel1.add(addPro);

        JPanel panel3 = new JPanel();
        panel3.setBounds(20, 480, (screenSize.width - 60), 140);
        panel3.setBackground(new Color(211, 211, 211));
        panel3.setBorder(BorderFactory.createLineBorder((new Color(0, 0, 205)), 5));
        panel3.setLayout(new BorderLayout());

        Look_up = new JButton("Lookup");
        Look_up.setFont(new Font("Arial", Font.BOLD, 9));
        ImageIcon I2 = new ImageIcon("Lookup.png");
        Image image1 = I2.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(image1);
        Look_up.setBounds(10, 5, 70, 50);
        Look_up.setFocusable(false);
        Look_up.setToolTipText("Lookup");
        Look_up.setContentAreaFilled(false);
        Look_up.setIconTextGap(1);
        Look_up.setVerticalTextPosition(SwingConstants.BOTTOM);
        Look_up.setHorizontalTextPosition(SwingConstants.CENTER);
        Look_up.setIcon(scaledIcon1);
        Look_up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lookup look_up = new lookup();
                look_up.lookup();
            }
        });

        panel1.add(Look_up);

        t2 = new JTextField();
        t2.setText(String.valueOf(sum1));
        t2.setBounds((screenSize.width - 110), 422, 50, 20);
        t2.setFont(new Font("Arial", Font.BOLD, 20));
        t2.setForeground(new Color(0, 0, 205));
        t2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (t2.getText().equals("0.0")) {
                    t2.setText("");
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (t2.getText().equals("")) {
                    t2.setText("0.0");
                }
            }
        });

        l5 = new JLabel();
        l5.setText(String.valueOf(sum));
        l5.setBounds((screenSize.width - 160), 400, 115, 20);
        l5.setFont(new Font("Arial", Font.BOLD, 20));

        l8 = new JLabel();
        l8.setText("Register Locked");
        l8.setForeground(new Color(255, 0, 0));
        l8.setHorizontalAlignment(SwingConstants.CENTER);
        l8.setSize(300, 300);
        l8.setFont(new Font("Arial", Font.BOLD, 60));
        l8.setForeground(Color.black);
        panel3.add(l8, BorderLayout.CENTER);

        l1 = new JLabel();
        l1.setText("Enter Product Code:");
        l1.setBounds(20, 70, 150, 30);
        l1.setFont(new Font("Arial", Font.BOLD, 15));

        l2 = new JLabel();
        l2.setText("SubTotal: $" + (String.valueOf(sum)));
        l2.setBounds((screenSize.width - 220), 400, 200, 20);
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l2.setForeground(new Color(0, 0, 205));

        l3 = new JLabel();
        l3.setText("Tax: $");
        l3.setBounds((screenSize.width - 170), 422, 115, 20);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setForeground(new Color(0, 0, 205));

        l4 = new JLabel();
        l4.setText("Total: $" + (String.valueOf(sum1)));
        l4.setBounds((screenSize.width - 183), 446, 200, 20);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setForeground(new Color(0, 0, 205));
        String[] columnNames = { "No.", "Product Code", "Description", "Quantity", "Price", "Extended Price" };
        MyTableModel tableModel = new MyTableModel(columnNames);
        t = new JTable(tableModel);
        JTableHeader header = t.getTableHeader();
        header.setBackground(new Color(211, 211, 211));
        header.setFont(new Font("Arial", Font.BOLD, 20));

        t.setFont(new Font("Arial", Font.BOLD, 16));
        t.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = t.getSelectedRow();
                if (selectedRow != -1) {
                    int selectedColumn = t.getSelectedColumn();
                    Object selectedValue = t.getValueAt(selectedRow, selectedColumn);
                }
            }
        });

        t1 = new JTextField();
        t1.setBounds(172, 75, 200, 20);
        t1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    AP = String.valueOf(t1.getText());
                    addproduct(AP);

                    if (c == 1) {
                        item4.setEnabled(true);
                        t2.setEnabled(false);
                        sum = (Double.valueOf(sum) + (1 * Double.valueOf(aproduct[4])));
                        sum1 = (Double.valueOf(sum) + Double.valueOf(t2.getText()));
                        l4.setText("Total: $" + String.valueOf(sum1));
                        l2.setText("SubTotal: $" + (String.valueOf(sum)));
                        String[] pro = { String.valueOf(count++), aproduct[0], aproduct[1], "1",
                                aproduct[4],
                                String.valueOf(1 * Double.valueOf(aproduct[4])) };
                        tableModel.addRow(pro);
                        t1.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Product not found!!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        t1.setText("");
                    }

                }
            }
        });
        item11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t2.setEnabled(true);
                tableModel.clearTable();
                sum = 0;
                sum1 = 0;
                l2.setText("SubTotal: $" + String.valueOf(sum));
                l4.setText("Total: $" + String.valueOf(sum1));
            }
        });
        item5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lockregister();
            }
        });
        if (ft == 0) {
            lockregister();
            ft = 1;
        }
        item4.setEnabled(false);
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    try (FileWriter writer = new FileWriter("transaction.txt", true)) {
                        writer.write("***************FIR***************\n" +"Cashier Name: " + getCurrentCashierName() + "\n" + "Subtotal: $" + tsum + "\n" + "Tax: $ " + t2.getText() + "\n" + "Total: $" + sum1 + "\n****ThankYou for Shopping****" +  System.lineSeparator());
                        JOptionPane.showMessageDialog(null, "Transaction saved successfully",
                                "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(null, "***************FIR****************\n" +"Cashier Name: " + getCurrentCashierName() + "\n" + "Subtotal: $" + tsum + "\n" + "Tax: $ " + t2.getText() + "\n" + "Total: $" + sum1 + "\n****ThankYou for Shopping****",
                                "Bill", JOptionPane.PLAIN_MESSAGE);
                        t2.setEnabled(true);
                        tableModel.clearTable();
                        sum = 0;
                        sum1 = 0;
                        l2.setText("SubTotal: $" + String.valueOf(sum));
                        l4.setText("Total: $" + String.valueOf(sum1));
                    } catch (IOException ex) {
                        System.out.println("File not found");
                    }
            }
        });

        JScrollPane scrollPane = new JScrollPane(t);

        add(scrollPane).setBounds(20, 110, (screenSize.width - 60), 280);
        add(panel3);
        setJMenuBar(Menu_bar);
        add(t2);
        add(t1);
        add(l1);
        add(l2);
        add(l3);
        add(l4);

        add(panel1);
        setLayout(new BorderLayout());
        setTitle("FIR");
        ImageIcon icon = new ImageIcon("fir2.png");
        setIconImage(icon.getImage());
        setSize(screenSize.width, screenSize.height);
        setUndecorated(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addproduct(String AP) {
        File file = new File("Products.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (AP.equals(parts[0])) {
                    aproduct = Arrays.copyOf(parts, parts.length);
                    c = 1;
                    break;
                } else {
                    c = 0;
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    class MyTableModel extends AbstractTableModel {
        private String[] columnNames;
        private Object[][] data;

        public void clearTable() {
            data = new Object[0][columnNames.length];
            fireTableDataChanged();
        }

        public MyTableModel(String[] columnNames) {
            this.columnNames = columnNames;
            this.data = new Object[0][columnNames.length];
        }

        public void addRow(String[] rowData) {
            int rowCount = getRowCount();
            Object[][] newData = new Object[rowCount + 1][getColumnCount()];
            for (int i = 0; i < rowCount; i++) {
                System.arraycopy(data[i], 0, newData[i], 0, getColumnCount());
            }
            System.arraycopy(rowData, 0, newData[rowCount], 0, getColumnCount());
            data = newData;
            fireTableDataChanged();
        }

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 3;
        }

        @Override
        public void setValueAt(Object value, int row, int col) {
            if (col == 3) {
                data[row][col] = value;
                updateExtendedPrice(row);
            } else if (col == 4) {
                data[row][col] = value;
                updateExtendedPrice(row);
            } else {
                data[row][col] = value;
            }
            fireTableCellUpdated(row, col);
        }

        private void updateExtendedPrice(int row) {
            Object quantity = data[row][3];
            Object price = data[row][4];

            if (quantity != null && price != null) {
                double extendedPrice = Double.parseDouble(quantity.toString()) * Double.parseDouble(price.toString());
                data[row][5] = extendedPrice;
                tsum = 0;
                for (int i = 0; i < getRowCount(); i++) {
                    Object extendedPriceValue = data[i][5];
                    if (extendedPriceValue != null) {
                        tsum += Double.parseDouble(extendedPriceValue.toString());
                    }
                }

                sum1 = tsum + Double.parseDouble(t2.getText());

                l4.setText("Total: $" + String.valueOf((Math.round(sum1))));
                l2.setText("SubTotal: $" + (String.valueOf(Math.round(tsum))));

                fireTableCellUpdated(row, 5);
            }
        }
    }

    private void openregister() {
        close = 0;
        l8.setText("Register Open");
        l8.setForeground((Color.black));
        t2.setEnabled(true);
        addPro.setEnabled(true);
        Look_up.setEnabled(true);
        t1.setEnabled(true);
        t.setEnabled(true);
        item11.setEnabled(true);
    }

    private void lockregister() {
        close = 1;
        if (l8 != null) {
            l8.setText("Register Locked");
            l8.setForeground(new Color(255, 0, 0));
        }
        t2.setEnabled(false);
        addPro.setEnabled(false);
        Look_up.setEnabled(false);
        t1.setEnabled(false);
        t.setEnabled(false);
        item11.setEnabled(false);
    }

    private static String currentCashierName = "";

    public static void setCurrentCashierName(String name) {
        currentCashierName = name;
    }

    public static String getCurrentCashierName() {
        return currentCashierName;
    }
   
}