package got;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char map[][] = new char[10][10];
		Util.initializeMap(map);
		int finish[] = { 0, 9 };
		Characters JonSnow = new Characters("Jon Snow",100,100);
		Characters Cersei = new Characters("Cersei",100,100);
		Characters NigthKing = new Characters("NightKing",200,200);
		Util.printMap(map);
		do {
			System.out.println("Make Your Move!");
			char move = scanner.next().charAt(0);
			move = java.lang.Character.toUpperCase(move);
			switch (move) {
			case 'W':
				JonSnow.up(map);
				break;
			case 'A':
				JonSnow.left(map);
				break;
			case 'S':
				JonSnow.down(map);
				break;
			case 'D':
				JonSnow.rigth(map);
				break;
			case 'I':
				JonSnow.stats();
				break;
			default:
				System.out.println("Unvalid move!");
				break;
			}
			Util.printMap(map);
		} while (Util.getPosition(map) != finish);

	}
}