import java.util.Vector;


public class Board {
	
	public Piece positions[][];
	
	public Board(){
		
		positions = new Piece[3][3];
		
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
