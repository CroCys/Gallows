package org.example;

import java.util.Random;

public class PickRandomWord {
	// Выбираем случайное слово прочитанное из файла
	public String randomWord() {
		Random random = new Random();
		ReadFile readFile = new ReadFile();
		if (readFile.words.isEmpty()) {
			readFile.readWords();
		}

		int wordCount = readFile.words.size();
		int randomWord = random.nextInt(wordCount + 1);

		return readFile.words.get(randomWord);
	}
}