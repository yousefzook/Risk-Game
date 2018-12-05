package controller;

import model.IBoard;
import model.ITerritory;

public class PacifistAgent extends Player {

	public PacifistAgent() {
		super("Pacifist Agent");
	}

	@Override
	public void nextStep(IBoard board) {
		// TODO Auto-generated method stub

	}

	public void setAdditionArmies(IBoard board) {
		if (additionalArmy == 0) {
			return;
		}

		ITerritory minTerr = territories.get(0);
		int minSize = Integer.MAX_VALUE;
		for (int i = 1; i < territories.size(); i++) {
			if (territories.get(i).getArmySize() < minSize) {
				minSize = territories.get(i).getArmySize();
				minTerr = territories.get(i);
			}
		}
		minTerr.setArmySize(minSize + additionalArmy);
	}

	public void attack() {

		ITerritory choosenTerr = null;
		ITerritory choosenNeighbourTerr = null;
		ITerritory iTerritory;
		int minSize = Integer.MAX_VALUE;
		for (int i = 0; i < territories.size(); i++) {
			iTerritory = territories.get(i);
			for (ITerritory territory : iTerritory.getNeighbors()) {
				if (territory.getOwner() == iTerritory.getOwner())
					continue;
				if (territory.getArmySize() + 1 < iTerritory.getArmySize() && territory.getArmySize() < minSize) {
					minSize = territory.getArmySize();
					choosenNeighbourTerr = territory;
					choosenTerr = iTerritory;
				}
			}
		}
		if (choosenNeighbourTerr != null) {
			int newArmyNum = choosenTerr.getArmySize() - choosenNeighbourTerr.getArmySize();
			choosenNeighbourTerr.getOwner().removeTerritory(choosenNeighbourTerr);
			choosenNeighbourTerr.setOwner(choosenTerr.getOwner());
			choosenNeighbourTerr.setArmySize(newArmyNum - 1);
			choosenTerr.setArmySize(1);
			addTerritory(choosenNeighbourTerr);
		}
	}

}
