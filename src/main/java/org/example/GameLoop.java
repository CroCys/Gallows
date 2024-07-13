package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class GameLoop {
	// Лист с отгаданными подряд словами
	ArrayList<String> solvedWords = new ArrayList<>();

	// Проверка на правильность ввода и начало/конец игры
	public void startGame() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
		ConsoleOutput consoleOutput = new ConsoleOutput();
		GodMode godMode = new GodMode();

		boolean validInput = false;
		System.out.println("Начать новую игру? (да / нет)");

		while (!validInput) {
			try {
				String startGame = reader.readLine().trim().toLowerCase();
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
					} else if (solvedWords.isEmpty()) {
						System.out.println("Вы разгадали " + 0 + " слов");
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
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
