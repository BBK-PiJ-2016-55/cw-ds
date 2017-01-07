/**
 * An implementation of a stack with additional methods. 
 * 
 * Classes implementing this interface must use a {@see List} as the
 * underlying data structure to store the elements on the stack. 
 * 
 * Not all operations on a stack will always be successful. For
 * example, a programmer may try to pop an element from an empty
 * stack. Since we hace not covered exceptions yet, we need another
 * mechanism to report errors. In order to do that, methods of this
 * list will return a {@see ReturnObject} that will contain either an
 * object or an error value of the right kind (as defined in {@see
 * ErrorMessage}).
 * 
 * @author PiJ
 */
public class ImprovedStackImpl implements ImprovedStack {
	/**
     * The data structure where the elements on the stack are stored. 
     */
    protected List internalList;

    public ImprovedStackImpl(List internalList) {
    	this.internalList = internalList;
    }

	/**
	 * Returns a copy of this stack with the items reversed, the top
	 * elements on the original stack is at the bottom of the new
	 * stack and viceversa.
	 * 
	 * @return a copy of this stack with the items reversed. 
	 */
	public ImprovedStack reverse() {
		// do something to take internal list, reverse and assigns to new stack
		ImprovedStack myStack = null;
		return myStack;
	}

	/**
	 * Removes the given object from the stack if it is
	 * there. Multiple instances of the object are all removed.
	 *
	 * Classes implementing this method must use method .equals() to
	 * check whether the item is in the stack or not.
	 * 
	 * @param object the object to remove
	 */
	public void remove(Object object) {
		// do something here
	}

	@Override
	public boolean isEmpty() {
		return (internalList.isEmpty());
	}

	@Override
	public int size() {
		return (internalList.size());
	}

	@Override
	public void push(Object item) {
		internalList.add(0, item);
	}

	@Override
	public ReturnObject top() {
		return (internalList.get(1));
	}

	@Override
	public ReturnObject pop() {
		return (internalList.remove(0));
	}

}

