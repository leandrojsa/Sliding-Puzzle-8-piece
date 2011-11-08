import java.util.Vector;


public class Main {

	
	public static void main(String[] args) {
		
		System.out.println("Heuristic Solution for Sliding Puzzle - 8 piece\n\n");
		System.out.println("Enter with pieces separate for one space (Ex: 7 8 6 0 4 2 1 3 5):");
		
		String input = Keyboard.readString();		
		String input_array[] = input.split(" ");
		Piece[][] positions = new Piece[3][3];
		int i = 0;
		for (int x = 0; x < 3; x++){
			for (int y = 0; y < 3; y++){
				positions[x][y] = new Piece(Integer.parseInt(input_array[i]));
				positions[x][y].refreshDistanceObjective(x, y);
				i++;		
			}
				
		}
		Board board = new Board(positions);
		Vector<Board> frontier = new Vector();
		Vector<Board> explored = new Vector();
		
		Piece[][] objective = new Piece[3][3];
		objective[0][0] = new Piece(1);
		objective[0][0].refreshDistanceObjective(0, 0);
		objective[0][1] = new Piece(2);
		objective[0][0].refreshDistanceObjective(0, 1);
		objective[0][2] = new Piece(3);
		objective[0][0].refreshDistanceObjective(0, 2);
		objective[1][0] = new Piece(4);
		objective[0][0].refreshDistanceObjective(1, 0);
		objective[1][1] = new Piece(5);
		objective[0][0].refreshDistanceObjective(1, 1);
		objective[1][2] = new Piece(6);
		objective[0][0].refreshDistanceObjective(1, 2);
		objective[2][0] = new Piece(7);
		objective[0][0].refreshDistanceObjective(2, 0);
		objective[2][1] = new Piece(8);
		objective[0][0].refreshDistanceObjective(2, 1);
		objective[2][2] = new Piece(0);
		objective[0][0].refreshDistanceObjective(2, 2);
		Board objectiveBoard = new Board(objective);
		
		
		frontier.addElement(board);
		
		while (!frontier.isEmpty()){
			Board currentBoard = frontier.remove(0);
			
			if (currentBoard == objectiveBoard){
				Util.printBoard(currentBoard);
				break;
			}else{
				explored.addElement(currentBoard);
				
				
			}
			
			
			
		}
		
		
		Util.printBoard(board);

	}

}
