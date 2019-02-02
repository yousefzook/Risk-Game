package model;

import java.util.Set;
import controller.Player;

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
	public void addNeighbor(ITerritory neighbor);

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


}
