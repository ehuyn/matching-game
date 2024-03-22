import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {
    public static void main(String[] args) {
        startScreen h = new startScreen();
        h.setContentPane(h.mainPanel);
        h.setTitle("Card Matching Game");
        h.setSize(1200, 800);
        h.setVisible(true);
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
/*
public class GUI implements ActionListener{

    private JFrame frame;
    private JButton button1;
    private JButton button2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;

    public GUI(){

        button1 = new JButton("instructions");
            button1.addActionListener(this);

        label1 = new JLabel("Card Game");
        label2 = new JLabel("label 2");
        label3 = new JLabel("how to play the game");
        panel1 = new JPanel();
            panel1.setBorder(BorderFactory.createEmptyBorder());
            panel1.setName("Card Game");
            panel1.add(label1);

        panel2 = new JPanel();
            panel2.setBorder(BorderFactory.createEmptyBorder());
            panel2.setName("Second Label");
            panel2.add(label2);

        panel3 = new JPanel();
            panel3.setBorder(BorderFactory.createEmptyBorder());
            panel3.setName("instructions");
            panel3.add(label3);

        frame = new JFrame();
            frame.add(panel2, BorderLayout.NORTH);
            frame.add(panel1, BorderLayout.CENTER);
            frame.add(button1, BorderLayout.SOUTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Card Game");
            frame.pack();
            frame.setVisible(true);

    }

    public static void main(String[] args) {
        new GUI();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.remove(button1);
        frame.add(panel3, BorderLayout.SOUTH);
        frame.pack();
    }

}
*/