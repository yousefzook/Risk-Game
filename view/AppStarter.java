package view;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import controller.InputParser;
import controller.PassiveAgent;
import model.IBoard;

public class AppStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ArrayList<String> allLines = (ArrayList<String>) Files
					.readAllLines(Paths.get("input.txt"));
			InputParser parser = new InputParser(new PassiveAgent(), new PassiveAgent());
			IBoard board = parser.parse(allLines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
