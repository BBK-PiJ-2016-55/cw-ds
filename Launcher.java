public class Launcher {
    public static void main(String[] args){

    	ReturnObjectImpl retObject1 = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
    	ReturnObjectImpl retObject2 = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
    	ReturnObjectImpl retObject3 = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
    	ReturnObjectImpl retObject4 = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);

    	System.out.println("No_ERROR: ");
    	System.out.println(retObject1.hasError());
    	System.out.println(retObject1.getError());
		System.out.println(" ");

		System.out.println("EMPTY_STRUCTURE: ");
    	System.out.println(retObject2.hasError());
    	System.out.println(retObject2.getError());    	
    	System.out.println(" ");

		System.out.println("INDEX_OUT_OF_BOUNDS: ");
    	System.out.println(retObject3.hasError());
    	System.out.println(retObject3.getError());  
    	System.out.println(" ");

		System.out.println("INVALID_ARGUMENT: ");
    	System.out.println(retObject4.hasError());
    	System.out.println(retObject4.getError());  
    }
}