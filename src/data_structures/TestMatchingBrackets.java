package data_structures;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS
	// A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		Stack<Character> charStack = new Stack<Character>();
		int openBracketCount = 0;
		int closedBracketCount = 0;

		for (int i = 0; i < b.length(); i++) {
			if (b.charAt(i) == '{') {
				openBracketCount++;
			}
			if (b.charAt(i) == '}') {
				closedBracketCount++;
			}

		}
		
		for (int j = b.length() - 1; j >= 0; j--) {
			charStack.push(b.charAt(j));
		}
		if (charStack.pop() == '{') {
			if(openBracketCount == closedBracketCount) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

}