
public class Util {
	
	public static void printBoard(Board board){
		
		for(int i = 0; i < 3;i++){
			for(int j = 0; j < 3;j++){
				System.out.print(board.positions[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
