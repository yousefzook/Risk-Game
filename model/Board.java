package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Board implements IBoard {

	private ArrayList<ITerritory> territories;
	private ArrayList<IContinent> continents;

	public Board() {
		territories = new ArrayList<>();
		continents = new ArrayList<>();
	}

	@Override
	public ArrayList<IContinent> getContinents() {
		return continents;
	}

	@Override
	public void SetContinents(ArrayList<IContinent> continents) {
		this.continents = continents;
	}

	@Override
	public ArrayList<ITerritory> getTerritories() {
		return territories;
	}

	@Override
	public void SetTerritory(ArrayList<ITerritory> territories) {
		this.territories = territories;
	}

	@Override
	public ITerritory getTerritoryByNumber(int number) {
		for (int i = 0; i < territories.size(); i++)
			if (territories.get(i).getNumber() == number)
				return territories.get(i);

		// if not found return null
		return null;

	}

}
