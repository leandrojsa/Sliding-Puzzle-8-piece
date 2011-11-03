import java.util.Vector;


public class Main {

	
	public static void main(String[] args) {
		
		System.out.println("Heuristic Solution for Sliding Puzzle - 8 piece\n\n");
		System.out.println("Enter with pieces separate for one space (Ex: 7 8 6 0 4 2 1 3 5):");
		
		String input = Keyboard.readString();		
		String input_array[] = input.split(" ");
		Board board = new Board();		
		int i = 0;
		for (int x = 0; x < 3; x++){
			for (int y = 0; y < 3; y++){
				board.positions[x][y] = new Piece(Integer.parseInt(input_array[i]));
				board.positions[x][y].refreshDistanceObjective(x, y);
				i++;		
			}
				
		}
		
		Vector<Piece> frontier = board.priorityPieces();
		Vector explored = new Vector();
		
		
		
		Util.printBoard(board);
		for(int a =0; a < frontier.size(); a++){
			System.out.println("Piece " + frontier.elementAt(a).id + ": " + frontier.elementAt(a).getCost());
			
		}

	}

}
