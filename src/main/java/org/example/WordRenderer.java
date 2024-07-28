package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordRenderer {
	// Лист в котором хранится случайное слово разбитое по буквам
	List<Character> completeWordBySymbol = new ArrayList<>();
	// Лист в котором сначала хранятся прочерки, которые заменяются на правильные буквы
	List<Character> answerWord = new ArrayList<>();

	// Разбиваем слово по буквам
	public void wordBySymbol() {
		PickDifficult pickDifficult = new PickDifficult();
		String word = pickDifficult.difficult();
		for (int i = 0; i < word.length(); i++) {
			completeWordBySymbol.add(word.charAt(i));
		}
	}

	// Добавляем столько прочерков, сколько букв в загаданном слове
	public void hiddenWord() {
		for (int i = 0; i < completeWordBySymbol.size(); i++) {
			answerWord.add('_');
		}
	}

	// Показываем 2 случайные буквы в загаданном слове
	public void hiddenWordWithTips() {
		for (int i = 0; i < completeWordBySymbol.size(); i++) {
			answerWord.add('_');
		}

		Random random = new Random();
		for (int i = 0; i < 2; ) {
			int index = random.nextInt(completeWordBySymbol.size());
			char answerSymbol = completeWordBySymbol.get(index);
			if (answerWord.get(index) == '_') {
				answerWord.set(index, answerSymbol);
				i++;
			}
		}
	}
}