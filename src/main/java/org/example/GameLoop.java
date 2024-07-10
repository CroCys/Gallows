package org.example;

import java.io.Console;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class GameLoop {
	// Лист с отгаданными подряд словами
	ArrayList<String> solvedWords = new ArrayList<>();

	// Проверка на правильность ввода и начало/конец игры
	public void startGame() {
		Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
		ConsoleOutput consoleOutput = new ConsoleOutput();
		GodMode godMode = new GodMode();

		boolean validInput = false;
		System.out.println("Начать новую игру? (да / нет)");
		String startGame = scanner.next().toLowerCase();

		while (!validInput) {
			if (startGame.equals("да")) {
				consoleOutput.output(this);
				validInput = true;
			} else if (startGame.equals("нет")) {
				System.out.println("Игра окончена");
				if (solvedWords.size() == 1) {
					System.out.println("Вы разгадали " + solvedWords.size() + " слово");
					System.out.println(solvedWords.toString());
				} else if ((solvedWords.size() > 1) && (solvedWords.size() < 5)) {
					System.out.println("Вы разгадали " + solvedWords.size() + " слова");
					System.out.println(solvedWords.toString());
				} else {
					System.out.println("Вы разгадали " + solvedWords.size() + " слов");
					System.out.println(solvedWords.toString());
				}
				validInput = true;
				System.exit(0);
			} else if (startGame.equals("godmode")) {
				godMode.output(this);
				validInput = true;
			} else {
				System.out.println("Введите да или нет");
				startGame = scanner.nextLine().toLowerCase();
			}
		}
		scanner.close();
	}
}
