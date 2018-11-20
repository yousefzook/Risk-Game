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
	public void setTerritories(ArrayList<ITerritory> territories);

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

}
