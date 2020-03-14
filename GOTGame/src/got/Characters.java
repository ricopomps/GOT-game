package got;

import java.util.Random;

public class Characters {
	private String name;
	private int health;
	private int maxHealth;
	boolean hasMetCersei = false;

	public Characters(String name, int health, int maxHealth) {
		this.name = name;
		this.health = health;
		this.maxHealth = maxHealth;
	}

	public void stats() {
		System.out.println(name);
		System.out.println("Health = " + health);
	}

	public void heal(int health) {
		this.health += health;
		if (this.health > maxHealth) {
			this.health = maxHealth;
		}
	}

	public void takeDamage(int health) {
		this.health -= health;
		if (this.health < 0) {
			System.out.println("dead");
		}
	}

	public void checkTarget(char map[][], int next[]) throws ObjectException {
		char target = map[next[0]][next[1]];
		switch (target) {
		case 'O':
			throw new ObjectException();
		case 'E':
			System.out.println("Jon has encountered an enemy!");
			System.out.println("Jon has killed the enemy");
			System.out.println("Jon took 1 point of damage");
			takeDamage(1);
			break;
		case 'P':
			System.out.println("Jon has found a health potion!");
			System.out.println("Jon drank the healh potion");
			System.out.println("Jon healed 5 health points");
			heal(5);
			break;
		case 'C':
			talk();

			break;
		case 'N':
			if (!hasMetCersei) {
				throw new ObjectException();
			} else {
				figthNigthKing();
			}

			break;
		default:
			break;
		}
	}

	public char[][] up(char map[][]) {
		int position[] = Util.getPosition(map, 'J');
		try {
			int next[] = { position[0] - 1, position[1] };
			checkTarget(map, next);
			map[position[0] - 1][position[1]] = 'J';
			map[position[0]][position[1]] = '_';
		} catch (ObjectException e) {
			System.out.println("Obstacle on the way!");
		} catch (Exception e) {
			System.out.println("Out of the map!");
		}
		return map;
	}

	public char[][] down(char map[][]) {
		int position[] = Util.getPosition(map, 'J');
		try {
			int next[] = { position[0] + 1, position[1] };
			checkTarget(map, next);
			map[position[0] + 1][position[1]] = 'J';
			map[position[0]][position[1]] = '_';
		} catch (ObjectException e) {
			System.out.println("Obstacle on the way!");
		} catch (Exception e) {
			System.out.println("Out of the map!");
		}

		return map;
	}

	public char[][] left(char map[][]) {
		int position[] = Util.getPosition(map, 'J');
		try {
			int next[] = { position[0], position[1] - 1 };
			checkTarget(map, next);
			map[position[0]][position[1] - 1] = 'J';
			map[position[0]][position[1]] = '_';
		} catch (ObjectException e) {
			System.out.println("Obstacle on the way!");
		} catch (Exception e) {
			System.out.println("Out of the map!");
		}
		return map;
	}

	public char[][] rigth(char map[][]) {
		int position[] = Util.getPosition(map, 'J');
		try {
			int next[] = { position[0], position[1] + 1 };
			checkTarget(map, next);
			map[position[0]][position[1] + 1] = 'J';
			map[position[0]][position[1]] = '_';
		} catch (ObjectException e) {
			System.out.println("Obstacle on the way!");
		} catch (Exception e) {
			System.out.println("Out of the map!");
		}

		return map;
	}

	public void talk() {
		this.hasMetCersei = true;
		Random random = new Random();
		int i, totalOfSucess = 0;
		for (i = 0; i < 5; i++) {
			System.out.println("Jon tried to convince Cersei to join his cause");
			if (random.nextInt(100) > 60) {
				totalOfSucess++;
				System.out.println("Cersei showed interest");
			} else {
				System.out.println("Cersei didn't care");
			}
		}
		if (totalOfSucess >= 3) {
			System.out.println("Cersei has joined Jon!");
			this.maxHealth += 100;
			this.health += 100;
		} else {
			System.out.println("Cersei attacked Jon!");
			fightCersei();

		}
	}

	public void fightCersei() {
		int cerseiHealth = 100;
		Random random = new Random();
		System.out.println("Jon has started figthing Cersei");
		do {
			System.out.println("Jon attacks!");
			if (random.nextInt(100) >= 50) {
				System.out.println("Jon hits!\nCersei has taken 10 points of damage");
				cerseiHealth -= 10;
			} else {
				System.out.println("Jon misses!");

			}
			System.out.println("Cersei attacks!");
			if (random.nextInt(100) >= 50) {
				System.out.println("Cersei hits!\nJon has taken 10 points of damage");
				this.health -= 10;
			} else {
				System.out.println("Cersei misses!");

			}
			System.out.println("Jon has " + this.health + " health points left");
			System.out.println("Cersei has " + cerseiHealth + " health points left");
		} while (this.health > 0 && cerseiHealth > 0);
		if (this.health <= 0) {
			System.out.println("Jon has died, you lost");
			System.exit(1);
		} else {
			System.out.println("Jon has killed Cersei");
		}
	}

	public void figthNigthKing() {
		int nightKingHealth = 200;
		Random random = new Random();
		System.out.println("Jon has started figthing the Night king");
		do {
			System.out.println("Jon attacks!");
			if (random.nextInt(100) >= 50) {
				System.out.println("Jon hits!\nThe Night King has taken 10 points of damage");
				nightKingHealth -= 10;
			} else {
				System.out.println("Jon misses!");

			}
			System.out.println("The Night King attacks!");
			if (random.nextInt(100) >= 50) {
				System.out.println("The Night King hits!\nJon has taken 5 points of damage");
				System.out.println("The Night King has healed 5 points of health");
				this.health -= 5;
				nightKingHealth += 5;
			} else {
				System.out.println("Night King misses!");
			}
			System.out.println("Jon has " + this.health + " health points left");
			System.out.println("The Night King has " + nightKingHealth + " health points left");
		} while (this.health > 0 && nightKingHealth > 0);
		if (this.health <= 0) {
			System.out.println("Jon has died, you lost");
			System.exit(2);
		} else {
			System.out.println("Jon has defeated the Night King! You have won!");
			System.exit(3);
		}
	}
}
