package controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import model.IBoard;
import model.ITerritory;

public abstract class Player {

	protected String name;
	protected int playerNumber; // 1 for player1, 2 for player2
	protected int additionalArmy;
	protected Color color;
	protected ArrayList<ITerritory> territories;
	protected Player otherPlayer;
	protected IBoard board;

	public abstract void supply();

	public abstract void attack();

	public Player(String name, int playerNum) {
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color color = new Color(r, g, b);
		this.color = color;
		territories = new ArrayList<>();
		this.name = name;
		playerNumber = playerNum;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public void nextStep() {
		supply();
		attack();
	}

	public Player getOtherPlayer() {
		return otherPlayer;
	}

	public void setOtherPlayer(Player otherPlayer) {
		this.otherPlayer = otherPlayer;
	}

	public IBoard getBoard() {
		return board;
	}

	public void setBoard(IBoard board) {
		this.board = board;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAdditionalArmy() {
		return additionalArmy;
	}

	public void setAdditionalArmy(int additionalArmy) {
		this.additionalArmy = additionalArmy;
	}

	public int getNoOfAcqTerrs() {
		return territories.size();
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void addTerritory(ITerritory terr) {
		this.territories.add(terr);
	}

	public void removeTerritory(ITerritory terr) {
		this.territories.remove(terr);
	}

	public ArrayList<ITerritory> getTerritories() {
		return this.territories;
	}

	public boolean hasTerritories() {
		return !territories.isEmpty();
	}

	public void updateAfterAlgorithm(ArrayList<ITerritory> terrs) {
		terrs.clear();
		for (ITerritory territory : terrs)
			if (territory.getOwner().getPlayerNumber() == playerNumber)
				territories.add(territory);

	}

	// public ArrayList<ITerritory> getBorderTerrs() {
	// ArrayList<ITerritory> borderNodes = new ArrayList<>();
	//
	// for (ITerritory terr : territories) {
	// for (int neighbor : terr.getNeighbors()) {
	// if (board.getTerritoryByNumber(neighbor).getOwner() == this) // if a friend
	// node, skip
	// continue;
	// break;
	// }
	// borderNodes.add(terr);
	// }
	//
	// return borderNodes;
	// }
	//
	// public ArrayList<ITerritory> getEnemyOfNode(ITerritory terr) {
	// ArrayList<ITerritory> enemies = new ArrayList<>();
	// for (Integer neighbor : terr.getNeighbors()) {
	// ITerritory neiTerr = board.getTerritoryByNumber(neighbor);
	// if (neiTerr.getOwner() != this)
	// enemies.add(neiTerr);
	// }
	// return enemies;
	// }

}
