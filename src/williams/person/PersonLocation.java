package williams.person;

abstract class PersonLocation {

	/***
	 * Move the person to this location, ensuring they are 
	 * removed from their previous location
	 * @param p
	 */
	public final void place( Person p ) {
		if( p.getLocation() != null ) {
			p.getLocation().remove(p);
		}
		p.setLocation( this );
		this.add( p );
	}
	
	protected abstract void add( Person p );
	
	protected abstract void remove( Person p );

	
	
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
