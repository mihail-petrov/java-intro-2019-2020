package homework8.om;

public class Worker extends Citizen {
	private int salary;

	@Override
	public boolean load(String dataLine) {
		return super.load(dataLine);
	}

	public int getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return String.format("[Трудещ се]: %s, заплата: %d", super.toString(), salary);
	}
}
