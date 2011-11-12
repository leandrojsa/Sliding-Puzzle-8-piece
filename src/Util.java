import java.util.Vector;


public class Util {
	
	public static void printBoard(Board board){
		
		for(int i = 0; i < 3;i++){
			for(int j = 0; j < 3;j++){
				System.out.print(board.positions[i][j].id + " ");
			}
			System.out.println();
		}
		System.out.println();
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
	
	public static void printSteps(Vector<Board> frontier){
		System.out.println("Steps:");
		for(int i=0;i < frontier.size();i++){
			Util.printBoard(frontier.elementAt(i));
		}
	}

}
