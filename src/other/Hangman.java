package other;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Stack;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener, ActionListener {
	Stack<String> wordStack = new Stack<>();
	ArrayList<JLabel> boxes = new ArrayList<>();
	JFrame frame;
	JPanel panel;
	JLabel lives;
	JButton guessWord;

	String word = "";
	int lifeCount = 9;
	int strikeCount = 0;

	char[] charArray;

	public static void main(String[] args) {
		Hangman hangman = new Hangman();

		hangman.addPuzzles();
		hangman.addFirstBoxes();
		hangman.setUI();
		hangman.checkAnswer();
	}

	public Hangman() {

	}

	void setUI() {
		frame = new JFrame();
		panel = new JPanel();
		frame.add(panel);
		for (int i = 0; i < boxes.size(); i++) {
			panel.add(boxes.get(i));
		}
		lives = new JLabel();
		guessWord = new JButton();
		guessWord.setFocusable(false);
		panel.add(lives);
		panel.add(guessWord);
		guessWord.setText("Guess the Word!");
		guessWord.addActionListener(this);
		lives.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		lives.setText(lifeCount + "");
		frame.addKeyListener(this);
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void addPuzzles() {
		wordStack.push("world");
		wordStack.push("hello");
	}

	void addFirstBoxes() {
		word = wordStack.pop();

		for (int i = 0; i < word.length(); i++) {
			JLabel temp = new JLabel();
			temp.setText("_ ");
			boxes.add(temp);

		}
	}

	void addBoxes() {
		boxes.clear();
		for (int i = 0; i < word.length(); i++) {
			JLabel temp = new JLabel();
			temp.setText("_ ");
			boxes.add(temp);
		}
	}

	void updateBox(int m, char n) {
		String temp = n + "";
		boxes.get(m).setText(temp);

		checkAnswer();
	}

	void updateLives() {
		lives.setText(lifeCount + "");
	}

	void checkAnswer() {
		if (getCurrentAnswer().equals(word)) {
			loadNextPuzzle();
			JOptionPane.showMessageDialog(null, "congrats");
		}
		System.out.println(getCurrentAnswer());
	}
	
	void checkGuess(String a) {
		if (a.equalsIgnoreCase(word)) {
			loadNextPuzzle();
			JOptionPane.showMessageDialog(null, "congrats");
		}
		System.out.println(getCurrentAnswer());
	}

	public String getCurrentAnswer() {
		StringBuffer answer = new StringBuffer();
		for (JLabel textBox : boxes) {
			answer.append(textBox.getText());
		}
		return answer.toString();
	}

	public void loadNextPuzzle() {
		word = wordStack.pop();
		
		removeBoxes();
		createBoxes();
		
		clearBoxes();
	}

	public void removeBoxes() {
		for (int i = 0; i < boxes.size(); i++) {
			panel.remove(boxes.get(i));
		}
		panel.remove(lives);

	}

	public void createBoxes() {
		addBoxes();
		for (int i = 0; i < boxes.size(); i++) {
			panel.add(boxes.get(i));
		}
		lifeCount = 9;
		panel.add(lives);
		lives.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		updateLives();
	}

	public void clearBoxes() {
		for (int i = 0; i < boxes.size(); i++) {
			boxes.get(i).setText("_ ");
		}
	}

	public void playDeathKnell() {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("/Users/League/Google Drive/league-sounds/funeral-march.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			Thread.sleep(8400);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void checkLives() { 
		if(lifeCount == 0) {
			playDeathKnell();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("hi");
		// TODO Auto-generated method stub
		charArray = word.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			if (e.getKeyChar() == charArray[i]) {
				if (boxes.get(i).getText() == "_ ") {
					JOptionPane.showMessageDialog(null, "yay");
				}
				updateBox(i, e.getKeyChar());
			} else {
				strikeCount++;
			}
		}
		if (strikeCount == boxes.size()) {
			lifeCount--;
			updateLives();
			JOptionPane.showMessageDialog(null, "wrong :(");
			checkLives();
		}

		strikeCount = 0;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == guessWord) {
			String input = JOptionPane.showInputDialog("Please input your entire guess.");
			checkGuess(input);
		}
	}

}
