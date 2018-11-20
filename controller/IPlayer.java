package controller;

import java.awt.Color;

public interface IPlayer {

	public String getName();

	public void setName(String name);

	public int getAdditionalArmy();

	public void setAdditionalArmy(int additionalArmy);

	public int getNoOfAcqTerrs();

	public void setNoOfAcqTerrs(int noOfAcqTerrs);

	public Color getColor();

	public void setColor(Color color);
}
