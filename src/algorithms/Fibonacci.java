package algorithms;

public class Fibonacci {
	public static void main(String[] args) {
		long temp1 = 1;	
		long temp2 = 1;
		for (int i = 0; i < 100; i++) {
			if(i == 0) {
				System.out.println(temp1);
			}else if(i == 1) {
				System.out.println(temp2);
			}else if(i != 0 || i != 1) {
				long temp3 = temp1+temp2;
				System.out.println(temp3);
				temp1 = temp2;
				temp2 = temp3;
			}
		}
	}

}
