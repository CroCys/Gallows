package org.example;

import java.io.*;
import java.util.ArrayList;

public class ReadFile {
	public ArrayList<String> words = new ArrayList<>();

	// Читаем файл со словами
	public void readWords() {
		InputStream inputStream = getClass().getResourceAsStream("/Words.txt");
		if (inputStream == null) {
			throw new RuntimeException("Файл не найден: Words.txt");
		}

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