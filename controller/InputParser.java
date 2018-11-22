package controller;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import model.Board;
import model.Continent;
import model.IBoard;
import model.IContinent;
import model.ITerritory;
import model.Territory;

public class InputParser {

	IPlayer p1, p2;

	private InputParser() {
	}

	public InputParser(IPlayer p1, IPlayer p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public IBoard parse(ArrayList<String> lines) {

		ArrayList<String> boardInitLines = new ArrayList<>();
		int i = 0;
		for (; i < lines.size(); i++) {
			boardInitLines.add(lines.get(i));
			if (lines.get(i).charAt(0) == '(' && lines.get(i + 1).charAt(0) == 'P')
				// last line of edges so break
				break;
		}
		IBoard board = createBoard(boardInitLines);
		System.out.println("Board has been created!");

		String pLine = lines.get(i + 1);
		int contNum = Integer.parseInt(pLine.substring(2, pLine.length()));
		ArrayList<String> contsInitLines = new ArrayList<>();
		for (int j = i + 2; j < i + 2 + contNum; j++)
			contsInitLines.add(lines.get(j));
		parseContinents(contsInitLines, board);
		System.out.println("Continents has been parsed!");

		addPlayersArmy(lines.get(lines.size() - 2), lines.get(lines.size() - 1), board);
		System.out.println("Initial armies placement has been finished!");
		return board;
	}

	private void addPlayersArmy(String p1ArmyLine, String p2ArmyLine, IBoard board) {
		String[] p1Army = p1ArmyLine.split(" ");
		String[] p2Army = p2ArmyLine.split(" ");

		// add player1 soldiers
		int noOfAcqTerrs = 0;
		for (int i = 0; i < p1Army.length; i++) {
			int armySize = Integer.parseInt(p1Army[i]);
			if (armySize > 0) {
				board.getTerritoryByNumber(i + 1).setArmySize(armySize);
				board.getTerritoryByNumber(i + 1).setOwner(p1);
				System.out.println("p1 terr no: " + (i + 1) + " armysize: " + armySize);
				noOfAcqTerrs++;
			}
		}
		System.out.println("p2 acq terrs: " + noOfAcqTerrs);
		p1.setNoOfAcqTerrs(noOfAcqTerrs);

		// add player2 soldiers
		noOfAcqTerrs = 0;
		for (int i = 0; i < p2Army.length; i++) {
			int armySize = Integer.parseInt(p2Army[i]);
			if (armySize > 0) {
				board.getTerritoryByNumber(i + 1).setArmySize(armySize);
				board.getTerritoryByNumber(i + 1).setOwner(p2);
				System.out.println("p2 terr no: " + (i + 1) + " armysize: " + armySize);
				noOfAcqTerrs++;
			}
		}
		System.out.println("p2 acq terrs: " + noOfAcqTerrs);
		p2.setNoOfAcqTerrs(noOfAcqTerrs);

	}

	private void parseContinents(ArrayList<String> contsInitLines, IBoard board) {

		ArrayList<IContinent> conts = new ArrayList<>();
		for (int i = 0; i < contsInitLines.size(); i++) {
			IContinent con = new Continent();
			String[] args = contsInitLines.get(i).split(" ");
			int value = Integer.parseInt(args[0]);
			con.setValue(value);
			System.out.println("cont no: " + (i + 1) + " - value: " + value);
			int noOfTerrs = 0;
			// for each continent add its territories
			for (int j = 1; j < args.length; j++) {
				int terrNo = Integer.parseInt(args[j]);
				ITerritory terr = board.getTerritoryByNumber(terrNo);
				con.addTerritory(terr);
				terr.setParentContinent(con);
				noOfTerrs++;
				System.out.println("cont no: " + (i + 1) + " terr: " + terrNo);
			}
			System.out.println("terr size: " + noOfTerrs);
			con.setNoOfTerrs(noOfTerrs);
			conts.add(con);
		}

		board.SetContinents(conts);
	}

	private IBoard createBoard(ArrayList<String> boardInitLines) {

		String line1 = boardInitLines.get(0);
		String line2 = boardInitLines.get(1);
		int noOfTerr = Integer.parseInt(line1.substring(2, line1.length()));
		int noOfEdges = Integer.parseInt(line2.substring(2, line2.length()));
		System.out.println("no of terrs: " + noOfTerr + " no of edges: " + noOfEdges);
		ArrayList<ITerritory> territories = new ArrayList<>();
		for (int i = 0; i < noOfTerr; i++)
			territories.add(new Territory(i + 1));
		IBoard board = new Board();
		board.SetTerritory(territories);

		for (int i = 0; i < noOfEdges; i++) {
			String[] sides = boardInitLines.get(i + 2)
					.substring(1, boardInitLines.get(i + 2).length() - 1).split(" ");
			ITerritory terr1 = board.getTerritoryByNumber(Integer.parseInt(sides[0]));
			ITerritory terr2 = board.getTerritoryByNumber(Integer.parseInt(sides[1]));
			if (terr1 == null || terr2 == null) {
				System.out.println("Error!, terr1 or terr2 not found");
				return null;
			}
			System.out.println("edge - terr1: " + sides[0] + " - terr2: " + sides[1]);
			terr1.addNeighbor(terr2);
			terr2.addNeighbor(terr1);
		}
		return board;
	}

}
