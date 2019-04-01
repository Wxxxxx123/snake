package mysnake;

public class Node
{
	private final int row;
	private final int col;
	
	public Node(int row,int col)
	{
		this.row=row;
		this.col=col;
	}

	public int getROW()
	{
		return row;
	}

	public int getCOL()
	{
		return col;
	}
	
}
