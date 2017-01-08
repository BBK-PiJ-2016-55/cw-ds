/**
 * An implementation of {@see ImprovedStack}.
 * 
 * @author svince04
 */
public class ImprovedStackImpl implements ImprovedStack {
	/**
     * The data structure where the elements of the stack are stored. 
     */
    protected List internalList;

    public ImprovedStackImpl(List internalList) {
    	this.internalList = internalList;
    }

	public ImprovedStack reverse() {
		List revList = new ArrayList();
			// Populate revList with reversed InternalList
			for (int i = 0; i <= internalList.size(); i++) {
				revList.add(internalList.get(internalList.size() - i).getReturnValue()); 
			}
			// Create new ImprovedStackImpl using reversed list
			ImprovedStack revStack = new ImprovedStackImpl(revList);
			return revStack;
	}

	public void remove(Object object) {
		for (int i = 0; i < size(); i++) {
			if (internalList.get(i).getReturnValue().equals(object)) {
					internalList.remove(i);
				}
			}

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
		return (internalList.get(0));
	}

	@Override
	public ReturnObject pop() {
		return (internalList.remove(0));
	}

}

