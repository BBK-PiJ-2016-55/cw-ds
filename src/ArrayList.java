/**
 * A list is a collection of objects that are sorted and can be
 * accessed by index. The first element in the list is at index 0.
 *
 * A list can store objects of any kind, and they can be of different
 * types: Integers, Doubles, String, or even other lists. However,
 * this list cannot store null objects.
 * 
 * There is no limit to the number of elements in the list (provided
 * that there is free memory in the Java Virtual Machine).
 * 
 * Not all operations on a list will always be successful. For
 * example, a programmer may try to remove an element from an empty
 * list, or from a position where there is nothing. Since we hace not
 * covered exceptions yet, we need another mechanism to report
 * errors. In order to do that, methods of this list will return a
 * {@see ReturnObject} that will contain either an object or an error
 * value of the right kind (as defined in {@see ErrorMessage}). 
 * 
 * @author svince04
 */
public class ArrayList implements List {

	private int size = 0;
	private static int DEFAULT_SIZE = 20; 
	private Object[] array = new Object[DEFAULT_SIZE];
	private ReturnObject retObject;

	/**
	 * Returns true if the list is empty, false otherwise. 
	 * 
	 * @return true if the list is empty, false otherwise. 
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * Returns the number of items currently in the list.
	 * 
	 * @return the number of items currently in the list
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns the element at the given position. 
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject get(int index) {
		if (isEmpty()) {
			retObject = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else if (index < 0 || index > size) {
			retObject = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			retObject = new ReturnObjectImpl(array[index]);
		}
	return retObject;
	}

	/**
	 * Returns the elements at the given position and removes it
	 * from the list. The indeces of elements after the removed
	 * element must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject remove(int index) {
		retObject = get(index);
		if (!retObject.hasError()) {
			for (int i = index; i < size; i++) {
				array[i] = array[i + 1];
			}
			array[size] = null;
			size--;
		}
		return retObject; 
	}

	/**
	 * Adds an element to the list, inserting it at the given
	 * position. The indeces of elements at and after that position
	 * must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param index the position at which the item should be inserted in
	 *              the list
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         or containing an appropriate error message otherwise
	 */
	public ReturnObject add(int index, Object item) {
		if (item == null) {
			retObject = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		} else if (index < 0 || index > size) {
			retObject = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {	
			if (size >= array.length){
				embiggen();
			}
			if (size == index){
				array[size] = item;
			} else {
				for (int i = (size - 1); i >= index; i--) {
					array[i + 1] = array[i];
				}
				array[index] = item;
			}
			retObject = new ReturnObjectImpl(item);
			size++;
		}
		return retObject;
	}

	/**
	 * Adds an element at the end of the list.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         or containing an appropriate error message otherwise
	 */
	public ReturnObject add(Object item) {
		retObject = add(size, item);
		return retObject;
	}

	/**
	 * Creates a bigger (+10) array if current capacity has 
	 * been reached, copies in existing values and switches old
	 * pointer to new, bigger array.
	 *
	 */ 
	public void embiggen() {
		Object[] tempArray = new Object[array.length + 10];
			for (int i = 0; i < array.length; i++) {
				tempArray[i] = array[i];
			}
		array = tempArray;
	}

} 