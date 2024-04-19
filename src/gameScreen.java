import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import java.util.Collections;

public class gameScreen extends JFrame implements ActionListener{
    private JButton backButton;
    private JFrame gameFrame;
    private JMenuItem openInstructions;
    private JPanel gamePanel;
    private final ImageIcon cardBack = new ImageIcon("cardback.png");
    private final ImageIcon circleCard = new ImageIcon("circle card.png");
    private final ImageIcon clubCard = new ImageIcon("club card.png");
    private final ImageIcon diamondCard = new ImageIcon("diamond card.png");
    private final ImageIcon spadeCard = new ImageIcon("spade card.png");
    private final ImageIcon squareCard = new ImageIcon("square card.png");
    private final ImageIcon starCard = new ImageIcon("star card.png");
    private final ArrayList<JButton> cards = new ArrayList<>();
    private final ArrayList<ImageIcon> cardIcons = new ArrayList<>();
    private JButton openedBttn1;
    private ImageIcon openedIcon1;
    private JButton openedBttn2;
    private ImageIcon openedIcon2;
    private int matchResult;
    private int matchedPairs = 0;
    private final int totalPairs = 6;
    public int trackScore = 0;
    private JLabel scoreDisplay;
    private JPanel collectionPanel;
    private JTextField nameBox;

    public gameScreen(){
        initialize();
    }

    private void initialize(){
        gameFrame = new JFrame();
        gameFrame.setSize(1900, 1000);
        gameFrame.setVisible(true);
        gameFrame.setTitle("Card Matching Game");
        gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameFrame.setLocationRelativeTo(null);

        setupUI();
    }

    private void setupUI(){
        JPanel borderPanel = new JPanel(new BorderLayout());
        gameFrame.add(borderPanel);

        gamePanel = new JPanel();
        gamePanel.setBackground(new Color(43, 53, 75));
        gamePanel.setLayout(new GridLayout(3,4,10,10));
        borderPanel.add(gamePanel, BorderLayout.CENTER);

        // add back button
        JPanel buttonPanel = new JPanel(new BorderLayout());
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setFont(new Font("Arial", Font.PLAIN, 28));
        buttonPanel.add(backButton, BorderLayout.EAST);
        borderPanel.add(buttonPanel,BorderLayout.SOUTH);

        // add score display
        scoreDisplay = new JLabel("Score: " + 0);
        scoreDisplay.setFont(new Font("Arial", Font.PLAIN, 28));
        buttonPanel.add(scoreDisplay, BorderLayout.WEST);
        buttonPanel.setBorder(new EmptyBorder(30,30,30,30));

        setupMenu();
        setupCards();
    }

    private void setupMenu() {
        JMenu instructionMenu = new JMenu("Menu");
        JMenuBar menuBar = new JMenuBar();
        openInstructions = new JMenuItem("Open Instructions");
        openInstructions.addActionListener(this);
        instructionMenu.setFont(new Font("Arial", Font.PLAIN, 25));
        openInstructions.setFont(new Font("Arial", Font.PLAIN, 24));
        instructionMenu.add(openInstructions);
        menuBar.add(instructionMenu);
        gameFrame.setJMenuBar(menuBar);
    }

    private void setupCards(){
        cardIcons.add(circleCard);
        cardIcons.add(circleCard);
        cardIcons.add(clubCard);
        cardIcons.add(clubCard);
        cardIcons.add(diamondCard);
        cardIcons.add(diamondCard);
        cardIcons.add(spadeCard);
        cardIcons.add(spadeCard);
        cardIcons.add(squareCard);
        cardIcons.add(squareCard);
        cardIcons.add(starCard);
        cardIcons.add(starCard);

        // shuffle card order
        Collections.shuffle(cardIcons);

        // match cards to JButtons and display card backs to screen
        for(ImageIcon icon: cardIcons){
            JButton button = new JButton(cardBack);
            button.addActionListener(this);
            cards.add(button);
            gamePanel.add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            backButtonClicked();
        }
        else if(e.getSource() == openInstructions) {
            new instructionsPage();
        }
        else {
            cardClicked((JButton)e.getSource());
        }
    }

    private void backButtonClicked(){
        // ask for user confirmation to leave game screen
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 22));
        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.BOLD, 20));
        int confirmBack = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to go back? Game will NOT save.", "Confirm Back",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirmBack == JOptionPane.YES_OPTION){
            // go back to starting menu
            gameFrame.dispose();
            new JavaGUI();
        }
    }

    private void cardClicked(JButton clickedButton){
        int index = cards.indexOf(clickedButton);
        //ImageIcon icon = cardIcons.get(index);
        ImageIcon icon = cardBack;
        // flips over first card when first card is clicked
        if(openedBttn1 == null){
            openedBttn1 = clickedButton;
            openedIcon1 = icon;
            clickedButton.setIcon(icon);
            matchResult = 1;
        }
        // flips over second card when second card is clicked
        else if(openedBttn2 == null && clickedButton != openedBttn1){
            openedBttn2 = clickedButton;
            openedIcon2 = icon;
            clickedButton.setIcon(icon);

            if(openedIcon1.equals(openedIcon2)){
                continueGame(true, "It's a MATCH!");
            }
            else{
                continueGame(false, "Unlucky... try again.");
            }
        }
    }

    private void continueGame(boolean isMatch, String matchMsg){
        Object[] options = {"Continue"};
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 24));
        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.BOLD, 22));

        while(matchResult != 0) {
            // display match result message
            matchResult = JOptionPane.showOptionDialog(null, matchMsg, "Is it a match?",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

            // when user confirms to continue game, and cards are a match,
            if (matchResult == 0 && isMatch) {
                // remove card icons from screen and add to score
                openedBttn1.setVisible(false);
                openedBttn2.setVisible(false);
                openedBttn1 = null;
                openedIcon1 = null;
                openedBttn2 = null;
                openedIcon2 = null;
                trackScore += 100;
                matchedPairs++;

                // when all card pairs are matched, display final score and ask for player name
                if(matchedPairs == totalPairs){
                    collectUserInfo();
                }
            }
            // when user confirms to continue game, and cards are a match,
            else if (matchResult == 0 && !isMatch) {
                // flip over cards to reveal back side
                openedBttn1.setIcon(cardBack);
                openedBttn2.setIcon(cardBack);
                openedBttn1 = null;
                openedIcon1 = null;
                openedBttn2 = null;
                openedIcon2 = null;
                trackScore -= 10;
            }
            // Updates Score
            scoreDisplay.setText("Score: " + trackScore);
        }
    }

    private void collectUserInfo(){
        String player;
        Object[] options = {"Confirm"};
        int choice = 1;

        setCollectionComponents();

        // display dialog to user for data collection
        do {
            UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.BOLD, 22));
            choice = JOptionPane.showOptionDialog(null, collectionPanel, "End",
                    JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
            // get player name
            player = nameBox.getText();
        } while(choice != 0 || player.equals(""));

        // go back to start screen
        new JavaGUI();
        gameFrame.dispose();
    }
    private void setCollectionComponents(){
        // set up dialog panel for collecting data
        collectionPanel = new JPanel(new BorderLayout());

        // set panel components
        JLabel nameText = new JLabel("Enter player name: ");
        nameBox = new JTextField(15);;
        JLabel scoreText = new JLabel("Score: " + trackScore);
        scoreText.setBorder(new EmptyBorder(0,0,15,0));

        // set fonts
        nameText.setFont(new Font("Arial", Font.PLAIN, 24));
        nameBox.setFont(new Font("Arial", Font.PLAIN, 24));
        scoreText.setFont(new Font("Arial", Font.PLAIN, 24));

        // add components to panel for display
        collectionPanel.add(nameText, BorderLayout.CENTER);
        collectionPanel.add(nameBox, BorderLayout.SOUTH);
        collectionPanel.add(scoreText, BorderLayout.NORTH);
    }
}
