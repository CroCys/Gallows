package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class PickDifficult {
	PickRandomWord pickRandomWord = new PickRandomWord();

	// Легкая: слова длиной 4 символа или меньше.
	// Средняя: слова длиной от 5 до 6 символов.
	// Высокая: слова длиной больше 6 символов.
	public String difficult() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

		System.out.println("Выберите сложность: (1 - Легкая | 2 - Средняя | 3 - Высокая)");
		String word;
		try {
			word = "";
			String input = reader.readLine();
			int pickDifficult = Integer.parseInt(input);
			if (pickDifficult == 1) {
				do {
					word = pickRandomWord.randomWord();
				} while (word.length() > 4);
				return word;
			} else if (pickDifficult == 2) {
				do {
					word = pickRandomWord.randomWord();
				} while (word.length() <= 4 || word.length() > 6);
				return word;
			} else if (pickDifficult == 3) {
				do {
					word = pickRandomWord.randomWord();
				} while (word.length() <= 6);
				return word;
			} else {
				System.out.println("Выберите сложность: (1 - Легкая | 2 - Средняя | 3 - Высокая)");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return word;
	}
}