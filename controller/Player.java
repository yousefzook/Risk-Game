package controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import model.IBoard;
import model.ITerritory;

public abstract class Player {

	protected String name;
	protected int additionalArmy;
	protected Color color;
	protected ArrayList<ITerritory> territories;

	public Player(String name) {
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color color = new Color(r, g, b);
		this.color = color;
		territories = new ArrayList<>();
		this.name = name;
	}

	public abstract void nextStep(IBoard board);

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

	public void removeTerritory(ITerritory terr) {
		this.territories.remove(terr);
	}

	public ArrayList<ITerritory> getTerritories() {
		return this.territories;
	}

	public boolean hasTerritories() {
		return !territories.isEmpty();
	}

}
