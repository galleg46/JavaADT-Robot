import edu.uwm.cs351.Robot;
import edu.uwm.cs.junit.LockedTestCase;

//this test suite contains general tests for Robots
//any implementation of a Robot should pass these tests
//(Note: these tests assume all concrete Robots can hold at least 2 arms, 2 legs, and 2 other parts)
//this class itself cannot be run (it is abstract)
//look for concrete subclasses of this class to run

public abstract class TestRobot extends LockedTestCase{
	//abstract method to be implemented by concrete subclasses
	public abstract Robot createRobot();
	
	//test to unlock
	public void testLocked() {
		Robot r = createRobot();
		assertEquals(Tb(1063841112), r.addLeg());
		assertEquals(Tb(1902024535), r.removeArm());
		assertEquals(Tb(2139242598), r.removeLeg());
		assertEquals(Tb(254106931), r.removeLeg());
		assertEquals(Tb(1057214618), r.addPart("bathing suit"));
		assertEquals(Tb(441694743), r.removeAllArms());
		assertEquals(Tb(1739492949), r.removeAllParts());
		assertEquals(Tb(292533884), r.removePart("bathing suit"));
		assertEquals(Tb(607777222), r.removeAllParts());
	}
	
	//testing empty robot
	public void test01() {
		Robot r = createRobot();
		assertFalse(r.removeArm());
		assertFalse(r.removeLeg());
	}
	
	//testing adding and removing arms and legs
	public void test10() {
		Robot r = createRobot();
		r.addArm();
		assertFalse(r.removeLeg());
		assertTrue(r.removeArm());
		assertFalse(r.removeArm());
	}
	
	public void test11() {
		Robot r = createRobot();
		r.addArm();
		r.addArm();
		assertTrue(r.removeArm());
		assertTrue(r.removeArm());
		assertFalse(r.removeArm());
	}
	
	public void test12() {
		Robot r = createRobot();
		r.addArm();
		assertTrue(r.removeArm());
		assertFalse(r.removeArm());
		r.addArm();
		assertTrue(r.removeArm());
		assertFalse(r.removeArm());
	}
	
	public void test13() {
		Robot r = createRobot();
		r.addArm();
		r.addArm();
		assertTrue(r.removeArm());
		r.addArm();
		assertTrue(r.removeArm());
		assertTrue(r.removeArm());
		assertFalse(r.removeArm());
	}
	
	public void test20() {
		Robot r = createRobot();
		r.addLeg();
		assertFalse(r.removeArm());
		assertTrue(r.removeLeg());
		assertFalse(r.removeLeg());
	}
	
	public void test21() {
		Robot r = createRobot();
		r.addLeg();
		r.addLeg();
		assertTrue(r.removeLeg());
		assertTrue(r.removeLeg());
		assertFalse(r.removeLeg());
	}
	
	public void test22() {
		Robot r = createRobot();
		r.addLeg();
		assertTrue(r.removeLeg());
		assertFalse(r.removeLeg());
		r.addLeg();
		assertTrue(r.removeLeg());
		assertFalse(r.removeLeg());
	}
	
	public void test23() {
		Robot r = createRobot();
		r.addLeg();
		r.addLeg();
		assertTrue(r.removeLeg());
		r.addLeg();
		assertTrue(r.removeLeg());
		assertTrue(r.removeLeg());
		assertFalse(r.removeLeg());
	}
	
	public void test30() {
		Robot r = createRobot();
		assertFalse(r.removeAllArms());
		r.addArm();
		assertTrue(r.removeAllArms());
		assertFalse(r.removeArm());
	}
	
	//testing removeAllArms
	public void test31() {
		Robot r = createRobot();
		r.addArm();
		r.addArm();
		assertTrue(r.removeAllArms());
		assertFalse(r.removeArm());
	}
	
	public void test32() {
		Robot r = createRobot();
		r.addArm();
		assertTrue(r.removeAllArms());
		r.addArm();
		assertTrue(r.removeArm());
		assertFalse(r.removeAllArms());
	}
	
	public void test33() {
		Robot r = createRobot();
		r.addArm();
		r.addArm();
		assertTrue(r.removeArm());
		assertTrue(r.removeAllArms());
		assertFalse(r.removeArm());
	}
	
	//testing removeAllLegs
	public void test40() {
		Robot r = createRobot();
		assertFalse(r.removeAllLegs());
		r.addLeg();
		assertTrue(r.removeAllLegs());
		assertFalse(r.removeLeg());
	}
	
	public void test41() {
		Robot r = createRobot();
		r.addLeg();
		r.addLeg();
		assertTrue(r.removeAllLegs());
		assertFalse(r.removeLeg());
	}
	
	public void test42() {
		Robot r = createRobot();
		r.addLeg();
		assertTrue(r.removeAllLegs());
		r.addLeg();
		assertTrue(r.removeLeg());
		assertFalse(r.removeAllLegs());
	}
	
	public void test43() {
		Robot r = createRobot();
		r.addLeg();
		r.addLeg();
		assertTrue(r.removeLeg());
		assertTrue(r.removeAllLegs());
		assertFalse(r.removeLeg());
	}
	
	//testing other parts
	public void test50() {
		Robot r = createRobot();
		r.addPart("eyeball");
		assertFalse(r.removePart("Eyeball"));
		assertTrue(r.removePart("eyeball"));
		assertFalse(r.removePart("eyeball"));
	}
	
	public void test51() {
		Robot r = createRobot();
		r.addPart("eyeball");
		r.addPart("motor");
		assertTrue(r.removePart("motor"));
		assertTrue(r.removePart("eyeball"));
		assertFalse(r.removePart("motor"));
		assertFalse(r.removePart("eyeball"));
	}
	
	public void test52() {
		Robot r = createRobot();
		r.addPart("eyeball");
		r.addPart("motor");
		assertTrue(r.removePart("eyeball"));
		r.addPart("telescope");
		assertTrue(r.removePart("motor"));
		r.addPart("compass");
		assertFalse(r.removePart("eyeball"));
		assertFalse(r.removePart("motor"));
		assertTrue(r.removePart("telescope"));
		assertTrue(r.removePart("compass"));
	}
	
	public void test60() {
		Robot r = createRobot();
		r.addArm();
		r.addLeg();
		r.addPart("wig");
		r.removeAllParts();
		assertFalse(r.removeLeg());
		assertFalse(r.removeArm());
		assertFalse(r.removePart("wig"));
	}
	
	//testing removeAllParts
	public void test61() {
		Robot r = createRobot();
		assertFalse(r.removeAllParts());
		r.addArm();
		assertTrue(r.removeAllParts());
		assertFalse(r.removeAllParts());
		r.addLeg();
		assertTrue(r.removeAllParts());
		assertFalse(r.removeAllParts());
		r.addPart("beaker");
		assertTrue(r.removeAllParts());
		assertFalse(r.removeAllParts());
	}
	
	public void test62() {
		Robot r = createRobot();
		r.addArm();
		r.addArm();
		r.removeArm();
		assertTrue(r.removeAllParts());
		r.addLeg();
		r.addLeg();
		r.removeLeg();
		assertTrue(r.removeAllParts());
		r.addPart("eyepatch");
		r.addPart("moustache");
		r.removePart("eyepatch");
		assertTrue(r.removeAllParts());
	}
	
	//testing the ARM and LEG constants
	public void test70() {
		Robot r = createRobot();
		r.addPart(Robot.ARM);
		assertFalse(r.removeLeg());
		assertTrue(r.removeArm());
	}
	
	public void test71() {
		Robot r = createRobot();
		r.addPart(Robot.LEG);
		assertFalse(r.removeArm());
		assertTrue(r.removeLeg());
	}
	
	public void test72() {
		Robot r = createRobot();
		r.addPart(Robot.ARM);
		assertTrue(r.removeAllArms());
		assertFalse(r.removeArm());
	}
	
	public void test73() {
		Robot r = createRobot();
		r.addPart(Robot.LEG);
		assertTrue(r.removeAllLegs());
		assertFalse(r.removeLeg());
	}
	
	//testing some interactions
	public void test80() {
		Robot r = createRobot();
		r.addArm();
		r.addLeg();
		r.removeLeg();
		r.addPart("teeth");
		assertTrue(r.removeAllArms());
		assertFalse(r.removeAllLegs());
		assertTrue(r.removeAllParts());
	}
	
	//testing exceptions
	public void test90() {
		Robot r = createRobot();
		boolean thrown = false;
		try { r.addPart(null); }
		catch (IllegalArgumentException ex) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	public void test91() {
		Robot r = createRobot();
		boolean thrown = false;
		try { r.removePart(null); }
		catch (IllegalArgumentException ex) {
			thrown = true;
		}
		assertTrue(thrown);
	}
}
