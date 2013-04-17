import java.util.ArrayList;
import java.util.BitSet;
import java.util.Properties;


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
	
	public void addLeft(Term lt){
		this.leftSeq = lt;
	}
	
	public void addRight(Term rt){
		this.rightSeq = rt;
	}
	
	public float calcNoBranch(Integer[] vars, Properties props){
		int k = 0;
		for (int i = 0; i < vars.length; i++) {
			if (vars[i] == 1) {
				k++;
			}
		}
		float cost = 0;
		cost = k * Float.valueOf(props.getProperty("r"));
		cost += (k-1) * Float.valueOf(props.getProperty("l"));
		cost += k * Float.valueOf(props.getProperty("f"));
		cost += Float.valueOf(props.getProperty("a"));
		return cost;
	}
	
	public float calcSAnd(Integer[] vars, Properties props, float[] select){
		int k = 0;
		for (int i = 0; i < vars.length; i++) {
			if (vars[i] == 1) {
				k++;
			}
		}
		float q = 0;
		float product = 1.0f;
		for (int i = 0; i < select.length; i++) {
			product = product * select[i];
		}
		if (product > 0.5){
			q = (1.0f - product);
		}
		else {
			q = product;
		}
		float cost = 0;
		cost = k * Float.valueOf(props.getProperty("r"));
		cost += (k-1) * Float.valueOf(props.getProperty("l"));
		cost += k * Float.valueOf(props.getProperty("f"));
		cost += Float.valueOf(props.getProperty("t"));
		cost += q * Float.valueOf(props.getProperty("m"));
		cost += product * Float.valueOf(props.getProperty("a"));
		return cost;
	}
	
	public float calcDoubAnd(Integer[] vars, float costPlan2, Properties props, float[] select){
		int k = 0;
		for (int i = 0; i < vars.length; i++) {
			if (vars[i] == 1) {
				k++;
			}
		}
		float fcost = k * Float.valueOf(props.getProperty("r"));
		fcost += (k-1)*Float.valueOf(props.getProperty("l"));
		fcost += k*Float.valueOf(props.getProperty("f"));
		fcost += Float.valueOf(props.getProperty("t"));
		float q = 0;
		float product = 1.0f;
		for (int i = 0; i < select.length; i++) {
			product = product * select[i];
		}
		if (product > 0.5){
			q = (1.0f - product);
		}
		else {
			q = product;
		}
		float planCost = fcost;
		planCost += q * Float.valueOf(props.getProperty("m"));
		planCost += product * costPlan2;
		return planCost;
	}
	
	public float[] calcCMetric(Integer[] vars, Properties props, float[] select){
		float[] tuple = new float[2];
		int k = 0;
		for (int i = 0; i < vars.length; i++) {
			if (vars[i] == 1) {
				k++;
			}
		}
		float fcost = k * Float.valueOf(props.getProperty("r"));
		fcost += (k-1)*Float.valueOf(props.getProperty("l"));
		fcost += k*Float.valueOf(props.getProperty("f"));
		fcost += Float.valueOf(props.getProperty("t"));
		float q = 0;
		float product = 1.0f;
		for (int i = 0; i < select.length; i++) {
			product = product * select[i];
		}
		if (product > 0.5){
			q = (1.0f - product);
		}
		else {
			q = product;
		}
		float inter = (product - 1.0f);
		inter = inter/fcost;
		tuple[0] = inter;
		tuple[1] = product;
		return tuple;
	}
	
	public float[] calcDMetric(Integer[] vars, Properties props, float[] select){
		float[] tuple = new float[2];
		int k = 0;
		for (int i = 0; i < vars.length; i++) {
			if (vars[i] == 1) {
				k++;
			}
		}
		float fcost = k * Float.valueOf(props.getProperty("r"));
		fcost += (k-1)*Float.valueOf(props.getProperty("l"));
		fcost += k*Float.valueOf(props.getProperty("f"));
		fcost += Float.valueOf(props.getProperty("t"));
		float product = 1.0f;
		for (int i = 0; i < select.length; i++) {
			product = product * select[i];
		}
		tuple[0] = fcost;
		tuple[1] = product;
		return tuple;
	}
	
	public static ArrayList<Term> generateTermArray(int card) {
		ArrayList<Integer[]> seqArr = Term.getTermsArray(card);
		ArrayList<Term> termArr = new ArrayList<Term>();
		for(Integer[] elem : seqArr){
			Term tempTerm = new Term(elem);
			termArr.add(tempTerm);
		}
		//System.out.print("There are " + termArr.size() + " elements");
		return termArr;
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


