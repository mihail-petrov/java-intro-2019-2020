package homework8.om;

import java.util.Map;

public abstract class Citizen extends Human {
	public static final char TYPE_PENSIONER = 'R';
	public static final char TYPE_WORKER    = 'W';
	public static final char TYPE_MOTHER    = 'M';

	public static final String KEY_TYPE     = "TYPE";
	public static final String KEY_ADDRESS  = "ADDRESS";
	public static final String KEY_PHONE    = "PHONE";
	public static final String KEY_GENDER   = "SEX";
	public static final String SPECIAL_PROPERTY_DELIMITER = "\\@\\{SPECIAL_PROPERTY\\}::";

	protected String address;
	protected String phone;
	protected char gender;

	protected abstract char getType();

	@Override
	public boolean match(String queryParams) {
		Map<String, String> mapParams = parseLine(queryParams);

		if (mapParams.containsKey(Citizen.KEY_TYPE)) {
			if (getType() != mapParams.get(Citizen.KEY_TYPE).charAt(0)) {
				return false;
			}
		}

		if (mapParams.containsKey(Citizen.KEY_FNAME)) {
			if (!firstName.equals(mapParams.get(Citizen.KEY_FNAME))) {
				return false;
			}
		}

		if (mapParams.containsKey(Citizen.KEY_LNAME)) {
			if (!lastName.equals(mapParams.get(Citizen.KEY_LNAME))) {
				return false;
			}
		}

		if (mapParams.containsKey(Citizen.KEY_AGE)) {
			if (age != Integer.parseInt(mapParams.get(Citizen.KEY_AGE))) {
				return false;
			}
		}

		if (mapParams.containsKey(Citizen.KEY_ADDRESS)) {
			if (!address.equals(mapParams.get(Citizen.KEY_ADDRESS))) {
				return false;
			}
		}

		if (mapParams.containsKey(Citizen.KEY_PHONE)) {
			if (!phone.equals(mapParams.get(Citizen.KEY_PHONE))) {
				return false;
			}
		}

		if (mapParams.containsKey(Citizen.KEY_GENDER)) {
			if (gender != mapParams.get(Citizen.KEY_GENDER).charAt(0)) {
				return false;
			}
		}

		return true;
	}

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

	@Override
	public String toString() {
		return String.format("%s, адрес: %s, тел.: %s, пол: %s",
				super.toString(), address, phone, gender);
	}
}