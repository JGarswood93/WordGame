		package Adventure;// package name associated with the project
		import java.util.Scanner; // scanner this is to allow user interaction and to allocate that data so that it can be used.
    		public class WordGame { // class something that has to be created
    		public static void main(String[] args) { // this is the main which is where the script is to be written
	
		Scanner user_input = new Scanner(System.in);// read user input
		// IN THIS PART WE MAY HAVE TO LOOK MORE INTO HOW THE USER INPUT
		//IS BEING USED, ALTERNATIVES SO WE CAN LOOK INTO HOW AND WHY WE MAY HAVE BEEN MAKING MISTAKES
	
		String temp;	// temporary string where the user input is stored
		System.out.println("You are trying to escape the dangerous Centaur (half man half horse). "
				+ "His intentions are to destroy you, and yours are to get away from him, or defeat him should you be so brave"
				+ "At this moment you have a choice do you try to run from the beast.");
		System.out.println("Hide or to pick up the mace and Fight or you can try to outrun him"
				+ "what do you choose?"
				+ 
				"Type your choice");//HERE WE NEED TO MAKE THIS STRING PARAGRAPHED IN A WAY THAT WILL COMPLIMENT THE USER
								//EXPERIENCE
		temp = user_input.next().toLowerCase();// some sort of edition here maybe needed
		System.out.println(temp);//OUTPUT FOR THE USER
		if ("fight".equals(temp)) //TEMP AS AN OUTPUT
		
		{
		
		System.out.println("You have chosen to fight");
		
		System.out.println("the monster gallops over your head do you? counter attack or dodge?");
		temp = user_input.next().toLowerCase();
		if("counter attack".equals(temp))
			
		{
			System.out.println("You have inflicted damage on to the beast but he comes at you for another counter attack");	
		}
		
		}
	
		
		else if("hide".equals(temp)) {
		
		System.out.println("You have chosen to hide");
		
		}
		
		else if("run".equals(temp)) {
		
		System.out.println("You have chosen to run");
		
		if ("dodge".equals(temp)) {
		
		System.out.println("The creature misses but he strikes again, what do you do?");
		}
		
		}
    		}
    		}
    		
    
		
	
    
    
    

