package controller;

import model.IBoard;

public class IntelligentAgent extends Player {

	public IntelligentAgent() {
		super("Intelligent Agent");
	}

	@Override
	public void nextStep(IBoard board) {
		nextSmartStep(board);
	}

	private void nextSmartStep(IBoard board) {
		// TODO Auto-generated method stub
		
	}

}
