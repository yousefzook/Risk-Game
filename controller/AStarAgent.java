package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import controller.IntelligentAgent.Pair;
import model.IBoard;

public class AStarAgent extends IntelligentAgent {

	public AStarAgent(int playerNum) {
		super("A* Agent", playerNum);
	}

	@Override
	public void attack() {
		aStarStep();
	}

	private void aStarStep() {
		Queue<Pair> queue = new PriorityQueue<>(stateCompartor);
		Set<Pair> explored = new HashSet<>();
		ArrayList<IBoard> nextStates = getNextStates(board);
		for (IBoard newBoard : nextStates) {
			float h = getHeuristic(newBoard);
			queue.add(new Pair(newBoard, board.getgN() + h, new Pair(board, board.getgN(), null)));
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
					queue.add(new Pair(neighborState, getHeuristic(neighborState) + state.board.getgN(), state));
				}
			}
			queue.add(state);
		}
	}

}
