public class FunctionalLinkedList extends LinkedList implements FunctionalList {

	public FunctionalLinkedList() {
		super();
	}

	/**
     * Returns the element at the beginning of the list. 
     * 
     * If the list is empty, an appropriate error is returned. 
     *
     * @return a copy of the element at the beginning of the list or 
     *         an error if the list is empty.
     */
	public ReturnObject head() {
		// test to check if retObject needs to be assigned back - shouldn't be
		// so 'retObject =' could be removed...
		retObject = super.get(0);
		return retObject;

	}

	public FunctionalList rest() {
		FunctionalList funList = new FunctionalLinkedList();
		return funList;
	}

}