/**
 * A wrapper containing either an object (the result of an operation
 * on a data structure) or an error value.
 *
 * @author svince04
 */
public class ReturnObjectImpl implements ReturnObject {
	private ErrorMessage errorMessage;
	private Object object;

	/**
	 * Constructor accepting ErrorMessage-type parameter. this.object remains null.
	 * @param errorMessage - ErrorMessage to go into the wrapper. 
	 */
	public ReturnObjectImpl(ErrorMessage errorMessage){
		this.errorMessage = errorMessage;
	} 

	/**
	 * Constructor accepting Object-type parameter. this.errorMessage remains null.
	 * @param object - Object to go into the wrapper.
	 */
	public ReturnObjectImpl(Object object){
		this.object = object;
	}

	/**
	 * Returns whether there has been an error
	 * @return whether there has been an error
	 */
	public boolean hasError(){
		if (errorMessage == ErrorMessage.NO_ERROR || errorMessage == null){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Returns the error message. 
	 * 
	 * This method must return NO_ERROR if and only if
	 * {@hasError} returns false.
	 * 
	 * @return the error message
	 */
	public ErrorMessage getError(){
		if (this.hasError()) {
			return errorMessage;
		} else {
			return ErrorMessage.NO_ERROR;
		}
	}

	/**
	 * Returns the object wrapped in this ReturnObject, i.e. the
	 * result of the operation if it was successful, or null if
	 * there has been an error.
	 * 
	 * Note that the output of this method must be null if {@see
	 * hasError} returns true, but the opposite is not true: if
	 * {@see hasError} returns false, this method may or may not
	 * return null.
	 * 
	 * @return the return value from the method or null if there has been an error
	 */
	public Object getReturnValue(){
		if (this.hasError()) {
			return null;
		} else {
			return object;
		}
	}
}
