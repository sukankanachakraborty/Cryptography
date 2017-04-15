import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class readFile {

	public static String readFile() throws FileNotFoundException {

		String entireFileText = new Scanner(new File("Secret.hex")).useDelimiter("\\A").next();

		return entireFileText;
	}
}