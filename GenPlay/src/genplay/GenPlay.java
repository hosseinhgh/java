package genplay;

import java.util.ArrayList;




public class GenPlay {

    public static void main(String[] args) {
        Stack<String> stackOfStrings = new Stack<>();
	
	System.out.printf("Stack of strings is %d tall\n", stackOfStrings.getHeight());
		
	stackOfStrings.push("Adam");
        // stackOfStrings.push(new Integer(1));
        stackOfStrings.push("Barry");
        stackOfStrings.push("Christian");

	System.out.printf("Stack of strings is %d tall\n", stackOfStrings.getHeight());

        for (int i=0; i<4; i++) {
            String s = stackOfStrings.pop();
            System.out.println("Popped: " + s);
        }
                
        
    }
    
}
