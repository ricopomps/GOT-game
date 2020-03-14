package got;

public class Util {

	public static char[][] initializeMap(char map[][]) {
		map[1][1] = 'J';
		map[1][4] = 'O';
		map[3][2] = 'O';
		map[4][4] = 'C';
		map[5][7] = 'O';
		map[5][3] = 'O';
		map[5][2] = 'O';
		map[6][6] = 'O';
		map[6][0] = 'O';
		map[7][7] = 'O';
		map[8][8] = 'O';
		map[9][8] = 'O';
		map[9][9] = 'N';
		map[0][0] = 'E';
		map[0][9] = 'E';
		map[0][8] = 'E';
		map[1][5] = 'E';
		map[2][1] = 'E';
		map[2][8] = 'E';
		map[3][0] = 'E';
		map[3][9] = 'E';
		map[3][3] = 'E';
		map[3][4] = 'E';
		map[4][0] = 'E';
		map[4][9] = 'E';
		map[4][8] = 'E';
		map[6][9] = 'E';
		map[7][3] = 'E';
		map[7][6] = 'E';
		map[8][2] = 'E';
		map[8][9] = 'E';
		map[9][2] = 'E';
		map[9][5] = 'E';
		map[0][2] = 'P';
		map[1][9] = 'P';
		map[2][4] = 'P';
		map[2][7] = 'P';
		map[3][6] = 'P';
		map[4][2] = 'P';
		map[5][5] = 'P';
		map[6][2] = 'P';
		map[8][0] = 'P';
		map[9][0] = 'P';
		return map;
	}

	public static void printMap(char map[][]) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				char print;
				if (map[i][j] == Character.MIN_VALUE) {
					print = '_';
				} else {
					print = map[i][j];
				}
				System.out.print(print + "|");
			}
			System.out.println("\n");
		}

	}

	public static int[] getPosition(char map[][]) {
		int i = 0, j = 0;
		boolean out = false;
		for (i = 0; i < map.length; i++) {
			for (j = 0; j < map[0].length; j++) {
				if (map[i][j] == 'J') {
					out = true;
					break;
				}
				if (out) {
					break;
				}
			}
			if (out) {
				break;
			}
		}
		int position[] = { i, j };
		return position;

	}

	public static int[] getPosition(char map[][], char target) {
		int i = 0, j = 0;
		boolean out = false;
		for (i = 0; i < map.length; i++) {
			for (j = 0; j < map[0].length; j++) {
				if (map[i][j] == target) {
					out = true;
					break;
				}
				if (out) {
					break;
				}
			}
			if (out) {
				break;
			}
		}
		int position[] = { i, j };
		return position;

	}



	}

	

