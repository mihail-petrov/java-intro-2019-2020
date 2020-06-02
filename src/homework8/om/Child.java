package homework8.om;

import java.util.Map;

public class Child extends Human {
	private static final String KEY_KID_FNAME  = "KFNAME";
	private static final String KEY_KID_LNAME  = "KLNAME";
	private static final String KEY_KID_AGE    = "KAGE";

	@Override
	public boolean load(String dataLine) {
		Map<String, String> parts = parseLine(dataLine);

		if (!parts.containsKey(KEY_KID_FNAME) ||
			!parts.containsKey(KEY_KID_LNAME) ||
			!parts.containsKey(KEY_KID_AGE)) {

			System.err.println("Липсващ атрибут за дете.");

			return false;
		}

		firstName = parts.get(KEY_KID_FNAME);
		lastName  = parts.get(KEY_KID_LNAME);
		age       = Integer.parseInt(parts.get(KEY_KID_AGE));

		return true;
	}

	@Override
	public String toString() {
		return String.format("[Дете]: %s", super.toString());
	}
}
