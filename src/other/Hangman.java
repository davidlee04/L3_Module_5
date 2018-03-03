package other;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	Stack<String> wordStack = new Stack<>();
	ArrayList<JLabel> boxes = new ArrayList<>();
	JFrame frame;
	JPanel panel;
	JLabel lives;
	
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
		panel.add(lives);
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
		String temp = n+"";
		boxes.get(m).setText(temp);
		
		checkAnswer();
	}
	
	void updateLives() {
		lives.setText(lifeCount + "");
	}
	
	void checkAnswer() {
		if(getCurrentAnswer().equals(word)) {
			JOptionPane.showMessageDialog(null, "congrats");
			loadNextPuzzle();
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
		
	}
	
	public void createBoxes() {
		addBoxes();
		for (int i = 0; i < boxes.size(); i++) {
			panel.add(boxes.get(i));
		}
	}
	
	public void clearBoxes() {
		for (int i = 0; i < boxes.size(); i++) {
			boxes.get(i).setText("_ ");
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		charArray = word.toCharArray();
		
		for (int i = 0; i < charArray.length; i++) {
			if(e.getKeyChar() == charArray[i]) {
				if(boxes.get(i).getText() == "_ ") {
					JOptionPane.showMessageDialog(null, "yay");
				}
				updateBox(i, e.getKeyChar());
			} else {
				strikeCount++;
			}
		}
		if(strikeCount == boxes.size()) {
			lifeCount--;
			updateLives();
			JOptionPane.showMessageDialog(null, "wrong :(");
		}
		
		strikeCount = 0;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
