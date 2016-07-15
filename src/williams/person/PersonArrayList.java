package williams.person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/***
 * Make sure nothing but object and abstract location class are in same package with
 * these specific location classes.  Otherwise other code will have access to the
 * add() and remove() methods, subverting the whole point of this pattern.  
 * @author ri18384
 *
 */
public class PersonArrayList extends PersonLocation implements Iterable<Person> {

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
	public PersonArrayList() {
	}
	
    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param c the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     */
    public PersonArrayList(Collection<? extends Person> c) {
    	c.stream().forEach( person -> this.place(person) );
    }

	private ArrayList<Person> list = new ArrayList<Person>();
	
	@Override
	protected void add(Person p) {
		list.add(p);
	}

	/***
	 * Its important that the location objects do NOT have a public
	 * remove method.  This prevents objects from ending up lost 
	 * (in no location).
	 * @param p
	 */
	@Override
	protected void remove(Person p) {
		list.remove(p);
	}

	@Override
	public Iterator<Person> iterator() {
		return list.iterator();
	}
	
    /**
     * Returns the element at the specified position in this list.
     *
     * @param  index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
	public Person get(int index) {
		return list.get(index);
	}
	
    /**
     * Returns <tt>true</tt> if this list contains the specified element.
     * More formally, returns <tt>true</tt> if and only if this list contains
     * at least one element <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     *
     * @param o element whose presence in this list is to be tested
     * @return <tt>true</tt> if this list contains the specified element
     */
    public boolean contains(Object o) {
        return list.contains(o);
    }

}
