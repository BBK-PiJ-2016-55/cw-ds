public class StackImpl extends AbstractStack {

	public StackImpl(List list) {
	  super(list);
	}

	public boolean isEmpty() {
		return (internalList.isEmpty());
	}

	public int size() {
		return internalList.size();
	}

	/**
	 * Adds an element at the top of the stack. 
	 * 
	 * @param item the new item to be added
	 */
	public void push(Object item) {
		internalList.add(0, item);
	}
	
	/**
	 * Returns the element at the top of the stack. The stack is
	 * left unchanged.
	 * 
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 */
	public ReturnObject top() {
		ReturnObject retObject = internalList.get(0);
		return retObject;
	}

	/**
	 * Returns the element at the top of the stack. The element is
	 * removed frmo the stack.
	 * 
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 */
	public ReturnObject pop() {
		ReturnObject retObject = internalList.remove(0);
		return retObject;
	}

}