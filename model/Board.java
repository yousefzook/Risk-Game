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
	public void SetContinent(ArrayList<IContinent> continents) {
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

}
