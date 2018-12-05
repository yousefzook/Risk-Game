package model;

import java.util.HashSet;
import java.util.Set;
import controller.Player;

public class Territory implements ITerritory {

	private Set<ITerritory> neighbors;
	private int armySize;
	private Player owner;
	private IContinent parentContinent;
	private int number;

	private Territory() {
	}

	public Territory(int num) {
		this.number = num;
		neighbors = new HashSet<>();
	}

	public int getNumber() {
		return number;
	}

	public Set<ITerritory> getNeighbors() {
		return neighbors;
	}

	public void addNeighbor(ITerritory neighbor) {
		this.neighbors.add(neighbor);
	}

	public int getArmySize() {
		return armySize;
	}

	public void setArmySize(int armySize) {
		this.armySize = armySize;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public IContinent getParentContinent() {
		return parentContinent;
	}

	public void setParentContinent(IContinent parentContinent) {
		this.parentContinent = parentContinent;
	}

}
