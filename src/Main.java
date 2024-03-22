import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main implements ActionListener{

    private JFrame frame;
    private JButton button;
    private JLabel label;
    private JPanel panel;

    public Main(){
        frame = new JFrame();
        label = new JLabel("something for testing");
        panel = new JPanel();
            panel.setBorder(BorderFactory.createEmptyBorder(100,540,800,540));
            panel.setName("Card Game");
            panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Card Game");
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Main();

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
