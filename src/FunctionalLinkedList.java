/**
 *An implementation of {@see FunctionalList} using {@see LinkedList}.
 * 
 * @author svince04
 */

public class FunctionalLinkedList extends LinkedList implements FunctionalList {

	public FunctionalLinkedList() {
		super();
	}

	/**
     * Returns the element at the beginning of the list. 
     * 
     * If the list is empty, an appropriate error is returned using 
     * get() from {@see LinkedList}.
     *
     * @return a copy of the element at the beginning of the list or 
     *         an error if the list is empty.
     */
	public ReturnObject head() {
		super.get(0);
		return retObject;
	}

    /**
     * Returns a list with the elements in this list except the
     * head. The elements must be in the same order. The original list
     * must not change or be affected by changes in the new list. 
     * 
     * If the list is empty, another empty list is returned. 
     */
	public FunctionalList rest() {
		FunctionalList funList = new FunctionalLinkedList();
		// Check for empty/head-only list
		if (super.isEmpty() || (super.size() == 1)) {
    		return funList;
    	} else {
    		// Assign each element to new list, starting after head
    		for (int i = 1; i < (super.size()); i++) {
    			funList.add(super.get(i).getReturnValue()); 
    		}
    		return funList;
    	}
	}

}