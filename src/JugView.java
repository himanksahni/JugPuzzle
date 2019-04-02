import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;


public class JugView extends JLabel implements Observer  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel j0 ,j1, j2;
	private int jugNum;
	
	public JugView(int jugNum){
		this.jugNum=jugNum;
		
		if(jugNum==0)
			this.setText("8/8");
		
		if(jugNum==1)
			
			this.setText("0/5");
		
		if(jugNum==2)
			
			this.setText("0/3");
	}
	
	
	
	public void update(Observable o, Object arg){
		
		JugPuzzle jug= (JugPuzzle)o;
		
		Jug[] jugs=jug.getJugs();

		Jug jug0=jugs[0]; Jug jug1=jugs[1]; Jug jug2=jugs[2];
		
		//Change the amount of liquid in different jugs as player progresses in the game.
		this.setText("" + jug0.getAmount()+ "               ");
		this.setText(" " +jug1.getAmount()+ "          ");
		this.setText("        "+jug2.getAmount());
		
	}

}
