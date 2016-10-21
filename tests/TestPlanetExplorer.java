import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_executeCommand() {
		//
		PlanetExplorer pe = new PlanetExplorer(100, 100, "5,5");
		
		assertEquals("Grid is not initialized",new int[100][100], pe.getGrid());
	}
}
