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
	
	/**
	 * Create a new Jumbled String given a string
	 * @param word
	 */
	public JumbledString(String word) 
	{
		this.word = word;
		this.size = word.length();
		this.solved = new char[size];
		this.scrambled = new char[size];
		this.solved = word.toCharArray();
		this.current = this.solved;
		scramble(size * size * size);
	}
	
	/**
	 * Create a new JumbledString by copying the given JumbledString
	 * @param state
	 */
	public JumbledString(JumbledString state)
	{
		this.word = state.getWord();
		this.size = state.getSize();
		this.solved = state.getSolved();
		this.scrambled = state.getScrambled();
		this.current = state.getCurrent();
	}
	
	public void scramble(int _moves) 
	{
		for (int i = 0; i < _moves; i++) 
		{
			boolean moveMade = false;
			while(!moveMade)
			{
				moveMade = makeMove(randomMove());
			}	
		}
		scrambled = current;
	}
	
	private boolean makeMove(Move move) 
	{
		if(move.isPossibleMove())
		{
			char first = current[move.getFirst()];
			char second = current[move.getSecond()];
			
			current[move.getFirst()] = second;
			current[move.getSecond()] = first;
			return true;
		}
		else
		{
			return false;
		}
	}

	private Move randomMove() 
	{
		int first = (int)(Math.random() * size);
		int second = (int)(Math.random() * size);
		Move move = new Move(first, second, current);
		
		return (move);
	}
	
	public boolean goalTest(char[] state)
	{
		if(state.equals(solved))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public String toString()
	{
		String letters = "";
		for(int i = 0; i < size; i++)
		{
			letters = letters + current[i];
		}
		
		return letters;
	}
	
	public static void main(String[] args) 
	{
		String word;
		
		Scanner input = new Scanner(System.in);
		System.out.println("String to be scarmbled and solved: ");
		word = input.nextLine();
		
		JumbledString solver = new JumbledString(word);
		System.out.println(solver.toString());
	}
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public char[] getSolved() {
		return solved;
	}

	public void setSolved(char[] solved) {
		this.solved = solved;
	}

	public char[] getScrambled() {
		return scrambled;
	}

	public void setScrambled(char[] scrambled) {
		this.scrambled = scrambled;
	}

	public char[] getCurrent() {
		return current;
	}

	public void setCurrent(char[] current) {
		this.current = current;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
