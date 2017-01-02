/**
 * An implementation of {@see SampleableList}
 * 
 * @author PiJ
 */
public class SampleableListImpl extends LinkedList implements SampleableList {
	/**
	 * Returns a list containing the first, third, fifth...
	 * items of this list, or an empty list if the list is empty. 
	 * 
	 * @return a list containing the first, third, fifth... items of this list
	 */
	public SampleableList sample(){
		SampleableList sampleableList = new SampleableListImpl();
		if (super.isEmpty()) {
    		return sampleableList;
    	} else {
			// Assign each element to new list, starting after head
    		for (int i = 0; i < (super.size()); i++) {
    			if ((i % 2) == 0) {
    			sampleableList.add(super.get(i).getReturnValue()); 
    			}
    		}
    		return sampleableList;
		}
	}
}
