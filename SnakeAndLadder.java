/**
* This program is that the user checks for a option like NoPlay,Ladder or snake.
*
* @author  BathalaHaresh
*/



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
		//asking the user like what he wants to play
	    System.out.println("1.Single Player\n 2.MultiPlayer");
	    Scanner sc=new Scanner(System.in);
	    int Choice=sc.nextInt();
	    switch(Choice){
	    case 1:
	    int position=0;
	    
	    //checking that the player position is less than or equal to 100
	    while(position < 101)
	    {
	    	int dice = (int) ((Math.random() * 100) % 6) + 1;
	        position+=dice;
	        
	        System.out.println("Your dice is:"+dice);
	        
	        
	        if(ladders.contains(position))
	        {
	            position=position+dice;
	        }
	        else if(snakes.contains(position))
	        {
	            position=position-2*dice;
	        }
	        else
	        {
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
	    	System.out.println("Will be developed in next UseCase");
	    
	    }
	    sc.close();
}
}