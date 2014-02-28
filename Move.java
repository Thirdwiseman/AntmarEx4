package rp13.search.problem.string;

public class Move 
{
	private int first;
	private int second;
	private char[] state;
	private boolean test;
	
	public Move(int first, int second, char[] state)
	{
		this.first = first;
		this.second = second;
		this.state = state;
		
		if(this.first >= 0 && this.second <= this.state.length && this.first != this.second){
			this.test = true;
		}
		else
		{
			this.test = false;
		}
	}

	public boolean isPossibleMove() 
	{
		return this.test;
	}
	
	public int getFirst()
	{
		return this.first;
	}
	
	public int getSecond()
	{
		return this.second;
	}
}
