package model;

import java.awt.Color;
import java.util.ArrayList;

public class Continent implements IContinent {

	private ArrayList<ITerritory> territories;
	private Color color;
	private int value;
	private int noOfTerrs;

	public ArrayList<ITerritory> getTerritories() {
		return territories;
	}

	public void setTerritories(ArrayList<ITerritory> territories) {
		this.territories = territories;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getNoOfTerrs() {
		return noOfTerrs;
	}

	public void setNoOfTerrs(int noOfTerrs) {
		this.noOfTerrs = noOfTerrs;
	}

}
