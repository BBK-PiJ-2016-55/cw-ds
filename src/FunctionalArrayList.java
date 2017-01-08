/**
 *An implementation of {@see FunctionalList} using {@see ArrayList}.
 * 
 * @author svince04
 */

public class FunctionalArrayList extends ArrayList implements FunctionalList {
	
	public FunctionalArrayList(){
		super();
	}

    public ReturnObject head() {
    	super.get(0);
    	return retObject;
    }

    public FunctionalList rest(){
    	FunctionalList funList = new FunctionalArrayList();
        // Check for empty/head-only list
    	if (super.isEmpty() || (super.size() == 1)) {
    		return funList;
    	} else {
            // Assign each element to new list, starting after head
    		for (int i = 1; i < (super.size()); i++) {
    			funList.add(super.get(i).getReturnValue()); 
    		}
    		return funList;
    	}
    }
}





