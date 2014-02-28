package rp13.search.problem.string;
// give program String
// method that scrambles String
// output scrambled String
// Solve
import java.util.Random;
import java.util.Scanner;

public class JumbledString 
{
	private String word;
	private char[] solved;
	private char[] scrambled;
	private char[] current;
	private int size;
	private Random randy;
	
	public JumbledString(String word) 
	{
		this.word = word;
		this.size = word.length();
		this.solved = new char[size];
		this.scrambled = new char[size];
		this.solved = word.toCharArray();
		this.current = this.solved;
		this.randy = new Random();
		Scramble(size * size * size);
	}
	
	public void Scramble(int _moves) 
	{
		for (int i = 0; i < _moves; i++) 
		{
			JumbledString.makeMove(randomMove());
		}
	}
	
	private static void makeMove(Move move) 
	{
		if(move.isPossibleMove())
		{
			char first = current[move.getFirst()];
		}
		
	}

	private Move randomMove() 
	{
		int first = (int)(Math.random() * size);
		int second = (int)(Math.random() * size);
		Move move = new Move(first, second, current);
		
		return (move);
	}

	public String toString()
	{
		return scrambled.toString();
	}
	
	public static void main(String[] args) 
	{
		String word;
		
		Scanner input = new Scanner(System.in);
		System.out.println("String to be scarmbled and solved: ");
		word = input.nextLine();
		
		JumbledString solver = new JumbledString(word);
		
	}
}
