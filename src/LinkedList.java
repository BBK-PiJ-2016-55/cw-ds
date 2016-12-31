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

	public ReturnObject get(int index){
		// start at first node and get nextNode()
		// set tempNode to nextNode
		// add one to counter 
		// get next node adde one to counter... until counter = index
		// return that node
		if (isEmpty()){
			retObject = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else if (index < 0 || index > size) {
			retObject = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
		Node tempNode = firstNode;
		for (int i = 0; i != index; i++) {
			tempNode = tempNode.getNextNode();
			}
			retObject = new ReturnObjectImpl(tempNode.getNodeValue());
		}
		return retObject;
	}

	public ReturnObject remove(int index){
		retObject = get(index);
		if (!retObject.hasError()) {
			Node tempNode = firstNode;
			// go through nodes until we reach the one before the one to be removed
			// set that nextNode to point to the one *after* node for deletion
			// decrease size
			if (index == 0) {
				firstNode = firstNode.getNextNode();
				size--;
			} else {
				for (int i = 0; i < (index - 1); i++) {
					tempNode = tempNode.getNextNode();
					}
					if (tempNode.getNextNode().getNextNode() == null){
						tempNode.setNextNode(null);
					} else {
						tempNode.setNextNode(tempNode.getNextNode().getNextNode());
						size--;
					}
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
				Node tempNode = firstNode;
				// iterate through list to find + stop at item *before* one given in index
				for (int i = 0; i < (index - 1); i++) {
						tempNode = tempNode.getNextNode();
					}
				// set nextNode of newNode to point to that node's current nextNode value
				newNode.setNextNode(tempNode.getNextNode());
				// set NextNode of tempNode to point to newNode  
				tempNode.setNextNode(newNode);
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
				Node tempNode = firstNode;
				// go to last node in list
				while (tempNode.getNextNode() != null) {
					tempNode = tempNode.getNextNode();
				}
				// set current last node to point to new node
				tempNode.setNextNode(newNode);
				size++;
			}
		}
		return retObject;		
	}
}
