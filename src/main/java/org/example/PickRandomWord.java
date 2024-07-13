package org.example;

import java.util.Random;

public class PickRandomWord {
	// Выбираем случайное слово прочитанное из файла
	public String randomWord() {
		Random random = new Random();
		ReadFile readFile = new ReadFile();
		readFile.readWords();

		String word;
		int wordCount = readFile.words.size();
		int randomIndex = random.nextInt(wordCount + 1);

		word = readFile.words.get(randomIndex);

		return word;
	}
}