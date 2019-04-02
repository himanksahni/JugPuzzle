
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

/**
 * Updates the TotalMoves onto Screen
 * @author student
 *
 */
public class MovesView extends JLabel implements Observer {
	
	public MovesView(){
		
		this.setText("<html><b>Moves: " + "0" + " <b></html>");
	
	}

	public void update(Observable o, Object arg){
		
		JugPuzzle game = (JugPuzzle)o;
		
//		this.setText("<html><b>Moves: " + j.getMoves() + " <b></html>");
		
		boolean solved= game.getIsPuzzleSolved();//Checks if the game is solved or not.
		
		if(solved==false){
			this.setText("<html><b>Moves: " + game.getMoves() + " <b></html>");}// This bold text will be set in the frame to show the
																					//moves made by the player.
		

		
		// if the game is solved the if system will work.
		if (solved==true){
			this.setText("<html>Congratulations! You won in <b>" + game.getMoves()+  
								" moves<b></html>");//This text will be set in the frame showing the number of moves
													//made by the player to complete the game and the text is in bold.
			
	
		}
	
	}

}