package controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import model.IBoard;
import model.IContinent;
import model.ITerritory;

public class GreedyAgent extends IntelligentAgent {

	public GreedyAgent(int playerNum) {
		super("Greedy Agent", playerNum);
	}

	@Override
	public void attack() {
		greedyStep();
	}

	private void greedyStep() {
		// TODO Auto-generated method stub
		Queue<Pair> queue = new PriorityQueue<>(stateCompartor);
		Set<Pair> explored = new HashSet<>();
		ArrayList<IBoard> nextStates = getNextStates(board);
		for (IBoard board : nextStates) {
			float h = getHeuristic(board);
			queue.add(new Pair(board, h, new Pair(board, 0, null)));
		}
		while (!queue.isEmpty()) {

			Pair state = queue.remove();
			explored.add(state);

			if (goalTest(state)) {
				while (state.parent.board != board)
					state = state.parent;
				this.board = state.board;
				break;
			}
			for (IBoard neighborState : getNextStates(state.board)) {
				if (!(inSet(neighborState, explored) || inQueue(neighborState, queue))) {
					queue.add(
							new Pair(neighborState, getHeuristic(neighborState), state));
				}
			}
			queue.add(state);
		}
	}

	private boolean inQueue(IBoard neighborState, Queue<Pair> queue) {
		// TODO Auto-generated method stub
		for (Pair pair : queue) {
			if (neighborState == pair.board)
				return true;
		}
		return false;
	}

}
