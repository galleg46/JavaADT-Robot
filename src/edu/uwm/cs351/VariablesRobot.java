//Name: Anthony Gallegos
//Discussion #: 803
package edu.uwm.cs351;

/**
 * This class implements the robot interface using a small number of string variables
 * It has room for 2 arms, 2 legs, and 2 other parts
 * Don't store any non-arms in arm1 or arm2, or non-legs in leg1 or leg2
 * Don't store any arms or legs in other1 or other2
 * Remember that the strings for arms and legs are defined by a constant in Robot.java
 * Note: addPart CAN result in adding an arm or a leg depending on the string passed
 */

public class VariablesRobot implements Robot{

	private String arm1;
	private String arm2;
	private String leg1;
	private String leg2;
	private String other1;
	private String other2;
	
	@Override
	public boolean addPart(String s) {
		if(s == null) throw new IllegalArgumentException();
		
		if(s == ARM)
		{
			if(arm1 == null) 
			{
				arm1 = s;
				return true;
			}
			else if(arm1 != null && arm2 == null)
			{
				arm2 = s;
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(s == LEG)
		{
			if(leg1 == null) 
			{
				leg1 = s;
				return true;
			}
			else if(leg1 != null && leg2 == null)
			{
				leg2 = s;
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			if(other1 == null)
			{
				other1 = s;
				return true;
			}
			else if(other1 != null && other2 == null)
			{
				other2 = s;
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	@Override
	public boolean addArm() {
		return addPart(ARM);
	}

	@Override
	public boolean addLeg() {
		return addPart(LEG);
	}
	@Override
	public boolean removePart(String s) {
		if(s == null) throw new IllegalArgumentException();
		
		if(s == ARM)
		{
			if(arm1 != null && arm2 != null)
			{
				arm2 = null;
				return true;
			}
			else if(arm1 != null && arm2 == null)
			{
				arm1 = null;
				return true;
			}
			else 
			{
				return false;
			}
		}
		else if(s == LEG) 
		{
			if(leg1 != null && leg2 != null)
			{
				leg2 = null;
				return true;
			}
			else if(leg1 != null && leg2 == null)
			{
				leg1 = null;
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			if(other1 == s)
			{
				other1 = null;
				return true;
			}
			else if(other2 == s)
			{
				other2 = null;
				return true;
			}
			return false;
		}
	}

	@Override
	public boolean removeArm() {
		return removePart(ARM);
	}

	@Override
	public boolean removeLeg() {
		return removePart(LEG);
	}

	@Override
	public boolean removeAllArms() {
		boolean changed = false;
		
		if(removeArm() == true)
		{
			arm1 = null;
			changed = true;
		}
			
		return changed;
	}

	@Override
	public boolean removeAllLegs() {
		boolean changed = false;
		
		if(removeLeg() == true)
		{
			leg1 = null;
			changed = true;
		}
		return changed;
	}

	@Override
	public boolean removeAllParts() {
		boolean changed = false;
		
		if(removeArm() == true || removeLeg() == true)
		{
			arm1 = null;
			arm2 = null;
			leg1 = null;
			leg2 = null;
			changed = true;
		}
		
		if(other1 != null || other2 != null)
		{
			other1 = null;
			other2 = null;
			changed = true;
		}
		
		return changed;
	}

}
