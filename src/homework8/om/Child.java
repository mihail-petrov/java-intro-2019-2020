package homework8.om;

public class Child extends Human {
	@Override
	public String toString() {
		return String.format("[Дете]: %s", super.toString());
	}
}
