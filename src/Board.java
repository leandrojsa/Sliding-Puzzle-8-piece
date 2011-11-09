import java.util.Vector;


public class Board {
	
	public Piece positions[][];
	public int functionG;
	public int functionH;
	public Board parent;
	
	public Board(Piece[][] positions){
		
	
		this.positions = positions;
		this.functionG = 0;
		this.calculateFunctionH();
		
	}
	
	public Board(Piece[][] positions, Board parent){
		
		this.positions = positions;
		this.parent = parent;
		this.functionG = this.parent.functionG + 1;
		this.calculateFunctionH();
	}
	
	public int getCost(){
		return this.functionG + this.functionH;		
	}
	
	public void calculateFunctionH(){
		int functionH = 0;
		
		for (int x = 0; x < 3; x++){
			for (int y = 0; y < 3; y++){
				functionH += this.positions[x][y].distanceObjective;				
			}
		}
		
		this.functionH = functionH;
	}
	
	public Vector<Piece> priorityPieces(){
		
		Vector<Piece> frontier = new Vector<Piece>();
		
		for (int x = 0; x < 3; x++){
			for (int y = 0; y < 3; y++){
				
				if(frontier.isEmpty()){
					frontier.addElement(this.positions[x][y]);
				}else{
					int i = 0;
					while(i < frontier.size()){
						Piece piece = (Piece)frontier.elementAt(i);
						if(this.positions[x][y].getCost() <= piece.getCost()){
							break;
						}
						i++;
					}
					frontier.add(i, this.positions[x][y]);
					
				}		
			}
		}
		return frontier;
		
	}
	
	public Board moveTop(){
		
		Piece piece = null;
		Board newBoard = this;
		int i = 0;
		int j = 0;
		for (int x = 0; x < 3; x++){
			for (int y = 0; y < 3; y++){
				if (newBoard.positions[x][y].id == 0){
					piece = newBoard.positions[x][y];
					i = x;
					j = y;
					
				}
			}
		}
		
		if (i > 0){
			newBoard.positions[i][j] = newBoard.positions[i-1][j];
			newBoard.positions[i-1][j] = piece;
			
			newBoard.positions[i][j].refreshDistanceObjective(i, j);
			newBoard.positions[i-1][j].refreshDistanceObjective(i-1, j);
			newBoard.calculateFunctionH();
		}
		return newBoard;	
		
	}
	
	public Board moveBottom(){
		
		Piece piece = null;
		Board newBoard = this;
		int i = 0;
		int j = 0;
		for (int x = 0; x < 3; x++){
			for (int y = 0; y < 3; y++){
				if (newBoard.positions[x][y].id == 0){
					piece = newBoard.positions[x][y];
					i = x;
					j = y;		
				}
			}
		}
		if (i < 2){
			newBoard.positions[i][j] = newBoard.positions[i+1][j];
			newBoard.positions[i+1][j] = piece;
			
			newBoard.positions[i][j].refreshDistanceObjective(i, j);
			newBoard.positions[i+1][j].refreshDistanceObjective(i+1, j);
			newBoard.calculateFunctionH();
		}
		return newBoard;	
		
	}
	
	public Board moveRight(){
		
		Piece piece = null;
		Board newBoard = this;
		int i = 0;
		int j = 0;
		for (int x = 0; x < 3; x++){
			for (int y = 0; y < 3; y++){
				if (newBoard.positions[x][y].id == 0){
					piece = newBoard.positions[x][y];
					i = x;
					j = y;
				}
			}
		}
		if (j < 2){
			newBoard.positions[i][j] = newBoard.positions[i][j+1];
			newBoard.positions[i][j+1] = piece;
			
			newBoard.positions[i][j].refreshDistanceObjective(i, j);
			newBoard.positions[i][j+1].refreshDistanceObjective(i, j+1);
			newBoard.calculateFunctionH();
			
		}
		return newBoard;	
		
	}
		
	public Board moveLeft(){
		
		Piece piece = null;
		Board newBoard = this;
		int i = 0;
		int j = 0;
		for (int x = 0; x < 3; x++){
			for (int y = 0; y < 3; y++){
				if (newBoard.positions[x][y].id == 0){
					piece = newBoard.positions[x][y];
					i = x;
					j = y;
				}
			}
		}
		if (j > 0){
			newBoard.positions[i][j] = newBoard.positions[i][j-1];
			newBoard.positions[i][j-1] = piece;
			
			newBoard.positions[i][j].refreshDistanceObjective(i, j);
			newBoard.positions[i][j-1].refreshDistanceObjective(i, j-1);
			newBoard.calculateFunctionH();
		}
		return newBoard;	
		
	}

}
