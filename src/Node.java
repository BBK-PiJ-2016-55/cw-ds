/**
 * Nodes for use with {@see LinkedList} objects.
 *
 * @author svince04
 */

public class Node {
	private Node nextNode;
	private Object value;

	/**
	 * Constructor.
	 * 
	 * @param value the object to be wrapped within the node.
	 *
	 */
	public Node(Object value){
		this.nextNode = null;
		this.value = value; 
	}

	/**
	 * Retrieves and returns node value.
	 * 
	 * @return The node's value.
	 */
	public Node getNode(){
		Node myNode = null;
		return myNode;
	} 

	/**
	 * Retrieves and returns next node in list.
	 * 
	 * @return The next node's location.
	 */
	public Node getNextNode(){
		return nextNode;
	}

	/**
	 * Updates location of current node's next node.
	 * 
	 * @param The new value of nextNode.
	 */
	public void setNextNode(Node nextNode){
		this.nextNode = nextNode;
	}

	/**
	 * Returns value of the next node in the list.
	 * 
	 * @return The value of the next Node.
	 */
	public Object getNodeValue(){
		return value; 
	}
}