

/* Algorithm- this program is to create ISBN numbers.
 * Step 1: It takes in a ProductID and uses weighted sum modulus 11.
 * Step 2: The Product Id is taken and converted to string and then the sum is calculated by multiplying the individual
 * digits with constants.
 * Step 3: Then the final 10th digit is calculated based on the sum value. If the sum is already divisible 
 * by 11 then 0 is added. If it is 10 then X is added. If not then the value of 11-(sum%11) is added.
 */
public class rakutenassignment {
	
	public static String converttoISBN(Long productID) {
		String id=String.valueOf(productID);
		
		// String builder is used instead of string as it is mutable compared to string which is immutable.
		StringBuilder sb= new StringBuilder();
		int sum=0;
		int j=10;
		
		//Sum is calculated in the same loop as well as appending it to the output string value.
		for(int i=3;i<id.length();i++) {
			String s=id.substring(i,i+1);
			sum+=Integer.parseInt(s)*j;
			j--;
			sb.append(s);
		}
		
		if (sum%11==0)
			sb.append(String.valueOf(0));
		
		else if (sum%11==1)
			sb.append("x");
		
		else
			sb.append(String.valueOf(11-(sum%11)));
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(converttoISBN(Long.parseLong("978037428158")));
	}

}
