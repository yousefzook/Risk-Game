package controller;

import model.IBoard;
import model.ITerritory;


public class PassiveAgent extends Player {

	public PassiveAgent() {
		super("Passive Agent");
	}

	@Override
	public void nextStep(IBoard board) {
		nextPassiveStep(board);
	}

	public void nextPassiveStep(IBoard board) {
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

}
