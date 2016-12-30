public class ArrayList implements List {
	
	private int size = 0;
	private static int START_SIZE = 20; 
	private Object[] array = new Object[START_SIZE];
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
		ReturnObject firstObject = null;
		return firstObject;
	}

	public ReturnObject add(int index, Object item) {
		ReturnObject firstObject = null;
		return firstObject;
	}

	public ReturnObject add(Object item) {
		ReturnObject firstObject = null;
		return firstObject;
	}

} 