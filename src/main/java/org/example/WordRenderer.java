package org.example;

import java.util.ArrayList;

public class WordRenderer {
	// Лист в котором хранится случайное слово разбитое по буквам
	ArrayList<Character> completeWordBySymbol = new ArrayList<>();
	// Лист в котором сначала хранятся прочерки, которые заменяются на правильные буквы
	ArrayList<Character> answerWord = new ArrayList<>();

	// Разбиваем слово по буквам
	public void wordBySymbol() {
		PickRandomWord pickRandomWord = new PickRandomWord();
		String word = pickRandomWord.randomWord();
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
}
