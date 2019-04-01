package mysnake;

import java.awt.*;
import javax.swing.JPanel;

public class Snakeview
{
	private final Gird grid;
	
	private JPanel canvas;

    public void init() {
        canvas = new JPanel() {

			@Override
            public void paintComponent(Graphics graphics) {
				drawgirdbackground(graphics);          	
                drawsnake(graphics, grid.getsnake());
                drawfood(graphics, grid.getfood());
                
            }
        };
    }


	public Snakeview(Gird gird)
	{
		this.grid = gird;
	}

	public void draw()
	{
		canvas.repaint();
	}
	
	public JPanel getcanvas()
	{
		return canvas;
	}
	
//画背景
	private void drawgirdbackground(Graphics graphics)
	{
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, 640, 320);
		
//		for(int i=0;i<Settings.row;i++)
//		{
//			for(int j=0 ;j<Settings.col;j++)
//			{
//				this.drawSquare(graphics, new Node(i,j),Color.CYAN);
//			}
//		}
	}
	
	
//画食物
	private void drawfood(Graphics graphics, Node getfood)
	{
		this.drawCircle(graphics, grid.getfood(), Color.RED);

	}

	//画蛇
	private void drawsnake(Graphics graphics, Snake getsnake)
	{
		for (Node a : grid.getsnake().getsnakebody())
		{
			this.drawCircle(graphics, a, Color.BLUE);
		}
		Node b=grid.getsnake().getsnakehead();
		this.drawCircle(graphics, b, Color.GREEN);
//		this.drawCircle(graphics, b, Color.red);

	}

	private void drawCircle(Graphics graphics, Node squareArea, Color color)
	{
		graphics.setColor(color);
		int size = Settings.squaresize;
		graphics.fillOval(squareArea.getROW() * size, squareArea.getCOL() * size, size, size );
	}

	private void drawSquare(Graphics graphics, Node squareArea, Color color)
	{
		graphics.setColor(color);
		int size = Settings.squaresize;
		graphics.fillRect(squareArea.getROW() * size, squareArea.getCOL() * size, size-1 , size-1 );
	}
	

}
