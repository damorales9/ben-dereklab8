public class LetterNode extends Node
{
	protected char letter;

	public LetterNode(char l, int c)
	{
		super(c);
		this.letter = l;
	}

	public String toString()
	{
		return letter + ", " +  super.count;
	}

	public void dump(String code)
	{
		System.out.println("the code for " + letter + " is " + code);
	}
}
