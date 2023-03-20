// A superclass is a class from which another class is inherited. Direct access to non-private fields and methods is provided.

class A {

	// A base implementation for hello
	void hello () {
		System.out.println("Non-overridden method from superclass says hello.");
	}
 
	void helloSuper () { 
		System.out.println("Hello from superclass!");  
	} 
} 

// A subclass is a class which inherits some or all of its non-private fields and methods from a superclass.
class B extends A { 
	
	void helloSub () {
		System.out.println("Hello from subclass!");
	}
	
	// Method overriding to replace the inheritied base implementation completely.
	@Override 
	void hello () {
		System.out.println("Overridden method from subclass says hello.");
	}  
	
	// Overloading: one of the possible overloads is defined here
	void helloThing (final String thing) {
		System.out.printf("Hello (String) %s!\n", thing);
	}
	
	// Overloading: one of the possible overloads is defined here
	void helloThing (final int thing) {
		for (int i = 0; i < thing; i++) { 
			System.out.printf("Hello (int) #%d!\n", i);
		}
	}
} 

public class Main {
	public static void main (String args[]) {
		final var a = new A(); 
		// Call the non-overridden method in the superclass 
		a.hello();
		// Call the inheritable unique method in the superclass 
		a.helloSuper();
		
		final var b = new B();
		// Call the overridden method in the subclass
		b.hello();
		// Call the inherited non-overridden method in the superclass from the sublcass
		b.helloSuper(); 
		// Call the non-inherited method uniquely defined in the subclass
		b.helloSub();
		// Call the String overload for helloThing 
		b.helloThing("user");
		// Call the int overload for helloThing 
		b.helloThing(4);
		
		// The overloads allow defining different signatures for the same method name
		// Reusing a method name means that the semantic intent of the method can be communicated 
		// to the reader, among other benefits of parametric polymorphism.
		
		// The overrides allow completely replacing a method of the same name from a superclass or interface.
		// They don't allow the overridden "original" superclass or interface method to be callable after being overridden.
	}
}
