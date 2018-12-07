package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Continent implements IContinent {

	private ArrayList<ITerritory> territories;
	private Color color;
	private int value;
	private int noOfTerrs;
	private int p1TerrsNum, p2TerrsNum;

	public Continent() {
		territories = new ArrayList<>();
		// adding continents color
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color color = new Color(r, g, b);
		this.color = color;
		p1TerrsNum = 0;
		p2TerrsNum = 0;

	}

	public void computePlayersTerrsNum() {
		p1TerrsNum = 0;
		p2TerrsNum = 0;

		for (ITerritory terr : territories) {
			if (terr.getOwner().getPlayerNumber() == 1)
				p1TerrsNum++;
			else
				p2TerrsNum++;
		}
	}

	public int getP1TerrsNum() {
		return p1TerrsNum;
	}

	public void setP1TerrsNum(int p1TerrsNum) {
		this.p1TerrsNum = p1TerrsNum;
	}

	public int getP2TerrsNum() {
		return p2TerrsNum;
	}

	public void setP2TerrsNum(int p2TerrsNum) {
		this.p2TerrsNum = p2TerrsNum;
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

	@Override
	public IContinent cloneContinent() {
		IContinent newContinent = new Continent();
		newContinent.setColor(color);
		newContinent.setValue(value);
		newContinent.setNoOfTerrs(noOfTerrs);
		for (ITerritory territory : territories)
			newContinent.addTerritory(territory.cloneTerritory());

		return newContinent;
	}

}
