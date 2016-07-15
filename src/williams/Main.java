package williams;

import williams.person.Person;
import williams.person.PersonArrayList;
//import williams.person.PersonLocation;

public class Main {

	/***
	 * The point of the "Persistent Object" design
	 * pattern is to enforce the rule (avoid logic errors) that an object is in
	 * exactly one location at any given time.
	 ***/
	public static void main( String[] args ) {
		
		// Person Locations
		PersonArrayList<Person> bar = new PersonArrayList<Person>();
		bar.setName("bar");
		PersonArrayList<Person> bathroom = new PersonArrayList<Person>();
		bathroom.setName("bathroom");
		PersonArrayList<Person> home = new PersonArrayList<Person>();
		home.setName("home");
		
		Person george = new Person( "George" );
		bar.place( george );
		bar.place( new Person( "Betty" ) );
		bar.place( new Person( "Sam" ) );
		
		// Shouldn't be able to access abstract location class
		// or override location classes to make people disappear.
		// The following two can't be done because PersonLocation 
		// class has default (package) level access.  
//		PersonLocation hotelCalifornia = new PersonLocation("Hotel California") {
//
//			@Override
//			protected void add(Person p) {
//				// They just disappear!
//			}
//
//			@Override
//			protected void remove(Person p) {
//			}
//			
//		};
//		hotelCalifornia.place( george ); // Goodby George
		
//		PersonLocation thePit = new Pit();
//		thePit.place( george ); // Goodbye George

		
//		for( Person p : people )
//			bar.add(p); // should create compilation error 
		

		
		// Can't meddle with Person::location
//		people.get(0).location = home; // should create compilation error
		
		// Can't even see Peron::location
//		george.getLocation(); // should create compilation error
		
		// Can't put a person nowhere
//		bar.remove(people.get(0)); // should create compilation error
		
		// Can't have a person in two places at once
//		home.add( bar.get(0) ); // should create compilation error
		Person frankie = new Person( "Frankie" );
		bar.place( frankie );
		bar.place( george );
		home.place( frankie );
		if( bar.contains(frankie) )
			throw new RuntimeException( "Frankie in two places at once!" );
		if( !bar.contains(george) )
			throw new RuntimeException( "George unexpectedly left bar!" );
			
		// Can iterate over people in a location
		System.out.print( "Who's at the bar: " );
		for( Person p : bar )
			System.out.print( p.getName() + " " );
		System.out.println();
		
		bathroom.place( george );
		
		// Where has George been?
		System.out.print( "George location history: ");
		for( String place : george.locationHistory )
			System.out.print( place + " " );
		System.out.println();
	}
	
}
