import java.util.Vector;


public class Util {
	
	public static void printBoard(Board board){
		
		for(int i = 0; i < 3;i++){
			for(int j = 0; j < 3;j++){
				System.out.print(board.positions[i][j].id + " ");
			}
			System.out.println();
		}
		System.out.println("\n");
	}
	
	public static boolean cmpBoard(Board board1, Board board2){
		
		boolean equal = true;
		
		for(int i = 0; i < 3;i++){
			for(int j = 0; j < 3;j++){
				if (board1.positions[i][j].id != board2.positions[i][j].id){
					equal = false;
				}
			}
		}
		
		return equal;
		
	}
	
	public static int findBoard(Vector<Board> vector, Board board) {
		
		int foundPosition = -1;
		
		for(int i = 0; i < vector.size(); i++ ){
			if(cmpBoard(vector.elementAt(i), board)){
				foundPosition = i;
				break;
			}
		}
		return foundPosition;
		
	}
	
	public static Board moveTop(Board board) throws CloneNotSupportedException{
		
		System.out.println("1:");
		Util.printBoard(board);
		Piece piece = null;
		Board newBoard = null;
		newBoard = board.clone();
		int i = 0;
		int j = 0;
		for (int x = 0; x < 3; x++){
			for (int y = 0; y < 3; y++){
				if (newBoard.positions[x][y].id == 0){
					piece = newBoard.positions[x][y].clone();
					i = x;
					j = y;
					
				}
			}
		}
		System.out.println("2:");
		Util.printBoard(board);
		if (i > 0){
		
			newBoard.positions[i][j] = newBoard.positions[i-1][j].clone();
			newBoard.positions[i-1][j] = piece.clone();
			
			newBoard.positions[i][j].refreshDistanceObjective(i, j);
			newBoard.positions[i-1][j].refreshDistanceObjective(i-1, j);
			newBoard.calculateFunctionH();
			System.out.println("3:");
			Util.printBoard(board);
		}
		return newBoard;	
		
	}

}
