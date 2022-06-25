package src.Exception;

import java.io.IOException;

class Ext {
	public static void meth() throws Exception {
		System.out.println("Hello");
	}
}

class ExceptionWithInheritance extends Ext {
	// In sublclass's meth() method, we have to declare the exception which is
	// either similar with superclass's meth() method or you have to
	// mention some exception in subclass which is sub-exception of whatever is
	// mentioned in the superclass.
	public static void meth() throws IOException {
		System.out.println("World");
	}

	public static void main(String[] args) throws IOException {
		try {
			Ext.meth();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Here, Ext1 class's meth() is getting called. So in main method, either same
		// exception whatever is there in Ext1's meth() should be mentioned (i.e.
		// IOException in this case). Otherwise
		// some super exception than that should be mentioned.
		meth();
	}
}