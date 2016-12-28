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
		boolean error = false;
		return error;
	}

	public ErrorMessage getError(){
		// ErrorMessage errorMessage = new ErrorMessage();
		return errorMessage;

	}

	public Object getReturnValue(){
		Object object = new Object();
		return object;
	}
}
