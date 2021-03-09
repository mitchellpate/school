package randomnumberguesser;

import java.util.Scanner;

public class randomnumberguesser {
	public static void main(String[] args)throws Exception {
	boolean playing = true;
	boolean passed = true;	
	int playagain = 0;
	int guesses = 0;
	int number = 0;
	int roundswon = 0;
	int roundsplayed = 0;
	double range = 0;
	do{ // game loop
			Scanner in = new Scanner(System.in);
			int diff = 0;
			int diffmax = 0;
			
			do{
				passed=true;
				try
				{
					System.out.println("Please choose a difficulty (1-3): ");
					diff=in.nextInt();
					passed = true;
				}
				catch(Exception Error){
					System.out.println("Invalid Input, please enter a number (1-3)");
					String garbage = in.next();
					passed = false;
				}if (passed==true&&diff<1||diff>3){
					System.out.println("That number is out of the boundaries.");
					passed=false;
				}
				
			}while(passed==false&&diff>3||1>diff);
			
			switch(diff){//switch for game difficulty
			
				case(1):
				{
				diffmax = 10;
				break;
				}
				case(2):
				{
				diffmax = 50;
				break;
				}
				case(3):{
				diffmax = 100;
				break;
				}
			}
			
			int randomNumber = (int) (Math.random() * (diffmax - 1 + 1) + 1);
			System.out.println(randomNumber);
			
			do{//loop for guess checking
				passed = true; 
				playing = true;
				if (guesses<=3) {
					try {
						
						System.out.println("Please choose a number: (1 - " + diffmax + ")");
						number=in.nextInt();
					
					}catch(Exception Error){
						
						System.out.println("Invalid input, please enter a number (1 - "+ diffmax + ")");
						String garbage = in.next();
						passed=false;
					
					}if(number>diffmax||1>number){
						
						System.out.println("Number is out of range, please enter a number between 1 - "+ diffmax );
						number = in.nextInt();
						passed = false;
					}
					
					if (number!=randomNumber&&number>=1) {
						
						guesses++;
						
						passed = false;
						
						if(number + 5 == randomNumber  ||number + 4 == randomNumber || number + 3 == randomNumber  || number + 2 == randomNumber  ||number + 1 == randomNumber )
		                {
		                    System.out.println("Hot!");
		                }
		                else if(number + (10) == randomNumber|| number + 9 == randomNumber || number + 8 == randomNumber  || number + 7 == randomNumber  || number + 6 == randomNumber)
		                {
		                    System.out.println("Warm!");
		                    
		                }
		                else
		                {
		                    System.out.println("Cold!");
		                    
		                }
						
						System.out.println("guesses used (out of 3): " + guesses);
					}
					if(guesses==3){
						System.out.println("the number was: " + randomNumber);
						System.out.println("Rounds Won: " + roundswon);
						roundsplayed++;
						System.out.println("Rounds Played: " + roundsplayed);
						System.out.println("would you like to play again? 1 for yes, 0 for no");
						playagain = in.nextInt();
						passed = true;		
						if(playagain != 1 && playagain != 0) {
							System.out.println("please enter a valid number (1 for yes, 0 for no)" );
							playagain = in.nextInt();
							do {
							System.out.println("please enter a valid number");
							playagain = in.nextInt();
							}while(playagain != 1 && playagain != 0);
						}
					
					}else if (number==randomNumber&&passed==true){
						
						roundswon++;
						roundsplayed++;
						guesses = 0;
						System.out.println("Correct! Would you like to play again?");
						System.out.println("1 for yes, 0 for no");
						System.out.println("Rounds Won: " + roundswon);
						System.out.println("Rounds Played: " + roundsplayed);
						playing = true;
						passed = true;
						playagain = in.nextInt();
						
						if(playagain==0) {
							System.out.println("Thank you for playing!");
						 
						
						
					}
						do {//to verify that playagain is either 1 or 0
							try {
								switch(playagain) {
								case(1):{
									playagain=1;
									break;
								}
								case(2):{
									playagain=0;
									break;
								}
								}
							}catch(Exception Error) {
								System.out.println("Sorry, that is an invalid number");
								System.out.println("Please enter a number (1 or 0)");
								playagain = in.nextInt();
							}
						}while(playagain!=1&&playagain!=0);
					}
				}
			}while(playing=true&&passed==false&&guesses!=3);
		}while(playing = true && playagain==1 && passed == true);
	}
}


