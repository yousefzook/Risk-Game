package model;

import java.util.Set;

import controller.IPlayer;

public interface ITerritory {

	/**
	 * 
	 * @return
	 */
	public Set<ITerritory> getNeighbors();

	/**
	 * 
	 * @param neighbors
	 */
	public void setNeighbors(Set<ITerritory> neighbors);

	/**
	 * 
	 * @return
	 */
	public int getArmySize();

	/**
	 * 
	 * @param armySize
	 */
	public void setArmySize(int armySize);

	/**
	 * 
	 * @return
	 */
	public IPlayer getOwner();

	/**
	 * 
	 * @param owner
	 */
	public void setOwner(IPlayer owner);

	/**
	 * 
	 * @return
	 */
	public IContinent getParentContinent();

	/**
	 * 
	 * @param parentContinent
	 */
	public void setParentContinent(IContinent parentContinent);
}
