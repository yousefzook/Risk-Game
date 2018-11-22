package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Continent implements IContinent {

	private ArrayList<ITerritory> territories;
	private Color color;
	private int value;
	private int noOfTerrs;

	public Continent() {
		territories = new ArrayList<>();
		// adding continents color
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color color = new Color(r, g, b);
		this.color = color;

	}

	public ArrayList<ITerritory> getTerritories() {
		return territories;
	}

	public void addTerritory(ITerritory territory) {
		this.territories.add(territory);
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
