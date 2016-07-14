package williams.person;

import java.util.ArrayList;

/***
 * An example persistent object.  The point of the "Persistent Object" design
 * pattern is to enforce the rule (avoid logic errors) that an object is in
 * exactly one location at any given time.  
 * 
 * Don't put any other classes other than the abstract location class
 * in the same package as the persistent object class, or you'll run the
 * risk of other code meddling with the persistent objects' location fields.
 * @author Clark Williams
 *
 */
public class Person {

	public Person( String name ) {
		this.name = name;
	}
	
	private PersonLocation location;
	
	PersonLocation getLocation() {
		return location;
	}	
	
	void setLocation( PersonLocation newloc ) {
		location = newloc;
		locationHistory.add( newloc.getName() );
	}
	
	
	
	// For this example we give each object a name and keep track of 
	// its location history
	
	private final String name;
	
	public final ArrayList<String> locationHistory = new ArrayList<String>();

	public String getName() {
		return name;
	}
	
}
