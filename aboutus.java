import java.awt.*;
import javax.swing.*;

public class aboutus extends JFrame {
    
    public void aboutus(){

        setTitle("Project FIR");
        ImageIcon icon = new ImageIcon("fir2.png");
        setIconImage(icon.getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setResizable(false);

        ImageIcon i = new ImageIcon("background.jpg");
        Image image = i.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel background = new JLabel(scaledIcon);
        setContentPane(background);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

}