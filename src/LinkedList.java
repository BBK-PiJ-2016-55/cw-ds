/**
 * An implementation of {@see List} using pointers.
 * 
 * @author svince04
 */
public class LinkedList implements List {
	protected int size = 0;
	protected Node firstNode = null;
	protected ReturnObject retObject;

	public boolean isEmpty() {
		return (size == 0);
	}

	public int size() {
		return size;
	}

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

	public ReturnObject remove(int index){
		// Check for errors via get()
		retObject = get(index);
		if (!retObject.hasError()) {
			retObject = new ReturnObjectImpl(null);
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
			retObject = new ReturnObjectImpl(null);
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

	public ReturnObject add(Object item) {
		if (item == null) {
			retObject = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		} else {
		Node newNode = new Node(item);
		retObject = new ReturnObjectImpl(null);
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
	 * Checks for errors related to indices.
	 * 
	 * If an invalid index is entered, the appropriate error
	 * message is returned.
	 *
	 * @param index the position in the index being validated
	 * @return a ReturnObject, containing an appropriate error/
	 *         no error message.
	 */
		private ReturnObject errorCheck(int index) {
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
