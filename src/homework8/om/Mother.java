package homework8.om;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Mother extends Citizen {
	protected static final String KID_LINE_START  = "{KID}=[";
	protected static final String KID_LINE_END  = "]";

	private final List<Child> children = new ArrayList<>();

	public List<Child> getChildren() {
		return this.children;
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

		if (children.size() > 0) {
			result += ", деца: {";

			for (Child child: children) {
				result += "(" + child + "), ";
			}

			result += "}";
		}

		return result;
	}
}
