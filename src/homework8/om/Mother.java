package homework8.om;

import java.util.ArrayList;
import java.util.List;

public class Mother extends Citizen {
	private final List<Child> children = new ArrayList<>();

	public void addChild(Child child) {
		children.add(child);
	}

	public List<Child> getChildren() {
		return this.children;
	}

	@Override
	public boolean load(String dataLine) {
		return super.load(dataLine);
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
