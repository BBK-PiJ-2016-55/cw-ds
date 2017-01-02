/**
 * A stack accepting {@see List} objects.
 * Extends {@see AbstractStack}
 * Uses index 0 as top of stack.
 *
 * @author svince04
 */
public class StackImpl extends AbstractStack {

	public StackImpl(List list) {
	  super(list);
	}

	/**
	 * Returns true if the list is empty, false otherwise. 
	 * 
	 * @return true if the list is empty, false otherwise. 
	 */
	public boolean isEmpty() {
		return (internalList.isEmpty());
	}

	/**
	 * Returns the number of items currently in the list.
	 * 
	 * @return the number of items currently in the list
	 */
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
	 * removed from the stack.
	 * 
	 * @return If stack is not empty, the item on the top is returned. If the
	 *         stack is empty, an appropriate error.
	 */
	public ReturnObject pop() {
		ReturnObject retObject = internalList.remove(0);
		return retObject;
	}

}