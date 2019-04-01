package mysnake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gamecontroler implements Runnable, KeyListener
{

	private Gird gird;
	private Snakeview snakeview;
	private boolean ispause=true;

	public Gamecontroler(Gird gird, Snakeview snakeview)
	{
		this.gird = gird;
		this.snakeview = snakeview;

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_UP)
		{
			gird.changedirection(Direction.up);
			System.out.print("up");
		} else if (keyCode == KeyEvent.VK_DOWN)
		{
			gird.changedirection(Direction.down);
			System.out.print("down");
		} else if (keyCode == KeyEvent.VK_LEFT)
		{
			gird.changedirection(Direction.left);
			System.out.print("left");
		} else if (keyCode == KeyEvent.VK_RIGHT)
		{
			gird.changedirection(Direction.right);
			System.out.print("right");
		} else if (keyCode == KeyEvent.VK_SPACE)
		{
			Thread a=new Thread(this);
			if(ispause)
			{
				ispause=false;
				a.start();
			}
			else
			{
				a.interrupt();
			    ispause=true;
			    
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void run()
	{
		while (!ispause)
		{

			{
				try
				{
					Thread.sleep(Settings.sleeptime);
				} catch (InterruptedException e)
				{
					break;
				}
				gird.snakemove();
				snakeview.draw();
			}
		}

	}

}
