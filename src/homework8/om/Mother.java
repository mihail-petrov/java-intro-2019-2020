package homework8.om;

import java.util.ArrayList;
import java.util.List;

public class Mother extends Citizen {
	protected static final String KID_LINE_START  = "{KID}=[";
	protected static final String KID_LINE_END  = "]";

	private final List<Child> children = new ArrayList<>();

	@Override
	protected char getType() {
		return Citizen.TYPE_MOTHER;
	}

	@Override
	public boolean match(String queryParams) {
		String[] parts = queryParams.split(SPECIAL_PROPERTY_DELIMITER);

		if (super.match(parts[0])) {
			if (parts.length == 2) {
				if (!parts[1].startsWith(KID_LINE_START) || !parts[1].endsWith(KID_LINE_END)) {
					return false;
				}

				String cleanKidPart = parts[1].substring(7, parts[1].length() -1);

				for (Child child: children) {
					if (child.match(cleanKidPart)) {
						return true;
					}
				}

				return false;
			}

			return true;
		}

		return false;
	}


	@Override
	public boolean load(String dataLine) {
		String[] parts = dataLine.split(SPECIAL_PROPERTY_DELIMITER);

		if (super.load(parts[0])) {
			if (parts.length == 2) {
				String[] kids = parts[1].split(":");

				for (String kidPart: kids) {
					if (kidPart.startsWith(KID_LINE_START) && kidPart.endsWith(KID_LINE_END)) {
						String cleanKidPart = kidPart.substring(7, kidPart.length() - 1);

						Child child = new Child();
						if (!child.load(cleanKidPart)) {
							return false;
						}

						children.add(child);
					} else {
						System.err.printf("Неочакван формат за данни за дете: %s %n", kidPart);
						return false;
					}
				}
			}

			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		String result = String.format("[Майка]: %s", super.toString());

		if (!children.isEmpty()) {
			result += ", деца: {";

			for (Child child: children) {
				result += "(" + child + "), ";
			}

			result += "}";
		}

		return result;
	}
}