import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class startScreen extends JFrame{
    private JPanel mainPanel;
    private JButton playButton;
    private JButton instructionsButton;
    private JLabel scoreLabel;
    private JLabel highScoreDisplay;
    private JButton aboutButton;
    private JButton quit;

    public startScreen() {
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game gamePage = new game();
                gamePage.setContentPane(gamePage.getGamePanel());
                gamePage.setLocation(playButton.getX()+400, playButton.getY()-100);
                gamePage.setTitle("Card Matching Game");
                gamePage.setSize(400, 300);
                gamePage.setVisible(true);
                gamePage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        instructionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                instructions instPg = new instructions();
                instPg.setContentPane(instPg.getInstPanel());
                instPg.setLocation(instructionsButton.getX()+400, instructionsButton.getY()-100);
                instPg.setTitle("Instructions");
                instPg.setSize(400, 300);
                instPg.setVisible(true);
                instPg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                about abtPage = new about();
                abtPage.setContentPane(abtPage.getAbtPanel());
                abtPage.setLocation(aboutButton.getX()+400, aboutButton.getY()-100);
                abtPage.setTitle("About");
                abtPage.setSize(400, 300);
                abtPage.setVisible(true);
                abtPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    public JPanel getMainPanel(){
        return mainPanel;
    }
}
