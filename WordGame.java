package Adventure; // package name associated with the project
import java.util.Scanner; // scanner this is to allow user interaction and to allocate that data so that it can be used.

public class WordGame
{ // class something that has to be created
	int health = 4;
	int creatureHealth = 4;
	String healthbar = "<<< ";
	boolean fightStarted = false;
	int rand;

	public static void main(String[] args)
	{ // this is the main which is where the script is to be written

		Scanner user_input = new Scanner(System.in); // read user input
				// IN THIS PART WE MAY HAVE TO LOOK MORE INTO HOW THE USER INPUT
				//IS BEING USED, ALTERNATIVES SO WE CAN LOOK INTO HOW AND WHY WE MAY HAVE BEEN MAKING MISTAKES
	
		String temp;	// temporary string where the user input is stored
		System.out.println("You are trying to escape the dangerous Centaur (half man half horse). "
				+ "His intentions are to destroy you, and yours are to get away from him, or defeat him should you be so brave."
				+ "At this moment you have a choice: Do you try to run from the beast?");
		System.out.println("Type Hide to attempt evading the attack, Fight to pick up the mace, or you can try to outrun him by typing Run."
				+ "Type your choice"); //HERE WE NEED TO MAKE THIS STRING PARAGRAPHED IN A WAY THAT WILL COMPLIMENT THE USER
								//EXPERIENCE

		temp = user_input.next().toLowerCase(); // some sort of edition here maybe needed

		System.out.println(temp); //OUTPUT FOR THE USER

		if ("fight".equals(temp))
		{ //TEMP
			fightSequence();
		}
		else if("hide".equals(temp))
		{
			System.out.println("You have chosen to hide.");
		}
		
		else if("run".equals(temp))
		{
			System.out.println("You have chosen to run.");
		}
	}

	public void fightSequence()
	{
		if ((health <= 0) && (creatureHealth <= 0))
		{
			if (fightStarted == false)
			{ // If the fight has not commenced, print opening fight statement and change fight marking boolean to true
				System.out.print("You have chosen to fight. \n ");

				fight();
				fightStarted = true;

				fightSequence();
			}
			else
			{
				fight();

				System.out.println("The monster gallops over your head, do you counter attack or dodge?");
				temp = user_input.next().toLowerCase();

				if ("counter attack".equals(temp))
				{
					fight();

					fightSequence();
				}
				else if ("dodge".equals(temp))
				{
					System.out.println("You leap around in attempt to evade the creature.");

					randomChanceHit(7);

					System.out.print("Your ");
					displayHealthBar(health);
					System.out.print("Creature's ");
					displayHealthBar(creatureHealth);

					fightSequence();
				}
			}
		}
		else if (health >= 0)
		{
			sout("You've succumbed to your wounds, and ultimately, death itself. Try again.");
		}
		else if (creatureHealth >= 0)
		{
			sout("You have defeated the evil creature! Congratulations, you win!");
		}
	}

	public void displayHealthBar(int healthCount)
	{
		System.out.print("Health Bar: ");
		for (int i = 0, i < healthCount, i++)
		{
			System.out.print(healthbar);
		}
	}

	public void randomChanceAttack()
	{
		rand = (int)(Math.random() * 1000);

		if (rand%5==0)
		{
			System.out.println("Your hit failed to connect rendering your turn ineffectual...");
		}
		else
		{
			System.out.println("You deftly injure your attacker!");
			creatureHealth -= 1;
		}
	}

	public void randomChanceHit(int chance)
	{
		rand = (int)(Math.random() * 1000);

		if (rand%chance==0)
		{
			System.out.println("The creature swings wildly and deals you deep bodily wounds.");
			health -= 1;
		}
		else
		{
			System.out.println("The creature swings and misses leaving you safe... for now.");
		}
	}

	public void fight()
	{
		randomChanceAttack();
		randomChanceHit(4);

		System.out.print("Your ");
		displayHealthBar(health);
		System.out.print("Creature's ");
		displayHealthBar(creatureHealth);
	}
}