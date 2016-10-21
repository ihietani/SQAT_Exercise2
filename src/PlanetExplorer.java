
// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID:146
// Finish time:

public class PlanetExplorer {
	
	private final char FORWARD = 'f', BACKWARD = 'b', LEFT = 'l', RIGHT = 'r';
	private int planetX;
	private int planetY;
	
	public PlanetExplorer(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  
		 
	 */
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
		Location s = new Location();
		s.setX(0);
		s.setY(0);
		char direction = 'N';
		for(int i = 0; i < command.length(); i++){
			char c = command.charAt(i);
			switch(c){
				case FORWARD:
					moveForward();
			}
		}
	}
	public String getLocation(){
		return null;
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
	}
}
