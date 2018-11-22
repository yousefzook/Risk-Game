package controller;

import java.awt.Color;
import java.util.ArrayList;

import model.ITerritory;

public interface IPlayer {

	public String getName();

	public void setName(String name);

	public int getAdditionalArmy();

	public void setAdditionalArmy(int additionalArmy);

	public int getNoOfAcqTerrs();

	public Color getColor();

	public void setColor(Color color);

	public void addTerritory(ITerritory terr);

	public ArrayList<ITerritory> getTerritories();

	public void removeTerritory(ITerritory terr);

}
