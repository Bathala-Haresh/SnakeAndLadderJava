package snakesAndLaders;
import java.util.*; 
import java.util.Scanner;
public class SnakesAndLadder
{
	public static void main(String[] args) {
		//taken arrarList to add the position of ladders and snakes.
		List<Integer> ladders=new ArrayList<Integer>(); 
		List<Integer> snakes=new ArrayList<Integer>(); 
		ladders.add(4);
		ladders.add(13);
		snakes.add(27);
		ladders.add(33);
		snakes.add(40);
		snakes.add(43);
		ladders.add(42);
		ladders.add(50);
		snakes.add(54);
		ladders.add(62);
		snakes.add(66);
		ladders.add(74);
		snakes.add(76);
		snakes.add(89);
		ladders.add(99);
		game(ladders,snakes);

	}
	public static void game(List<Integer> ladders,List<Integer> snakes)
	{
		System.out.println("1.Single Player\n2.2 Players");
		Scanner sc=new Scanner(System.in);
		int Choice=sc.nextInt();
		
		switch(Choice){
		case 1:
			int position=0,steps=0;
			int min=1,max=6;
			while(true)
			{
				int dice = (int)(Math.random()*(max-min+1)+min);
				position+=dice;
				steps++;
				System.out.println("Your dice is:"+dice);
				if(position==100)
				{
					System.out.println("You Won the Match");
					System.out.println("You taken Steps"+steps);
					return;
				}
				else if(position>100)
				{
					position=position-dice;
				}
				else if(ladders.contains(position))
				{
					position=position+dice;
				}
				else if(snakes.contains(position))
				{
					position=position-2*dice;
				}
				else
				{
					//if position is not in ladder or snake then asking user to confirm whether wants to move or not
					System.out.println("1.Move\n2.Not Move");
					System.out.println("Enter Choice:");
					int ch=sc.nextInt();
					switch(ch){
					case 1: break;
					case 2: position=position-dice;
					break;
					default:System.out.println("You Entered Wrong Choice");
					break;
					}
				}
				System.out.println("Your position is:"+position);
			}
		case 2:
			//used for saving position of players
			int position2[]=new int[3];
			int steps2[]=new int[3];
			int current=1;

			while(true)
			{
				int dice = (int) ((Math.random() * 100) % 6) + 1;
				//storing current position in tempcurrent
				int tempcurrent=current;
				//incrementing position with dice
				position2[tempcurrent]+=dice;
				//adding number of steps
				steps2[tempcurrent]++;
				System.out.println("-------The Player is------"+tempcurrent);
				System.out.println("Your dice is:"+dice);
				if(current==1)
				{
					current=2;
				}
				else
				{
					current=1;
				}
				if(position2[tempcurrent]==100)
				{
					System.out.println("player"+tempcurrent+"Won the Match");
					System.out.println("You taken Steps :"+steps2[tempcurrent]);
					return;
				}
				else if(position2[tempcurrent]>100)
				{
					position2[tempcurrent]=position2[tempcurrent]-dice;
				}
				else if(ladders.contains(position2[tempcurrent]))
				{
					position2[tempcurrent]=position2[tempcurrent]+dice;
					//giving chance to play again
					current=tempcurrent;
				}
				else if(snakes.contains(position2[tempcurrent]))
				{
					position2[tempcurrent]=position2[tempcurrent]-2*dice;
				}

				else
				{
					System.out.println("1.Move\n2.Not Move");
					System.out.println("Enter Choice:");
					int ch=sc.nextInt();
					switch(ch){
					case 1: break;
					case 2: position2[tempcurrent]=position2[tempcurrent]-dice;
					break;
					default:System.out.println("You Entered Wrong Choice");
					break;
					}
				}
				System.out.println("Your position is:"+position2[tempcurrent]);

			}
		}
		sc.close();
		
	}
}