import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_executeCommandNorth() {
		//
		PlanetExplorer pe = new PlanetExplorer(100,100,"(5,5)(7,8)");
		assertEquals("Explorer did not move", "N", pe.executeCommand("N"));
	}
}
