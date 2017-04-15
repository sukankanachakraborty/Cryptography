import java.io.FileNotFoundException;

public class solveCipher1 {

	public static void main(String[] args) {

		int n=0;

		String cipherText="";

		//Reading the text from the given file 'Secret.hex' into the String cipherText 
		//using the readFile method from the copyFile class

		try {
			cipherText=readFile.readFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//Converting the given text from ASCII to decimal form

		int[] arr=new int[cipherText.length()];

		for(int i=0;i<cipherText.length();i++){
			arr[i]=(int) cipherText.charAt(i);
		}
		

		//Converting from decimal form to binary strings to perform the XOR function

		String[] binary=new String[arr.length];

		for(int i=0;i<arr.length;i++){
			binary[i]=Integer.toBinaryString(arr[i]);
		}

		String str="";

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


		//Calculating the first position of the key value from the given hint
		//that the first character is 'A'

		String key1=calculateKey.getKey(binary[0]);

		//Using the first position of the key value to decrypt characters
		//at positions which are multiples of k where k varies from 1 to 7,
		//to get an estimate of the key length
		
		System.out.println("Testing for key length:\n");

		for(int k=1;k<8;k++){

			//Performing XOR

			for(int i=0;i<binary.length;i++){

				//Performs XOR with key1 for characters in the first position
				//and multiples of 'k'

				if(i%k==0){
					for (int j = 0; j < binary[i].length(); j++) {
						sb.append(calculateChar(calculateBit(binary[i].charAt(j)) ^ 
								calculateBit(key1.charAt(j))));
					}
					plaintext[i] = sb.toString();
					sb = new StringBuilder();
				}
				else{
					plaintext[i]=binary[i];
				}

			}

			for(int i=0;i<plaintext.length;i++){
				arr[i] = Integer.parseInt(plaintext[i], 2);
			}

			char[] result=new char[arr.length];

			for(int i=0;i<arr.length;i++){
				result[i]=(char) arr[i];
			}

			System.out.println("k="+k);

			int count=0;


			//Checking to see if positions which are multiples of k
			// have invalid characters after decrypting with key1


			for(int i=0;i<arr.length;i++){
				if(i%k==0){
					if(!(arr[i]>=65 && arr[i]<=90)&& !(arr[i]>=97 && arr[i]<=122) &&
							!(arr[i]>=44 && arr[i]<=46) && arr[i]!=32){
						System.out.println("Invalid characters present at positions "
								+ "which are multiples of "+k+"!!\n");
						count++;
						break;
					}
				}
			}
			if(count==0){
				System.out.println("No invalid characters!\nSuggests a valid key length.\n");
			}
			/*
			for(int i=0;i<result.length;i++){
				System.out.print(result[i]);
			}

	*/

		//	System.out.println("\n");
		}
		
		//Checking with Kasisky test
		
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
						if(i<3){
							System.out.println("Match found at "+(i+1)+" and "+(j+1)
									+" with distance:"+(j-i));
						}
					}
			}
		}
		
		//Calculating the GCD of 84, 262, 308, 458, 712 on a calculator
		
		System.out.println("\nGCD of distances=2.\nTherefore confirming key length=2.");


		//Above analysis shows that for even values, decryption with 
		//key1 does not result in an invalid character, suggesting
		//the key length is 2.

		//'A?fEeR' suggests '?' could either be a letter or ' '(a space)

		String key2=calculateKey.getKey(binary[1],' ');

		for(int i=0;i<binary.length;i++){

			//Performs XOR with key1 for characters in the first position
			//and key2 in the second position
			
			if(i%2==0){
				for (int j = 0; j < binary[i].length(); j++) {
					sb.append(calculateChar(calculateBit(binary[i].charAt(j)) ^ 
							calculateBit(key1.charAt(j))));
				}
				plaintext[i] = sb.toString();
				sb = new StringBuilder();
			}
			else{
				for (int j = 0; j < binary[i].length(); j++) {
					sb.append(calculateChar(calculateBit(binary[i].charAt(j)) ^ 
							calculateBit(key2.charAt(j))));
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

		//Prints the Plaintext

		System.out.println("\nPlaintext:");

		for(int i=0;i<result.length;i++){
			System.out.print(result[i]);
		}

		//Prints the Key in ASCII

		System.out.println("\nKey:"+(char) Integer.parseInt(key1, 2)+
				(char) Integer.parseInt(key2, 2));

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
