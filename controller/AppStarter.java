package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import model.IBoard;
import model.ITerritory;

public class AppStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ArrayList<String> allLines = (ArrayList<String>) Files
					.readAllLines(Paths.get("input.txt"));
			InputParser parser = new InputParser(new Agent(), new Agent());
			IBoard board = parser.parse(allLines);
//			for(ITerritory terr: board.getTerritories()) {
//				System.out.println(terr.getNumber());
//				System.out.println(terr.getArmySize());
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
