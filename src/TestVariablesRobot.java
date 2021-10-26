import edu.uwm.cs351.VariablesRobot;
import edu.uwm.cs351.Robot;

// this extends is doing a lot of work!
public class TestVariablesRobot extends TestRobot{

	@Override
	public Robot createRobot() {
		return new VariablesRobot();
	}
	
	public void testCapacity() {
		VariablesRobot r = new VariablesRobot();
		assertTrue(r.addArm());
		assertTrue(r.addArm());
		assertTrue(r.addLeg());
		assertTrue(r.addLeg());
		assertTrue(r.addPart("left eye"));
		assertTrue(r.addPart("right eye"));
		
		assertFalse(r.addLeg());
		assertFalse(r.addArm());
		assertFalse(r.addPart("pocket watch"));
		
		assertTrue(r.removeLeg());
		assertTrue(r.removeLeg());
		assertFalse(r.removeLeg());
		assertTrue(r.removeArm());
		assertTrue(r.removeArm());
		assertFalse(r.removeArm());
		assertTrue(r.removePart("left eye"));
		assertTrue(r.removePart("right eye"));
		assertFalse(r.removePart("pocket watch"));
	}
	
}
