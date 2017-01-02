public class FunctionalLinkedList extends LinkedList implements FunctionalList {

	public FunctionalLinkedList() {
		super();
	}

	public ReturnObject head() {
		return retObject;

	}

	public FunctionalList rest() {
		FunctionalList funList = new FunctionalLinkedList();
		return funList;
	}

}