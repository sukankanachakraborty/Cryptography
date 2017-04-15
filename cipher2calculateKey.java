

public class cipher2calculateKey {

	public static void main(String[] args) {
		String cipherText = "ZVM]AZCH^kPPMWs\\sCsCM@AU[_LRM\\[UXUOYG\\"
				+ "[YDBNUMkXZPEDY\\UXCM\\GBB_DWsTZUXBNUHYOPs\\Ous";
		
		
		int[] arr=new int[cipherText.length()];

		int n=0;

		String str="";

		
		//Converting ASCII values to decimal values

		for(int i=0; i<cipherText.length();i++){
			arr[i]=(int) cipherText.charAt(i);
		}


		String[] binary=new String[arr.length];
		
		//Converting decimal values to binary strings

		for(int i=0;i<arr.length;i++){
			binary[i]=Integer.toBinaryString(arr[i]);
		}

		//Adjusting length of the binary strings 

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

		String[] plaintext=new String[binary.length];

		
	
		//Key value for 'P' in the first position in binary
		
	//	String key1=Integer.toBinaryString(10);
		
		
		//Key value for 'S' in the first position in binary
		String key1=Integer.toBinaryString(9);
		
		n=0;
		
		str=new String();
		
		//Adjusting length of the binary strings 
		
		if(key1.length()<8){
			n=8-key1.length();
			str=key1;
			if(n==1){
				key1="0"+str;
			}
			else if(n==2){
				key1="00"+str;
			}
			else if(n==3){
				key1="000"+str;
			}
			else if(n==4){
				key1="0000"+str;
			}
			str=new String();
		}
		
		
		n=0;
		
		str=new String();
		
		//Key value for 'G' in the second position in binary
		
		String key2=Integer.toBinaryString(17);
		
		//Adjusting length of the binary strings 
		
		if(key2.length()<8){
			n=8-key2.length();
			str=key2;
			if(n==1){
				key2="0"+str;
			}
			else if(n==2){
				key2="00"+str;
			}
			else if(n==3){
				key2="000"+str;
			}
			else if(n==4){
				key2="0000"+str;
			}
			str=new String();
		}

		
		for(int i=0;i<binary.length;i++){
			
			//Performs XOR with key1 for characters in the first position
			//and key2 in the second position
			
			if(i%2==0){
				for (int j = 0; j < binary[i].length(); j++) {
			        sb.append(calculateChar(calculateBit(binary[i].charAt(j)) 
			        		^ calculateBit(key1.charAt(j))));
			    }
			    plaintext[i] = sb.toString();
			    sb = new StringBuilder();
			}
			else{
				for (int j = 0; j < binary[i].length(); j++) {
			        sb.append(calculateChar(calculateBit(binary[i].charAt(j)) 
			        		^ calculateBit(key2.charAt(j))));
			    }
			    plaintext[i] = sb.toString();
			    sb = new StringBuilder();
			}
		}
		
		
		//Converting binary strings to characters to get the Plaintext
		
		for(int i=0;i<plaintext.length;i++){
			arr[i] = Integer.parseInt(plaintext[i], 2);
		}
		
		char[] result=new char[arr.length];
		
		for(int i=0;i<arr.length;i++){
			result[i]=(char) arr[i];
		}
		
		//Prints the partially decrypted text

		System.out.println("Partially decrypted text:");
		
		for(int i=0;i<result.length;i++){
			System.out.print(result[i]);
		}
		
		
	}
	
	//Calculating the bit-by-bit value of the XOR operation
		//Gives the boolean result of a^b

		private static boolean calculateBit(char input) {
			boolean result=false;

			if(input=='1'){
				result=true;
			}

			return result;
		}

		//Converts boolean to character value

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
