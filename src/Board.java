import java.util.Vector;


public class Board implements Cloneable{
	
	public Piece positions[][];
	public int functionG;
	public int functionH;
	public Board parent;
	
	public Board(Piece[][] positions){
		
		this.parent = null;
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
	@Override 
	public Board clone() throws CloneNotSupportedException { 
		
		Board clone = (Board) super.clone();
		clone.positions = new Piece[3][3];
		for (int x = 0; x < 3; x++){
			for (int y = 0; y < 3; y++){
				clone.positions[x][y] = positions[x][y].clone();
			}
		}
		
		if (parent != null){
			clone.parent = parent.clone();
		}else{
			clone.parent = null;			
		}
		
        return clone;  
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
	
	public Board moveTop() throws CloneNotSupportedException{
		Piece piece = null;
		Board newBoard = null;
		newBoard = this.clone();
		newBoard.parent = this;
		newBoard.functionG = this.functionG + 1;
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

		if (i > 0){
		
			newBoard.positions[i][j] = newBoard.positions[i-1][j];
			newBoard.positions[i-1][j] = piece;
			
			newBoard.positions[i][j].refreshDistanceObjective(i, j);
			newBoard.positions[i-1][j].refreshDistanceObjective(i-1, j);
			newBoard.calculateFunctionH();

		}
		return newBoard;	
		
	}
	

	public Board moveBottom() throws CloneNotSupportedException{
		
		Piece piece = null;
		Board newBoard = null;
		newBoard = this.clone();
		newBoard.parent = this;
		newBoard.functionG = this.functionG + 1;
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
	
	public Board moveRight() throws CloneNotSupportedException{
		
		Piece piece = null;
		Board newBoard = null;
		newBoard = this.clone();
		newBoard.parent = this;
		newBoard.functionG = this.functionG + 1;
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
		
	public Board moveLeft() throws CloneNotSupportedException{
		
		Piece piece = null;
		Board newBoard = null;
		newBoard = this.clone();
		newBoard.parent = this;
		newBoard.functionG = this.functionG + 1;
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
	
	public boolean hasSolution(){
		int inversions = 0;
		for (int x = 0; x < 3; x++){
			for (int y = 0; y < 3; y++){
				for (int i = 0; i < 3; i++){
					for (int j = 0; j < 3; j++){
						if((this.positions[x][y].id < this.positions[i][j].id) && (x > i || y > j) )
							inversions++;
					}
				}
				
			}	
		}
		if(inversions % 2 == 0)
			return true;
		else
			return false;	
	}

}
