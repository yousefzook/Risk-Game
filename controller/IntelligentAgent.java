package controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Queue;
import java.util.Set;

import controller.IntelligentAgent.Pair;
//import controller.IntelligentAgent.Pair;
import model.IBoard;
import model.IContinent;
import model.ITerritory;

public abstract class IntelligentAgent extends Player {

	Comparator<Pair> stateCompartor = new Comparator<Pair>() {
		@Override
		public int compare(Pair s1, Pair s2) {
			return (s2.fCost - s1.fCost < 0) ? -1 : 1;
		}
	};

	public IntelligentAgent(String name, int playerNum) {
		super(name, playerNum);
		// TODO Auto-generated constructor stub
	}

	class BorderWrapper {
		ITerritory borderTerr;
		float nbsd; // border security ratio
		float contRatio;

		public BorderWrapper(ITerritory terr, float nbsd, float contRatio) {
			this.borderTerr = terr;
			this.nbsd = nbsd;
			this.contRatio = contRatio;
		}

		public float getAvgRatio() {
			return (float) ((contRatio + nbsd) / 2);
		}
	}

	class Pair {
		IBoard board;
		float fCost;
		Pair parent;

		public Pair(IBoard board, float heuristic, Pair parent) {
			this.board = board;
			this.fCost = heuristic;
			this.parent = parent;
		}
	}

	private ArrayList<BorderWrapper> getBorderBSR() {
		ArrayList<BorderWrapper> borderNodes = new ArrayList<>();

		for (ITerritory terr : territories) {
			int bst = 0; // border security threat
			for (Integer neighb : terr.getNeighbors()) {
				ITerritory neighbor = board.getTerritoryByNumber(neighb);

				// for (ITerritory neighbor : terr.getNeighbors()) {
				if (neighbor.getOwner() == this) // if a friend node, skip
					continue;
				bst += neighbor.getArmySize();
			}

			if (bst == 0) // not a border node so skip
				continue;

			float bsd = bst - terr.getArmySize();
			borderNodes.add(new BorderWrapper(terr, bsd, 0));
		}

		return borderNodes;
	}

	private void normalize(ArrayList<BorderWrapper> borders) {

		// nbsd = bsd/sum(BSds);
		float sum = 0;
		for (BorderWrapper border : borders)
			sum += border.nbsd;
		for (BorderWrapper border : borders)
			border.nbsd = (float) border.nbsd / sum;

		// nContRatio = contRatio/sum(contRatio)
		sum = 0;
		for (BorderWrapper border : borders)
			sum += border.contRatio;
		for (BorderWrapper border : borders)
			border.contRatio = (float) border.contRatio / sum;

	}

	private void addContRatios(ArrayList<BorderWrapper> borders) {
		// TODO Auto-generated method stub
		for (BorderWrapper border : borders) {
			ITerritory terr = border.borderTerr;
			float acqRatio = 0;
			if (this.getPlayerNumber() == 1)
				acqRatio = terr.getParentContinent().getP1TerrsNum() / terr.getParentContinent().getNoOfTerrs();
			else
				acqRatio = terr.getParentContinent().getP2TerrsNum() / terr.getParentContinent().getNoOfTerrs();
			border.contRatio = acqRatio;
		}
	}

	@Override
	public void supply() {
		// TODO Auto-generated method stub
		if (additionalArmy == 0)
			return;

		ArrayList<BorderWrapper> borders = getBorderBSR();
		addContRatios(borders);
		normalize(borders);

		// now we have each node on the border with it's security threat normalized
		// ratio, i.e. sum of nbsd = 1 and sum of contRaios = 1
		// So we will assign soldiers to each node based on these ratios
		for (BorderWrapper border : borders) {
			int additional = Math.round(additionalArmy * (border.getAvgRatio()));
			if (additional > additionalArmy)
				additional = additionalArmy;

			additionalArmy -= additional;
			border.borderTerr.addArmySize(additional);
			if (additionalArmy == 0)
				break;
		}
		if (additionalArmy > 0) {
			borders.get(0).borderTerr.addArmySize(additionalArmy);
		}
	}

	protected float getHeuristic(IBoard board) {
		// TODO Auto-generated method stub
		float reward = 0;
		int acqTerrs = 0;
		for (ITerritory terr : board.getTerritories()) {
			if (terr.getOwner() == this)
				acqTerrs++;
		}

		float maxRatio = 0;
		for (IContinent cont : board.getContinents()) {
			cont.computePlayersTerrsNum();
			int size = 0;
			if (this.getPlayerNumber() == 1) {
				size = cont.getP1TerrsNum();
			} else {
				size = cont.getP2TerrsNum();
			}
			float ratio = (float) size / cont.getNoOfTerrs();
			if (maxRatio < ratio)
				maxRatio = ratio;
		}
		reward = maxRatio + (float) acqTerrs / board.getTerritories().size();
		return reward;
	}

	protected boolean goalTest(Pair state) {
		Player currOwner = state.board.getTerritories().get(0).getOwner();
		for (ITerritory terr : state.board.getTerritories()) {
			if (terr.getOwner() != currOwner)
				return false;
		}
		if (currOwner == this)
			return true;
		else
			return false;
	}

	protected ArrayList<IBoard> getNextStates(IBoard board) {
		ArrayList<IBoard> newBoardList = new ArrayList<>();
		for (ITerritory terr : board.getBorderTerrs(this.getPlayerNumber())) {
			for (ITerritory enemy : board.getEnemyOfNode(terr, this.getPlayerNumber())) {
				if (terr.getArmySize() - 2 >= enemy.getArmySize()) { // can attack
					IBoard newBoard = board.cloneBoard();
					int newArmyNum = newBoard.getTerritoryByNumber(terr.getNumber()).getArmySize()
							- newBoard.getTerritoryByNumber(enemy.getNumber()).getArmySize();
					newBoard.getTerritoryByNumber(enemy.getNumber()).setOwner(this);
					if (getRiskArmyState(newBoard, newBoard.getTerritoryByNumber(enemy.getNumber())) > getRiskArmyState(
							newBoard, newBoard.getTerritoryByNumber(terr.getNumber()))) {
						newBoard.getTerritoryByNumber(enemy.getNumber()).setArmySize(newArmyNum - 1);
						newBoard.getTerritoryByNumber(terr.getNumber()).setArmySize(1);
					} else {
						newBoard.getTerritoryByNumber(enemy.getNumber()).setArmySize(1);
						newBoard.getTerritoryByNumber(terr.getNumber()).setArmySize(newArmyNum - 1);
					}
					newBoardList.add(newBoard);
				}
			}
		}
		return newBoardList;
	}

	private int getRiskArmyState(IBoard board, ITerritory territory) {
		int bst = 0; // border security threat
		for (Integer neighb : territory.getNeighbors()) {
			ITerritory neighbor = board.getTerritoryByNumber(neighb);

			if (neighbor.getOwner() == this) // if a friend node, skip
				continue;
			bst += neighbor.getArmySize();
		}
		return bst - territory.getArmySize();
	}

	protected boolean inSet(IBoard neighborState, Set<Pair> explored) {
		// TODO Auto-generated method stub

		for (Pair pair : explored) {
			if (neighborState == pair.board)
				return true;
		}
		return false;
	}

	protected boolean inQueue(IBoard neighborState, Queue<Pair> queue) {
		// TODO Auto-generated method stub
		for (Pair pair : queue) {
			if (neighborState == pair.board)
				return true;
		}
		return false;
	}

}
