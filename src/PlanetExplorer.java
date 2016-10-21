
import java.util.*;
// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID:146
// Finish time:

public class PlanetExplorer {
	
	private final char FORWARD = 'f', BACKWARD = 'b', LEFT = 'l', RIGHT = 'r';
	private int planetX;
	private int planetY;
	private Location rover;
	private char direction;
	private ArrayList<Location> obs;
	
	public PlanetExplorer(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  
		 
	 */
		obs = new ArrayList<Location>();
		rover = new Location();
		rover.setX(0);
		rover.setY(0);
		this.setDirection('N');
		planetX = x;
		planetY = y;
		
		Scanner sc = new Scanner(obstacles).useDelimiter(^0-9);
		while(sc.hasNextInt()){
			Location l = new Location();
			l.setX(sc.nextInt());
			l.setY(sc.nextInt());
			obs.add(l);
		}
		sc.close();
		
		
	}
	public void setDirection(char nd){
		direction = nd;
	}
	public char getDirection(){
		return direction;
	}
	public int getObstacleSize(){
		return obs.size();
	}
	
	public String executeCommand(String command){
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		for(int i = 0; i < command.length(); i++){
			if(command.charAt(i) == LEFT || command.charAt(i) == RIGHT){
				turn(command.charAt(i));
			}
			else if (command.charAt(i) == 'f'){
				moveForward();
				if(isObstacle()){
					moveBackward();
				}
			}
			else{
				moveBackward();
				if(isObstacle()){
					moveForward();
				}
			}
		}
		return getLocation();
	}
	public String getLocation(){
		return "("+rover.getX()+","+rover.getY()+","+this.getDirection()+")";
	}
	public boolean isObstacle(){
		for(Location l: obs){
			if(rover.getX() == l.getX() && rover.getY() == l.getY()){
				return true;
			}
		}
		return false;
	}
	public void moveForward(){
		switch(getDirection()){
			case 'N':
				rover.setY(rover.getY() + 1);
				break;
			case 'S':
				rover.setY(rover.getY() - 1);
				break;
			case 'E':
				rover.setX(rover.getX() + 1);
				break;
			case 'W':
				rover.setX(rover.getX() - 1);
				break;
		}
	}
	public void moveBackward(){
		switch(this.getDirection()){
			case 'N':
				rover.setY(rover.getY() - 1);
				break;
			case 'S':
				rover.setY(rover.getY() + 1);
				break;
			case 'E':
				rover.setX(rover.getX() - 1);
				break;
			case 'W':
				rover.setX(rover.getX() + 1);
				break;
		}
	}
	public void turn(char nd){
		if(nd == 'r'){
			switch(this.getDirection()){
				case 'N':
					this.setDirection('E');
					break;
				case 'E':
					this.setDirection('S');
					break;
				case 'S':
					this.setDirection('W');
					break;
				case 'W':
					this.setDirection('N');
					break;
			}
		}
		else if(nd == 'l'){
			switch(this.getDirection()){
				case 'N':
					this.setDirection('W');
					break;
				case 'E':
					this.setDirection('N');
					break;
				case 'S':
					this.setDirection('E');
					break;
				case 'W':
					this.setDirection('S');
					break;
			}
		}
	}

	
	
	class Location{
		private int x;
		private int y;
		
		public void setX(int xLocation){
			x = xLocation;
		}
		public void setY(int yLocation){
			y = yLocation;
		}
		
		
		public int getY(){
			return y;
		}
		public int getX(){
			return x;
		}
		
	}
}
