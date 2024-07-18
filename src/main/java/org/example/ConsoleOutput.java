package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ConsoleOutput {
	int numberOfMistakes = 0; // Количество ошибок (жизней)

	// Финальная сборка классов и весь процесс игры
	public void output(GameLoop gameLoop) {
		WordRenderer wordRenderer = new WordRenderer();
		DrawGallows drawGallows = new DrawGallows();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
		StringBuilder builder = new StringBuilder();
		// Лист с ошибочными буквами
		ArrayList<Character> wrongSymbols = new ArrayList<>();

		boolean validInput = false;
		String tips;

		// Спрашиваем включить ли отображение двух случайных букв слова
		System.out.println("Включить подсказки? (да / нет)");
		while (!validInput) {
			try {
				tips = reader.readLine().trim().toLowerCase();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			if (tips.equals("да")) {
				wordRenderer.wordBySymbol();
				wordRenderer.hiddenWordWithTips();
				validInput = true;
			} else if (tips.equals("нет")) {
				wordRenderer.wordBySymbol();
				wordRenderer.hiddenWord();
				validInput = true;
			} else {
				System.out.println("Включить подсказки? (да / нет)");
			}
		}

		try {
			do {
//				System.out.println(wordRenderer.completeWordBySymbol); // Вывод ответа
				drawGallows.draw(numberOfMistakes); // Выводим виселицу
				System.out.println(wordRenderer.answerWord); // Вывод прогресса разгадывания слова пользователем

				System.out.println("Введите букву: ");
				String input = reader.readLine();
				if (input != null && !input.isEmpty()) {
					char inputSymbol = input.charAt(0);

					// Находим повторяющиеся буквы в слове и проверяем есть ли эта буква вообще
					for (int i = 0; i < wordRenderer.completeWordBySymbol.size(); i++) {
						if (wordRenderer.completeWordBySymbol.get(i).equals(inputSymbol)) {
							wordRenderer.answerWord.set(i, inputSymbol);
						}
					}

					// Проверка на неправильную букву
					if (!wordRenderer.completeWordBySymbol.contains(inputSymbol)) {
						wrongSymbols.add(inputSymbol);
						System.out.print("Таких букв нет: ");
						System.out.println(wrongSymbols);

						numberOfMistakes++; // В случае ошибки увеличиваем счетчик ошибок

						if (numberOfMistakes == 1) {
							System.out.println("Вы сделали " + numberOfMistakes + " ошибку");
						} else if ((numberOfMistakes > 1) && (numberOfMistakes < 5)) {
							System.out.println("Вы сделали " + numberOfMistakes + " ошибки");
						} else {
							System.out.println("Вы сделали " + numberOfMistakes + " ошибок");
						}
					}

                /* Сообщаем о конце игры если закончились жизни, выводим количество разгаданных слов,
                количество слов, предлагаем сыграть заново */
					if (numberOfMistakes == 6) {
						drawGallows.draw(numberOfMistakes);
						System.out.println(wordRenderer.answerWord);
						System.out.println("Вы повешенны! (Игра окончена)");
						System.out.println("Загаданное слово: " + wordRenderer.completeWordBySymbol);

						// Правильно склоняем сообщение в зависимости от кол-ва угаданных слов
						if (gameLoop.solvedWords.size() == 1) {
							System.out.println("Разгадано " + gameLoop.solvedWords.size() + " слово");
							System.out.println(gameLoop.solvedWords.toString());
							gameLoop.startGame();
						} else if ((gameLoop.solvedWords.size() > 1) && (gameLoop.solvedWords.size() < 5)) {
							System.out.println("Разгадано " + gameLoop.solvedWords.size() + " слова");
							System.out.println(gameLoop.solvedWords.toString());
							gameLoop.startGame();
						} else if (gameLoop.solvedWords.isEmpty()) {
							System.out.println("Разгадано " + 0 + " слов");
							gameLoop.startGame();
						} else {
							System.out.println("Разгадано " + gameLoop.solvedWords.size() + " слов");
							System.out.println(gameLoop.solvedWords.toString());
							gameLoop.startGame();
						}
					}

                /* Сообщаем о победе, добавляем разгаданное слово в лист,
                предлагаем сыграть заново */
					if (!wordRenderer.answerWord.contains('_')) {
						for (Character ch : wordRenderer.answerWord) {
							builder.append(ch);
						}
						String solvedWord = builder.toString();
						gameLoop.solvedWords.add(solvedWord);

						drawGallows.draw(numberOfMistakes);
						System.out.println(wordRenderer.answerWord);
						System.out.println("Поздравляем, вы разгадали слово!");
						gameLoop.startGame();
					}
				} else {
					System.out.println("Ввод завершен.");
					break;
				}
			} while (numberOfMistakes < 6);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}