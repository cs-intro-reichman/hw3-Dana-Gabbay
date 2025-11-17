// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  
	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		while (x2!=0)
		{
			if (x2>0)
			{
				x1++;
				x2--;
			}
			else
			{
				x1--;
				x2++;
			}
		}
		return x1;
	}
	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		while (x2!=0)
		{
			if (x2>0)
			{
				x1--;
				x2--;
			}
			else
			{
				x1++;
				x2++;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		boolean negative = false;
		if (x1<0)
		{
			x1 = minus (0, x1);
			negative = !negative;
		}
		if (x2<0)
		{
			x2= minus(0, x2);
			negative= !negative;
		}
		int r = 0;
		for (int i=0; i<x2; i++)
		{
			r= plus(r, x1);
		}
		if (negative)
			r = minus(0, r);
		
		return r;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int r=1;
		for (int i=0; i<n; i++)
		{
			r= times(r,x);
		}
		return r;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if (x2 ==0)
			return 0;
		boolean negative = false;
		if (x1<0)
		{
			x1 = minus(0, x1);
			negative= !negative;
		}
		if (x2<0)
		{
			x2 = minus(0, x2);
			negative= !negative;
		}
		int q=0;
		while (x1>=x2)
		{
			x1 = minus(x1, x2);
			q++;
		}
		if (negative)
			q = minus(0, q);

		return q;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int q = div(x1, x2);
		int prod = times(q, x2);
		int r = minus(x1, prod);
		return r;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int i=0;
		while (times(i,i)<=x)
		{
			i++;
		}
		int r = minus (i,1);
		return r;
	}	  	  
}