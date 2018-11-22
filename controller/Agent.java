package controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import model.IBoard;
import model.ITerritory;

public class Agent implements IPlayer {

	private String name;
	private int additionalArmy;
	private Color color;
	private ArrayList<ITerritory> territories;

	public Agent() {
		name = "Agent";
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color color = new Color(r, g, b);
		this.color = color;
		territories = new ArrayList<>();
	}

	public IBoard nextPassiveStep(IBoard board) {
		if(additionalArmy > 0);
		ITerritory minTerr;
		for(ITerritory terr: territories) {
			if(terr.getArmySize())
		}
		return board;
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

	public void removeTerritory(ITerritory terr) {
		this.territories.remove(terr);
	}

	public ArrayList<ITerritory> getTerritories() {
		return this.territories;
	}

}
