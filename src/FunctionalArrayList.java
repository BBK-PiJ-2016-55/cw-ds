/**
 * A functional list is a list with a few additional methods that are
 * common in functional languages (such as Lisp, Clojure, or Haskell)
 * to work with lists in a recursive way. 
 *
 * Not all operations on a recursive list will always be
 * successful. For example, a programmer may try to extract the head
 * from an empty list. Since we have not covered exceptions yet, we
 * need another mechanism to report errors. In order to do that,
 * methods of this list will return a {@see ReturnObject} that will
 * contain either an object or an error value of the right kind (as
 * defined in {@see ErrorMessage}).
 * 
 * @author PiJ
 */

public class FunctionalArrayList extends ArrayList implements FunctionalList {
	
	public FunctionalArrayList(){
		super();
	}

	/**
     * Returns the element at the beginning of the list. 
     * 
     * If the list is empty, an appropriate error is returned using 
     * get() from {@see ArrayList}.
     *
     * @return a copy of the element at the beginning of the list or 
     *         an error if the list is empty.
     */
    public ReturnObject head() {
    	retObject = super.get(0);
    	return retObject;
    }

     /**
     * Returns a list with the elements in this list except the
     * head. The elements must be in the same order. The original list
     * must not change or be affected by changes in the new list. 
     * 
     * If the list is empty, another empty list is returned. 
     */
    public FunctionalList rest(){
    	FunctionalList funList = new FunctionalArrayList();
    	if (super.isEmpty()) {
    		return funList;
    	} else {
    		for (int i = 1; i < (super.size()); i++) {
    			funList.add(super.get(i).getReturnValue()); 
    		}
    		return funList;
    	}
    }
}





