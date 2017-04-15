import java.util.HashMap;
import java.util.Map;

public class substitution {

	public static void main(String[] args) {
		
		String cipherText = "noxw z owdzitgw iunhdui woiwkj bnhk "
				+ "ptov, bnh uzgw in yw zfzkw ne ti, zov wovwzgnk in "
				+ "kwmqzxw ti ftiu z xnojikhxitgw now. te iuw owdzitgw "
				+ "iunhdui kwihkoj, kwmqzxw ti zdzto ftiu z mnjtitgw now. "
				+ "ti tj zj te iuwkw zkw ifn mtxihkwj to eknoi ne bnh, zov "
				+ "bnh uzgw in xunnjw in qnnr zi now ne iuwp, zov vtjkwdzkv "
				+ "iuw niuwk. mwkjtjiwoxw ftqq wgwoihzqqb iwzxu bnhk ptov in "
				+ "iutor mnjtitgwqb, zov in tdonkw owdzitgw iunhduij.";
		
		
		int count = 0;

		Map<Character, Integer> list = new HashMap<Character, Integer>();
		
		//Frequency analysis performed on the cipher text

		for (int i = 0; i < cipherText.length(); i++) {
			if (cipherText.charAt(i) != ' ' && cipherText.charAt(i) != ',' 
					&& cipherText.charAt(i) != '.') {
				if (list.containsKey(cipherText.charAt(i))) {
					count = list.get(cipherText.charAt(i));
					count++;
					list.put(cipherText.charAt(i), count);
				} else {
					list.put(cipherText.charAt(i), 0);
				}
			}
		}
		
		System.out.println("Frequency Analysis:");

		System.out.println(list+"\n");
		
		System.out.println("Given cipher text:");
		
		System.out.println(cipherText+"\n");
		
		char[] arr=cipherText.toCharArray();
		
		System.out.println("Substituting 'z' with 'A'");
		
		//Stand-alone character 'z' could be 'A' or 'I'
		//replaced with 'A' since it is usually more frequent that 'I'
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='z'){
				arr[i]='A';
			}
		}
		cipherText=new String(arr);
		
		System.out.println(cipherText+"\n");
		
		//'w' has the highest frequency in the cipher text
		
		System.out.println("Substituting 'w' with 'E'");
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='w'){
				arr[i]='E';
			}
		}
		cipherText=new String(arr);
		
		System.out.println(cipherText+"\n");
		
		
		System.out.println("Substituting 'i' with 'T'");
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='i'){
				arr[i]='T';
			}
		}
		cipherText=new String(arr);
		
		System.out.println(cipherText+"\n");
		
		
		System.out.println("Substituting 'n' with 'O'");
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='n'){
				arr[i]='O';
			}
		}
		cipherText=new String(arr);
		
		System.out.println(cipherText+"\n");
		
		System.out.println("Substituting 'o' with 'N'");
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='o'){
				arr[i]='N';
			}
		}
		cipherText=new String(arr);
		
		System.out.println(cipherText+"\n");
		
		System.out.println("Substituting 'v' with 'D'");
		
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='v'){
				arr[i]='D';
			}
		}
		cipherText=new String(arr);
		
		System.out.println(cipherText+"\n");
		
		System.out.println("Substituting 'x' with 'C'");
		
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='x'){
				arr[i]='C';
			}
		}
		cipherText=new String(arr);
		
		System.out.println(cipherText+"\n");
		
		System.out.println("Substituting 'g' with 'V'");
		
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='g'){
				arr[i]='V';
			}
		}
		cipherText=new String(arr);
		
		System.out.println(cipherText+"\n");
		
		System.out.println("Substituting 'k' with 'R'");
		

		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='k'){
				arr[i]='R';
			}
		}
		cipherText=new String(arr);
		
		System.out.println(cipherText+"\n");
		
		System.out.println("Substituting 't' with 'I'");
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='t'){
				arr[i]='I';
			}
		}
		cipherText=new String(arr);
		
		System.out.println(cipherText+"\n");
		
		System.out.println("Substituting 'd' with 'G'");
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='d'){
				arr[i]='G';
			}
		}
		cipherText=new String(arr);
		
		System.out.println(cipherText+"\n");
		
		System.out.println("Substituting 'j' with 'S'");
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='j'){
				arr[i]='S';
			}
		}
		cipherText=new String(arr);
		
		System.out.println(cipherText+"\n");
		
		System.out.println("Substituting 'u' with 'H'");
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='u'){
				arr[i]='H';
			}
		}
		cipherText=new String(arr);
		
		System.out.println(cipherText+"\n");
		
		System.out.println("Substituting 'y' with 'B'");
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='y'){
				arr[i]='B';
			}
		}
		cipherText=new String(arr);
		
		System.out.println(cipherText+"\n");
		
		System.out.println("Substituting 'h' with 'U'");
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='h'){
				arr[i]='U';
			}
		}
		cipherText=new String(arr);
		
		System.out.println(cipherText+"\n");
		
		System.out.println("Substituting 'b' with 'Y'");
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='b'){
				arr[i]='Y';
			}
		}
		cipherText=new String(arr);
		
		System.out.println(cipherText+"\n");
		
		System.out.println("Substituting 'p' with 'M'");
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='p'){
				arr[i]='M';
			}
		}
		cipherText=new String(arr);
		
		System.out.println(cipherText+"\n");
		
		System.out.println("Substituting 'e' with 'F'");
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='e'){
				arr[i]='F';
			}
		}
		cipherText=new String(arr);
		
		System.out.println(cipherText+"\n");
		
		System.out.println("Substituting 'f' with 'W'");
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='f'){
				arr[i]='W';
			}
		}
		cipherText=new String(arr);
		
		System.out.println(cipherText+"\n");
		
		System.out.println("Substituting 'm' with 'P'");
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='m'){
				arr[i]='P';
			}
		}
		cipherText=new String(arr);
		
		System.out.println(cipherText+"\n");
		
		System.out.println("Substituting 'q' with 'L'");
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='q'){
				arr[i]='L';
			}
		}
		cipherText=new String(arr);
		
		System.out.println(cipherText+"\n");
		
		System.out.println("Substituting 'r' with 'K'");
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='r'){
				arr[i]='K';
			}
		}
		cipherText=new String(arr);
		
		System.out.println(cipherText+"\n");
		
		System.out.println("\nPlain text:");
		
		System.out.println(cipherText+"\n");
	}
}
