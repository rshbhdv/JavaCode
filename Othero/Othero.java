package lecture22;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Othero extends JFrame implements ActionListener{

	private boolean Cross_Turn;
	private static final int BOARD_SIZE = 8;
	private JButton[][] board = new JButton[BOARD_SIZE][BOARD_SIZE];
	private static final String Black_Text = "Black";
	private static final String White_Text = "White";
	 
	public Othero() 
	{
		super.setTitle("Othero");
		super.setVisible(true);
		super.setResizable(false);
		super.setSize(850, 850);
		//super.setLayout(layout);
	//	super.setSize(850, 850);
		
		GridLayout layout = new GridLayout(BOARD_SIZE, BOARD_SIZE);
		super.setLayout(layout);
		//super
		for(int row=0;row<BOARD_SIZE;row++)
		{
			for(int col=0;col<BOARD_SIZE;col++)
			{
				JButton button = new JButton();
			    button.addActionListener(this);
			    
			    this.board[row][col] = button;
			   // layout.setRows(BOARD_SIZE);
			    //layout.setColumns(BOARD_SIZE);
				super.add(button);
			}
		}
		super.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		if(clickedButton.getText().equals(""))
		{
			makeMove(clickedButton);
		int gamestatus = getGameStatus();
		if(gamestatus ==0)
		{
			Cross_Turn = !Cross_Turn;
			super.setTitle(Cross_Turn?Black_Text:White_Text);
			
		}
		else{
			declareWinner(gamestatus);
			dispose();
		}
			
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Wrong Move");
		}
		
	}
	public void startGame(){
		Cross_Turn = true;
	}
	private void makeMove(JButton button){
		if(Cross_Turn == true)
		{
		button.setBackground(Color.BLACK);
	    }
		else{
			button.setBackground(Color.WHITE);	
		}
	}

	private int getGameStatus()
	{
		return 0;
	}
	
	private void declareWinner(int gameStatus)
	{
		
	}
}
