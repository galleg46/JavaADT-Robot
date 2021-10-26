//Name: Anthony Gallegos
//Discussion #: 803
package edu.uwm.cs351;

/**
 * This class implements the robot interface using an array of strings
 * It has room for any 10 parts, and will fail to add more than 10
 * Each string in the array represents a part
 * Each null in the array does not represent a part
 * In this implementation, an arm is the string "arm" and a leg is the string "leg",
 *     as defined by the constants in Robot.java
 */

public class ArrayRobot implements Robot{

	private String[] parts;
	public static final int CAPACITY = 10;
	
	public ArrayRobot() {
		parts = new String[CAPACITY];
	}

	@Override
	public boolean addPart(String s) {
		if(s == null) throw new IllegalArgumentException();
		for(int i=0; i<CAPACITY; i++)
			if(parts[i]==null) {
				parts[i] = s;
				return true;
			}
		return false;	
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
		if(s == null) throw new IllegalArgumentException("Nothing was specified to remove");
		for(int i = 0; i < CAPACITY; i++)
		{
			if(parts[i] == s)
			{
				parts[i] = "";
				return true;
			}
		}
		return false;
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
		for(int i=0; i<CAPACITY; i++)
			if(ARM.equals(parts[i])) {
				parts[i] = null;
				changed = true;
			}
		return changed;
	}

	@Override
	public boolean removeAllLegs() {
		boolean changed = false;
		for(int i=0; i<CAPACITY; i++)
			if(LEG.equals(parts[i])) {
				parts[i] = null;
				changed = true;
			}
		return changed;
	}

	@Override
	public boolean removeAllParts() {
		boolean changed = false;
		for(int i = 0; i < CAPACITY; i++)
		{
			if(parts[i] != null && parts[i] != "")
			{
				parts[i] = "";
				changed = true;
			}
			
		}
		return changed;
	}
}
