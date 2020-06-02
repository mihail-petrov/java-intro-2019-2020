package homework8.om;

public class Pensioner extends Citizen {
	private int pension;

	@Override
	public boolean load(String dataLine) {
		return super.load(dataLine);
	}

	public int getPension() {
		return pension;
	}

	@Override
	public String toString() {
		return String.format("[Пенсионер]: %s, пенсия: %d", super.toString(), pension);
	}
}
