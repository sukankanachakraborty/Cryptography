
public class calculateXOR {

	public static String[] binaryValues(char c){
		
		String[] result=new String[26];
		
		String binaryValue=Integer.toBinaryString(c);
		
		
		int [] decimalValues={65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90};
		
		String[] binaryKeys=new String[26];
		
		String[] binary=new String[decimalValues.length];
		
		for(int i=0;i<decimalValues.length;i++){
			binary[i]=Integer.toBinaryString(decimalValues[i]);
		}
		
		int n=0;
		
		String str="";
		
		if(binaryValue.length()<8){
			n=8-binaryValue.length();
			str=binaryValue;
			if(n==1){
				binaryValue="0"+str;
			}
			else if(n==2){
				binaryValue="00"+str;
			}
			else if(n==3){
				binaryValue="000"+str;
			}
			else if(n==4){
				binaryValue="0000"+str;
			}
		}
		
		for(int i=0;i<binary.length;i++){
			if(binary[i].length()<8){
				n=8-binary[i].length();
				str=binary[i];
				if(n==1){
					binary[i]="0"+str;
				}
				else if(n==2){
					binary[i]="00"+str;
				}
				else if(n==3){
					binary[i]="000"+str;
				}
				else if(n==4){
					binary[i]="0000"+str;
				}
				str=new String();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		
		for(int i=0;i<binary.length;i++){
				for (int j = 0; j < binary[i].length(); j++) {
			        sb.append(calculateChar(calculateBit(binary[i].charAt(j)) ^ 
			        		calculateBit(binaryValue.charAt(j))));
			    }
				binaryKeys[i] = sb.toString();
			    sb = new StringBuilder();
		}
		
		result=binaryKeys;
		
		return result;

	}
	
	private static boolean calculateBit(char input) {
		boolean result=false;
		
		if(input=='1'){
			result=true;
		}
	   
		return result;
	}

	private static char calculateChar(boolean input) {
		char result='\0';
		
		if(input){
			result='1';
		}
		else{
			result='0';
		}
		
		return result;
	    
	}

}
