import edu.uwm.cs351.ArrayRobot;
import edu.uwm.cs351.Robot;

// this extends is doing a lot of work!
public class TestArrayRobot extends TestRobot{

	@Override
	public Robot createRobot() {
		return new ArrayRobot();
	}
	
	//this class runs all inherited tests,
	//in addition to any special ones here
	
	public void testCapacity() {
		ArrayRobot r = new ArrayRobot();
		for(int i=0; i<ArrayRobot.CAPACITY; i++)
			assertTrue(r.addPart(String.valueOf(i)));
		assertFalse(r.addLeg());
		assertFalse(r.addArm());
		assertFalse(r.addPart("pocket watch"));
		assertFalse(r.removeLeg());
		assertFalse(r.removeArm());
		assertFalse(r.removePart("pocket watch"));
	}
}
