package model;

import java.util.Set;
import controller.Player;

public interface ITerritory {

	/**
	 * 
	 * @return
	 */
	public Set<Integer> getNeighbors();

	/**
	 * 
	 * @param neighbors
	 */
	public void addNeighbor(int neighbor);

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
	 * @param addArmySize
	 */
	public void addArmySize(int armySize);

	/**
	 * 
	 * @param addArmySize
	 */
	public void decreaseArmySize(int size);

	/**
	 * 
	 * @return
	 */
	public Player getOwner();

	/**
	 * 
	 * @param owner
	 */
	public void setOwner(Player owner);

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

	/**
	 * 
	 * @return
	 */
	public int getNumber();
	
	public ITerritory cloneTerritory();

}
