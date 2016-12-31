public class Node {
	private Node nextNode;
	private Object value;

	public Node(Object value, Node nextNode){
		this.nextNode = nextNode;
		this.value = value; 
	}

	public Node getNode(){
		Node myNode = null;
		return myNode;
	} 

	public Node getNextNode(){
		return nextNode;
	}

	public void setNextNode(Node nextNode){
		this.nextNode = nextNode;
	}

	public Object getNodeValue(){
		return value; 
	}




}