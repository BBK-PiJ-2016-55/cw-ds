/**
 * An implementation of {@see SampleableList}
 * 
 * @author svince04
 */
public class SampleableListImpl extends LinkedList implements SampleableList {

	public SampleableList sample(){
		SampleableList sampleableList = new SampleableListImpl();
		if (super.isEmpty()) {
    		return sampleableList;
    	} else {
			// Goes through each element in target list
    		for (int i = 0; i < (super.size()); i++) {
    			// Assigns only even indices to new list
    			if ((i % 2) == 0) {
    			sampleableList.add(super.get(i).getReturnValue()); 
    			}
    		}
    		return sampleableList;
		}
	}
}
