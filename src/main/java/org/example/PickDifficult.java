package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class PickDifficult {
	/* Предлагаем 3 сложности на выбор:
	Легкая: слова длиной 4 символа или меньше.
	Средняя: слова длиной от 5 до 6 символов.
	Высокая: слова длиной больше 6 символов */
	public String difficult() {
		PickRandomWord pickRandomWord = new PickRandomWord();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
		ReadFile readFile = new ReadFile();
		readFile.readWords();

		String word = "";
		boolean validInput = false;
		String input;

		System.out.println("Выберите сложность: (л - Легкая | с - Средняя | в - Высокая)");
		while (!validInput) {
			try {
				input = reader.readLine().trim().toLowerCase();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}

			switch (input) {
				case "л" -> {
					for (int i = 0; i < readFile.words.size(); i++) {
						word = pickRandomWord.randomWord();
						if (word.length() <= 5) {
							return word;
						}
					}
					validInput = true;
				}
				case "с" -> {
					for (int i = 0; i < readFile.words.size(); i++) {
						word = pickRandomWord.randomWord();
						if (word.length() > 5 && word.length() <= 8) {
							return word;
						}
					}
					validInput = true;
				}
				case "в" -> {
					for (int i = 0; i < readFile.words.size(); i++) {
						word = pickRandomWord.randomWord();
						if (word.length() > 8) {
							return word;
						}
					}
					validInput = true;
				}
				default -> System.out.println("Выберите сложность: (л - Легкая | с - Средняя | в - Высокая)");
			}
		}
		return word;
	}
}