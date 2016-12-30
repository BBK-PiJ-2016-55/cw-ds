public class ArrayList implements List {
	
	private int size = 0;
	private static int DEFAULT_SIZE = 20; 
	private Object[] array = new Object[DEFAULT_SIZE];
	private ReturnObject retObject;

	public boolean isEmpty() {
		return (size == 0);
	}

	public int size() {
		return size;
	}

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

	public ReturnObject remove(int index) {
		retObject = get(index);
		if (!retObject.hasError()) {
			for (int i = index; array[(i + 1)] != null; i++) {
				array[i] = array[(i + 1)];
			}
			array[size] = null;
			size--;
		}
		return retObject; 
	}

	public ReturnObject add(int index, Object item) {
		if (item == null) {
			retObject = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		} else {
			if (size == DEFAULT_SIZE){
				embiggen();
			}
			if (size == index){
				array[size] = item;
				size++;
			} else {
				for (int i = (size - 1); i != index; i--) {
					array[(i + 1)] = array[i];
				}
				array[index] = item;
				size++;
			}
			retObject = new ReturnObjectImpl(item);
		}
		return retObject;
	}

	public ReturnObject add(Object item) {
		retObject = add(size, item);
		return retObject;
	}

	// Makes array bigger if it has reached maximum capacity
	// Change this name to something more sensible pre-submission 
	public void embiggen() {
		Object[] tempArray = new Object[DEFAULT_SIZE + 10];
			for (int i = 0; i < DEFAULT_SIZE; i++) {
				tempArray[i] = array[i];
			}
		DEFAULT_SIZE += 10;
		array = tempArray;
	}

} 