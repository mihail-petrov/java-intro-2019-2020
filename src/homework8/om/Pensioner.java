package homework8.om;

import java.util.Map;

public class Pensioner extends Citizen {
	protected static final String KEY_PENSION  = "PENSION";

	private int pension;

	@Override
	protected char getType() {
		return Citizen.TYPE_PENSIONER;
	}

	@Override
	public boolean match(String queryParams) {
		String[] parts = queryParams.split(SPECIAL_PROPERTY_DELIMITER);

		if (super.match(parts[0])) {
			if (parts.length == 2) {
				Map<String, String> specialParams = parseLine(parts[1]);

				if (specialParams.containsKey(KEY_PENSION)) {
					if (pension != Integer.parseInt(specialParams.get(KEY_PENSION))) {
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
				String specialValue = parseSpecialProperty(KEY_PENSION, parts[1]);

				if (specialValue != null) {
					this.pension = Integer.parseInt(specialValue);
				} else {
					System.err.println("Липсва PENSION");
					return false;
				}
			}

			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		return String.format("[Пенсионер]: %s, пенсия: %d", super.toString(), pension);
	}
}