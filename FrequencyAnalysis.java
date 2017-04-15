import java.util.HashMap;
import java.util.Map;

public class FrequencyAnalysis {

	public static void main(String[] args) {
		
/*		String cipherText="PGGLKKIYTzZAGFyMyRyRGQKDQNFCGMQD"
				+ "RDEHMMQHNSDDGzRKZTNHVDRRGMMSHNNFyEPDRSDDBHEAyMEdy";*/
		
		//Gives a more realistic frequency distribution
		
		String cipherText = "SGDLHKJYWzYADFzMzRzRDQHDRNEC"
				+ "DMRDQDFHNMRHMSGDDzQKYTMHUDQRDMNSKNMFzESDQSGDAHFAzMFdz";
		
		System.out.println("Cipher text:");
		System.out.println(cipherText+"\n\n");
		int count = 0;
		
		
		//Frequency Analysis
		
		System.out.println("Frequencies of letters:");
		Map<Character, Integer> list = new HashMap<Character, Integer>();

		for (int i = 0; i < cipherText.length(); i++) {
			if (cipherText.charAt(i) != ',') {
				if (list.containsKey(cipherText.charAt(i))) {
					count = list.get(cipherText.charAt(i));
					count++;
					list.put(cipherText.charAt(i), count);
				} else {
					list.put(cipherText.charAt(i), 1);
				}
			}
		}

		System.out.println(list);
		
		System.out.println("\n");
		
		//Converting ASCII values to decimal values
		
		int[] arr=new int[cipherText.length()];
		
		for (int i = 0; i < cipherText.length(); i++){
			arr[i]=(int) cipherText.charAt(i);
		}
		
		char[] plainText=new char[arr.length];
		
		
		//Shifting each letter by +1

		for(int i=0;i<arr.length;i++){
			plainText[i]=(char) (arr[i]+1);
		}
		
		for(int i=0;i<plainText.length;i++){
			
			//To accommodate shift from Z to A
			if(plainText[i]=='{'){
				plainText[i]='A';
			}
		}
		
		for(int i=0;i<plainText.length;i++){
			System.out.print(plainText[i]);
		}
		
		//Hint is provided in MILKZXAZ which should
		//be MILKY WAY, and so 'Z' is replaced with 'Y'
		//and 'X' with 'W' to obtain the original text
		for(int i=0;i<plainText.length;i++){
			if(plainText[i]=='Z'){
				plainText[i]='Y';
			}
			else if(plainText[i]=='X'){
				plainText[i]='W';
			}
		}
		
		System.out.println("\n\nPlaintext:");
		
		for(int i=0;i<plainText.length;i++){
			System.out.print(plainText[i]);
		}
	}
}
