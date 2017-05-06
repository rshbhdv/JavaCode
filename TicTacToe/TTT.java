package lecture22;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TTT extends JFrame implements ActionListener{
	private static final int BOARD_SIZE = 3;
	private static final String Cross_Text = "X";
	private static final String Zero_Text = "O";
	private static final int X_Wins = 0;
	private static final int O_Wins = 1;
	private static final int Tie = 2;
	private static final int Incomplete = 3;
	
	private JButton[][] board = new JButton[BOARD_SIZE][BOARD_SIZE];
	private boolean Cross_Turn;
	
	public TTT(){
		super.setTitle("Tic-Tac-Toe");
		super.setVisible(true);
		super.setResizable(false);
		super.setSize(700, 700);
		
		GridLayout layout = new GridLayout(BOARD_SIZE, BOARD_SIZE);
		super.setLayout(layout);
		
		for(int row=0;row<BOARD_SIZE;row++)
		{
			for(int col=0;col<BOARD_SIZE;col++)
			{
				JButton button = new JButton();
				button.setFont(new Font("Times New Roman", 2, 200));
			    button.addActionListener(this);
			    
			    this.board[row][col] = button;
			   // layout.setRows(BOARD_SIZE);
			    //layout.setColumns(BOARD_SIZE);
				super.add(button);
			}
		}
	}
	public void startGame(){
		Cross_Turn = true;
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		if(clickedButton.getText().equals(""))
		{
			makeMove(clickedButton);
		int gamestatus = getGameStatus();
		if(gamestatus ==3)
		{
			Cross_Turn = !Cross_Turn;
			super.setTitle(Cross_Turn?Cross_Text:Zero_Text);
			
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
	
	private void makeMove(JButton button){
		if(Cross_Turn == true)
		{
		button.setText(Cross_Text);
	    }
		else{
			button.setText(Zero_Text);	
		}
	}
	
	private int getGameStatus(){
	int row=0;
	int col = 0;
	String text1= "";
	String text2= "";
	int winner =0 ;
		//rows
	row=0;
	col=0;
	for(row=0;row<BOARD_SIZE;row++)
	{
		while(col<BOARD_SIZE-1)
		{
			text1 =this.board[row][col].getText() ;
			text2 = this.board[row][col+1].getText();
		    if(!text1.equals(text2) || text1.equals(""))
		    {
		    	break;
		    }
		    else{
		    	col++;
		    }
		    
		    }
		}
	if(col == BOARD_SIZE-1){
		return (text1=="X"?X_Wins:O_Wins);
	   // declareWinner(winner);
	    //return 1;
	}
	
	//cols
	row=0;
	col=0;
	for(col=0;col<BOARD_SIZE;col++)
	{
		while(row<BOARD_SIZE-1)
		{
			text1 =this.board[row][col].getText() ;
			text2 = this.board[row + 1][col].getText();
		    if(!text1.equals(text2) || text1.equals(""))
		    {
		    	break;
		    }
		    else{
		    	row++;
		    }
		    
		    }
		}
	if(row == BOARD_SIZE-1){
	     winner = (Cross_Turn?X_Wins:O_Wins);
	     declareWinner(winner);
	     return 1;
	}
	
	//diag1
	row=0;
	col=0;
	while(col<BOARD_SIZE-1)
	{
		
			text1 =this.board[row][col].getText() ;
			text2 = this.board[row + 1][col+1].getText();
		    if(!text1.equals(text2) || text1.equals(""))
		    {
		    	break;
		    }
		    else{
		    	row++;
		    	col++;
		    }
		    
		    
		}
	if(col == BOARD_SIZE-1){
		 declareWinner(winner);
		 return (text1=="X"?X_Wins:O_Wins);
	//     declareWinner(winner);
	  // return 1;
	}
	
	//diag2
	row=0;
	col=2;
	
	while(row<BOARD_SIZE-1)
		{
			text1 =this.board[row][col].getText() ;
			text2 = this.board[row + 1][col-1].getText();
		    if(!text1.equals(text2) || text1.equals(""))
		    {
		    	break;
		    }
		    else{
		    	row++;
		    	col--;
		    }
		    
		    
		}
	if(row == BOARD_SIZE-1){
	     return (text1=="X"?X_Wins:O_Wins);
	   //  declareWinner(winner);
	     //return 1;
	}
	
	//incomplete
	row=0;
	col=0;
	for(col=0;col<BOARD_SIZE;col++)
	{
		for(row=0;row<BOARD_SIZE-1;row++)
		{
			text1 =this.board[row][col].getText() ;
	
		    if(text1.equals(""))
		    {
		    	return Incomplete;
		    }
		    }
		}
	
	//declareWinner(3);
	return Tie;
	
	}

	private void declareWinner(int gamestatus){
		if(gamestatus ==0 )
		{
			JOptionPane.showMessageDialog(null, "X_Wins");
		}
		if(gamestatus ==1 )
		{
			JOptionPane.showMessageDialog(null, "O_Wins");
		}
		if(gamestatus ==2 )
		{
			JOptionPane.showMessageDialog(null, "Tie");
		}
	}
}
