package homework8.om;

import java.util.Map;

public class Worker extends Citizen {
	protected static final String KEY_SALARY  = "SALARY";

	private int salary;

	@Override
	protected char getType() {
		return Citizen.TYPE_WORKER;
	}

	@Override
	public boolean match(String queryParams) {
		String[] parts = queryParams.split(SPECIAL_PROPERTY_DELIMITER);

		if (super.match(parts[0])) {
			if (parts.length == 2) {
				Map<String, String> specialParams = parseLine(parts[1]);

				if (specialParams.containsKey(KEY_SALARY)) {
					if (salary != Integer.parseInt(specialParams.get(KEY_SALARY))) {
						return false;
					}
				} else {
					return false;
				}
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
				String specialValue = parseSpecialProperty(KEY_SALARY, parts[1]);

				if (specialValue != null) {
					this.salary = Integer.parseInt(specialValue);
				} else {
					System.err.println("Липсва SALARY");
					return false;
				}
			}

			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		return String.format("[Трудещ се]: %s, заплата: %d", super.toString(), salary);
	}
}