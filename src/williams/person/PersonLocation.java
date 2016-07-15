package williams.person;

abstract class PersonLocation<E extends Person> {

	/***
	 * Move the person to this location, ensuring they are 
	 * removed from their previous location
	 * @param person
	 */
	public final void place( E person ) {
		if( person.getLocation() != null ) {
			person.getLocation().remove(person);
		}
		person.setLocation( this );
		this.add( person );
	}
	
	public final void placeAll( Iterable<? extends E> c ) {
		for( E person : c ) {
			this.place(person);
		}
	}
	
	protected abstract void add( E person );
	
	protected abstract void remove( Object person );

	
	
	private String name;
	
	public PersonLocation() {
	}
	
	public String getName() {
		return name;
	}
	
	public void setName( String v ) {
		this.name = v;
	}
	
}
