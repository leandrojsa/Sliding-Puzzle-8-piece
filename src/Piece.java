
public class Piece {
	
	public int id;
	public int distanceObjective;
	public int distanceStart;
	
	public Piece(int id){
		
		this.id = id;
		this.distanceStart = 0;
		this.distanceObjective = -1;
		
	}
	
	public int getCost(){
		
		return this.distanceStart + this.distanceObjective;
		
	}
	
	public void refreshDistanceObjective(int boardPositionX, int boardPositionY){
		
		int posX = 0;
		int posY = 0;
		
		switch (this.id) {
		case 0:
			posX = 2;
			posY = 2;
			break;
		case 1:
			posX = 0;
			posY = 0;
			break;
		case 2:
			posX = 0;
			posY = 1;
			break;
		case 3:
			posX = 0;
			posY = 2;
			break;
		case 4:
			posX = 1;
			posY = 0;
			break;
		case 5:
			posX = 1;
			posY = 1;
			break;
		case 6:
			posX = 1;
			posY = 2;
			break;
		case 7:
			posX = 2;
			posY = 0;
			break;
		case 8:
			posX = 2;
			posY = 1;
			break;
		}
		this.distanceObjective = Math.abs(posX - boardPositionX) + Math.abs(posY - boardPositionY); 
		
	}

}
