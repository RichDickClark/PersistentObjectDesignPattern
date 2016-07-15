package williams.person;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

public class PersonStack<E extends Person> extends PersonLocation<E> implements Iterable<E> {

	public PersonStack() {
	}
	
	private Stack<E> stack = new Stack<E>();
	
	@Override
	protected void add(E p) {
		stack.add(p);
	}

	/***
	 * Its important that the location objects do NOT have a public
	 * remove method.  This prevents objects from ending up lost 
	 * (in no location).
	 * @param p
	 */
	@Override
	protected void remove(Object p) {
		stack.remove(p);
	}

	@Override
	public Iterator<E> iterator() {
		return stack.iterator();
	}
	
    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return  the object at the top of this stack (the last item
     *          of the <tt>Vector</tt> object).
     * @throws  EmptyStackException  if this stack is empty.
     */
    public synchronized E peek() {
        return stack.peek();
    }
}

