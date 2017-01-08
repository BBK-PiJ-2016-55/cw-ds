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

	public boolean isEmpty() {
		return (internalList.isEmpty());
	}

	public int size() {
		return internalList.size();
	}

	public void push(Object item) {
		internalList.add(0, item);
	}
	
	public ReturnObject top() {
		ReturnObject retObject = internalList.get(0);
		return retObject;
	}

	public ReturnObject pop() {
		ReturnObject retObject = internalList.remove(0);
		return retObject;
	}

}