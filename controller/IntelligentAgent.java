package controller;

import java.awt.Color;

public class IntelligentAgent implements IPlayer {

	private String name;
	private int additionalArmy;
	private int noOfAcqTerrs;
	private Color color;

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
