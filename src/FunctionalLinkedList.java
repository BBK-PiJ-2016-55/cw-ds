/**
 *An implementation of {@see FunctionalList} using {@see LinkedList}.
 * 
 * @author svince04
 */

public class FunctionalLinkedList extends LinkedList implements FunctionalList {

	public FunctionalLinkedList() {
		super();
	}

	public ReturnObject head() {
		super.get(0);
		return retObject;
	}

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