package com.company;
import java.util.Scanner;

public class Main {
	static int health;
	static int creatureHealth;
	static String healthbar = "<<< ";
	static String userInput;
	static int rand;
	static int rand2;

	static Scanner user_input = new Scanner(System.in);

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_mystery = "\u001B[29m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";

	public static void main(String[] args) {
		health = 4; // HP is changeable depending on how long the game should last
		creatureHealth = 4;

		System.out.println("You awake cloaked in darkness in a strange, damp room.\n"
				+ "A rumbling roar startles you and, as you turn around, you're accosted by a centaur " + ANSI_mystery + "(half man half horse).\n"
				+ ANSI_RESET + "At this moment you have a choice: Do you try to run from the beast?");

		while (health>0 && creatureHealth >0) {
			System.out.println("Type Hide to attempt evading the attack by typing " + ANSI_CYAN + "Hide" + ANSI_RESET + ", " + ANSI_PURPLE + "Fight" + ANSI_RESET + " to pick up the mace, or you can try to outrun him by typing " + ANSI_GREEN + "Run" + ANSI_RESET + "."
					+ " \nType your choice");

			userInput = user_input.next().toLowerCase();

			if ("fight".equals(userInput)) {
				// while (health > 0 && creatureHealth > 0) {
				System.out.print("You have chosen to fight. \n ");

				randomChanceAttack();
				randomChanceHit(4);

				healthDisplay();
				// }
			} else if ("hide".equals(userInput)) {
				System.out.println("You have chosen to hide.");
				// while (health > 0 && creatureHealth > 0) {
				System.out.println("You leap around in attempt to evade the creature.");
				randomChanceHit(7);

				healthDisplay();
				//  }
			} else if ("run".equals(userInput)) {
				System.out.println("You have chosen to run.");
			}

			if (health <= 0) {
				System.out.println("You've succumbed to your wounds, and ultimately, death itself. Try again.");
			} else if (creatureHealth <= 0) {
				System.out.println("You have defeated the evil creature! Congratulations, you win!");
			}
		}

	}

	public static void displayHealthBar(int healthCount) {
		System.out.print("Health Bar: ");
		for (int i = 0; i < healthCount; i++) {
			System.out.print(healthbar);
		}
	}

	public static void randomChanceAttack() {
		rand = (int)(Math.random() * 1000);

		if (rand%5==0) {
			System.out.println("Your hit failed to connect rendering your turn ineffectual...");
			rand = 0;
		} else {
			creatureHealth -= 1;
			rand = 0;
		}
	}

	public static void randomChanceHit(int chance) {
		rand2 = (int)(Math.random() * 1000);

		if (rand2%chance==0) {
			System.out.println("The creature swings wildly and deals you deep bodily wounds.");
			health -= 1;
			rand2 = 0;
		} else {
			System.out.println("The creature swings and misses leaving you safe... for now.");
			rand2 = 0;
			System.out.println("You deftly injure your attacker!");
		}
	}

	public static void healthDisplay() {
		System.out.print("Your ");
		displayHealthBar(health);
		System.out.print("\nCreature's ");
		displayHealthBar(creatureHealth);
		System.out.print("\n");
		System.out.print("\n");
	}
}