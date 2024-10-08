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
				switch (startGame) {
					case "да" -> {
						consoleOutput.output(this);
						validInput = true;
					}
					case "нет" -> {
						System.out.println("Игра окончена");
						validInput = true;
						System.exit(0);
					}
					case "god mode" -> {
						godMode.output(this);
						validInput = true;
					}
					default -> System.out.println("Введите да или нет");
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}