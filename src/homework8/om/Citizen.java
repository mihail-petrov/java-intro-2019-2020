package homework8.om;

import java.util.Map;

public abstract class Citizen extends Human {
	public static final char TYPE_PENSIONER = 'R';
	public static final char TYPE_WORKER    = 'W';
	public static final char TYPE_MOTHER    = 'M';

	protected static final String KEY_ADDRESS  = "ADDRESS";
	protected static final String KEY_PHONE    = "PHONE";
	protected static final String KEY_GENDER   = "SEX";
	protected static final String SPECIAL_PROPERTY_DELIMITER = "\\@\\{SPECIAL_PROPERTY\\}::";

	protected String address;
	protected String phone;
	protected char gender;

	@Override
	public boolean load(String dataLine) {
		Map<String, String> parts = parseLine(dataLine);

		firstName = parts.get(KEY_FNAME);
		lastName  = parts.get(KEY_LNAME);
		age       = Integer.parseInt(parts.get(KEY_AGE));
		address   = parts.get(KEY_ADDRESS);
		phone     = parts.get(KEY_PHONE);
		gender    = parts.get(KEY_GENDER).charAt(0);

		return true;
	}

	protected String parseSpecialProperty(String key, String part) {
		Map<String, String> specialPropertiesMap = parseLine(part);

		return specialPropertiesMap.get(key);
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public char getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return String.format("%s, адрес: %s, тел.: %s, пол: %s",
				super.toString(), address, phone, gender);
	}
}
