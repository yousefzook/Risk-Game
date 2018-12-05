package controller;

import model.ITerritory;


public class PassiveAgent extends Player {

	public PassiveAgent() {
		super("Passive Agent");
	}


	@Override
	public void supply() {
		// TODO Auto-generated method stub
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


	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

}
