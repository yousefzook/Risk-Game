package model;

import java.awt.Color;
import java.util.ArrayList;

public interface IContinent {

	/**
	 * 
	 * @return
	 */
	public ArrayList<ITerritory> getTerritories();

	/**
	 * 
	 * @param territories
	 */
	public void addTerritory(ITerritory territory);

	/**
	 * 
	 * @return
	 */
	public Color getColor();

	/**
	 * 
	 * @param color
	 */
	public void setColor(Color color);

	/**
	 * 
	 * @return
	 */
	public int getValue();

	/**
	 * 
	 * @param value
	 */
	public void setValue(int value);

	/**
	 * 
	 * @return
	 */
	public int getNoOfTerrs();

	/**
	 * 
	 * @param noOfTerrs
	 */
	public void setNoOfTerrs(int noOfTerrs);

	/**
	 * 
	 * compute the number of territories acquired for each player, sets p1TerrsNum
	 * and p2TerrsNum variables
	 */
	public void computePlayersTerrsNum();

	/**
	 * 
	 * @return number of territories for player 1
	 */
	public int getP1TerrsNum();

	/**
	 * 
	 * @return number of territories for player 1
	 */
	public int getP2TerrsNum();

}
