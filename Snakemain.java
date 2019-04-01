package mysnake;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.*;

public class Snakemain
{

	public void gamestar()
	{
		Gird gird=new Gird(Settings.row,Settings.col);
		Snakeview snakeview=new Snakeview(gird);
		Gamecontroler gamecontroler=new Gamecontroler(gird,snakeview);
		
		
		JFrame window = new JFrame("SnakeOne");
		
		Container contenPane=window.getContentPane();
		
		
		snakeview.init();
		
		
		
		window.addKeyListener(gamecontroler);
//		new Thread(gamecontroler).start();

		
		snakeview.getcanvas().setPreferredSize(new Dimension (Settings.weigh,Settings.hight));
		contenPane.add(snakeview.getcanvas(),BorderLayout.CENTER);
		

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
		window.pack();
		

	}

	public static void main(String [] args)
	{
		Snakemain snakeapp = new Snakemain();

		snakeapp.gamestar();

	}

}
