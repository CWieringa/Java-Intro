// lab2.java
// Clay Wieringa
// September 5, 2025
// calculates primes using Sieve of Eratosthenes
// demonstrates command line arguments and methods
// *** add answers to performance questions here ***
/* 
The maximum prime I could find with my program was 1999999973. Printing drastically affected my program
performance. With printing it took 5 minutes and 19 seconds to get to that prime. Without printing it
took just 18 seconds. The issue that kept my program from finding higher primes was that it ran out of
memory.
*/

public class lab2 {

	public static void main(String[] args) 
	{
		
        int num;
		if (args.length > 0)
        {
            num = Integer.parseInt( args[0] );
            System.out.println( "num = " + num);
        }
        else
        {
            num = 1000;
            System.out.println( "using default num: " + num);
        }

        boolean[] array = new boolean[num + 1];

        for (int i = 0; i <= num; i++) {
            array[i] = true;
        }
        array[0] = false;
        array[1] = false;
        
        
        
		//call showPrimes
		showPrimes( array, num );
		
	}//main
	
	public static void showPrimes(boolean[] array, int num)
	{
		//add code to display primes
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (array[i] == true) {
                for (int j = i * i; j < num; j += i) {
                    array[j] = false;
                }
            }
        }

        for (int i = 2; i < num; i++)
        {
            if (array[i] == true) {
                System.out.println( i );
            }
        }   
	}//showPrimes
	
}//lab2