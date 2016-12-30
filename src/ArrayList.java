public class ArrayList implements List {
	
	private int size = 0;
	private static int DEFAULT_SIZE = 5; 
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

		//ReturnObject firstObject = null;
		return retObject;
	}

	public ReturnObject add(int index, Object item) {
		ReturnObject firstObject = null;
		return firstObject;
	}

	public ReturnObject add(Object item) {
		if (size >= DEFAULT_SIZE) {
			embiggen();
		}
		array[size] = item;
		size++;
		retObject = new ReturnObjectImpl(item);
		return retObject;
	}

	public void embiggen() {
		Object[] tempArray = new Object[DEFAULT_SIZE + 10];
			for (int i = 0; i < DEFAULT_SIZE; i++) {
				tempArray[i] = array[i];
			}
		DEFAULT_SIZE += 10;
		array = tempArray;

	}

} 