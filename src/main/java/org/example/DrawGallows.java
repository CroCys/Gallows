package org.example;

public class DrawGallows {
	// Рисуем виселицу
	public void draw(int numberOfMistakes) {
		if (numberOfMistakes == 0) {
			System.out.println("+---+");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("===");
		}

		if (numberOfMistakes == 1) {
			System.out.println("+---+");
			System.out.println("|   " + "0");
			System.out.println("|");
			System.out.println("|");
			System.out.println("===");
		}

		if (numberOfMistakes == 2) {
			System.out.println("+---+");
			System.out.println("|   " + "0");
			System.out.println("|   " + "|");
			System.out.println("|");
			System.out.println("===");
		}

		if (numberOfMistakes == 3) {
			System.out.println("+---+");
			System.out.println("|   " + "0");
			System.out.println("|  " + "/" + "|");
			System.out.println("|");
			System.out.println("===");
		}

		if (numberOfMistakes == 4) {
			System.out.println("+---+");
			System.out.println("|   " + "0");
			System.out.println("|  " + "/" + "|" + "\\");
			System.out.println("|");
			System.out.println("===");
		}

		if (numberOfMistakes == 5) {
			System.out.println("+---+");
			System.out.println("|   " + "0");
			System.out.println("|  " + "/" + "|" + "\\");
			System.out.println("|  " + "/");
			System.out.println("===");
		}

		if (numberOfMistakes == 6) {
			System.out.println("+---+");
			System.out.println("|   " + "0");
			System.out.println("|  " + "/" + "|" + "\\");
			System.out.println("|  " + "/" + " " + "\\");
			System.out.println("===");
		}
	}
}