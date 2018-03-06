package unit_tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinionTest {

	@Test
	public void testConstructor() {
		Minions stuart = new Minions("Stuart", 1, "yellow", "");
		assertEquals("Stuart", stuart.getName());
		assertEquals(1, stuart.getEyes());
		assertEquals("yellow", stuart.getColor());
		Minions dave = new Minions("Dave", 2, "yellow", "");
		assertEquals("Dave", dave.getName());
		assertEquals(2, dave.getEyes());
		assertEquals("yellow", dave.getColor());
	}

	@Test
	public void testSetters() {
		Minions stuart = new Minions("Stuart", 1, "yellow", "");

	}

}
