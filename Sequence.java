import java.util.BitSet;


public class Sequence {
	public BitSet rep;
	Sequence leftSeq;
	Sequence rightSeq;
	float cost;
	float tempCost;
	String cMetric;
	String dMetricString;
	String elementsString;
	
	Sequence() {
		rep = new BitSet();
	}
	
	Sequence(BitSet bs){
		rep = bs;
	}
	
	public Sequence[] getSequenceArray(int card){
		int iSetSize = (int) Math.pow(2, card) - 1;
		Sequence[] arr = new Sequence[iSetSize];
		String sBinInt;
		String bit;
		for (int i = 0; i < iSetSize; i++) {
			sBinInt = Integer.toBinaryString(i+1);
			System.out.println("binary string " + Integer.toBinaryString(i+1));
			BitSet bs = new BitSet(card);
			
			for (int s = 0; s < sBinInt.length(); s++) {
				
				bit = sBinInt.substring(s, s + 1);
				
				if (Integer.parseInt(bit) == 1) {
					
					bs.set(s);
				}
			}
			
			arr[i].rep = bs;
			System.out.println("value set[i] = " + arr[i].rep.toString());
			System.out.print(" binary representation of a plan ");
			for (int j = 0; j < card; j++) {
				
				if (arr[i].rep.get(j)) {
					
					System.out.print(1);
				}
				else {
					
					System.out.print(0);
				}
			}
			System.out.println();
			System.out.println("cardinality " + arr[i].rep.cardinality());
			System.out.println("===============" );
			System.out.println();
		}
		return arr;
	}
	
}


