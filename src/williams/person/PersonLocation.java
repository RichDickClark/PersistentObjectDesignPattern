package williams.person;

public abstract class PersonLocation {

	/***
	 * Move the person to this location, ensuring they are 
	 * removed from their previous location
	 * @param p
	 */
	public void place( Person p ) {
		if( p.getLocation() != null ) {
			p.getLocation().remove(p);
		}
		p.setLocation( this );
		this.add( p );
	}
	
	protected abstract void add( Person p );
	
	protected abstract void remove( Person p );

	
	
	private final String name;
	
	public PersonLocation( String name ) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
