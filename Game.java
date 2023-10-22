import javax.swing.*;
import java.awt.*;


class Main extends JFrame{
    JTextField guess,bestScore, totalGuesses;
    JLabel inputLabel,guessLabel,tryLabel,bestScoreLabel, totalGuessesLabel,imgLabel;

    int rand = (int) (Math.random() * 100);
    int bestscr = 100;
    int count = 0;

    public Main(){
//        It is a Container package which returns a container
//        We have to define the containers layout
        Container c = getContentPane();
        c.setLayout(null);
//        defining bg colour
        c.setBackground(Color.white);
//        Creating the Jlabels
        guessLabel = new JLabel("Guess the Number ?");
        guessLabel.setForeground(Color.red);
        guessLabel.setFont(new Font("times new roman",Font.BOLD,24));
        guessLabel.setSize(270,20);
        guessLabel.setLocation(70,70);

        inputLabel = new JLabel("Enter a number between 1 to 100");
        inputLabel.setFont(new Font("times new roman",Font.PLAIN,14));
        inputLabel.setSize(270,20);
        inputLabel.setLocation(70,90);

        tryLabel = new JLabel("Try and Guess It!");
        tryLabel.setFont(new Font("times new roman",Font.PLAIN,14));
        tryLabel.setSize(270,20);
        tryLabel.setLocation(70,160);

//      Creating the text fields
        guess = new JTextField(5);
        guess.setSize(50,30);
        guess.setLocation(140,120);

        bestScore = new JTextField(5);
        bestScore.setSize(30,20);
        bestScore.setLocation(10,10);

        totalGuesses = new JTextField(5);
        totalGuesses.setSize(30,20);
        totalGuesses.setLocation(10,40);

        totalGuessesLabel = new JLabel("Number of Guesses");
        totalGuessesLabel.setFont(new Font("times new roman",Font.PLAIN,14));
        totalGuessesLabel.setSize(270,20);
        totalGuessesLabel.setLocation(50,40);

        bestScoreLabel = new JLabel("Best Score");
        bestScoreLabel.setFont(new Font("times new roman",Font.PLAIN,14));
        bestScoreLabel.setSize(270,20);
        bestScoreLabel.setLocation(50,10);

        imgLabel = new JLabel("");
        imgLabel.setIcon(new ImageIcon("img.png"));
        imgLabel.setBounds(280,10,500,350);

//      Implementing the function button
        JButton guessButton = new JButton("Guess");
        guessButton.setSize(100,30);
        guessButton.setLocation(110,190);
        guessButton.setBackground(Color.lightGray);
        guessButton.addActionListener((e)-> guessListener());

        JButton giveUpButton = new JButton("Give Up");
        giveUpButton.setSize(100,30);
        giveUpButton.setLocation(50,240);
        giveUpButton.setBackground(Color.lightGray);
        giveUpButton.addActionListener((e)-> giveUpListener());

        JButton playAgainButton = new JButton("Play Again");
        playAgainButton.setSize(100,30);
        playAgainButton.setLocation(180,240);
        playAgainButton.setBackground(Color.lightGray);
        playAgainButton.addActionListener((e)-> playAgainListener());


//        Adding the components in the container
        c.add(guessLabel);
        c.add(inputLabel);
        c.add(tryLabel);
        c.add(guess);
        c.add(bestScore);
        c.add(totalGuesses);
        c.add(totalGuessesLabel);
        c.add(bestScoreLabel);
        c.add(imgLabel);
        c.add(guessButton);
        c.add(playAgainButton);
        c.add(giveUpButton);

//        Using the JFrame methods to make a frame
        setTitle("GUESS THE NUMBER!!!");
        setSize(500,350);
//        By default, Jframe is invisible, so we have to set it as visible
        setVisible(true);
//        Setting what we want to do when we close the frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
//  Defining the actions of the buttons
    private void playAgainListener() {
        int rand = (int) (Math.random() * 100);
        guess.setText("");
        totalGuesses.setText("");
        tryLabel.setText("Try and Guess It!");
        count = 0;
        guess.setEditable(true);
        guess.requestFocus();
    }

    private void giveUpListener() {
        totalGuesses.setText("");
        tryLabel.setText("Poor You. The number is "+ rand);
        guess.setText("");
        guess.setEditable(false);
    }

    private void guessListener() {

        int a = Integer.parseInt(guess.getText());
        count++;
        if(a<rand){
            tryLabel.setText("Oops!..Guess a greater number.");
        }
        else if (a>rand){
            tryLabel.setText("Oops!..Guess a smaller number.");
        }
        else{
            tryLabel.setText("Congratulations!You have guessed it Right.");
            if(count<bestscr){
                bestscr = count;
                bestScore.setText(bestscr+"");
            }
            else{
                bestScore.setText(bestscr+"");
            }
            guess.setEditable(false);
        }
        guess.requestFocus();
//        to mark the changes and makes the state back to normal
        guess.selectAll();
        totalGuesses.setText(count+"");
    }
// A main function to call our game
    public static void main(String[] args) {
        new Main();
    }
}