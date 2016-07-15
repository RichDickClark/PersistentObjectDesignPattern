package williams.person;

public class Pit extends PersonLocation {

	public Pit() {
		super("The Pit");
	}

	@Override 
	public void place(Person p) {
		if( p.getLocation() != null ) {
			p.getLocation().remove(p);
		}
		p.setLocation( null );
	}
	
	@Override
	protected void add(Person p) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void remove(Person p) {
		// TODO Auto-generated method stub

	}

}
