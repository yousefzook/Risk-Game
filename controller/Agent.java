package controller;

import java.awt.Color;
import java.util.Random;

public class Agent implements IPlayer {

	private String name;
	private int additionalArmy;
	private int noOfAcqTerrs;
	private Color color;

	public Agent() {
		name = "Agent";
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color color = new Color(r, g, b);
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAdditionalArmy() {
		return additionalArmy;
	}

	public void setAdditionalArmy(int additionalArmy) {
		this.additionalArmy = additionalArmy;
	}

	public int getNoOfAcqTerrs() {
		return noOfAcqTerrs;
	}

	public void setNoOfAcqTerrs(int noOfAcqTerrs) {
		this.noOfAcqTerrs = noOfAcqTerrs;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
