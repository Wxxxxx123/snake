package mysnake;

import mysnake.Node;

public class Gird
{
	private Snake snake;
	private Node food;
	private int rows = Settings.row;
	private int cols = Settings.col;
	private Direction direction = Direction.right;

	//根据设置的棋盘行列数初始化棋盘
	public Gird(int rows, int cols)
	{
		snake = new Snake();
		// newSnake();// 生成蛇的身体
		createFood();// 生成食物
	}

	// private Snake newSnake()// 初始化蛇
	// {
	//
	// }

	
	//生成随机点
	private Node randomnode()
	{
		int foodrow = (int) (Math.random() * Settings.row);
		int foodcol = (int) (Math.random() * Settings.col);
		Node a = new Node(foodrow, foodcol);
		return a;
	}

	// 生成食物
	private Node createFood()
	{
		food = this.randomnode();
		while (this.issnakebody(food))
		{
			food = this.createFood();
		}
		return food;

	}

	//获取食物点
	public Node getfood()
	{
		return food;
	}

	// 判断某一点是不是食物
	private boolean isfood(Node addOne)
	{
		if (addOne.getROW() == food.getROW() && addOne.getCOL() == food.getCOL())
		{

			return true;
		} else
		{
			return false;
		}
	}

	
	//移动蛇
	public Snake snakemove()
	{
		Node a = snake.getnextone(this.direction);
		if ((!this.issnakebody(a) && a.getROW() >= 0 && a.getROW() < rows && a.getCOL() >= 0 && a.getCOL() < cols))
		{
			snake.getsnakebody().addFirst(a);

			if (this.isfood(a))// 如果蛇头是食物就生成新的食物否则移除蛇尾
			{
				this.createFood();
			} else
			{
				snake.getsnakebody().removeLast();
			}
		} else
		{
			snake = new Snake();
			direction = Direction.right;

		}

		return snake;
	}

	// 判断一点是不是蛇身
	private boolean issnakebody(Node someone)
	{
		boolean is = false;
		for (Node a : snake.getsnakebody())
		{
			if ((a.getROW() == someone.getROW() && a.getCOL() == someone.getCOL()))
			{
				is = true;
				break;
			}
		}
		return is;
	}

	public Snake getsnake()
	{
		return snake;
	}

	
	//改变蛇的方向
	public void changedirection(Direction d)
	{
		Direction up=Direction.up;
		Direction down=Direction.down;
		Direction left=Direction.left;
		Direction right=Direction.right;
		
		
		if(!(this.direction==up&&d==down
				
			||this.direction==down&&d==up
			
			||this.direction==left&&d==right
			
			||this.direction==right&&d==left))
		{
			this.direction=d;
		}
	}

}
