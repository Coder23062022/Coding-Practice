package GeneralProgram;

public class SquareCheck {
	
	static boolean isPerfectSquareWithSquareRoot(double x)  
    { 
          
        // Find floating point value of 
        // square root of x. 
        double sr = Math.sqrt(x); 
      
        // If square root is an integer 
        return ((sr - Math.floor(sr)) == 0); 
    } 
	
	static boolean isPerfectSquareWithoutSquareRoot(int n) 
	{ 
		for (int i = 1; i * i <= n; i++) { 

			// If (i * i = n) 
			if ((n % i == 0) && (n / i == i)) { 
				return true;
			} 
		} 
		return false; 
	} 

	public static void main(String[] args) 
	{ 

		int n = 14162; 

		if (isPerfectSquareWithoutSquareRoot(n)) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 
	} 
} 
