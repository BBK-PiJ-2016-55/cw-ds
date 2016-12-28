public class ReturnObjectImpl implements ReturnObject {
	
	private ErrorMessage errorMessage;
	private Object object;

	public ReturnObjectImpl(ErrorMessage errorMessage){
		this.errorMessage = errorMessage;
		this.object = null;
	} 

	public ReturnObjectImpl(Object object){
		this.errorMessage = null;
		this.object = object;
	}

	public boolean hasError(){
		boolean error = (this.errorMessage == ErrorMessage.NO_ERROR)? false : true;
		return error;
	}

	public ErrorMessage getError(){
		if (this.hasError()) {
		return errorMessage;
	} else {
		return ErrorMessage.NO_ERROR;
	}

	}

	public Object getReturnValue(){
		Object object = new Object();
		return object;
	}
}
