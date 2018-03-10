package data_structures;

import java.util.ArrayList;
import java.util.Random;

public class ArrayOverload {
	public static void main(String[] args) {
		ArrayList<Integer> blowUp = new ArrayList<Integer>();
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < Integer.MAX_VALUE; i++) {
					Random random = new Random();
					int lol = random.nextInt();
					blowUp.add(lol);
				}

			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < Integer.MAX_VALUE; i++) {
					Random random = new Random();
					int lol2 = random.nextInt();
					blowUp.add(lol2);
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < Integer.MAX_VALUE; i++) {
					Random random = new Random();
					int lol3 = random.nextInt();
					blowUp.add(lol3);
				}
			}
		}).start();
	}

}
