package org.example;

import java.util.Random;

public class PickRandomWord {
	// Выбираем случайное слово прочитанное из файла
	public String randomWord() {
		ReadFile readFile = new ReadFile();
		readFile.readWords();

		int wordCount = readFile.words.size();

		Random random = new Random();
		int randomIndex = random.nextInt(wordCount + 1);

		String word;
		word = readFile.words.get(randomIndex);

		return word;
	}
}