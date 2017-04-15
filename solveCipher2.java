
import java.util.ArrayList;
import java.util.List;

public class solveCipher2 {

	public static void main(String[] args) {

		//Given cipher text
		String cipherText = "ZVM]AZCH^kPPMWs\\sCsCM@AU[_LRM\\[UXUOYG\\["
				+ "YDBNUMkXZPEDY\\UXCM\\GBB_DWsTZUXBNUHYOPs\\Ous";


		//Checking with Kasisky test to determine key length

		System.out.println("Kasisky Test:\n");

		for(int i=0; i<cipherText.length()-2;i++){
			String s1=new String();
			s1=""+cipherText.charAt(i)+cipherText.charAt(i+1)
			+cipherText.charAt(i+2);
			for(int j=i+3; j<cipherText.length()-2;j++){
				String s2=new String();
				s2=""+cipherText.charAt(j)+cipherText.charAt(j+1)
				+cipherText.charAt(j+2);
				if(s1.equals(s2)){

					System.out.println("Match found at "+(i+1)+" and "+(j+1)
							+" with distance:"+(j-i));

				}
			}
		}

		//The short length of the message renders the Kasisky test
		//unsuccessful. 

		System.out.println("Kasisky Test proves to be unsuccessful.\n");


		int[] arr=new int[cipherText.length()];

		int n=0;

		String str="";

		//Converting ASCII values to decimal values

		for(int i=0; i<cipherText.length();i++){
			arr[i]=(int) cipherText.charAt(i);
		}

		//Converting from decimal form to binary strings to perform the XOR function

		String[] binary=new String[arr.length];

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

		List<String[]>	binaryList=new ArrayList<String[]>();

		//Employing Brute force technique
		
		
		//Testing multiple key lengths by changing the
		//value of k
		
		
		int k=2;
		//	int k=3;
		//	int k=4;
		
		//Fetching the list of all possible binary values
		//which on XOR operation with each character from
		//the cipher text 

		for(int i=0;i<k;i++){
			binaryList.add(calculateXOR.binaryValues(cipherText.charAt(i)));
		}
		


		for(int itr=0;itr<binaryList.size();itr++){


			String[] binaryKeys=new String[binaryList.get(itr).length];

			binaryKeys=binaryList.get(itr);



			for(int k1=0;k1<binaryKeys.length;k1++){

				String key1="";
				key1=binaryKeys[k1];
				
				
				//Performing XOR for each binary string in the list obtained
				//for each character in cipher-text

				for(int i=0;i<binary.length;i++){
					if(i%k==itr){
						for (int j = 0; j < binary[i].length(); j++) {
							sb.append(calculateChar(calculateBit(binary[i].charAt(j)) ^ 
									calculateBit(key1.charAt(j))));
						}
						plaintext[i] = sb.toString();
						sb = new StringBuilder();
					}
					else{
						//Replacing the characters in positions 
						//other than the multiples of k as 'x'
						plaintext[i]=Integer.toBinaryString((int) 'x');
					}
				}

				for(int i=0;i<plaintext.length;i++){
					arr[i] = Integer.parseInt(plaintext[i], 2);
				}

				boolean print=true;
				
				//Checking to see if the partially decrypted text
				//have invalid characters in positions which are
				//multiples of 'k'
				

				for(int i=0;i<arr.length;i++){
					if(!(arr[i]>=65 && arr[i]<=90)&& !(arr[i]>=97 && arr[i]<=122)){
						print=false;
						break;
					}

				}

				char[] result=new char[arr.length];

				for(int i=0;i<arr.length;i++){
					result[i]=(char) arr[i];
				}
				
				//Only possible solutions are printed

				if(print){

					for(int i=0;i<result.length;i++){
						System.out.print(result[i]);
					}
					
					//Key values:
					
					System.out.println("\nKey:"+Integer.parseInt(key1, 2)+" at position k="+(itr+1));
					System.out.print("\n");

				}
	

			}
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
