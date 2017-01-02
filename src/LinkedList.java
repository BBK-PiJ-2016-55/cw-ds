/**
 * An implementation of {@see List} using an Object array.
 * 
 * @author svince04
 */
public class LinkedList implements List {
	protected int size = 0;
	protected Node firstNode = null;
	protected ReturnObject retObject;

	/**
	 * Returns true if the list is empty, false otherwise. 
	 * 
	 * @return true if the list is empty, false otherwise. 
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * Returns the number of items currently in the list.
	 * 
	 * @return the number of items currently in the list
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns the element at the given position. 
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject get(int index){
		// Check for errors
		retObject = errorCheck(index);
		// If error-free, go through list to find required index
		if (!retObject.hasError()) {	
			Node currentNode = firstNode;
			for (int i = 0; i != index; i++) {
				currentNode = currentNode.getNextNode();
				}
				// Retrieve nodeValue and use to create new RetObject 
				retObject = new ReturnObjectImpl(currentNode.getNodeValue());
		}
		return retObject;
	}

	/**
	 * Returns the elements at the given position and removes it
	 * from the list. The indeces of elements after the removed
	 * element must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject remove(int index){
		// Check for errors via get()
		retObject = get(index);
		if (!retObject.hasError()) {
			// If index is first item in list, redefine firstNode
			if (index == 0) {
				firstNode = firstNode.getNextNode();
			} else {
				Node currentNode = firstNode;
				// Go through list to find item preceding index to be removed
				for (int i = 0; i < (index - 1); i++) {
					currentNode = currentNode.getNextNode();
					}
				// If index is last in list, set pointer to null
				if (currentNode.getNextNode().getNextNode() == null){
						currentNode.setNextNode(null);
				// Otherwise, set pointer to item after deleted item
				} else {
						currentNode.setNextNode(currentNode.getNextNode().getNextNode());
				}
			}
		size--;
		}
		return retObject;
	}

	/**
	 * Adds an element to the list, inserting it at the given
	 * position. The indeces of elements at and after that position
	 * must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param index the position at which the item should be inserted in
	 *              the list
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         or containing an appropriate error message otherwise
	 */
	public ReturnObject add(int index, Object item) {
		// Check for errors
		retObject = errorCheck(index);
		if (item == null) {
			retObject = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
			return retObject;
		} else if (retObject.hasError()) {
			return retObject;
		} else {
			Node newNode = new Node(item);
			retObject = new ReturnObjectImpl(item);
			// If index is first item in list, redefine firstNode
			if (index == 0) {
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			} else {
				Node currentNode = firstNode;
				// Go through list to find item preceding index addition point
				for (int i = 0; i < (index - 1); i++) {
						currentNode = currentNode.getNextNode();
					}
				newNode.setNextNode(currentNode.getNextNode()); 
				currentNode.setNextNode(newNode);
			}
		size++;
		return retObject;
		}	
	}

	/**
	 * Adds an element at the end of the list.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         or containing an appropriate error message otherwise
	 */
	public ReturnObject add(Object item) {
		if (item == null) {
			retObject = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		} else {
		Node newNode = new Node(item);
		retObject = new ReturnObjectImpl(item);
			// If list is empty, set firstNode
			if (isEmpty()){
				firstNode = newNode;
			} else {
				Node currentNode = firstNode;
				// Find last node in list
				while (currentNode.getNextNode() != null) {
					currentNode = currentNode.getNextNode();
				}
				currentNode.setNextNode(newNode);
			}
		size++;
		}
		return retObject;		
	}

	/**
	 * Checks for errors related to indeces.
	 * 
	 * If an invalid index is entered, the appropriate error
	 * message is returned.
	 *
	 * @param index the position in the index being validated
	 * @return a ReturnObject, containing an appropriate error/
	 *         no error message.
	 */
		public ReturnObject errorCheck(int index) {
		if (isEmpty()){
			retObject = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else if (index < 0 || index >= size) {
			retObject = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			retObject = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		}
		return retObject;
	}
}
