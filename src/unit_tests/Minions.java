package unit_tests;

public class Minions {
	private String name;
	private int eyes;
	private String color;
	private String master;

	public Minions(String name, int eyes, String color, String master) {
		this.name = name;
		this.eyes = eyes;
		this.color = color;
		this.master = master;

	}

	public String getName() {
		return name;
	}

	public int getEyes() {
		return eyes;
	}

	public String getColor() {
		return color;
	}

	public String getMaster() {
		return master;
	}
}
