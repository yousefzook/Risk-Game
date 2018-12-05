package controller;

import java.util.ArrayList;

import model.IBoard;
import model.IContinent;
import model.ITerritory;

public class AggressiveAgent extends Player {

	public AggressiveAgent() {
		super("Aggressive Agent");
	}

	@Override
	public void nextStep(IBoard board) {
		// TODO Auto-generated method stub
		aggressiveAttack();
	}

	private ITerritory setAdditionArmies() {
		if (additionalArmy == 0) {
			return null;
		}

		ITerritory maxTerr = territories.get(0);
		int maxSize = Integer.MIN_VALUE;
		for (int i = 1; i < territories.size(); i++) {
			if (territories.get(i).getArmySize() > maxSize) {
				maxSize = territories.get(i).getArmySize();
				maxTerr = territories.get(i);
			}
		}
		maxTerr.setArmySize(maxSize + additionalArmy);
		return maxTerr;
	}

	public IContinent getMaxContinentTerritories(IBoard board) {
		ArrayList<Integer> continentsValues = new ArrayList<>();
		for (int i = 0; i < board.getContinents().size(); i++) {
			int terrNumber = 0;
			for (int j = 0; j < territories.size(); j++) {
				if (territories.get(j).getParentContinent().equals(board.getContinents().get(i)))
					terrNumber++;
			}
			continentsValues.add(terrNumber);
		}
		int temb = 0;
		int index = 0;
		for (int i = 0; i < continentsValues.size(); i++) {
			if (continentsValues.get(i) > temb) {
				temb = continentsValues.get(i);
				index = i;
			}

		}
		if (temb > 0)
			return board.getContinents().get(index);
		return null;
	}
	
	private void aggressiveAttack() {
		ITerritory iTerritory = setAdditionArmies();
		ITerritory maxTerr = null;
		int maxSize = Integer.MIN_VALUE;

		for (ITerritory territory : iTerritory.getNeighbors()) {
			if (territory.getOwner() == iTerritory.getOwner())
				continue;
			if (territory.getArmySize() > maxSize && territory.getArmySize() + 1 < iTerritory.getArmySize()) {
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
//			maxx= maxTerr.clone();	
		}
	}

}
