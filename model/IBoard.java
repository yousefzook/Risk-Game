package model;

import java.util.ArrayList;

public interface IBoard {

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

	/**
	 * 
	 * @param g(n) steps
	 * @return
	 */
	public int getgN();
	
	public IBoard cloneBoard();

	public ArrayList<ITerritory> getBorderTerrs(int owner);

	public ArrayList<ITerritory> getEnemyOfNode(ITerritory terr, int owner);

//	public Object getBorderTerrs(int i);

}
