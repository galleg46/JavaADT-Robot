package edu.uwm.cs351;

public interface Robot {
	//constants defining the string values for arms and legs
	//you can remove a leg using removePart if you pass the constant Robot.LEG
	public static final String ARM = "arm";
	public static final String LEG = "leg";
	
	/**
	 * Add a part to the robot given by a string
	 * @param s the part to be added
	 * @exception IllegalArgumentException for a null string
	 * @return whether a part was successfully added
	 */
	public abstract boolean addPart(String s);
	
	/**
	 * Add an arm to the robot
	 * @return whether an arm was successfully added
	 */
	public abstract boolean addArm();
	
	/**
	 * Add a leg to the robot
	 * @return whether a leg was successfully added
	 */
	public abstract boolean addLeg();
	
	/**
	 * Remove one part from the robot given by a string
	 * @param s the part to be removed
	 * @exception IllegalArgumentException for a null string
	 * @return whether a part was successfully removed
	 *         will return false if the part does not exist in the robot
	 */
	public abstract boolean removePart(String s);
	
	/**
	 * Remove an arm from the robot
	 * @return whether an arm was successfully removed
	 *         will return false if the robot has no arms
	 */
	public abstract boolean removeArm();
	
	/**
	 * Remove a leg from the robot
	 * @return whether a leg was successfully removed
	 *         will return false if the robot has no legs
	 */
	public abstract boolean removeLeg();
	
	/**
	 * Remove all arms from the robot
	 * @return whether any arm were successfully removed
	 *         will return false if the robot has no arms
	 */
	public abstract boolean removeAllArms();
	
	/**
	 * Remove all legs from the robot
	 * @return whether any legs were successfully removed
	 *         will return false if the robot has no legs
	 */
	public abstract boolean removeAllLegs();
	
	/**
	 * Remove all parts from the robot, including arms and legs
	 * @return whether any parts were successfully removed
	 *         will return false if the robot has no parts
	 */
	public abstract boolean removeAllParts();
}
