import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_executeCommandNorth() {
		//
		PlanetExplorer pe = new PlanetExplorer(100,100,"(5,5)(7,8)");
		assertEquals("Explorer did not move", "(0,1,N)", pe.executeCommand("f"));
	}
	@Test
	public void test_executeCommandEast() {
		//
		PlanetExplorer pe = new PlanetExplorer(100,100,"(5,5)(7,8)");
		assertEquals("Explorer is not facing east", "(0,0,E)", pe.executeCommand("r"));
	}
	@Test
	public void test_executeCommandEast() {
		//
		PlanetExplorer pe = new PlanetExplorer(100,100,"(5,5)(7,8)");
		assertEquals("Explorer did not move", "(0,0,E)", pe.executeCommand("r"));
	}
}
