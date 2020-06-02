package homework8.om;

import java.util.HashMap;
import java.util.Map;

public abstract class Human {
	protected static final String KEY_FNAME = "FNAME";
	protected static final String KEY_LNAME = "LNAME";
	protected static final String KEY_AGE   = "AGE";

	protected String firstName;
	protected String lastName;
	protected int age;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return String.format("%s %s, възраст: %d", firstName, lastName, age);
	}

	protected Map<String, String> parseLine(String dataLine) {
		Map<String, String> partsCollection = new HashMap<>();

		String[] parts = dataLine.split("@");

		for (String part: parts) {
			putInMap(part, partsCollection);
		}

		return partsCollection;
	}

	private void putInMap(String part, Map<String, String> map) {
		String[] parts = part.split("=");

		if (parts.length == 2) {
			String key = getKey(parts[0]);
			String value = getValue(parts[1]);

			if (key != null && value != null) {
				map.put(key, value);

				return;
			}
		}

		System.err.printf("Не може да се обработи: %s %n", part);
	}

	private String getKey(String part) {
		return getPart(part, '{', '}');
	}

	private String getValue(String part) {
		return getPart(part, '[', ']');
	}

	private String getPart(String part, char openBracket, char closingBracket) {
		if (part.charAt(0) == openBracket && part.charAt(part.length()-1) == closingBracket) {
			return part.substring(1, part.length()-1);
		}

		return null;
	}
}
