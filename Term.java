import java.util.ArrayList;
import java.util.BitSet;


public class Term {
	//public BitSet rep;
	public Integer[] rep;
	Term leftSeq;
	Term rightSeq;
	float cost;
	float tempCost;
	String cMetric;
	String dMetricString;
	String elementsString;
	
	Term() {
	}
	
	Term(Integer[] givenRep){
		this.rep = givenRep;
	}

	
	public static ArrayList<Integer[]> getTermsArray(int card){
	    int numRows = (int)Math.pow(2, card);
	    ArrayList<Integer[]> varArr = new ArrayList<Integer[]>();
	    for(int i = 0;i<numRows;i++)
	    {
	    	Integer[] vars = new Integer[card];
	        for(int j = 0; j < card; j++)
	        {
	            int val = numRows * j + i;
	            int ret = (1 & (val >>> j));
	            if (ret != 0){
	            	vars[j] = 1;
	            }
	            else {
					vars[j] = 0;
				}
	            //System.out.print(bitArrs[i][j]);
	        }
	        boolean notAllZeros = false;
	        for (int j = 0; j < vars.length; j++) {
				if(vars[j] == 1){
					notAllZeros = true;
				}
			}
	        if (notAllZeros){
	        	varArr.add(vars);
	        }
	        
	        //System.out.println();
	    }
	    /*//printing code
	    for (int i = 0; i < varArr.size(); i++) {
	    	System.out.print(i + ": ");
	    	if (i < (numRows)){
				for (int j = 0; j < card; j++) {
					System.out.print(varArr.get(i)[j]);
				}
			}	
			System.out.println();
		}
		*/
	    return varArr;
	}
	
}


