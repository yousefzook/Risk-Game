package controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import model.ITerritory;

public class HumanAgent implements IPlayer {

	private String name;
	private int additionalArmy;
	private Color color;
	private ArrayList<ITerritory> territories;

	public HumanAgent() {
		name = "Human Agent";
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color color = new Color(r, g, b);
		this.color = color;
		territories = new ArrayList<>();
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
		return territories.size();
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void addTerritory(ITerritory terr) {
		this.territories.add(terr);
	}

	public ArrayList<ITerritory> getTerritories() {
		return this.territories;
	}

	public void removeTerritory(ITerritory terr) {
		this.territories.remove(terr);
	}

}
