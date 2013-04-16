import java.util.BitSet;

/* ga
 * Set of plans where each plan represented as bitset of 0s and 1s.
 * 
 * Consider example when cardinality of a plan that is a number of column in given input is 3.
 * Number of all plans 2^3 - 1 = 7
 * plans can be represented via binary strings :
 * {001} {010{ {100}
 * {011} {101} {110}
 * {111}
 * 
 * In the morning I will :
 * 1 fix issue with cardinality 1 plans, since they come out of the set with different binary values that expected
 * (see the printout statements)
 * 2 rewrite this test program to a class with appropriate getters and setters. I need to see your skeleton and
 * data structures you use to come up with names and appropriate set of functions. In this test file you
 * can see the main idea and implementation behind it.
 */

public class BitSetTest {

  /**
	 * @param args[0] cardinality - number of columns
	 */
	public static void main(String[] args) {
		 
		int iK = Integer.parseInt(3);
		int iSetSize = (int) Math.pow(2, iK) - 1;
		System.out.println("K is " + iK);
		System.out.println("iSetSize = 2^K - 1 = " + iSetSize);
		System.out.println();
		
		//BitSet bs = new BitSet(iK);
		BitSet[] set = new BitSet[iSetSize];  
		String sBinInt;
		String bit;
		for (int i = 0; i < iSetSize; i++) {
			
			sBinInt = Integer.toBinaryString(i+1);
			System.out.println("binary string " + Integer.toBinaryString(i+1));
			BitSet bs = new BitSet(iK);
			
			for (int s = 0; s < sBinInt.length(); s++) {
				
				bit = sBinInt.substring(s, s + 1);
				
				if (Integer.parseInt(bit) == 1) {
					
					bs.set(s);
				}
			}
			
			set[i] = bs;
			System.out.println("value set[i] = " + set[i].toString());
			System.out.print(" binary representation of a plan ");
			for (int j = 0; j < iK; j++) {
				
				if (set[i].get(j)) {
					
					System.out.print(1);
				}
				else {
					
					System.out.print(0);
				}
			}
			System.out.println();
			System.out.println("cardinality " +set[i].cardinality());
			System.out.println("===============" );
			System.out.println();
		}
		
		System.out.println("Test set of bit sets.");
		System.out.println("set.length " + set.length);
		System.out.println("print all sets");

		for (int i = 1; i <= iK; i++) {
			
			System.out.println("All plans with cardinality " + (i) );
			
			for (int s = 0; s < set.length; s ++) {
				
				if (set[s].cardinality() == (i) ) { 
					
					System.out.print(set[s].toString());
					System.out.print(" binary representation of a plan ");
					for (int j = 0; j < iK; j++) {
						
						if (set[s].get(j)) {
							
							System.out.print(1);
						}
						else {
							
							System.out.print(0);
						}
					}
					System.out.println();
				}
			}
		}	
	}
}
