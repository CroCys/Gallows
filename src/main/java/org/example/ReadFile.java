package org.example;

import java.io.*;
import java.util.ArrayList;

public class ReadFile {
	public ArrayList<String> words = new ArrayList<>();

	// Ищем и читаем файл
	public void readWords() {
		InputStream inputStream = getClass().getResourceAsStream("/Words.txt");
		if (inputStream == null) {
			throw new RuntimeException("Файл не найден: Words.txt");
		}

		// Читаем слова и записываем в лист
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
			String s;
			while ((s = bufferedReader.readLine()) != null) {
				words.add(s.toLowerCase());
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}