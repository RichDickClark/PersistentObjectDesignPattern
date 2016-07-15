package williams.person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/***
 * Make sure nothing but object and abstract location class are in same package with
 * these specific location classes.  Otherwise other code will have access to the
 * add() and remove() methods, subverting the whole point of this pattern.  
 * @author Clark Williams
 *
 */
public class PersonArrayList<E extends Person> extends PersonLocation<E> implements Iterable<E> {

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
	public PersonArrayList() {
	}
	
    /**
     * Constructs a person array list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param c the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     */
    public PersonArrayList(Collection<? extends E> c) {
    	c.stream().forEach( person -> this.place(person) );
    }

	private ArrayList<E> list = new ArrayList<E>();
	
	@Override
	protected void add(E p) {
		list.add(p);
	}

	/***
	 * Its important that the location objects do NOT have a public
	 * remove method.  This prevents objects from ending up lost 
	 * (in no location).
	 * @param p
	 */
	@Override
	protected void remove(Object p) {
		list.remove(p);
	}

	@Override
	public Iterator<E> iterator() {
		// If we just return list.iterator() and the calling code
		// places any of the cards it will modify this.list,
		// resulting in a ConcurrentModificationException.
		// We therefore return an iterator to a copy of the list.
		return (new ArrayList<E>(list)).iterator();
	}
	
    /**
     * Returns the element at the specified position in this list.
     *
     * @param  index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
	public E get(int index) {
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
    
    /**
     * Returns <tt>true</tt> if this list contains no elements.
     *
     * @return <tt>true</tt> if this list contains no elements
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    /**
     * Returns a sequential {@code Stream} with this collection as its source.
     *
     * @return a sequential {@code Stream} over the elements in this collection
     */
    public Stream<E> stream() {
        return list.stream();
    }
    
    public void shuffle( Random rng ) {
        Collections.shuffle( this.list, rng );
    }

	public List<E> asUnmodifiableList() {
		return Collections.unmodifiableList( this.list );
	}

}

