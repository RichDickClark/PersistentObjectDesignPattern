package williams;

import java.util.ArrayList;
import java.util.List;

import williams.person.Person;
import williams.person.PersonArrayList;

public class Main {

	/***
	 * The point of the "Persistent Object" design
	 * pattern is to enforce the rule (avoid logic errors) that an object is in
	 * exactly one location at any given time.
	 ***/
	public static void main( String[] args ) {
		
		Person george = new Person( "George" );
		
		List<Person> people = new ArrayList<Person>();
		people.add( george );
		people.add( new Person( "Betty" ) );
		people.add( new Person( "Sam" ) );
		
		PersonArrayList bar = new PersonArrayList("bar");
		PersonArrayList bathroom = new PersonArrayList("bathroom");
		PersonArrayList home = new PersonArrayList("home");
		
//		for( Person p : people )
//			bar.add(p); // should create compilation error 
		
		for( Person p : people )
			bar.place(p);
		
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
