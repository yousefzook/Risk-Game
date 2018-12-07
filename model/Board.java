package model;

import java.util.ArrayList;

import controller.Player;

public class Board implements IBoard {

	private ArrayList<ITerritory> territories;
	private ArrayList<IContinent> continents;
	private int gN ; 
	

	public Board(int gN) {
		territories = new ArrayList<>();
		continents = new ArrayList<>();
		this.gN = gN;
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
	@Override
	public int getgN() {
		return gN;
	}
	
	@Override
	public IBoard cloneBoard() {
		IBoard newBoard = new Board(gN + 1);
		ArrayList<ITerritory> newTerritories = new ArrayList<>();
		for (ITerritory territory : territories)
			newTerritories.add(territory.cloneTerritory());
		newBoard.SetTerritory(newTerritories);

		ArrayList<IContinent> newContinents = new ArrayList<>();

		for (IContinent continent : continents)
			newContinents.add(continent.cloneContinent());
		newBoard.SetContinents(newContinents);

		return newBoard;
	}

	public ArrayList<ITerritory> getBorderTerrs(int owner) {
		ArrayList<ITerritory> borderNodes = new ArrayList<>();

		for (ITerritory terr : territories) {
			if (terr.getOwner().getPlayerNumber() != owner)
				continue;

			for (int neighbor : terr.getNeighbors()) {
				if (getTerritoryByNumber(neighbor).getOwner().getPlayerNumber() == owner) // if a friend node, skip
					continue;
				break;
			}
			borderNodes.add(terr);
		}
		return borderNodes;
	}

	@Override
	public ArrayList<ITerritory> getEnemyOfNode(ITerritory terr, int owner) {
		ArrayList<ITerritory> enemies = new ArrayList<>();
		for (Integer neighbor : terr.getNeighbors()) {
			ITerritory neiTerr = getTerritoryByNumber(neighbor);
			if (neiTerr.getOwner().getPlayerNumber() != owner)
				enemies.add(neiTerr);
		}
		return enemies;
	}

}
