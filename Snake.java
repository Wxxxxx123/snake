package mysnake;

import java.util.LinkedList;

import mysnake.Node;

public class Snake
{
	private LinkedList<Node> snakebody = new LinkedList<>();
//	private Direction direction;
	private Node nextone;

	public Snake()
	{
//		direction = Direction.up;
		int a = Settings.col / 2;
		this.getsnakebody().add(new Node(3, a));
		this.getsnakebody().add(new Node(2, a));
		this.getsnakebody().add(new Node(1, a));
		this.getsnakebody().add(new Node(0, a));

	}

//	public Direction setDirection(Direction diraction)
//	{
//		this.direction = direction;
//		System.out.print("蛇的方向为");
//		return direction;
//	}
//
//	public Direction getDirection()
//	{
//		return direction;
//	}

	// 蛇根据方向获取下一个到达的点 并返回这个点
	public Node getnextone(Direction direction)
	{
		int addrow;
		int addcol;

		addrow = snakebody.getFirst().getROW();
		addcol = snakebody.getFirst().getCOL();
		switch (direction)
		{
		case up:
			addcol--;
			break;
		case down:
			addcol++;
			break;
		case left:
			addrow--;
			break;
		case right:
			addrow++;
			break;
		}
		nextone = new Node(addrow, addcol);
		return nextone;
	}

	// 获取头部点
	public Node getsnakehead()
	{
		return snakebody.getFirst();
	}

	// 获取蛇身链表
	public LinkedList<Node> getsnakebody()
	{
		return snakebody;
	}

	// 获取蛇尾部点
	public Node getsnaketail()
	{
		return snakebody.getLast();
	}
}
