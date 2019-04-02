
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JugPuzzleGUIController implements ActionListener {
	private JFrame frame;
	private JButton b1,b2,b3,quit, new_game;
	private JPanel panel1,panel2,panel3;
	private JLabel jugs0,jugs1,jugs2,numMoves;
	private JugPuzzle game;
	private boolean buttonPressed=false,solved;
	private int from,to;
	
	public JugPuzzleGUIController(){
		
		game= new JugPuzzle(); // Initiating a new JugPuzzle 
//		Jug[] jugs=game.getJugs();
//		Jug jug0=jugs[0]; Jug jug1=jugs[1]; Jug jug2=jugs[2]; //  Assign Jugs to different variables
		
		frame = new JFrame("Jug Puzzle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contains = frame.getContentPane();
//		frame.getContentPane().setLayout(new  BorderLayout());
		
		b1 = new JButton("8");// This button refers to jug0.
		b2 = new JButton("5");// This button refers to jug1.
		b3 = new JButton("3");// This button refers to jug2.
		quit = new JButton("Quit");
		new_game= new JButton("New Game");
		
		// Adding ActionListener to the buttons.
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		quit.addActionListener(this);
		new_game.addActionListener(this);
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
				
//		numMoves = new JLabel("<html><b>Moves: " + game.getMoves() + " <b></html>");
		
		MovesView num= new MovesView();
		
		// Set the initial amount of Liquid in each jug.
//		jugs0=new JLabel("" + jug0.getAmount()+ "               ");
//		jugs1=new JLabel(" " +jug1.getAmount()+ "          ");
//		jugs2=new JLabel("        "+jug2.getAmount());
		
		JugView j0= new JugView(0);
		JugView j1= new JugView(1);
		JugView j2= new JugView(2);
		
		game.addObserver(j0);
		game.addObserver(j1);
		game.addObserver(j2);
		game.addObserver(num);
		
		
		panel1.add(b1);
		panel1.add(b2);
		panel1.add(b3);
		
		frame.add(j0);
		panel3.add(j1);
		panel3.add(j2);
		
		panel2.add(new_game);
		panel2.add(num);
		panel2.add(quit);

		//Designing the Layout for the GUI.
		contains.add(panel3, BorderLayout.NORTH);
		contains.add(panel1);
		contains.add(panel2, BorderLayout.SOUTH);
		
		frame.setSize(600, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.notifyObservers();
	
	}
	
		
	
	public static void main(String[] args) {		
		// creating and showing this application's GUI.
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				@SuppressWarnings("unused")
				JugPuzzleGUIController jugg = new JugPuzzleGUIController();
			} });}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		String button = e.getActionCommand();
		
		// If the pouring jug has not been set and the button is "8".
		if (button.equals("8") && buttonPressed==false){
			from=0;      // The user chooses to pour from jug0.
			buttonPressed=true;  // Marks that the pouring jug has been set.
			button="";	 }
		
		
			// If the pouring jug has been set and the button is "8".
		if (button.equals("8") && buttonPressed==true){
			to=0;     // The user chooses to spill into jug0.
			buttonPressed=false;  // Marks that spilling jug has been set .
			game.move(from,to); // Call the method move from JugPuzzle class.
		}
		
			// If the pouring jug has not been set and the button is "5".
		if (button.equals("5") && buttonPressed==false){
			from=1;  // The user chooses to pour from jug1.
			buttonPressed=true;
			button="";	// This set the button to an empty string so that it waits for the 
						//next button to get pressed in the game and not call the next if statement.
		}
		
		// If the pouring jug has been set and the button is "5".
		if (button.equals("5") && buttonPressed==true){
			to=1; // The user chooses to spill into jug1.
			buttonPressed=false;
			game.move(from,to);}		
		
		// If the pouring jug has not been set and the button is "3".
		if (button.equals("3") && buttonPressed==false){
			from=2; // The user chooses to pour from jug2.
			buttonPressed=true;
			button="";	}
		
		// If the pouring jug has been set and the button is "3".
		if (button.equals("3") && buttonPressed==true){
			to=2;  // The user chooses to spill into jug2.
			buttonPressed=false;
			game.move(from,to);}
		
		if (button.equals("Quit")){
			System.exit(0);}	// This will close the frame and end the game.
		
		if(button.equals("New Game")){
			frame.dispose();
			main(null);	// Starts a new game by calling the main method.
		}
		
//		Jug[] jugs=game.getJugs();
//
//		Jug jug0=jugs[0]; Jug jug1=jugs[1]; Jug jug2=jugs[2];
//		
//		//Change the amount of liquid in different jugs as player progresses in the game.
//		jugs0.setText("" + jug0.getAmount()+ "               ");
//		jugs1.setText(" " +jug1.getAmount()+ "          ");
//		jugs2.setText("        "+jug2.getAmount());
		
		// if the game is not solved the if system will work.
//		if(solved==false){
//			numMoves.setText("<html><b>Moves: " + game.getMoves() + " <b></html>");}// This bold text will be set in the frame to show the
//																					//moves made by the player.
//		
		solved= game.getIsPuzzleSolved();//Checks if the game is solved or not.
		
		// if the game is solved the if system will work.
		if (solved==true){
//			numMoves.setText("<html>Congratulations! You won in <b>" + game.getMoves()+  
//								" moves<b></html>");//This text will be set in the frame showing the number of moves
//													//made by the player to complete the game and the text is in bold.
			
			b1.setEnabled(false); b2.setEnabled(false); b3.setEnabled(false);}// Disable all the buttons that control jugs.	 
	
		game.notifyObservers();
	}
}