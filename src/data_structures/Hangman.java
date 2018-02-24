package data_structures;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Hangman {
	
	public static void main(String[] args) {
		Hangman hangman = new Hangman();
		hangman.setUI();
	}
	
	void setUI() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
