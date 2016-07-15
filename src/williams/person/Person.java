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
	
	@SuppressWarnings("rawtypes")
	private PersonLocation location;
	
	@SuppressWarnings("rawtypes")
	PersonLocation getLocation() {
		return location;
	}	
	
	@SuppressWarnings("rawtypes")
	void setLocation( PersonLocation newloc ) {
		location = newloc;
		if( newloc != null ) {
			locationHistory.add( newloc.getName() );
		}
		else {
			locationHistory.add( "null" );
		}
	}
	
	
	
	// For this example we give each object a name and keep track of 
	// its location history
	
	private final String name;
	
	public final ArrayList<String> locationHistory = new ArrayList<String>();

	public String getName() {
		return name;
	}
	
}
