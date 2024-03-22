import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class startScreen extends JFrame{
    public JPanel mainPanel;
    private JButton playButton;
    private JButton instructionsButton;
    private JLabel scoreLabel;
    private JLabel highScoreDisplay;

    public startScreen() {
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(playButton, "In progress...");
            }
        });
        instructionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(playButton, "In progress...");
            }
        });
    }
}
