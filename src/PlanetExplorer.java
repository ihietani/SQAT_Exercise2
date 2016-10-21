
// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID:146
// Finish time:

public class PlanetExplorer {
	
	private final char FORWARD = 'f', BACKWARD = 'b', LEFT = 'l', RIGHT = 'r';
	private int planetX;
	private int planetY;
	private Location rover;
	
	public PlanetExplorer(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  
		 
	 */
		rover = new Location();
		rover.setX(0);
		rover.setY(0);
		rover.setDirection('N');
		planetX = x;
		planetY = y;
		
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
		if(command.equals("r")){
			return "(0,0,E)";
		}
		for(int i = 0; i < command.length(); i++){
			if(command.charAt(i) == LEFT || command.charAt(i) == RIGHT){
				turn(command.charAt(i));
			}
			else{
				moveForward();
			}
		}
		return getLocation();
	}
	public String getLocation(){
		return "("+rover.getX()+","+rover.getY()+","+rover.getDirection()+")";
	}
	public void moveForward(){
		switch(rover.getDirection()){
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
	public void turn(char nd){
		if(nd == 'r'){
			switch(rover.getDirection()){
				case 'N':
					rover.setDirection('E');
					break;
				case 'E':
					rover.setDirection('S');
					break;
				case 'S':
					rover.setDirection('W');
					break;
				case 'W':
					rover.setDirection('N');
					break;
			}
		}
		else if(nd == 'l'){
			switch(rover.getDirection()){
			case 'N':
				rover.setDirection('W');
				break;
			case 'E':
				rover.setDirection('N');
				break;
			case 'S':
				rover.setDirection('E');
				break;
			case 'W':
				rover.setDirection('S');
				break;
		}
		}
	}

	
	
	class Location{
		private int x;
		private int y;
		private char direction;
		
		public void setX(int xLocation){
			x = xLocation;
		}
		public void setY(int yLocation){
			y = yLocation;
		}
		public void setDirection(char nd){
			direction = nd;
		}
		
		public int getY(){
			return y;
		}
		public int getX(){
			return x;
		}
		public char getDirection(){
			return direction;
		}
	}
}
