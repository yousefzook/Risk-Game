package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public interface IBoard extends Cloneable{

	/**
	 * 
	 * @return
	 */
	public ArrayList<IContinent> getContinents();

	/**
	 * 
	 * @param continent
	 */
	public void SetContinents(ArrayList<IContinent> continents);

	/**
	 * 
	 * @return
	 */
	public ArrayList<ITerritory> getTerritories();

	/**
	 * 
	 * @param territory
	 */
	public void SetTerritory(ArrayList<ITerritory> territories);

	/**
	 * 
	 * @param number
	 * @return
	 */
	public ITerritory getTerritoryByNumber(int number);

}
