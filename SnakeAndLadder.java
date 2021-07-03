/**
* This program is to ensure repeating till the user position reaches 100.
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
	    System.out.println("1.Single Player\n2.2 Players");
	    Scanner sc=new Scanner(System.in);
	    int Choice=sc.nextInt();
	    switch(Choice){
	    case 1:
	    int position=0;
	    while(true)
	    {
	    	int dice = (int) ((Math.random() * 100) % 6) + 1;
	        position+=dice;
	        
	        System.out.println("Your dice is:"+dice);
	        
	        if(position==100)
	        {
	            System.out.println("You Won the Match");
	            
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
	    	System.out.println("Will be developed in next UseCase");
	    }
	    sc.close();
	   
}
}