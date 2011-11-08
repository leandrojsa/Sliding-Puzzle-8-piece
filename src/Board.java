import java.util.Vector;


public class Board {
	
	public Piece positions[][];
	public int functionG;
	public int functionH;
	public Board parent;
	
	public Board(Piece[][] positions){
		
		positions = this.positions;
		functionG = 0;
		calculateFunctionH();
		
	}
	
	public Board(Piece[][] positions, Board parent){
		
		positions = this.positions;
		parent = this.parent;
		functionG = this.parent.functionG + 1;
		calculateFunctionH();
	}	
	
	private void calculateFunctionH(){
		int functionH = 0;
		for (int x = 0; x < 3; x++){
			for (int y = 0; y < 3; y++){
				functionH += this.positions[x][y].getCost();				
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

}
