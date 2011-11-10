import java.util.Collections;
import java.util.Vector;


public class Main {
	
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
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
		Vector<Board> frontier = new Vector<Board>();
		Vector<Board> explored = new Vector<Board>();
		
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
			System.out.println("Explored: " + explored.size());
			Board currentBoard = frontier.remove(0);
			System.out.println("frontier: " + frontier.size());
			//System.out.println("cost: " + currentBoard.getCost());
			//Util.printBoard(currentBoard);
			
			if (Util.cmpBoard(currentBoard, objectiveBoard)){
				Util.printBoard(currentBoard);
				Vector<Board> steps = new Vector<Board>();
				
				while(currentBoard.parent != null){
					steps.add(currentBoard);
					currentBoard = currentBoard.parent;
				}
				Collections.reverse(steps);
				printFrontier(steps);
				System.out.println("Steps: " + steps.size());						
				return;
			}else{
				
				explored.addElement(currentBoard);
				
				Board tmpBoard;
				int indexExplored, indexFrontier;
				
				tmpBoard = currentBoard.moveTop();
				indexExplored = Util.findBoard(explored, tmpBoard);
				indexFrontier = Util.findBoard(frontier, tmpBoard);
				if(indexExplored == -1 && indexFrontier == -1 ){
					insertFrontier(tmpBoard, frontier);
				}else if(indexFrontier >= 0 && frontier.get(indexFrontier).getCost() > tmpBoard.getCost()){
					frontier.remove(indexFrontier);
					insertFrontier(tmpBoard, frontier);
				}
				
				tmpBoard = currentBoard.moveBottom();
				indexExplored = Util.findBoard(explored, tmpBoard);
				indexFrontier = Util.findBoard(frontier, tmpBoard);
				if(indexExplored == -1 && indexFrontier == -1 ){
					insertFrontier(tmpBoard, frontier);
				}else if(indexFrontier >= 0 && frontier.get(indexFrontier).getCost() > tmpBoard.getCost()){
					frontier.remove(indexFrontier);
					insertFrontier(tmpBoard, frontier);
				}
				
				tmpBoard = currentBoard.moveRight();
				indexExplored = Util.findBoard(explored, tmpBoard);
				indexFrontier = Util.findBoard(frontier, tmpBoard);
				if(indexExplored == -1 && indexFrontier == -1 ){
					insertFrontier(tmpBoard, frontier);
				}else if(indexFrontier >= 0 && frontier.get(indexFrontier).getCost() > tmpBoard.getCost()){
					frontier.remove(indexFrontier);
					insertFrontier(tmpBoard, frontier);
				}
				
				tmpBoard = currentBoard.moveLeft();
				indexExplored = Util.findBoard(explored, tmpBoard);
				indexFrontier = Util.findBoard(frontier, tmpBoard);
				if(indexExplored == -1 && indexFrontier == -1 ){
					insertFrontier(tmpBoard, frontier);
				}else if(indexFrontier >= 0 && frontier.get(indexFrontier).getCost() > tmpBoard.getCost()){
					frontier.remove(indexFrontier);
					insertFrontier(tmpBoard, frontier);
				}
				
			}
		}
		
		
		

	}
	
	public static void printFrontier(Vector<Board> frontier){
		System.out.println("FRONTIER");
		for(int i=0;i < frontier.size();i++){
			Util.printBoard(frontier.elementAt(i));
		}
		System.out.println("END");
	}
	
	public static void insertFrontier(Board board, Vector<Board> frontier){
		
		int i = 0;
		
		for(i = 0;i < frontier.size(); i++){
			if(frontier.get(i).getCost() > board.getCost()){
				frontier.add(i, board);
				return;
			}
		}
		frontier.add(i, board);
		return;
		
	}

}
