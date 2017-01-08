/**
 * An implementation of {@see ReturnObject}.
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

	public boolean hasError(){
		if (errorMessage == ErrorMessage.NO_ERROR || errorMessage == null){
			return false;
		} else {
			return true;
		}
	}

	public ErrorMessage getError(){
		if (this.hasError()) {
			return errorMessage;
		} else {
			return ErrorMessage.NO_ERROR;
		}
	}

	public Object getReturnValue(){
		if (this.hasError()) {
			return null;
		} else {
			return object;
		}
	}
}
