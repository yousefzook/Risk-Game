package model;

import java.util.HashSet;
import java.util.Set;
import controller.Player;

public class Territory implements ITerritory {

	private Set<Integer> neighbors;
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

	public void addNeighbor(int neighbor) {
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

	@Override
	public void addArmySize(int armySize) {
		this.armySize += armySize;
	}

	@Override
	public void decreaseArmySize(int size) {
		this.armySize -= size;
	}

	@Override
	public Set<Integer> getNeighbors() {
		return neighbors;
	}

	@Override
	public ITerritory cloneTerritory() {
		ITerritory newTerritory = new Territory(number);
		newTerritory.setArmySize(armySize);
		newTerritory.setOwner(owner);
		newTerritory.setParentContinent(parentContinent);
		for (Integer neighb : neighbors)
			newTerritory.addNeighbor(neighb);

		return newTerritory;
	}

}
