package model;

import java.util.Set;

import controller.IPlayer;

public class Territory implements ITerritory {

	private Set<ITerritory> neighbors;
	private int armySize;
	private IPlayer owner;
	private IContinent parentContinent;

	public Set<ITerritory> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(Set<ITerritory> neighbors) {
		this.neighbors = neighbors;
	}

	public int getArmySize() {
		return armySize;
	}

	public void setArmySize(int armySize) {
		this.armySize = armySize;
	}

	public IPlayer getOwner() {
		return owner;
	}

	public void setOwner(IPlayer owner) {
		this.owner = owner;
	}

	public IContinent getParentContinent() {
		return parentContinent;
	}

	public void setParentContinent(IContinent parentContinent) {
		this.parentContinent = parentContinent;
	}

}
