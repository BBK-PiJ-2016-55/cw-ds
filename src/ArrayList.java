/**
 * An implementation of {@see List} using an Object array.
 * 
 * @author svince04
 */
public class ArrayList implements List {

	protected int size = 0;
	protected static final int DEFAULT_SIZE = 20; 
	protected Object[] array = new Object[DEFAULT_SIZE];
	protected ReturnObject retObject;

	public boolean isEmpty() {
		return (size == 0);
	}

	public int size() {
		return size;
	}

	public ReturnObject get(int index) {
		// Checks for errors
		if (isEmpty()) {
			retObject = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		} else if (index < 0 || index > size) {
			retObject = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {
			retObject = new ReturnObjectImpl(array[index]);
		}
	// Returns retObject with errors or object
	return retObject;
	}

	public ReturnObject remove(int index) {
		retObject = get(index);
		if (!retObject.hasError()) {
			for (int i = index; i < size; i++) {
				array[i] = array[i + 1];
			}
			// Sets last object to null - last object now held at previous index
			array[size] = null;
			size--;
		}
		return retObject; 
	}

	public ReturnObject add(int index, Object item) {
		// Checks for errors
		if (item == null) {
			retObject = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		} else if (index < 0 || index > size) {
			retObject = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else {	
			// Makes array larger if already at full capacity
			if (size >= array.length){
				embiggen();
			}
			// Checks if index is last in current list
			if (size == index){
				array[size] = item;
			} else {
				// Goes backwards through list, moving all elements up one place
				// Until correct index point is found
				for (int i = (size - 1); i >= index; i--) {
					array[i + 1] = array[i];
				}
				array[index] = item;
			}
			retObject = new ReturnObjectImpl(null);
			size++;
		}
		return retObject;
	}

	public ReturnObject add(Object item) {
		// Uses the other get() to add item at end of list
		retObject = add(size, item);
		return retObject;
	}

	/**
	 * Creates a bigger (+10) array if current capacity has 
	 * been reached, copies in existing values and switches old
	 * pointer to new, bigger array.
	 *
	 */ 
	private void embiggen() {
		Object[] tempArray = new Object[array.length + 10];
			for (int i = 0; i < array.length; i++) {
				tempArray[i] = array[i];
			}
		array = tempArray;
	}

} 