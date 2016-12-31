/**
 * An implementation of {@see List} using an Object array.
 * 
 * @author svince04
 */
public class LinkedList implements List {
	private int size = 0;
	private Node firstNode = null;
	private ReturnObject retObject;

	public boolean isEmpty() {
		return (size == 0);
	}

	public int size() {
		return size;
	}

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
		retObject = get(index);
		if (!retObject.hasError()) {
			Node currentNode = firstNode;
			// go through nodes until we reach the one before the one to be removed
			// set that nextNode to point to the one *after* node for deletion
			// decrease size
			if (index == 0) {
				firstNode = firstNode.getNextNode();
				size--;
			} else {
				for (int i = 0; i < (index - 1); i++) {
					currentNode = currentNode.getNextNode();
					}
				if (currentNode.getNextNode().getNextNode() == null){
						currentNode.setNextNode(null);
				} else {
						currentNode.setNextNode(currentNode.getNextNode().getNextNode());
				}
				size--;
			}	
		}
		return retObject;
	}

	public ReturnObject add(int index, Object item) {
		if (item == null) {
			retObject = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		} else if (index < 0 || index >= size) {
			retObject = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			// create new node with item passed in params
			Node newNode = new Node(item);
			retObject = new ReturnObjectImpl(item);
			// adding to start of list
			if (index == 0) {
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			// adding anywhere else in list (except at end - out of bounds)
			} else {
				Node currentNode = firstNode;
				// iterate through list to find + stop at item *before* one given in index
				for (int i = 0; i < (index - 1); i++) {
						currentNode = currentNode.getNextNode();
					}
				// set nextNode of newNode to point to that node's current nextNode value
				newNode.setNextNode(currentNode.getNextNode());
				// set NextNode of currentNode to point to newNode  
				currentNode.setNextNode(newNode);
			}
		size++;
		}	
		return retObject;
	}

	public ReturnObject add(Object item) {
		if (item == null) {
			retObject = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		} else {
		Node newNode = new Node(item);
		retObject = new ReturnObjectImpl(item);
			// checks if list is empty and sets firstnode to new if so
			if (isEmpty()){
				firstNode = newNode;
				size++;
			} else {
				Node currentNode = firstNode;
				// go to last node in list
				while (currentNode.getNextNode() != null) {
					currentNode = currentNode.getNextNode();
				}
				// set current last node to point to new node
				currentNode.setNextNode(newNode);
				size++;
			}
		}
		return retObject;		
	}
}
