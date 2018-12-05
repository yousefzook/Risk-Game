package controller;

import model.IContinent;
import model.ITerritory;

public class AggressiveAgent extends Player {

	public AggressiveAgent(int playerNum) {
		super("Aggressive Agent", playerNum);
	}

	ITerritory iTerritory;

	@Override
	public void supply() {
		// TODO Auto-generated method stub
		iTerritory = setAdditionArmies();
	}

	private ITerritory setAdditionArmies() {
		if (additionalArmy == 0) {
			return null;
		}

		IContinent minCont = null;
		for (IContinent cont : board.getContinents()) {
			int minContTerrs = Integer.MAX_VALUE;
			int contTerrs = 0;
			if (this.playerNumber == 1)
				contTerrs = cont.getP1TerrsNum();
			else
				contTerrs = cont.getP2TerrsNum();
			if (minContTerrs > contTerrs) {
				minContTerrs = contTerrs;
				minCont = cont;
			}
		}
		ITerritory maxTerr = minCont.getTerritories().get(0);
		int maxSize = Integer.MIN_VALUE;
		for (int i = 1; i < minCont.getTerritories().size(); i++) {
			if (minCont.getTerritories().get(i).getArmySize() > maxSize) {
				maxSize = minCont.getTerritories().get(i).getArmySize();
				maxTerr = minCont.getTerritories().get(i);
			}
		}
		maxTerr.addArmySize(additionalArmy);
		return maxTerr;
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub

		ITerritory maxTerr = null;
		int maxSize = Integer.MIN_VALUE;

		for (ITerritory territory : iTerritory.getNeighbors()) {
			if (territory.getOwner() == iTerritory.getOwner())
				continue;
			if (territory.getArmySize() > maxSize
					&& territory.getArmySize() + 1 < iTerritory.getArmySize()) {
				maxSize = territory.getArmySize();
				maxTerr = territory;
			}
		}
		if (maxTerr != null) {
			int newArmyNum = iTerritory.getArmySize() - maxTerr.getArmySize();
			maxTerr.getOwner().removeTerritory(maxTerr);
			maxTerr.setOwner(iTerritory.getOwner());
			maxTerr.setArmySize(newArmyNum - 1);
			iTerritory.setArmySize(1);
			addTerritory(maxTerr);
		}

	}
}
