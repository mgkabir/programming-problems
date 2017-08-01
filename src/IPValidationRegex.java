
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPValidationRegex {

	private Matcher matcher;
	private Pattern pattern;

	private static final String IP_ADDRESS_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

	public IPValidationRegex() {
		pattern = Pattern.compile(IP_ADDRESS_PATTERN);
	}

	/* validates the given ip */
	boolean validate(String ip) {
		matcher = pattern.matcher(ip);
		return matcher.matches();
	}

	private static final String FILENAME = "ip_address.txt";

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader(FILENAME);
		BufferedReader br = new BufferedReader(fr);
		String currentLine;

		IPValidationRegex ipValidator = new IPValidationRegex();

		System.out.println("== Invalid IP address ==");
		while ((currentLine = br.readLine()) != null) {
			/*Print invalid ip addresses*/
			if (!ipValidator.validate(currentLine)) {
				System.out.println(currentLine);
			}
		}
		
		br.close();
		fr.close();
	}

}
