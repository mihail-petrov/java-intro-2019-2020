package homework8.om;

public class Pensioner extends Citizen {
	protected static final String KEY_PENSION  = "PENSION";

	private int pension;

	public int getPension() {
		return pension;
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
