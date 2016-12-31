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
		return (firstNode == null);
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
		ReturnObject retObject = null;
		return retObject;
	}

	public ReturnObject add(int index, Object item) {
		ReturnObject retObject = null;
		return retObject;	
	}

	public ReturnObject add(Object item) {
		ReturnObject retObject = null;
		return retObject;			
	}
}
